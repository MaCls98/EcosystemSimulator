package linkedList;

public class MyStack<T> {
	
	private Node<T> head;
	
	public Node<T> pop(){
		Node<T> nodeToPop = head;
		head = head.getNextNode();
		nodeToPop.setNextNode(null);
		return nodeToPop;
	}
	
	public void push(Node<T> node){
		if (head != null) {
			node.setNextNode(head);
			head = node;
		}else {
			head = node;
		}
	}
	
	public Node<T> peek(){
		return head;
	}

	public void print() {
		Node<T> aux = head;
		while (aux != null) {
			System.out.println(aux.getInfo() + "-");
			aux = aux.getNextNode();
		}
	}
}
