import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AsteroidClass {
    static boolean crushFlag = false; // true, если произошло столкновение
    int nOfAsteroids = 7;
    int randAY = 0;
    int asteroidRadius = 50;
    int asteroidSpeed = 10;

    // двухмерные массивы координат астероидов
    public ShipClass shipAndAstr = new ShipClass();
    Dimension[] asteroidArray = new Dimension[nOfAsteroids];

    public void astrMovingFunction() {
        //движение астероидов
        for (int i = 0; i < nOfAsteroids; i++) {
            if (asteroidArray[i].getWidth() <= 999) {
                asteroidArray[i].setSize(asteroidArray[i].getWidth() + asteroidSpeed, asteroidArray[i].getHeight());
                //проверка столкновения
                if (((asteroidArray[i].getWidth()>700)&&(asteroidArray[i].getWidth()<800))&&
                        ((asteroidArray[i].getHeight()>shipAndAstr.shipY+20)&&(asteroidArray[i].getHeight()<shipAndAstr.shipY+140))) {
                    System.out.print("!!!!!!!!!!!!");
                    crushFlag = true;
                }

            } else {
                randAY = 10 + (int) (Math.random()*980);
                asteroidArray[i].setSize(asteroidArray[i].getWidth() - 1200, randAY);
            }
        }
    }
    public void RandomPositionsFunction(){
        //рандомизация изначальных координат

        for (int i = 0; i < nOfAsteroids; i++) {
            asteroidArray[i]=new Dimension(-(600 + (int) (Math.random() * 2100)),10 + (int) (Math.random() * 680));
        }
    }



    public void asterDraw(Graphics g) {
        //отрисовка астероидов
        BufferedImage spaceShip = null;
        try
        {
            spaceShip = ImageIO.read(new File("images/asteroid.png"));
        } catch (IOException e){e.printStackTrace();}

        for (int i = 0; i < nOfAsteroids; i++)
            g.drawImage(spaceShip, (int) asteroidArray[i].getWidth(), (int) asteroidArray[i].getHeight(),100, 100, null);
    }

}