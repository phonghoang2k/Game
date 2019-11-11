package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public abstract class GameEntity{
    public double posX, posY, t, blood, speed, armor, reward;

    public GameEntity(){
    };
    public GameEntity(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }


    //getter
    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
//setter
    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
    public void action(GraphicsContext gc, int t){};



}

