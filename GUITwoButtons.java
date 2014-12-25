import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Zadatak: Treba napraviti prozor za dva dugmica, gdje ce kada se klikne na prvi
//pisati "Clicked", a kada se zatim klikne na drugi, na drugom pisati "Clicked"
//a prvi vratiti u prvobitno stanje

public class GUITwoButtons {

	public static JButton button1 = new JButton("OK");//kreiranje prvog dugmica
	public static JButton button2 = new JButton("NOT OK");//kreiranje drugog dugmica

	public static void main(String[] args) {
		JFrame frame = new JFrame("Java Window");//kreiranje frame-a i podesavanje
		frame.setLocation(700, 200);
		frame.setSize(200, 150);

		JPanel jp = new JPanel();//kreiranje panela
		frame.add(jp);
		
		jp.add(button1);//dodavanje dva dugmica na panel
		jp.add(button2);
		ButtonHandler bh = new ButtonHandler(); //kreiranje Buttonhandler-a
		button1.addActionListener(bh);//modifikovanje dugmica
		button1.setBackground(Color.yellow);
		button1.setForeground(Color.cyan);
		button2.addActionListener(bh);
		button2.setBackground(Color.yellow);
		button2.setForeground(Color.cyan);

		frame.setVisible(true); //podesavanje frame-a
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static class ButtonHandler implements ActionListener {//kreiranje klase Buttonhandler koja implementira ActionListener

		@Override
		public void actionPerformed(ActionEvent e) {
			
            JButton b = (JButton) e.getSource();
			if (b.getText().equals("OK")) {
				button1.setText("Clicked");
				button2.setText("NOT OK");
			} else if (b.getText().equals("NOT OK")) {
				button1.setText("OK");
				button2.setText("Clicked");
			}

		}

	}
}