
package assignment5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import assignment3.Person;

@SuppressWarnings("serial")
public class AddressBook extends JFrame implements ActionListener {

    FlowLayout leftLayout;
    JFrame newContactFrame;
    private JLabel lastNameLabel;
    private JTextField lastNameText;
    private JLabel birthdayLabel;
    private JTextField birthdayText;
    private static JPanel titlePanel;
    private static JPanel firstNamePanel;
    private static JPanel lastNamePanel;
    private static JPanel phoneNumberPanel;
    private static JPanel emailPanel;
    private static JPanel birthdayPanel;
    private static JPanel buttonPanel;
    private static JLabel titleLabel;
    private static JLabel firstNameLabel;
    private static JLabel phoneNumberLabel;
    private static JLabel emailLabel;
    private static JTextField firstNameText;
    private static JTextField phoneNumberText;
    private static JTextField emailText;
    private static JButton saveButton;
    private static JMenu fileMenu;
    private static JMenuItem openItem;
    private static JMenuItem saveItem;
    private static JMenuItem saveAsItem;
    private static JMenuItem printItem;
    private static JMenuItem exitItem;
    private static JMenu editMenu;
    private static JMenuItem newItem;
    private static JMenuItem editItem;
    private static JMenuItem deleteItem;
    private static JMenuItem findItem;
    private static JMenuItem firstItem;
    private static JMenuItem nextItem;
    private static JMenuItem lastItem;
    private static JMenuItem previousItem;
    private static JMenuItem aboutItem;
    private static JMenu helpMenu;
    private static JMenuItem docItem;
    private Person person;

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        AddressBook project = new AddressBook();
    }

    public AddressBook() {

        final int WIDTH = 450;
        final int HEIGHT = 400;
        JFrame frame = new JFrame("Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initActionListeners();
        frame.setJMenuBar(setUpMenu());
        frame.add(setUpToolBar());
        leftLayout = new FlowLayout(FlowLayout.LEFT);
        frame.setLayout(new GridLayout(6, 1));
        frame.setSize(WIDTH, HEIGHT);
        frame.setBackground(Color.BLUE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(GetFirstNamePanel());
        frame.add(GetLastNamePanel());
        frame.add(GetPhonePanel());
        frame.add(GetEmailPanel());
        frame.add(GetBDayPanel());
        // frame.add(statusBarPanel());
        frame.setVisible(true);
    }

    /* (non-Javadoc)
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newItem)
            AddContact();
        if (e.getSource() == saveButton)
            SaveContact();

        //
        // int returnVal = fc.showOpenDialog(AddressBook.this);
    }

    /* Saves contact information */
    private void SaveContact() {

        if (birthdayText.toString().isEmpty())
            person = new Person(firstNameText.toString(),
                    lastNameText.toString(), emailText.toString(),
                    phoneNumberText.toString());
        else
            person = new Person(firstNameText.toString(),
                    lastNameText.toString(), emailText.toString(),
                    phoneNumberText.toString(), emailText.toString());
    }

    /* Opens Add contact form */
    public void AddContact() {

        newContactFrame();
    }

    private JPanel GetFirstNamePanel() {

        firstNamePanel = new JPanel();
        firstNamePanel.setLayout(leftLayout);
        firstNameLabel = new JLabel("First Name: ");
        firstNameText = new JTextField(20);
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameText);

        return firstNamePanel;
    }

    private JPanel GetLastNamePanel() {

        lastNamePanel = new JPanel();
        lastNamePanel.setLayout(leftLayout);
        lastNameLabel = new JLabel("Last Name: ");
        lastNameText = new JTextField(20);
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameText);

        return lastNamePanel;
    }

    private JPanel GetEmailPanel() {

        emailPanel = new JPanel();
        emailPanel.setLayout(leftLayout);
        emailLabel = new JLabel("Email: ");
        emailText = new JTextField(30);
        emailPanel.add(emailLabel);
        emailPanel.add(emailText);
        return emailPanel;
    }

    private JPanel GetPhonePanel() {

        phoneNumberPanel = new JPanel();
        phoneNumberPanel.setLayout(leftLayout);
        phoneNumberLabel = new JLabel("Phone Number: ");
        phoneNumberText = new JTextField(12);
        phoneNumberPanel.add(phoneNumberLabel);
        phoneNumberPanel.add(phoneNumberText);
        return phoneNumberPanel;
    }

    private JPanel GetBDayPanel() {

        birthdayPanel = new JPanel();
        birthdayPanel.setLayout(leftLayout);
        birthdayLabel = new JLabel("Birthday: ");
        birthdayText = new JTextField(30);
        birthdayPanel.add(birthdayLabel);
        birthdayPanel.add(birthdayText);

        return birthdayPanel;
    }

    private JPanel statusBarPanel() {

        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        statusPanel.setLayout((LayoutManager) new BoxLayout(statusPanel,
                BoxLayout.X_AXIS));

        return statusPanel;
    }

    /* private function for new contact frame */
    private void newContactFrame() {

        final int WIDTH = 375;
        final int HEIGHT = 275;
        newContactFrame = new JFrame("Add New Contact");
        leftLayout = new FlowLayout(FlowLayout.LEFT);
        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titleLabel = new JLabel("New Contact");
        titlePanel.add(titleLabel);
        newContactFrame.add(titlePanel);
        newContactFrame.setLayout(new GridLayout(6, 1));
        newContactFrame.setSize(WIDTH, HEIGHT);
        newContactFrame.setBackground(Color.BLUE);
        newContactFrame.add(GetFirstNamePanel());
        newContactFrame.add(GetLastNamePanel());
        newContactFrame.add(GetPhonePanel());
        newContactFrame.add(GetEmailPanel());
        newContactFrame.add(GetBDayPanel());
        buttonPanel = new JPanel();
        saveButton = new JButton("Save");
        buttonPanel.add(saveButton);
        saveButton.addActionListener(this);
        newContactFrame.add(buttonPanel);
        newContactFrame.setVisible(true);
    }

    /* Initialize action listener to items */
    private void initActionListeners() {

        openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        saveAsItem = new JMenuItem("Save as");
        saveAsItem.addActionListener(this);
        printItem = new JMenuItem("Print");
        printItem.addActionListener(this);
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        editItem = new JMenuItem("Edit");
        editItem.addActionListener(this);
        deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(this);
        findItem = new JMenuItem("Find");
        findItem.addActionListener(this);
        firstItem = new JMenuItem("First");
        firstItem.addActionListener(this);
        previousItem = new JMenuItem("Previous");
        previousItem.addActionListener(this);
        nextItem = new JMenuItem("Next");
        nextItem.addActionListener(this);
        lastItem = new JMenuItem("Last");
        lastItem.addActionListener(this);
        docItem = new JMenuItem("Documentation");
        docItem.addActionListener(this);
        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
    }

    /* Set up Menu Bar private method "setUpMenu" returns JMenuBar object */
    private static JMenuBar setUpMenu() {

        JMenuBar menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(printItem);
        fileMenu.add(exitItem);
        editMenu.add(newItem);
        editMenu.add(editItem);
        editMenu.add(deleteItem);
        editMenu.add(findItem);
        editMenu.add(firstItem);
        editMenu.add(previousItem);
        editMenu.add(nextItem);
        editMenu.add(lastItem);
        helpMenu.add(docItem);
        helpMenu.add(aboutItem);

        return menuBar;
    }

    /* Set up ToolBar private method "setUpToolBar" returns JToolBar object */
    private static JToolBar setUpToolBar() {

        JToolBar bar = new JToolBar();
        bar.add(newItem);
        bar.add(editItem);
        bar.add(deleteItem);
        bar.add(findItem);
        bar.add(firstItem);
        bar.add(previousItem);
        bar.add(nextItem);
        bar.add(lastItem);

        return bar;
    }

}
