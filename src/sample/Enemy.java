package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Enemy extends GameEntity {

    public Enemy(){
        this.blood = 100;
        this.speed = 100;
        this.armor = 100;
        this.reward = 100;
    }

    public Enemy(int t) {
        if(t< 600) {
            this.posX = 650 - t ;
            this.posY = 75;
        }
        else if( t<770) {
            this.posX = 50 ;
            this.posY = 75 + t-600;
        }
        else if( t < 1320){
            this.posX = 50 + t - 770;
            this.posY = 240;
        }
        else if( t< 1480){
            this.posX = 590;
            this.posY = 240 + t- 1320;
        }
        else{
            this.posX = 590 - t + 1480;
            this.posY = 400;
        }

    }


    @Override
    public void action(GraphicsContext gc,int i) {

        Image enemy1   = new Image( 231 + i +".png" );

        gc.drawImage( enemy1, posX, posY, 30,20 );

    }

    public boolean collision (double x, double y,GraphicsContext gc){
        if( Math.sqrt((x-posX)*(x-posX)+ (y-posY)*(y-posY)) < 100)
        {
            Bullet B20 = new Bullet(x+10, y+30);
            B20.action(gc, posX +20, posY+20);
            return true;
        }
        else return false;
    }


}

