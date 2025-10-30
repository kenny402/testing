import java.awt.*;
import java.awt.event.*;

public class AWTLogin24rp09362 extends Frame implements ActionListener {

    // these is the header mr!!
    Panel headerPanel;
    Button closeBtn;
    Label headerLabel;

    // these is the footer 
    Panel footerPanel;

    // these is the login niggg
    Label loginTitleLabel, usernameLabel, passwordLabel;
    TextField usernameField, passwordField;
    Button loginBtn;

    public AWTLogin24rp09362() {
        // 
        setTitle("AWT Login Project - 24rp09362");
        setSize(500, 400);
        setLayout(null);
        setResizable(false);

        // these is the header mr
        headerPanel = new Panel();
        headerPanel.setBounds(0, 0, 500, 50);
        headerPanel.setLayout(null);
        headerPanel.setBackground(new Color(180, 180, 180));

        // my header text
        headerLabel = new Label("SIMPLE JAVA AWT LAYOUT");
        headerLabel.setBounds(10, 10, 200, 70);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(headerLabel);

        // Close button
        closeBtn = new Button("X");
        closeBtn.setBounds(440, 10, 40, 30);
        closeBtn.addActionListener(this);
        headerPanel.add(closeBtn);

        add(headerPanel);

        // login page tit
        loginTitleLabel = new Label("Login Page", Label.CENTER);
        loginTitleLabel.setBounds(0, 70, 500, 30);
        loginTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(loginTitleLabel);

        // the login form
        usernameLabel = new Label("Username:");
        usernameLabel.setBounds(100, 120, 80, 25);
        add(usernameLabel);

        usernameField = new TextField();
        usernameField.setBounds(200, 120, 180, 25);
        add(usernameField);

        passwordLabel = new Label("Password:");
        passwordLabel.setBounds(100, 160, 80, 25);
        add(passwordLabel);

        passwordField = new TextField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(200, 160, 180, 25);
        add(passwordField);

        loginBtn = new Button("Login");
        loginBtn.setBounds(200, 200, 100, 30);
        loginBtn.addActionListener(this);
        add(loginBtn);

        //footer gee
        footerPanel = new Panel();
        footerPanel.setBounds(0, 340, 500, 40);
        footerPanel.setBackground(Color.GRAY); 
        footerPanel.setLayout(null);
        add(footerPanel); 

        // window cross btn jama
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeBtn) {
            dispose();
        } else if (e.getSource() == loginBtn) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Hardcoded credentials
            String correctUsername = "imena";
            String correctPassword = "123";

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                // Welcome dialog
                Dialog welcome = new Dialog(this, "Welcome", true);
                welcome.setLayout(new FlowLayout());
                Label msg = new Label("Welcome, " + username + "!");
                Button ok = new Button("OK");
                ok.addActionListener(ev -> welcome.dispose());
                welcome.add(msg);
                welcome.add(ok);
                welcome.setSize(250, 100);
                welcome.setLocationRelativeTo(this);
                welcome.setVisible(true);
            } else {
                // Error dialog
                Dialog error = new Dialog(this, "Error", true);
                error.setLayout(new FlowLayout());
                Label msg = new Label("Invalid credentials! Try again.");
                Button ok = new Button("OK");
                ok.addActionListener(ev -> error.dispose());
                error.add(msg);
                error.add(ok);
                error.setSize(300, 100);
                error.setLocationRelativeTo(this);
                error.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new AWTLogin24rp09362();
    }
}
