import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by eliorgietz on 27.05.17.
 */
public class ShipClass {

    static int shipX=700;
    static int shipY=270;

    public void shipNullCoord(){
        shipX=700;
        shipY=270;
    }
    public void shipDraw(Graphics g) {
        //отрисовка корабля
        BufferedImage spaceShip = null;
        try
        {
            spaceShip = ImageIO.read(new File("images/spaceshit3.png"));
        } catch (IOException e){e.printStackTrace();}

        g.drawImage(spaceShip, shipX, shipY, 200, 160, null);
    }
}
