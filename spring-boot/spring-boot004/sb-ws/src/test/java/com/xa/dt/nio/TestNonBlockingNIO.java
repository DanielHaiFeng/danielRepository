package com.xa.dt.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 一、使用NIO完成网络通信的三个核心：
 *
 * 1.通道（Channel）：负责连接
 *  java.nio.channels.Channel接口
 *     |-- SelectableChannel
 *        |-- SocketChannel
 *        |-- ServerSocketChannel
 *        |-- DatagramChannel
 *
 *        |-- Pipe.SinkChannel
 *        |-- Pipe.SourceChannel
 * 2.缓冲区（Buffer）：负责数据的存取
 *
 * 3.选择器（Selector）：是SelectableChannel的多路复用器，用于监控SelectableChannel的IO状况
 */
public class TestNonBlockingNIO {

    //客户端，启动多次client，则就是简易聊天室
    @Test
    public void client() throws Exception {
        //1. 获取通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //2. 切换为非阻塞模式
        channel.configureBlocking(false);
        //3. 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4. 发送数据给服务器
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String msg = scanner.next();
            buffer.put((LocalDateTime.now().toString() + " " + msg).getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
        //5. 关闭通道
        channel.close();
    }

    //服务端
    @Test
    public void server() throws Exception {
        //1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.切换为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //3.绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(9898));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上，并且指定"监听接收事件"
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.轮询式得获取选择器上已经“准备就绪”的事件
        while (selector.select()>0){
            //7. 获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //8.获取准备“就绪”的事件
                SelectionKey selectionKey = iterator.next();
                //9.判断具体是什么事件准备就绪
                if(selectionKey.isAcceptable()){
                    //10.若“接收就绪”，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11.将客户端连接切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    //12.将客户端连接注册到选择器上，并监听客户端连接的“读就绪”事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //13. 获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //14.读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }
                //15. 取消选择键SelectionKey
                iterator.remove();
            }
        }
    }
}
