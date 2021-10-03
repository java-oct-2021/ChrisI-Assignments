import java.util.function.BiFunction;
public class SinglyLinkedList {
	public Node head;
	public SinglyLinkedList() {

	}
	private <T> Node r(BiFunction<Node,T,Boolean> tester, T val) {
		if(this.head == null) {
			return this.head;
		} else {
			Node runner = this.head;
			while(!tester.apply(runner, val)) {
				runner = runner.next;
			}
			return runner;
		}
	}
	private static <T> Boolean isEnd(Node node, T val) {
		return node.next == null;
	}
	private static <T> Boolean printAll(Node node, T val) {
		System.out.println(node.value);
		return isEnd(node, val);
	}
	private static <T> Boolean isPenultimate(Node node,T val) {
		if(isEnd(node, val)){	//Required for when the only node is the head
			return true;
		} else if (node.next.next == null) {
			return true;
		} else {
			return false;
		}
	}
	private static <T> Boolean matchVal(Node node, T val) {
		if(isEnd(node, val)) {
			return true;
		} else {
			int value = (int) val;
			return value == node.value;
		}
	}
	private static <T> Boolean isPreviousNode(Node node, T val) {
		if(isEnd(node, val)){
			return true;
		} else if(node.next == (Node) val) {
			return true;
		} else {
			return false;
		}
	}
	private Node tail() {
		return r(SinglyLinkedList::isEnd, 0);
	}
	private Node preTail() {
		return r(SinglyLinkedList::isPenultimate,0);
	}
	public Node find(int value) {
		Node foundNode = r(SinglyLinkedList::matchVal,value);
		if (foundNode.value == value) {	//This checks if the value at the end matches due to how the runner works
			return foundNode;
		} else {
			return null;
		}
	}
	
	public void removeAt(int index) {
		Node runner = this.head;
		if (runner == null) {
			System.out.println("empty list");
			return;
		}
		if (index < 0) {
			System.out.println("invalid index (index < 0)");
			return;
		}
		for (int i = 0; i < index; i++) {
			if (index == i) {
				break;
			}
			if(runner.next == null) {
				System.out.println("invalid index (index > list length)");
				return;
			}
			runner = runner.next;
		}

		if(runner == this.head) {
			this.head = this.head.next;
			return;
		} else {
			Node prev = r(SinglyLinkedList::isPreviousNode, runner);
			prev.next = runner.next;
		}
	}
	
	public void add(int value) {
		Node newNode = new Node(value);
		Node runner = tail();
		if(runner == null) {
			this.head = newNode;
		} else {
			runner.next = newNode;
		}
	}
	public void remove() {
		if(this.head == null) {
			return;
		} else if (this.head.next == null) {
			this.head = null;
		} else {
			preTail().next = null;
		}
	}
	public void printValues() {
		System.out.println("----print values----");
		r(SinglyLinkedList::printAll,0);
		System.out.println("---------end--------");
	}
}
