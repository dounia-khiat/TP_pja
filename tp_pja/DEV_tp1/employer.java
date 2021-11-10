package DEV_tp1;
import java.io.*;
public class employer implements Serializable {

	
	 public static int length;
	String nom;
	 String prenom;
	 String adress;
	 int age;
	 

		public employer() {
			super();
		}			 
	 
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public employer(String nom, String prenom, String adress, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.age = age;
	}


	@Override
	public String toString() {
		return "employer [nom=" + nom + ", prenom=" + prenom + ", adress=" + adress + ", age=" + age + "]";
	}
	 
	 public void read(RandomAccessFile raf) throws IOException
	 {
		 char [] temp = new char[15];
		 for(int i=0;i<=temp.length;i++)
		 {
			 temp[i]= raf.readChar();
			 nom= new String(temp);
		 }
		 temp= new char[15];
		 for(int i=0;i<=temp.length;i++)
		 {
			 temp[i]= raf.readChar();
			 prenom = new String(temp);
			 
			 
		 }
		 temp = new char[30];
		 for(int i=0;i<=temp.length;i++)
		 {
			 temp[i]=raf.readChar();
			 adress = new String(temp);
			 age = raf.read();
			 
		 }
	 }
		 
		  void write (RandomAccessFile raf) throws IOException{
			
			  StringBuffer sb;
			  if(nom != null)
			  {
				  sb = new StringBuffer(nom);
			  }
			  else
			  {
				  sb = new StringBuffer();
			  }
			  
			  sb.setLength(15);
			  raf.writeChars(sb.toString());
			  
			  if(adress !=null)
			  {
				  sb = new StringBuffer(adress);
			  }
			  else
			  {
				  sb = new StringBuffer();
			  }
			  sb.setLength(15);
			  raf.writeChars(sb.toString());
			  raf.write(age);
			  
			  
			  
			  
		  
		 }
	 
		  	public int size() {
		  
		  		return 2*(15+15+30)+9;
		  	}


		 
		 
		 
	 }
	 

