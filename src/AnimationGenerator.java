import javafx.scene.image.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class AnimationGenerator extends JComponent{

    static int movbutt = 1; // костыль-страшный сон булата 1, если w, 2, если s
    int shipSpeed = 4;
   static int aaa=0;

    static boolean flagForPause = false; //флаг для остановки элементов во время паузы. false, если не pause

    static int score = 0;
    public StarArrayClass starComplex = new StarArrayClass();
    public AsteroidClass asteroidComplex = new AsteroidClass();
    public GameOverMode endOfGame = new GameOverMode();
    public ShipClass shipObject = new ShipClass();

    Color bgndColor2 = new Color(7, 7, 15);

    public Timer shipMovingTimer = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if((movbutt==1)&&(shipObject.shipY<500)) shipObject.shipY+=shipSpeed;
            if((movbutt==2)&&(shipObject.shipY>10)) shipObject.shipY-=shipSpeed;
        }
    });

    Timer scoretimer = new Timer( 100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (flagForPause==false){ score++; }
        }
    });

    public Timer moveTimer = new Timer( 10, new ActionListener() {
        @Override
        //движение мелких, средних, больших звезд
        public void actionPerformed(ActionEvent e) {
            starComplex.starMovingFunction();

        }
    });

    public Timer moveAstrTimer = new Timer(10, new ActionListener() {
        @Override
        //движение астероидов
        public void actionPerformed(ActionEvent e) {
            asteroidComplex.astrMovingFunction();

        }
    });

    // таймер перерисовывает картинку
    Timer redrawTimer = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();

            if (asteroidComplex.crushFlag==true){
                    moveTimer.stop();
                    moveAstrTimer.stop();
                    scoretimer.stop();
                    shipMovingTimer.stop();
                    endOfGame.resetScore(score);

            }
        }

    });

    // конструктор-кондуктор, в котором происходит изначальная генерация позиций звезд
    AnimationGenerator(){
        score = 0;
        shipObject.shipNullCoord();
        starComplex.RandomPositionsFunction();
        asteroidComplex.RandomPositionsFunction();
        moveTimer.start();
        moveAstrTimer.start();
        redrawTimer.start();
        scoretimer.start();
    }

    Color textColor = new Color(255, 224, 61);
    Color pauseColor = new Color(250, 255, 239);

    public void paint(Graphics g){
        g.setColor(bgndColor2);
        starComplex.starDraw(g);
        shipObject.shipDraw(g);
        asteroidComplex.asterDraw(g);
        Font textfont = new Font("Tahoma", Font.BOLD|Font.ITALIC, 20);
        g.setFont(textfont);
        g.setColor(textColor);
        g.drawString("Ваш звёдолёт пролетел уже целых "+ score + " световых годиков", 30, 30);
        if(flagForPause==true){
            g.setColor(pauseColor);
            g.fillRect(460,300,30, 100);
            g.fillRect(520,300,30, 100);
        }
        if (asteroidComplex.crushFlag==true) endOfGame.EndDraw(g);

    }



}

