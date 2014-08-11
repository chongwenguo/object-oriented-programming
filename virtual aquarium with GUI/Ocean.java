import javax.swing.JFrame;
import java.awt.BorderLayout;
/**
 * driver class
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Ocean {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ocean");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.WEST);
        frame.add(new OceanPanel(control)); //defaults to CENTER
        frame.pack();
        frame.setVisible(true);
    }
}
