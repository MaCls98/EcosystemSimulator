package views;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import linkedList.Node;
import model.Ecosystem;
import model.Person;

public class JPanelEvents extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon skull = new ImageIcon(getClass().getResource("/img/skull.png"));
	private JButton btnEvent;
	
	public JPanelEvents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		btnEvent = new JButton();
		add(new JButton(skull));
	}
	
	public void addEvents(Ecosystem ecosystem){
		repaint();
		revalidate();
		Node<Person> aux = ecosystem.getPersonList().getHead();
		while (aux != null) {
			if (!aux.getInfo().isAlive()) {
				btnEvent.setIcon(skull);
				add(btnEvent);
				revalidate();
			}
			aux = aux.getNextNode();
		}
	}

}
