package giaiBTlab8;

import java.util.Scanner;

abstract class Person{
	protected String code, name;
	protected int rank;
	public Person(){code =name =""; this.rank=0;}
	

	public Person(String code, String name, int rank) {
		this.code= code; this.name=name; this.rank=rank;
	}
	
	public String getCode() {return code;}
	public String getName() {return name;}
	public int getRank() {return rank;}
	public void display() {
		System.out.println("Person code:" + code);
		System.out.println("Person name:" + name);
		System.out.println("Person Rank:" + rank);
	}
	public abstract String description();
	void input() {
		Scanner kb= new Scanner(System.in);
		System.out.println("nhap ma so:"); code= kb.next(); kb.nextLine();
		System.out.println("nhap ten:"); name= kb.nextLine();
		System.out.println("nhap rank:"); rank= kb.nextInt();
	}
}


class Student extends Person{
	private String DP;
	private int YoG;
	
	void input() {
		super.input();
		Scanner kb=new Scanner(System.in);
		System.out.println("Nhap chuong trinh: ");
		DP=kb.nextLine();
		System.out.println("Nhap nam tot nghiep: ");
		YoG=kb.nextInt();
	}
	
	public void display() {
		super.display();
		System.out.println("\t Chuong trinh hoc: "+DP);
		System.out.println("\t Nam tot nghiep: "+YoG);
	}
	public String description() {
		String t="";
		switch(rank) {
			case 0: t= t+ "None"; break;
			case 1: t= t+ "Preshman"; break;
			case 2: t= t+ "Sophomore"; break;
			case 3: t= t+ "Junior"; break;
			case 4: t= t+ "Senior"; break;
			case 5: t= t+ "Graduate"; break;
			case 6: t= t+ "Masters Postgraduate"; break;
			case 7: t= t+ "PhD Postgraduate\r\n"; break;
		}
		return t;

	}
}
class Professor extends Person{
	private String khoa;
	
	void input() {
		super.input();
		Scanner kb= new Scanner(System.in);
		System.out.println("Nhap khoa cong tac: ");
		khoa=kb.nextLine();
	}
	
	public void display() {
		super.display();
		
		System.out.println("\t Khoa cong tac: "+khoa);
	}
	
	public String description() {
		String t="";
		switch(rank)
		{
			case 0: t= t+ "None"; break;
			case 1: t= t+ "Assistant Professor"; break;
			case 2: t= t+ "Asociate Professor"; break;
			case 3: t= t+ "Professor"; break;
			case 4: t= t+ "Assistant Teaching Professor"; break;
			case 5: t= t+ "Asociate Teaching Professor"; break;
			case 6: t= t+ "Teaching Professor"; 
			
		}
		return t;

	}
}
public class Peoplelist {
	int n;
	Person []a;
	Scanner kb= new Scanner(System.in);
	void input() {
		System.out.println("Nhap so luong nhan vien: ");
		n=kb.nextInt();
		a=new Person[n];
		for(int i=0;i<n;i++) {
			System.out.println("Nhap nguoi thu "+ (i+1) +":");
			System.out.println("Sinh vien hay giao su? (0/ <>0");
			int tl=kb.nextInt();
			if(tl==0) { a[i]=new Student();}
			else {
				a[i] = new Professor();
			}
			a[i].input();
			
		}
	}
	public void display() {
		for(Person x:a) {
			
			x.display();
		}
	}
	
	double tbRank() {
		double k=0;
		for(Person x:a) {
			k+=x.getRank();
		}
		return k/n;
	}
	
	void maxRank() {
		int v=n-1;
		for(int i=n-1;i>= 0;i--) {
			if(a[i].getRank()>a[v].getRank()) v=i;
		}
		System.out.println("Nguoi co rank cao cuoi cung la: ");
		a[v].display();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Peoplelist m=new Peoplelist();
		m.input();
		m.display();
		System.out.println("Trung binh rank: "+m.tbRank());
		m.maxRank();
		System.out.println("\n XONG!!");
	}

}
