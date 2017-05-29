import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AnimaExplorer extends JFrame{


    public AnimationGenerator animationGenerator=new AnimationGenerator();
    public ShipClass shipKostil = new ShipClass();
    public JPanel mainPanel;

    AnimaExplorer() {
        super("3,14здолёт");
        getContentPane().setBackground(Color.BLACK);
        setBounds(300, 200, 1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Color bgndColor = new Color(7, 7, 15);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.setBackground(bgndColor);
        mainPanel.add(animationGenerator,BorderLayout.CENTER);

        this.addKeyListener(new buttonHandler());

        getContentPane().setBackground(Color.BLACK);

        setContentPane(mainPanel);
        setVisible(true);
    }


    public class buttonHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            if((e.getExtendedKeyCode()==80)||(e.getExtendedKeyCode()==16778295)){
                if(animationGenerator.moveTimer.isRunning()){
                    animationGenerator.moveTimer.stop();
                    animationGenerator.moveAstrTimer.stop();
                    animationGenerator.flagForPause = true;
                }
                else {
                    animationGenerator.moveTimer.start();
                    animationGenerator.moveAstrTimer.start();
                    animationGenerator.flagForPause = false;
                }
            }


            if(((e.getExtendedKeyCode()==83)||(e.getExtendedKeyCode()==16778315))&&
                    (shipKostil.shipY<500)&&(animationGenerator.flagForPause==false)){
                animationGenerator.movbutt=1;
                animationGenerator.shipMovingTimer.start();
            }

            if(((e.getExtendedKeyCode()==87)||(e.getExtendedKeyCode()==16778310))&&
                    (shipKostil.shipY>10)&&(animationGenerator.flagForPause==false)){
                animationGenerator.movbutt=2;
                animationGenerator.shipMovingTimer.start();
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

            if(((e.getExtendedKeyCode()==83)||(e.getExtendedKeyCode()==16778315))&&
                    (shipKostil.shipY<500)&&(animationGenerator.flagForPause==false)){
                animationGenerator.movbutt=1;
                animationGenerator.shipMovingTimer.stop();
            }

            if(((e.getExtendedKeyCode()==87)||(e.getExtendedKeyCode()==16778310))&&
                    (shipKostil.shipY>10)&&(animationGenerator.flagForPause==false)){
                animationGenerator.movbutt=2;
                animationGenerator.shipMovingTimer.stop();
            }


        }
    }

    public static void main(String[] args) {
        new AnimaExplorer();
    }
}