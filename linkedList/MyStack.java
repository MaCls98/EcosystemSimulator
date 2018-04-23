package linkedList;

public class MyStack<T> {
	
	private Node<T> head;
	
	public void push(Node<T> node){
		if (head != null) {
			node.setNextNode(head);
			head = node;
		}else {
			head = node;
		}
	}
	
	public Node<T> pop(){
		Node<T> nodeToPop = head;
		head = head.getNextNode();
		nodeToPop.setNextNode(null);
		return nodeToPop;
	}

	public void print() {
		Node<T> aux = head;
		while (aux != null) {
			System.out.println(aux.getInfo() + "-");
			aux = aux.getNextNode();
		}
	}
	
	public T peek(){
		return head.getInfo();
	}

	public T getHead() {
		return head.getInfo();
	}
}
