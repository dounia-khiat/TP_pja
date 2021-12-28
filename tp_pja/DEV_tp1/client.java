package bean;
import java.net.*;
import java.util.*;
import java.io.*;


public class client {
//public static ServerSocket gestionnaire_de_cnx;
public final static int port = 1234;
boolean stat = true ;
public static void envoyer(Scanner sc , PrintWriter mon_entre, Socket ma_cnx )
{
	try {
	String message =sc.nextLine();
	System.out.println(message);
	if(message.equals("QUIT")) {
		boolean stat = false;
		ma_cnx.close();
	}}
	
	catch(IOException c  )
	{
		c.printStackTrace();
	}
	
	
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket ma_cnx = new Socket ("localhost",port);
			System.out.println("waiting for cnx");
			PrintWriter mon_entre = new PrintWriter (ma_cnx.getOutputStream());
			System.out.println("client admis IP sur le port"+port);
			InputStreamReader  isr = new InputStreamReader (ma_cnx.getInputStream());
			BufferedReader flux_entrant = new BufferedReader(isr);
			System.out.println("mon tampon de lecture ecrire attache");
			Scanner sc = new Scanner (System.in);
			PrintWriter ma_sortie = new PrintWriter(ma_cnx.getOutputStream(), true);
			System.out.println("mon tampon pour ecrire attache");
			try {
					envoyer(sc, mon_entre, ma_cnx);
					String rep;
					while ((rep = flux_entrant.readLine()) != null)
					{
						System.out.println(rep);
						
						if (rep.equals("")) {
							break;
						}
					}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
