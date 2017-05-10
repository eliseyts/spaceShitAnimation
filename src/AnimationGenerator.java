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


    int starX=5;
    int starY=5;
    int starRadius=3;
    int starMediumRadius=8;
    int starBigRadius=18;
    int nOfStars=150;
    int nOfMediumStars=40;
    int nOfBigStars=10;
    static int shipX=700;
    static int shipY=270;

    // двухмерные массивы координат звезд
    Dimension[] starArray = new Dimension[nOfStars];
    Dimension[] mediumStarArray = new Dimension[nOfMediumStars];
    Dimension[] bigStarArray = new Dimension[nOfBigStars];

    public Timer moveTimer = new Timer(10, new ActionListener() {
        @Override
        //движение мелких, средних, больших звезд
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < nOfStars ; i++) {
                if(starArray[i].getWidth()<=999) {
                    starArray[i].setSize(starArray[i].getWidth() + 1, starArray[i].getHeight());
                }
                else starArray[i].setSize(starArray[i].getWidth() - 999.0, starArray[i].getHeight());
            }

            for (int i = 0; i < nOfMediumStars ; i++) {
                if(mediumStarArray[i].getWidth()<=999) {
                    mediumStarArray[i].setSize(mediumStarArray[i].getWidth() + 2, mediumStarArray[i].getHeight());
                }
                else mediumStarArray[i].setSize(mediumStarArray[i].getWidth() - 999.0, mediumStarArray[i].getHeight());
            }

            for (int i = 0; i < nOfBigStars ; i++) {
                if(bigStarArray[i].getWidth()<=999) {
                    bigStarArray[i].setSize(bigStarArray[i].getWidth() + 5, bigStarArray[i].getHeight());
                }
                else bigStarArray[i].setSize(bigStarArray[i].getWidth() - 999.0, bigStarArray[i].getHeight());
            }

        }
    });

    public void mover(int yyy){
        shipY+=yyy;
    };

    // таймер перерисовывает картинку
    Timer redrawTimer = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    });


    // конструктор-кондуктор, в котором происходит изначальная генерация позиций звезд
    AnimationGenerator(){
        moveTimer.start();
        redrawTimer.start();

        for (int i = 0; i < nOfStars ; i++) {
            starArray[i]=new Dimension(10 + (int) (Math.random() * 980),10 + (int) (Math.random() * 680));
        }

        for (int i = 0; i < nOfMediumStars ; i++) {
            mediumStarArray[i]=new Dimension(10 + (int) (Math.random() * 980),10 + (int) (Math.random() * 680));
        }

        for (int i = 0; i < nOfBigStars ; i++) {
            bigStarArray[i]=new Dimension(10 + (int) (Math.random() * 980),10 + (int) (Math.random() * 680));
        }
    }

    // цвет звезд
    Color starColor = new Color(248, 247, 255);


    public void paint(Graphics g){

        //отрисовка звезд трех слоев
        g.setColor(starColor);
        for (int i = 0; i < nOfStars ; i++)
            g.fillOval((int)starArray[i].getWidth(), (int)starArray[i].getHeight(), starRadius, starRadius);
        for (int i = 0; i < nOfMediumStars ; i++)
            g.fillOval((int) mediumStarArray[i].getWidth(), (int) mediumStarArray[i].getHeight(), starMediumRadius, starMediumRadius);
        for (int i = 0; i < nOfBigStars ; i++)
            g.fillOval((int) bigStarArray[i].getWidth(), (int) bigStarArray[i].getHeight(), starBigRadius, starBigRadius);

        BufferedImage spaceShip = null;
        try
        {
            spaceShip = ImageIO.read(new File("images/spaceshit3.png"));
        } catch (IOException e){e.printStackTrace();}

        g.drawImage(spaceShip, shipX, shipY, 200, 160, null);

    }



}

