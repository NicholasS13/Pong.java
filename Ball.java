public class Ball
{
	private double xpos;
	private double ypos;
	private int incrimentx =1;
	private int incrimenty = 1;
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
		if(xpos==400-10||xpos==0)
			incrimentx*=-1;
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
}