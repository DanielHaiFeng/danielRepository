package com.xa.boco.java8;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		/*
		 * ����򵥵���ʽ�У�һ��lambda�������ö��ŷָ��Ĳ����б��C>�����뺯���������ֱ�ʾ�����磺
		 */
		Arrays.asList("a", "b", "d").forEach(a -> System.out.println(a));

		/*
		 * ��ע�����e���������ɱ������Ʋ�����ġ�ͬʱ����Ҳ����ͨ���Ѳ�����������������������е���ʽֱ�Ӹ������������ͣ�
		 */
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));

		/*
		 * ��ĳЩ�����lambda�ĺ��������Ӹ��ӣ���ʱ���԰Ѻ�����ŵ���һ�Ի������У� ������Java�ж�����ͨ����һ�������磺
		 */
		Arrays.asList("a", "b", "d").forEach(e -> {
			System.out.print(e);
			System.out.print(e);
		});

		/*
		 * Lambda����������ĳ�Ա������ֲ������������Щ��������final�Ļ������ǻᱻ������תΪfinal������Ч�ʸ��ߣ���
		 * ���磬������������Ƭ���ǵȼ۵ģ�
		 */
		String separator = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator));

		final String separator1 = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator1));

		/*
		 * Lambda���ܻ᷵��һ��ֵ������ֵ������Ҳ���ɱ������Ʋ�����ġ����lambda�ĺ�����ֻ��һ�еĻ���
		 * ��ôû�б�Ҫ��ʽʹ��return��䡣������������Ƭ���ǵȼ۵ģ�
		 */
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
		
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
		
	}
	
	@FunctionalInterface
	public interface Functional {
	    void method();
	}

}
