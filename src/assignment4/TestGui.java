
package assignment4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestGui extends JFrame {

    public TestGui() {

        super("Test GUI");
        // JButton b = new JButton("click me");
        CustomButton cb = new CustomButton();
        this.add(cb);
        cb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.out.println("clicked!!!!");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {

        TestGui app = new TestGui();
        app.setSize(200, 200);
        app.setVisible(true);
    }
}
