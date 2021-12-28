package bean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class thread_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	try
	{
		final Socket clientSocket;
	      final BufferedReader in;
	      final PrintWriter out;
	      final Scanner sc = new Scanner(System.in);
	      clientSocket = new Socket("127.0.0.1",5000);
	      out = new PrintWriter(clientSocket.getOutputStream());
	      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	      Thread envoyer = new Thread(new Runnable() {
	             String msg;
	              @Override
	              public void run() {
	                while(true){
	                  msg = sc.nextLine();
	                  out.println(msg);
	                  out.flush();
	                }
	             }
	         });
	      envoyer.start();
	      Thread recevoir = new Thread(new Runnable() {
	            String msg;
	            @Override
	            public void run() {
	               try {
	                 msg = in.readLine();
	                 while(msg!=null){
	                    System.out.println("Serveur : "+msg);
	                    msg = in.readLine();
	                 }
	                 System.out.println("Serveur déconecté");
	                 out.close();
	                 clientSocket.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	            }
	        });
	      
	      recevoir.start();
	      
    
	}
	catch(Exception b)
	{
		b.printStackTrace();
	}
	}

}
