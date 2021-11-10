package DEV_tp1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;



public class classe3 {
	public static void main(String [] args)
	{
	Scanner sc =new Scanner(System.in);
	  
	  
    try
    {   
          InputStreamReader fichier = new InputStreamReader(new FileInputStream( "emp.dat"));
          BufferedReader    bf  = new BufferedReader(fichier);
          
          System.out.println("entrer le numéro d'employé svp!\n ");
	    	int numemp = sc.nextInt();
	    	String ligne;
	    	
          while((ligne = bf.readLine()) != null) {
              System.out.println(ligne);
              if (ligne == "number" ){
              System.out.println("Employee -> name :%s ,address :%s , SSN :%d ,number :%d");
              }
          }
          System.out.println("employee n'existe pas");

          bf.close();
    
    }
    catch(IOException i)
    {
        i.printStackTrace();
    } catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    sc.close();

}}
