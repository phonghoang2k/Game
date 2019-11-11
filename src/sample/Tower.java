package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Tower extends GameTiles {
    public int posX, posY, speed, range, damage;
    public Tower(){
        this.posX = 715;
        this.posY = 20;
    }

    public Tower(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    //getter


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    //setter

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    @Override
    public  boolean containsPoint(double x, double y){
        if ( x- posX < 80 && y - posY < 55)  return true;
        else return false;
    }
    @Override
    public void write(double x, double y, GraphicsContext gc){
        Image tower = new Image("78.png");
        gc.drawImage(tower, x, y, 15,30);
    }

    public void action(){

    }


}
