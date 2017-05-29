import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameOverMode {
    int sco=0;
    Color textColor = new Color(255, 224, 61);
    Color bcgrnd = new Color(14, 14, 29);

    void resetScore(int s){
        sco = s;
    }
    public void EndDraw(Graphics g) {
        g.setColor(bcgrnd);
        g.fillRect(0, 0, 1000,700);
        Font textfont = new Font("Tahoma", Font.BOLD|Font.ITALIC, 200);
        g.setFont(textfont);
        g.setColor(textColor);
        g.drawString(""+ sco + "", 300, 400);

        Font textfont2 = new Font("Tahoma", Font.BOLD|Font.ITALIC, 45);
        g.setFont(textfont2);
        g.drawString("Вы пролетели", 100, 200);

        BufferedImage restartButt = null;
        try
        {
            restartButt = ImageIO.read(new File("images/restartbutton.png"));
        } catch (IOException e){e.printStackTrace();}

        g.drawImage(restartButt, 410, 500, 180, 80, null);

    }
}