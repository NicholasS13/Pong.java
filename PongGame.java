import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.media.AudioClip;
import java.net.URL;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;

public class PongGame extends Application implements EventHandler<InputEvent>
{
	GraphicsContext gc;
	Canvas canvas;
	AnimateObjects animate;
	paddle player1;
	paddle player2;
	Ball ball;
	public void start(Stage stage)
	{

		stage.setTitle("Pong");
		Group root = new Group();
		canvas = new Canvas(400,400);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		scene.addEventHandler(KeyEvent.KEY_PRESSED,this);
		scene.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
		gc = canvas.getGraphicsContext2D();
		player1 = new paddle();
		player2 = new paddle(canvas.getWidth()-70);
		ball = new Ball();
		animate = new AnimateObjects();
		animate.start();
		stage.show();
	}

	public class AnimateObjects extends AnimationTimer
	{
		public void handle(long now)
		{
			if((ball.getXpos()<=player1.getXpos()+20&&ball.getXpos()>player1.getXpos())||(ball.getXpos()<=player2.getXpos()+20&&ball.getXpos()>player2.getXpos()))
				if((ball.getYpos()>=player1.getYpos()&&ball.getYpos()<player1.getYpos()+120)||(ball.getYpos()>=player2.getYpos()&&ball.getYpos()<player2.getYpos()+120)){
					ball.changeIncrimentx();
					ball.changeIncrimenty();
				}
			ball.move();
			gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
			gc.fillRect(player1.getXpos(),player1.getYpos(),20,120);//paddle 1

			gc.fillRect(player2.getXpos(),player2.getYpos(),20,120);//paddle 2

			gc.fillRect(ball.getXpos(),ball.getYpos(),20,20);//ball

			//board styling
			gc.fillRect(canvas.getWidth()/2,0,3,canvas.getHeight());//center line
			gc.fillRect(0,0,canvas.getWidth(),5);
			gc.fillRect(0,0,5,canvas.getHeight());
			gc.fillRect(canvas.getWidth()-5,0,5,canvas.getHeight());
			gc.fillRect(0,canvas.getHeight()-5,canvas.getWidth(),5);

		}
	}

	public void handle(final InputEvent event)
	{
		if(event instanceof KeyEvent)
		{
			if(((KeyEvent)event).getCode()==KeyCode.UP)
			{
				player2.moveUp();
			}
			if(((KeyEvent)event).getCode()==KeyCode.DOWN)
			{
				player2.moveDown();
			}

			if(((KeyEvent)event).getCode()==KeyCode.W)
			{
				player1.moveUp();
			}

			if(((KeyEvent)event).getCode()==KeyCode.S)
			{
				player1.moveDown();
			}
		}
	}

	public static void main(String[] args)
	{
		launch();
	}


}
