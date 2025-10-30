import java.awt.*;
import java.awt.event.*;
public class MyShapes_24rp09362 extends Frame implements ActionListener {

    private Button closeBtn;

    public MyShapes_24rp09362() {
        // here is the frame setup 
        setTitle("My Shapes - 24rp09362");
        setSize(500, 500);
        setLayout(new BorderLayout());

       // ghee these is the navbar 
        Container navbar = new Container();
        navbar.setLayout(new BorderLayout());
        navbar.setPreferredSize(new Dimension(500, 50));

        // its the left - title bar
        Label title = new Label("My Shapes", Label.LEFT);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        navbar.add(title, BorderLayout.WEST);

        // its the button on the left for closing the fram nig
        closeBtn = new Button("X");
        closeBtn.setFont(new Font("Arial", Font.BOLD, 14));
        closeBtn.addActionListener(this);
        navbar.add(closeBtn, BorderLayout.EAST);

        add(navbar, BorderLayout.NORTH);

        //these is the image in the center of my face hhhhh!
        FaceCanvas faceCanvas = new FaceCanvas();
        add(faceCanvas, BorderLayout.CENTER);

        //thes is close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // l made it for button action
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeBtn) {
            dispose();
        }
    }

    // these is all about the color and the shape mr ! 
    class FaceCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            // Face outline
            g.setColor(Color.BLACK);
            g.drawOval(120, 100, 250, 250);

            // eyse hapa
            g.fillOval(200, 180, 25, 25);
            g.fillOval(290, 180, 25, 25);

            // Mouth that l curved
            g.drawArc(200, 250, 120, 70, 0, -180);
        }
    }

    // =these is the main nigga
    public static void main(String[] args) {
        new MyShapes_24rp09362();
    }
}
