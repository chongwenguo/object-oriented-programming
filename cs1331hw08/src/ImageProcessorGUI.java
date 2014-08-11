import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import edu.gatech.cs1331.image.ImageProcessor;
import edu.gatech.cs1331.image.Pic;


/**
 * cs1331 hw08
 * ImageProcessorGUI class, implement a Image processor
 *
 * @author chongwen Guo
 * @version 1.0
 */
public class ImageProcessorGUI extends JFrame {

    private JPanel panel;
    private ActionListener noChangeAction;
    private ActionListener grayscaleAction;
    private ActionListener invertAction;
    private ActionListener onlyRedAction;
    private ActionListener onlyGreenAction;
    private ActionListener onlyBlueAction;
    private ActionListener posterizeAction;
    private ActionListener voerlayAction;
    private ActionListener openAction;
    private ActionListener saveAsAction;
    private JLabel label;
    private ImageProcessor ip;
    private Pic pic;
/**
 * Default constructor
 * set up the frame, panel and label,
 * and initialize the actions.
 */
    public ImageProcessorGUI() {
        super("Image Processor");
        //create anonymous inner classes of ActionListeners
        initActions();
        //set frame default size
        this.setSize(800, 600);

        // Set up panel
        panel = new JPanel(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up label
        label = new JLabel("", JLabel.CENTER);
        panel.add(label);
        add(panel);
        setJMenuBar(createJMenuBar());

    }
/**
 * method to set up all actions by defining
 * several anonymous inner classes
 *
 */
     private void initActions() {

        noChangeAction = new AbstractAction("No Change") {
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon(ip.noChange().getImage()));
            }
        };

        grayscaleAction = new AbstractAction("Grayscale") {
            public void actionPerformed(ActionEvent e) {
                pic = ip.grayscale();
                label.setIcon(new ImageIcon(pic.getImage()));
            }
        };

        invertAction = new AbstractAction("Invert") {
            public void actionPerformed(ActionEvent e) {
                pic = ip.invert();
                label.setIcon(new ImageIcon(pic.getImage()));
            }
        };

        onlyRedAction = new AbstractAction("Only Red") {
            public void actionPerformed(ActionEvent e) {
                pic = ip.onlyRed();
                label.setIcon(new ImageIcon(pic.getImage()));
            }
        };

        onlyGreenAction = new AbstractAction("Only Green") {
            public void actionPerformed(ActionEvent e) {
                pic = ip.onlyGreen();
                label.setIcon(new ImageIcon(pic.getImage()));
            }
        };

        onlyBlueAction = new AbstractAction("Only Blue") {
            public void actionPerformed(ActionEvent e) {
                pic = ip.onlyBlue();
                label.setIcon(new ImageIcon(pic.getImage()));
            }
        };

        posterizeAction = new AbstractAction("Posterize") {
            public void actionPerformed(ActionEvent e) {
                pic = ip.posterize();
                label.setIcon(new ImageIcon(pic.getImage()));
            }
        };

        voerlayAction = new AbstractAction("Overlay") {
            public void actionPerformed(ActionEvent e) {
                  File thisDir = new File(System.getProperty("user.dir"));
                  JFileChooser chooser = new JFileChooser(thisDir);
                  int returnVal = chooser.showOpenDialog(panel);
                  if (returnVal == JFileChooser.APPROVE_OPTION) {
                      File file = chooser.getSelectedFile();
                      pic = ip.overlay(file);
                      label.setIcon(new ImageIcon(pic.getImage()));
                  }
               }
        };

        openAction = new AbstractAction("Open") {
            public void actionPerformed(ActionEvent e) {
                File thisDir = new File(System.getProperty("user.dir"));
                JFileChooser chooser = new JFileChooser(thisDir);
                int returnVal = chooser.showOpenDialog(panel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    pic = new Pic(file);
                    ip = new ImageProcessor(pic);
                    label.setIcon(new ImageIcon(pic.getImage()));
                    pack();

                }
            }
        };

        saveAsAction = new AbstractAction("Save As...") {
            public void actionPerformed(ActionEvent e) {
                File thisDir = new File(System.getProperty("user.dir"));
                JFileChooser chooser = new JFileChooser(thisDir);
                int returnVal = chooser.showSaveDialog(panel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                          ImageIO.write(pic.getImage(), "jpg", file);

                    } catch (IOException e1) {
                          e1.printStackTrace();
                    }
                }
            }
        };
    }

/**
 * method to set up the menu bar,
 * add ActionListener to each JMenuItem
 * @return menuBar - the created JMenubar
 */
    private JMenuBar createJMenuBar() {

        JMenuItem noChangeMenuItem = new JMenuItem("No Change");
        noChangeMenuItem.addActionListener(noChangeAction);

        JMenuItem grayscaleMenuItem = new JMenuItem("Grayscale");
        grayscaleMenuItem.addActionListener(grayscaleAction);

        JMenuItem invertMenuItem = new JMenuItem("Invert");
        invertMenuItem.addActionListener(invertAction);

        JMenuItem onlyRedMenuItem = new JMenuItem("Only Red");
        onlyRedMenuItem.addActionListener(onlyRedAction);

        JMenuItem onlyGreenMenuItem = new JMenuItem("Only Green");
        onlyGreenMenuItem.addActionListener(onlyGreenAction);

        JMenuItem onlyBlueMenuItem = new JMenuItem("Only Blue");
        onlyBlueMenuItem.addActionListener(onlyBlueAction);

        JMenuItem posterizeMenuItem = new JMenuItem("Posterize");
        posterizeMenuItem.addActionListener(posterizeAction);

        JMenuItem overlayMenuItem = new JMenuItem("Voerlay");
        overlayMenuItem.addActionListener(voerlayAction);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(openAction);


        JMenuItem saveAsMenuItem = new JMenuItem("Save As...");
        saveAsMenuItem.addActionListener(saveAsAction);

        JMenu fileMenu = new JMenu("File");

        fileMenu.add(openMenuItem);
        fileMenu.add(saveAsMenuItem);

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(noChangeMenuItem);
        editMenu.add(grayscaleMenuItem);
        editMenu.add(invertMenuItem);
        editMenu.add(onlyRedMenuItem);
        editMenu.add(onlyGreenMenuItem);
        editMenu.add(onlyBlueMenuItem);
        editMenu.add(posterizeMenuItem);
        editMenu.add(overlayMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        return menuBar;
    }
/**
 * main method, run the program
 * @param args - command line args
 */
    public static void main(String[] args) {
        ImageProcessorGUI ipGUI = new ImageProcessorGUI();
        ipGUI.setVisible(true);
    }
}