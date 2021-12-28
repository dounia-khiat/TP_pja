package bean;
import java.net.*;
import java.io.*;
import java.util.*;

public class serveur {
	public final static int port = 1234;
	static String[] fichier;
	private static void readFile(String trim, PrintWriter is) {
		try {
            File file = new File("pja.txt");
            BufferedReader read = new BufferedReader(new FileReader(file));
            String str;
            while ((str = read.readLine()) != null) {
                System.out.println(str);
            }
            System.out.println("");

		} catch (Exception e) {
            e.printStackTrace();
        }
		
	}
		private static void getFilesList(String trim, PrintWriter is) {
			try {
	            String[] nom_fich;
	            File file = new File("pja.txt");
	            nom_fich = file.list();
	            if (nom_fich.length == 0) {
	                System.out.println("dossier vide");
	                
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket gestionnaire_de_cnx = new ServerSocket(port);
			System.out.println("Server Listening on " +port);
			Socket ma_cnx = gestionnaire_de_cnx.accept();
			PrintWriter is = new PrintWriter(ma_cnx.getOutputStream(), true);
			BufferedReader os = new BufferedReader(new InputStreamReader (ma_cnx.getInputStream()));
			while(true)
			{
				String input =os.readLine();
				System.out.println(input);
				if (input.equals("QUIT")) {
					os.close();
					is.close();
					ma_cnx.close();
					break;
				}
				if (input.startsWith("fichier")) {
                    getFilesList(input.substring(4).trim(), is);
                }
                else if (input.startsWith("end")) {
        
					readFile(input.substring(3).trim(),is);
                }
                
            }
				
			
			
			
			
			
		}
		
		catch(Exception c)
		{
			c.printStackTrace();
		}
	}

}
