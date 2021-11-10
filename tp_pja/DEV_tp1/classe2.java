
package DEV_tp1;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class classe2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		System.out.println("enter le nombre que vous voulez connait" +v);
		try {
			RandomAccessFile raf = new RandomAccessFile("C:\\ficher\\emp.dat", "r");
			System.out.println("votre position est : \n");
			byte[] bytes = new byte[s.nextByte()];
			
			for(int i=0; i<=v;i++)
			{
				
				raf.read(bytes);
				
			}
			
			raf.close();
			System.out.println(new String(bytes));
		
		
		}
		catch(Exception h )
		{
			h.printStackTrace();
		}
	}

}
