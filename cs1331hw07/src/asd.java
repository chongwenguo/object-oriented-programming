import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class asd extends JFrame {
	private JLabel label;
	
	public asd() {
	
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    label = new JLabel ("Greeting will go here.");
    JButton button = new JButton("Greet!");
    button.addActionListener ( new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        
        String gr = "aaa";
        label.setText(gr);
        }
 });
add(label, BorderLayout.CENTER);
add(button, BorderLayout.SOUTH);
   pack();
}
	public static void mian(String[] args) {
		 asd gg = new asd();
		 gg.setVisible(true);


		}
}
