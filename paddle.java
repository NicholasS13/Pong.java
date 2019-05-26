public class paddle
{
	private double xpos;
	private double ypos;

	public paddle()
	{
		this.xpos=50;
		this.ypos=125;
	}

	public paddle(double x)
	{
		this.xpos=x;
		this.ypos=125;
	}

	public void moveUp()
	{
		if(this.ypos>0)
		{
			this.ypos-=5;
		}
	}

	public void moveDown()
	{
		if(this.ypos<400-120)
		{
			this.ypos+=5;
		}
	}

	public double getXpos()
	{
		return this.xpos;
	}

	public double getYpos()
	{
		return this.ypos;
	}
}