package com.xa.boco.java7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		//java7������
		Map<String, List<String>> anagrams = new HashMap<>();
		
		//�ɶ��Ը��õ�������
		int one_million = 1_000_000;
		
		//switch֧��string
		String s = "";
		switch (s) {
		case "quux":
		case "foo":
		case "bar":
			break;
		case "baz":
		default:
			break;
		}
		
		//������
		int binary = 0b1001_1001; 
		
	}

}
