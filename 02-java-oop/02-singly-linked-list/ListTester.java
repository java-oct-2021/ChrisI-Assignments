public class ListTester {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.add(3);
		sll.add(4);
		sll.add(10);
		sll.add(5);
		sll.add(15);
		sll.add(2);
		sll.printValues();
		sll.remove();
		Node temp;
		Integer result = null;
		temp = sll.find(3);
		if(temp != null){
			result = temp.value;
		} else {
			result = null;
		}
		System.out.println("find result:"+result);
		sll.removeAt(2);
		sll.printValues();
		temp = sll.find(5);
		if(temp != null){
			result = temp.value;
		} else {
			result = null;
		}
		System.out.println("find result:"+result);
		sll.removeAt(4);
		sll.removeAt(-1);
		sll.removeAt(0);
		sll.removeAt(2);
		sll.remove();
		sll.removeAt(0);
		sll.printValues();
	}
}
