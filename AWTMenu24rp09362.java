import java.awt.*;
import java.awt.event.*;

public class AWTMenu24rp09362 extends Frame implements ActionListener {

    Panel navbar, leftSidebar, rightSidebar, centerContent;
    Button loginBtn, closeBtn;
    Label headerLabel;
    TextField emailField, passwordField;

    // Navbar links
    Button pagesLink, editLink, helpLink;

    public AWTMenu24rp09362() {
        setTitle("AWT Menu Project - 24rp09362");
        
        // Increased height to make space for the visible navbar content
        setSize(700, 490); 
        
        setLayout(null);
        setResizable(false);

        
        int yOffset = 40; 

        // navbar started hano
        navbar = new Panel();
        
        
        navbar.setBounds(0, yOffset, 700, 70); 
        
        navbar.setLayout(null);
        navbar.setBackground(new Color(180, 200, 220));

        // Title (This will now be visible) hapa prof
        Label title = new Label("AWT MENU PRACTICE");
        title.setBounds(20, 5, 300, 25);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        navbar.add(title);

        
        closeBtn = new Button("X"); 
        closeBtn.setFont(new Font("Arial", Font.BOLD, 12));
        closeBtn.setBounds(665, 5, 25, 25);
        closeBtn.addActionListener(this);
        closeBtn.setActionCommand("Close"); 
        navbar.add(closeBtn);

    
        pagesLink = new Button("Pages");
        pagesLink.setBounds(20, 35, 60, 25);
        pagesLink.addActionListener(this);
        navbar.add(pagesLink);

        editLink = new Button("Edit");
        editLink.setBounds(90, 35, 60, 25);
        editLink.addActionListener(this);
        navbar.add(editLink);

        helpLink = new Button("Help");
        helpLink.setBounds(160, 35, 60, 25);
        helpLink.addActionListener(this);
        navbar.add(helpLink);

        add(navbar);

        //left side
        leftSidebar = new Panel();
        
        // Applied was offset l applied lect
        leftSidebar.setBounds(0, 70 + yOffset, 120, 380); 
        
        leftSidebar.setLayout(new GridLayout(10, 1, 0, 10));

        Button loginSidebar = new Button("Login");
        Button studentSidebar = new Button("Student");
        loginSidebar.addActionListener(this);
        studentSidebar.addActionListener(this);

        leftSidebar.add(loginSidebar);
        leftSidebar.add(studentSidebar);
        add(leftSidebar);

        // rigth side nigg
        rightSidebar = new Panel();
        

        rightSidebar.setBounds(580, 70 + yOffset, 120, 380); 
        
        rightSidebar.setLayout(null);
        add(rightSidebar);

        // conten cente
        centerContent = new Panel();
        
        // Applied the yOffset
        centerContent.setBounds(120, 70 + yOffset, 460, 380); 
        
        centerContent.setLayout(null);
        add(centerContent);

        // Header label
        headerLabel = new Label("Login Page", Label.CENTER);
        headerLabel.setBounds(80, 10, 300, 25);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        centerContent.add(headerLabel);

        showLoginPage();

        // Window close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void showLoginPage() {
        centerContent.removeAll();
        centerContent.add(headerLabel);
        headerLabel.setText("Login Page");

        Label emailLabel = new Label("Email:");
        emailLabel.setBounds(30, 60, 60, 20);
        emailField = new TextField();
        emailField.setBounds(100, 60, 250, 20);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setBounds(30, 100, 60, 20);
        passwordField = new TextField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(100, 100, 250, 20);

        loginBtn = new Button("Login");
        loginBtn.setBounds(100, 140, 100, 25);
        loginBtn.setActionCommand("LoginBtn");
        loginBtn.addActionListener(this);

        centerContent.add(emailLabel);
        centerContent.add(emailField);
        centerContent.add(passwordLabel);
        centerContent.add(passwordField);
        centerContent.add(loginBtn);

        centerContent.revalidate();
        centerContent.repaint();
    }

    private void showStudentPage() {
        centerContent.removeAll();
        centerContent.add(headerLabel);
        headerLabel.setText("Student Page");

        Label studentLabel = new Label("IMENA KENNY - 24rp09362", Label.CENTER);
        studentLabel.setBounds(50, 100, 300, 25);
        studentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        centerContent.add(studentLabel);

        centerContent.revalidate();
        centerContent.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Login":
                showLoginPage();
                break;
            case "Student":
                showStudentPage();
                break;
            case "Close":
                dispose();
                break;
            case "LoginBtn":
                // You can add validation/login logic here
                String email = emailField.getText();
                String password = passwordField.getText();
                System.out.println("Login attempt with Email: " + email + ", Password: " + password);
                break;
            case "Pages":
                System.out.println("Pages clicked!");
                break;
            case "Edit":
                System.out.println("Edit clicked!");
                break;
            case "Help":
                System.out.println("Help clicked!");
                break;
        }
    }

    public static void main(String[] args) {
        new AWTMenu24rp09362();
    }
}