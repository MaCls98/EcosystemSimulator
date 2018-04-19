package linkedList;

public class MyLinkedList<T> {
	
	private Node<T> head;
	
	public MyLinkedList() {
	}
	
	public MyLinkedList(Node<T> head) {
		this.head = head;
	}
	
	public void append(Node<T> newNode) {
		Node<T> noActual = head;
		if (noActual != null) {
			while (noActual.getNextNode() != null) {
				noActual = noActual.getNextNode();
			}
			noActual.setNextNode(newNode);
		}else {
			head = newNode;
		}
	}
	
	public void print() {
		Node<T> tmp = head;
		while (tmp != null) {
			System.out.println(tmp.getPerson() + " -> ");
			tmp = tmp.getNextNode();
		}
		System.out.println("null");
	}
}
