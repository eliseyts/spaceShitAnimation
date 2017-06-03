import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        this.addKeyListener(new ButtonHandler());
        this.addMouseListener(new MouseHandler());

        getContentPane().setBackground(Color.BLACK);

        setContentPane(mainPanel);
        setVisible(true);
    }


    public class ButtonHandler implements KeyListener {
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

    public class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            Point mouseCoord = getMousePosition();
            if ((AsteroidClass.crushFlag==true)&&(((mouseCoord.x>=410)&&(mouseCoord.x<=590))&&((mouseCoord.y>=500)&&(mouseCoord.y<=580)))) {
                System.out.println("YOUBA");
                AsteroidClass.crushFlag=false;
                animationGenerator.score = 0;
                animationGenerator.shipObject.shipNullCoord();
                animationGenerator.starComplex.RandomPositionsFunction();
                animationGenerator.asteroidComplex.RandomPositionsFunction();
                animationGenerator.moveTimer.start();
                animationGenerator.moveAstrTimer.start();
                animationGenerator.redrawTimer.start();
                animationGenerator.scoretimer.start();
                //new AnimationGenerator();


            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        new AnimaExplorer();
    }
}