import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AnimaExplorer extends JFrame{


    public AnimationGenerator animationGenerator=new AnimationGenerator();
    public JPanel mainPanel;
    private AnimationGenerator anim = new AnimationGenerator();

    AnimaExplorer() {
        super("CONVERTER");
        getContentPane().setBackground(Color.BLACK);
        setBounds(300, 300, 1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Color bgndColor = new Color(7, 7, 15);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(bgndColor);

        mainPanel.add(animationGenerator,BorderLayout.CENTER);

        this.addKeyListener(new pauseButton());
        this.addKeyListener(new upButton());
        this.addKeyListener(new downButton());

        getContentPane().setBackground(Color.BLACK);
        setContentPane(mainPanel);
        setVisible(true);
    }


    public class pauseButton implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println(e.getExtendedKeyCode()+" "+animationGenerator.moveTimer.isRunning());
            if(e.getExtendedKeyCode()==80){
                if(animationGenerator.moveTimer.isRunning()) animationGenerator.moveTimer.stop();
                else animationGenerator.moveTimer.start();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class upButton implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            if((e.getExtendedKeyCode()==83)||(e.getExtendedKeyCode()==16778315)&&(anim.shipY<500)){
                anim.shipY+=20;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class downButton implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            if(((e.getExtendedKeyCode()==87)||(e.getExtendedKeyCode()==16778310))&&(anim.shipY>10)){
                anim.shipY-=20;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public static void main(String[] args) {
        new AnimaExplorer();
    }
}