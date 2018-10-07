import java.util.Scanner;

public class Question_04 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter your source Number");
		int sn=scn.nextInt();
		
		System.out.println("Enrter Your Sorce Base");
		int sb=scn.nextInt();
		
		System.out.println("Enter Your Destination Base");
		int db=scn.nextInt();
		
		System.out.println("Your ans is:" + destination(sn,sb,db));
		
		

	}
	
	public static int decimal(int sn, int sb){
		int rv=0,pow=1;
		for(int i=1;sn!=0;i++){
			int rem=sn%10;
			sn=sn/10;
			rv= rv + rem*pow;
			pow=pow*sb;
		}
		return rv;
	}
	
	public static int destination(int sn, int sb, int db){
		int rv=0,pow=1;
		int n=decimal(sn,sb);
		for(int i=1;n!=0;i++){
			int rem=n%db;
			n=n/db;
			rv=rv + rem*pow;
			pow=pow*10;
		}
		return rv;
		
	}

}
