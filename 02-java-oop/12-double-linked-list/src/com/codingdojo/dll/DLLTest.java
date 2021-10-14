package com.codingdojo.dll;

public class DLLTest {
	public static void main(String[] args) {
		DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        dll.printValuesForward();
        dll.pop();
        System.out.println(dll.contains(80));
        System.out.println(dll.contains(100));
        System.out.println(dll.contains(10));
        Node n7 = new Node(0);
        dll.insertAt(n7, 0);
        dll.printValuesForward();
        Node n8 = new Node(101);
        dll.insertAt(n8, 6);
        dll.printValuesForward();
        Node n9 = new Node(110);
        dll.insertAt(n9, 3);
        dll.printValuesForward();
        dll.printValuesBackwards();
        dll.removeAt(7);
        dll.removeAt(0);
        dll.removeAt(3);
        dll.printValuesForward();
	}
}
