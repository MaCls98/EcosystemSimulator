package linkedList;

public class MyQueue<T> {
	
	private Node<T> head;
	
	public MyQueue() {
	}
	
	public void enqueue(Node<T> node) {
		Node<T> nodeActual = head;
		if (head != null) {
			while (nodeActual.getNextNode() != null) {
				nodeActual = nodeActual.getNextNode();
			}
			nodeActual.setNextNode(node);
		}else {
			head = node;
		}
	}
	
	public Node<T> dequeue(){
		Node<T> nodeDequeue = head;
		head = head.getNextNode();
		nodeDequeue.setNextNode(null);
		return nodeDequeue;
	}
	
	public void print(){
		Node<T> aux = head;
		while (aux != null) {
			System.out.println(aux.getInfo() + "-");
			aux = aux.getNextNode();
		}
	}
	
	public T peek(){
		return head.getInfo();
	}

	public Node<T> getHead() {
		return head;
	}
}
