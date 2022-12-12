import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DomandiereProva
{
	public static void main(String[] args) throws IOException
	{
		FileReader dom = new FileReader("domande.txt");
		BufferedReader lettore = new BufferedReader(dom);
		
		String data = lettore.readLine();
		while(data != null)
		{
			if(data.charAt(0) == 49 || data.charAt(1) == 50 || data.charAt(0) == 97) {
				System.out.println(data);
			}
			
			data = lettore.readLine();
		}
	}
}
