 import java.util.*;
class Student 
{
	String name;
	int token;
	double cgpa;
	Student(String name,double cgpa,int token)
	{
		this.name=name;
		this.cgpa=cgpa;
		this.token=token;
	}
	public String giveName()
	{
		return name;
	}
	public double giveCgpa()
	{
		return cgpa;
	}
	public int giveTokenNo()
	{
		return token;
	}
}

class StudentComparer implements Comparator<Student>
{
	@Override
	public int compare(Student s1,Student s2)
	{
		//storing cgpa values for comparision
		double cgpa1=s1.giveCgpa();
		double cgpa2=s2.giveCgpa();
		//comparing if any 2 cgpa are equal
		//if they are equal we go to else block otherwise we enter if block
		if(cgpa1!=cgpa2)
		{
			if(cgpa1>cgpa2)
				return -1;
			else
				return 1;
		}
		else
		{
			//storing name for comparision
			int nameValue=((s1.giveName()).compareTo(s2.giveName()));
			//storing token value for comparision
			int tokenValue=s1.giveTokenNo()-s2.giveTokenNo();
			//if both names are not same then returning value accoring to differnce 			//in ascii
			if(nameValue!=0)
			{
				return nameValue;
			}
			//if both names are equal then as cgpa is also equal so only thing left is 				//token no.
			else
			{
				return tokenValue;
			}
		}
	}
}
//class containing main() where all input and output will take place
public class Assignment
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int eventno=sc.nextInt();
		PriorityQueue<Student> PQ=new PriorityQueue<Student>(eventno,new StudentComparer());
		//Takes each student details as input
		while(eventno!=0)
		{
			String event=sc.next();
			if(event.equals("ENTER"))
			{
				String name=sc.next();
				double cgpa=sc.nextDouble();
				int token=sc.nextInt();
				Student s=new Student(name,cgpa,token);
				PQ.offer(s);
			}
			else
			{
				PQ.poll();
			}
			eventno--;
		}
		//Prints empty if queue is empty
		if(PQ.isEmpty())
		{
			System.out.println("EMPTY");
		}
		//Prints the final list
		else
		{
		    Student s;
			while(!PQ.isEmpty())
			{
			    s=PQ.poll();
			    System.out.println(s.giveName());
			}
		}
	}
}		
	