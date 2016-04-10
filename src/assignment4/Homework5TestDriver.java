
package assignment4;

/**
 * Homework5TestDriver A test driver for Homework 4, custom button
 * implementation. Don't forget to uncomment the code to test your
 * implementation of the assignment. Copyright 2011 Kent Yang. Released under a
 * href="http://www.opensource.org/licenses/afl-3.0.php" The Academic Free
 * License 3.0 ("AFL") v.3.0 in USA. author KentYang version 5/15/11 6:15 AM
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Homework5TestDriver extends JFrame implements ActionListener {

    public Homework5TestDriver() {

        super("HW4 Test Driver");
    }

    public static void main(String[] args) {

        Homework5TestDriver app = new Homework5TestDriver();
        CustomButton cb = new CustomButton();
        cb.addActionListener(app);
        cb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.out.println("Custom Button Clicked!");
            }
        });

        JButton swingButton = new JButton("Swing");

        swingButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.out.println("Swing Button Clicked!");
            }
        });

        app.add(swingButton);
        app.add(cb);

        app.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                System.out.println("Application exiting...");
                System.exit(0);
            }

        });

        app.setSize(300, 300);
        app.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        System.out.println("Custom Button Clicked!");
    }
}