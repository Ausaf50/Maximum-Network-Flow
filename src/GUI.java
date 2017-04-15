import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUI {

    JPanel panel;
    JButton button;

    public static void start(String args[])
    {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(e.getClickCount() == 2)
                {
                    System.out.println("Hello again ");
                }
            }
        });
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300,300);
        frame.setVisible(true);


    }
}