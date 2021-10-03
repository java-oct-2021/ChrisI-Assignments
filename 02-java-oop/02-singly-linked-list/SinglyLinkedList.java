public class SinglyLinkedList {
	public Node head;
	public SinglyLinkedList() {

	}
	private Node run() {
		if(this.head == null) {
			return this.head;
		} else {
			Node runner = this.head;
			while(runner.next != null) {
					runner = runner.next;
			}
			return runner;
		}
	}
	private Node runPenultimate() {
		if(this.head == null) {
			return this.head;
		} else {
			Node runner = this.head;
			while(runner.next != null) {
				Node temp = runner.next;
				if(temp.next == null) {
					break;
				} else {
					runner = runner.next;
				}
			}
			return runner;
		}
	}
	public void add(int value) {
		Node newNode = new Node(value);
		Node runner = run();
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
			runPenultimate().next = null;
		}
	}
	public void printValues() {
		System.out.println("\n");
		if(this.head == null) {
			return;
		} else {
			Node runner = this.head;
			System.out.println(runner.value);
			
			while(runner.next != null) {
				runner = runner.next;
				System.out.println(runner.value);
			}
		}
	}
}
