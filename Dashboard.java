import java.awt.*;
import java.awt.event.*;

public class Dashboard extends Frame implements ActionListener {

    // Panels
    Panel topNav, sideBar, contentArea;
    TextField emailField, passwordField;
    Button loginBtn;
    Label messageLabel;

    public Dashboard() {
        setTitle("testing AWT Dashboard Layout");
        setSize(800, 500);
        setLayout(null);
        setBackground(Color.WHITE);
        setResizable(false);

        // ======= NAV BAR =======
        topNav = new Panel();
        topNav.setBackground(new Color(52, 73, 94));
        topNav.setBounds(0, 0, 800, 60);
        topNav.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 15));

        Label title = new Label("AWT System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        Label home = createNavLabel("Home");
        Label about = createNavLabel("About");
        Label contact = createNavLabel("Contact");

        topNav.add(title);
        topNav.add(home);
        topNav.add(about);
        topNav.add(contact);

        // ======= imena kenny =======
        sideBar = new Panel();
        sideBar.setBackground(new Color(44, 62, 80));
        sideBar.setBounds(0, 60, 180, 440);
        sideBar.setLayout(new GridLayout(6, 1, 0, 10));

        String[] items = {"Dashboard", "Register", "View Users", "Settings", "Help", "Exit"};
        for (String item : items) {
            Label lbl = new Label(item, Label.CENTER);
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Arial", Font.PLAIN, 14));
            sideBar.add(lbl);
        }

        // ======= MAIN CONTENT (LOGIN FORM) =======
        contentArea = new Panel();
        contentArea.setBounds(180, 60, 620, 440);
        contentArea.setLayout(null);
        contentArea.setBackground(Color.WHITE);

        Label loginTitle = new Label("User Login");
        loginTitle.setBounds(250, 40, 200, 30);
        loginTitle.setFont(new Font("Arial", Font.BOLD, 20));

        Label emailLabel = new Label("Email:");
        emailLabel.setBounds(180, 120, 80, 25);
        emailField = new TextField();
        emailField.setBounds(260, 120, 180, 25);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setBounds(180, 160, 80, 25);
        passwordField = new TextField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(260, 160, 180, 25);

        loginBtn = new Button("Login");
        loginBtn.setBounds(260, 210, 100, 30);
        loginBtn.setBackground(new Color(52, 152, 219));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addActionListener(this);

        messageLabel = new Label("", Label.CENTER);
        messageLabel.setBounds(180, 250, 260, 30);
        messageLabel.setForeground(Color.RED);

        contentArea.add(loginTitle);
        contentArea.add(emailLabel);
        contentArea.add(emailField);
        contentArea.add(passwordLabel);
        contentArea.add(passwordField);
        contentArea.add(loginBtn);
        contentArea.add(messageLabel);

        // ======= ADD ALL PANELS =======
        add(topNav);
        add(sideBar);
        add(contentArea);

        // ======= WINDOW CLOSE =======
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private Label createNavLabel(String text) {
        Label lbl = new Label(text);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("Arial", Font.PLAIN, 14));
        return lbl;
    }

    // ======= BUTTON ACTION =======
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (email.equals("admin") && password.equals("123")) {
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("✅ Login Successful!");
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("❌ Invalid Email or Password!");
            }
        }
    }

    // ======= MAIN METHOD =======
    public static void main(String[] args) {
        new Dashboard();
    }
}
