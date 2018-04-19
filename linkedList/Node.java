package linkedList;

import model.Person;

public class Node<T> {
	
	private Node<T> nextNode;
	private Person person;
	
	public Node(Person person) {
		this.person = person;
	}
	public Node<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "Node [nextNode=" + nextNode + ", person=" + person + "]";
	}
}
