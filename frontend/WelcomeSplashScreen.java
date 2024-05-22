package project;
import javax.swing.*;
import java.awt.*;

public class WelcomeSplashScreen extends JFrame {
    public WelcomeSplashScreen() {
        initComponents();
    }

    private void initComponents() {
        JPanel jPanel_Background = new JPanel();
        JProgressBar jProgressBar_LoadingBar = new JProgressBar();
        JLabel jLabel_Percent = new JLabel();
        JPanel jPanel_Heading = new JPanel();
        JLabel BookTapHeadingLabel = new JLabel();
        JLabel jLabel_BackgroundImage = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WELCOME SPLASH SCREEN");
        setSize(new Dimension(998, 570));

        jPanel_Background.setBackground(new Color(255, 255, 255));
        jPanel_Background.setLayout(new BorderLayout());

        jProgressBar_LoadingBar.setForeground(new Color(139, 69, 19));
        jPanel_Background.add(jProgressBar_LoadingBar, BorderLayout.SOUTH);

        jLabel_Percent.setFont(new Font("Century Gothic", Font.BOLD, 24));
        jLabel_Percent.setForeground(new Color(255, 102, 0));
        jLabel_Percent.setText("%");
        jPanel_Background.add(jLabel_Percent, BorderLayout.CENTER);

        jPanel_Heading.setBackground(new Color(139, 69, 19, 100));
        jPanel_Heading.setPreferredSize(new Dimension(640, 180));
        jPanel_Heading.setLayout(new BorderLayout());
        
        BookTapHeadingLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 100));
        BookTapHeadingLabel.setText("BookTap");
        BookTapHeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel_Heading.add(BookTapHeadingLabel, BorderLayout.CENTER);

        jPanel_Background.add(jPanel_Heading, BorderLayout.WEST);

        jLabel_BackgroundImage.setIcon(new ImageIcon(getClass().getResource("/Login_Interests images/BookFlip.gif")));
        jPanel_Background.add(jLabel_BackgroundImage, BorderLayout.CENTER);

        getContentPane().add(jPanel_Background);

        setLocationRelativeTo(null);
    }


    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new WelcomeSplashScreen().setVisible(true);
            try {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(40);
                    // Update the progress bar and percent label here
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Open the main options screen here
            new MainOptionsScreen().setVisible(true);
        });
    }
}
