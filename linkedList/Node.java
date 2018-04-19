package linkedList;

public class Node<T> {
	
	private Node<T> nextNode;
	private T info;
	
	public Node(T info) {
		this.info = info;
	}
	
	public Node<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return "Node [nextNode=" + nextNode + ", info=" + info + "]";
	}
}
