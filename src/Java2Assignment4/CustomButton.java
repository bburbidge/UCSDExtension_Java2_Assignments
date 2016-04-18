
package Java2Assignment4;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CustomButton extends JPanel implements MouseListener {

    private boolean buttonDown = false;
    private String buttonMessage;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    private java.util.List<ActionListener> listeners = new java.util.ArrayList<ActionListener>();

    public CustomButton() {

        setButtonMessage("Clicked like a boss!");
        this.addMouseListener(this);
        repaint();
    }

    public CustomButton(String message) {

        setButtonMessage(message);
        this.addMouseListener(this);
        repaint();

    }

    public CustomButton(LayoutManager arg0) {

        super(arg0);

    }

    public CustomButton(boolean arg0) {

        super(arg0);

    }

    public CustomButton(LayoutManager arg0, boolean arg1) {

        super(arg0, arg1);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Assignment 4 - Brent Burbidge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final CustomButton cb = new CustomButton();
        cb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.out.println(cb.getButtonMessage());
            }
        });

        Container cont = frame.getContentPane();
        cont.setLayout(new FlowLayout());
        cont.add(cb);
        frame.pack();
        frame.setVisible(true);
    }

    public void mouseClicked(MouseEvent arg0) {

    }

    public void mouseEntered(MouseEvent arg0) {

    }

    public void mouseExited(MouseEvent arg0) {

    }

    public void mousePressed(MouseEvent arg0) {

        buttonDown = true;
        repaint();
        notifyListeners();
    }

    public void mouseReleased(MouseEvent arg0) {

        buttonDown = false;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Polygon poly1;
        Rectangle rect1;
        Rectangle rect2;
        Color polyColor;
        Color rect1Color;
        Color rect2Color;

        rect1 = new Rectangle(getPreferredSize());
        rect2 = new Rectangle(rect1.getBounds().x + 15,
                rect1.getBounds().y + 15, rect1.getBounds().height - 30,
                rect1.getBounds().width - 30);

        poly1 = RectangleToPolygon(rect1);

        Graphics2D g2 = (Graphics2D) g;

        if (buttonDown == true) {
            polyColor = Color.lightGray;
            rect1Color = Color.gray;
            rect2Color = Color.black;
        } else {
            polyColor = Color.lightGray;
            rect1Color = Color.gray;
            rect2Color = Color.white;
        }

        g2.setColor(rect1Color);
        g2.draw(rect1);
        g2.fill(rect1);

        g2.setColor(polyColor);
        g2.draw(poly1);
        g2.fill(poly1);
        g2.setColor(rect2Color);
        g2.draw(rect2);
        g2.fill(rect2);
    }

    private static Polygon RectangleToPolygon(Rectangle rect) {

        Polygon result = new Polygon();
        result.addPoint(rect.x, rect.y);
        result.addPoint(rect.x + rect.width, rect.y);
        result.addPoint(rect.x, rect.y + rect.height);
        return result;
    }

    public String getButtonMessage() {

        return buttonMessage;
    }

    public void setButtonMessage(String buttonMessage) {

        this.buttonMessage = buttonMessage;
    }

    public void addActionListener(ActionListener actionListener) {

        this.listeners.add(actionListener);
    }

    public void removeActionListener(ActionListener actionListener) {

        this.listeners.remove(actionListener);
    }

    private void notifyListeners() {

        ActionEvent ae = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "");
        for (ActionListener al : this.listeners) {
            al.actionPerformed(ae);
        }
    }

    public Dimension getPreferredSize() {

        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}
