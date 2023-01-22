import java.util.Random;

public class Dado
{
	Random rand = new Random();
	public int lancia()
	{
		return (int) (rand.nextInt(5))+1;
	}
}
