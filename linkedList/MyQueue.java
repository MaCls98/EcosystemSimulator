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
		return nodeDequeue;
	}
	
	public Node<T> peek(){
		return head;
	}
}
