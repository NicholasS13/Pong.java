public class Ball
{
	private double xpos;
	private double ypos;
	private int incrimentx =1;
	private int incrimenty = 1;
	private int player1Score = 0;
	private int player2Score = 0;
	public Ball()
	{
		xpos=400/2-20;
		ypos=400/2-60;

	}
	public void changeIncrimenty()
	{
		incrimenty*=-1;
	}

	public void changeIncrimentx(){
		incrimentx*=-1;
	}
	public void move()
	{
		if(ypos==400-10||ypos==0)
			incrimenty*=-1;
		if(xpos==400-10)
			player1Score++;
		if(xpos==0)
			player2Score++;
		xpos+=incrimentx;
		ypos+=incrimenty;
	}

	public double getXpos()
	{
		return xpos;
	}

	public double getYpos()
	{
		return ypos;
	}

	public int getP1Score()
	{
		System.out.println("Player 1's score is:"+player1Score);
		return player1Score;
	}

	public int getP2Score()
	{
		System.out.println("Player 2's score is:"+player2Score);
		return player2Score;
	}
}