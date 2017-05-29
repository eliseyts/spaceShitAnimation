import java.awt.*;

public class StarArrayClass{
    int nOfStars = 150;
    int nOfMediumStars = 40;
    int nOfBigStars = 10;
    int randY = 0;
    int randMY = 0;
    int randBY = 0;
    int starRadius=3;
    int starMediumRadius=8;
    int starBigRadius=18;
    Color starColor = new Color(248, 247, 255);// цвет звезд
    // двухмерные массивы координат звезд
    Dimension[] starArray = new Dimension[nOfStars];
    Dimension[] mediumStarArray = new Dimension[nOfMediumStars];
    Dimension[] bigStarArray = new Dimension[nOfBigStars];

    public void starMovingFunction() {
        //движение мелких, средних, больших звезд
        for (int i = 0; i < nOfStars; i++) {
            if (starArray[i].getWidth() <= 999) {
                starArray[i].setSize(starArray[i].getWidth() + 1, starArray[i].getHeight());
            } else {
                randY = 10 + (int) (Math.random()*980);
                starArray[i].setSize(starArray[i].getWidth() - 1300, randY);
            }
        }

        for (int i = 0; i < nOfMediumStars; i++) {
            if (mediumStarArray[i].getWidth() <= 999) {
                mediumStarArray[i].setSize(mediumStarArray[i].getWidth() + 2, mediumStarArray[i].getHeight());
            } else {
                randMY = 10 + (int) (Math.random()*980);
                mediumStarArray[i].setSize(mediumStarArray[i].getWidth() - 1300,randMY);
            }
        }

        for (int i = 0; i < nOfBigStars; i++) {
            if (bigStarArray[i].getWidth() <= 999) {
                bigStarArray[i].setSize(bigStarArray[i].getWidth() + 5, bigStarArray[i].getHeight());
            } else {
                randBY = 10 + (int) (Math.random()*980);
                bigStarArray[i].setSize(bigStarArray[i].getWidth() - 1300,randBY);
            }
        }
    }
    public void RandomPositionsFunction(){
        //рандомизация изначальных координат
        for (int i = 0; i < nOfStars ; i++) {
            starArray[i]=new Dimension(0 + (int) (Math.random() * 1200),10 + (int) (Math.random() * 680));
        }

        for (int i = 0; i < nOfMediumStars ; i++) {
            mediumStarArray[i]=new Dimension(0 + (int) (Math.random() * 1200),10 + (int) (Math.random() * 680));
        }

        for (int i = 0; i < nOfBigStars ; i++) {
            bigStarArray[i]=new Dimension(0 + (int) (Math.random() * 1200),10 + (int) (Math.random() * 680));
        }
    }

    public void starDraw(Graphics g){
        //отрисовка звезд трех слоев
        g.setColor(starColor);
        for (int i = 0; i < nOfStars ; i++)
            g.fillOval((int) starArray[i].getWidth(),
                    (int) starArray[i].getHeight(), starRadius, starRadius);

        for (int i = 0; i < nOfMediumStars ; i++)
            g.fillOval((int) mediumStarArray[i].getWidth(),
                    (int) mediumStarArray[i].getHeight(), starMediumRadius, starMediumRadius);

        for (int i = 0; i < nOfBigStars ; i++)
            g.fillOval((int) bigStarArray[i].getWidth(),
                    (int) bigStarArray[i].getHeight(), starBigRadius, starBigRadius);
    }
}