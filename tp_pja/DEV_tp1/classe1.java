package DEV_tp1;



import java.io.Console;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class classe1 {
	  public static void main(String [] args)
	   {  Scanner sc =new Scanner(System.in);
		  System.out.println("entrer le nombre d'objet a sérialiser svp!\n");
		  int no = sc.nextInt();
		  System.out.printf("le nombre d'objet a sérialiser = %d\n",no);
		  System.out.println("*****************");
		  
		  
	      try
	      {  
	          employer[] Employees = new employer[no];
	         FileOutputStream fileOut = new FileOutputStream("C:\\ficher\\emp.dat",true);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    
	         for(int i=0 ; i<no ; i++) {
	        	  System.out.println("entrer le nom ,l'address ,le SSN , le number");
				  Employees[i]= new employer(sc.next(),sc.next(),sc.next(),sc.nextInt());
		   	      System.out.println(Employees[i].toString());
		   	      System.out.println("*****************");
		   	       out.writeObject(Employees);
		   		  }
	   	      out.close();
	         fileOut.close();
	         System.out.printf("donnees serialisees sauvegardees dans emp.dat");
	      }
	      catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	   }
}
