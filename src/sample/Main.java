package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;




public class Main extends Application {

    private int inp = 0, n = 0,health = 1000;
    private double[] Tower_x = new double[100];
    private double[] Tower_y = new double[100];
    private int [] Tower_blood = new int[100];

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "Canvas Example" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 900, 500 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();




        Image sample = new Image("25.png");
        Image title = new Image("194.png");
        Image h1 = new Image("186.png");
        Image h2 = new Image("175.png");
        Image h3 = new Image("246.png");
        Image h4 = new Image("151.png");
        Image h5 = new Image("16.png");
        Image tower = new Image("78.png");
        Image tower1 = new Image("79.png");
//        Image h6 = new Image("194.png");

        gc.drawImage( sample, 0, 0 , 750, 500);
        gc.drawImage( title, 700, 0 , 200, 500);

        gc.drawImage( title, 715, 20 , 80, 55);
        gc.drawImage( h1, 740, 25 , 30, 50);
        gc.fillText("50 $", 740, 90);

        gc.drawImage( title, 805, 20 , 80, 55);
        gc.drawImage( h2, 830, 25 , 28, 43);
        gc.fillText("80 $", 830, 90);

        gc.drawImage( title, 715, 100 , 80, 55);
        gc.drawImage( h3, 740, 105 , 30, 50);
        gc.fillText("150 $", 740, 170);

        gc.drawImage( title, 805, 100 , 80, 55);
        gc.drawImage( h4, 840, 105 , 10, 44);
        gc.fillText("300 $", 830, 170);







        final long startNanoTime = System.nanoTime();
        new AnimationTimer()        {
            public void handle(long currentNanoTime) {


                canvas.setOnMouseClicked(
                        new EventHandler<MouseEvent>()
                        {
                            public void handle(MouseEvent e)
                            {
                                Tower tower = new Tower();
                                if ( tower.containsPoint( e.getX(), e.getY() ) ) {
                                    inp++;
                                }
                                else if (e.getX()<700 && inp > 0 && health >=50){
                                    inp--;
                                    n++;
                                    Tower_x[n-1] = e.getX()-15;
                                    Tower_y[n-1]= e.getY()-25;
                                    health -=500;
                                }
                            }
                        });

                double t = (currentNanoTime - startNanoTime) / 100000.0;

                gc.drawImage( sample, 0, 0 , 710, 500);

                gc.drawImage( h5, 725, 200 , 150, 40);
                gc.setFill( Color.BLACK );
                gc.setStroke( Color.BLACK);
                gc.setLineWidth(2);
//                Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 30 );
                Font theFont = Font.font( "Times New Roman",  25 );
                gc.setFont( theFont );
                gc.fillText( "Lever X", 740, 230 );
                gc.strokeText( "Lever X", 740, 230 );

                gc.setFill( Color.RED);

                gc.drawImage( h5, 720, 300 , 150, 40);
                gc.fillText( "Health :  "+ health/10 , 730, 330 );

                for (int i=1;i< 6; i++){
                    int k = (int) (t/100 -i*50-500);

                    if(k>0) {
                        Enemy enemys = new Enemy(k);
                        enemys.action(gc, i);
                        for (int j = 0; j< n ;j++) {
                            if (enemys.collision(Tower_x[j], Tower_y[j], gc)) {
                                health++;
                                Tower_blood[j] --;
                                if(Tower_blood[j] ==0)
                                break;
                            }
                        }



                    }
                }
                for (int i=0 ; i< n; i++){
                    gc.drawImage(h1, Tower_x[i], Tower_y[i],20, 35);

                }


            }

        }.start();


        theStage.show();
    }
}