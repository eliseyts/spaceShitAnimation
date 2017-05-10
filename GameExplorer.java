import javax.swing.*;
import java.awt.*;

public class GameExplorer extends JFrame{


    public JPanel infoPanel;
    public JPanel mainPanel;

    GameExplorer() throws InterruptedException {
        super("CONVERTER");
        getContentPane().setBackground(Color.BLACK);
        setBounds(300, 300, 1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Color bgndColor = new Color(181, 238, 255);

        infoPanel = new JPanel();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(bgndColor);

        infoPanel = new JPanel();
        JTextArea jTextArea=new JTextArea("piska");
        infoPanel.add(jTextArea);


        mainPanel.add(new GameContent(), BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.BLACK);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        new GameExplorer();
    }

}