
import java.io.*;
import java.util.*;

public class gmail2 {
	
	public static void main(String args[]) throws IOException
	{
		
		Scanner sc=new Scanner(System.in);
		int gl=0;
		
		accounts2 start =new accounts2();
		
		
		String newem,newp;
		int input,oc;
		
		
		
		ArrayList<String> al=start.getAccounts();
		oc=accounts2.count;
		accounts2[] ac=new accounts2[oc];

		String emails[]=new String[2];
		for(int i=0;i<oc;i++){
			emails=al.get(i).split("~");
			ac[i]=new accounts2(emails[0],emails[1]);
		}
		
		one:
		while(true)
		{
			System.out.print("\nEnter your option....\n\n1.Register\n2.Log In\n\nEnter:");
			input=sc.nextInt();
			sc.nextLine();
			if(input==1)
			{
				two:
				while(true)
				{
					System.out.print("\n\n......Registration......");
					System.out.print("\n\nEnter your new email id:");
					newem=sc.nextLine();
					
					if(ac[1].check(newem))
					{
						System.out.print("\nThis email was already taken try any other email \n");
						continue two;
					}
					
					System.out.print("\nEnter password:");
					newp=sc.nextLine();
					ac=increase(ac);
					ac[oc]=start.register(newem,newp);
					oc++;
					System.out.print("\nCongrats....\nyour email registered Successfully\n");
					continue one;
				}
			}
			else if(input==2)
				System.out.println();
			else
				System.out.println("\nInvlaid Input");
			
		
		
			
			while(true)
			{
				inner:
				while(true)
				{
					System.out.print("\n\nLog In:");
					
					System.out.print("\nenter your email:");
					String c=sc.nextLine();
					
					for(int i=0;i<oc;i++)
					{
						if(ac[i].id.equals(c))
						{
							while(true)
							{
								System.out.print("\nenter your password:");
								String d=sc.nextLine();
								if(ac[i].pass.equals(d))
								{
									gl=i;
									System.out.println("\nLogged in..");
									break inner;
								}
								else
									System.out.print("wrong password.");
							}
						}
						if(i==(oc-1) && gl==0 )
						{
							System.out.println("wrong email id....\nplease enter correct email id.\n");
						}		
					}
				}
			
			
				while(true)
				{
					System.out.print("\nEnter your option....\n\n1.compose email\n2.sent box\n3.inbox\n4.logout\n5.Exit\n\nEnter:");
					int p=sc.nextInt();
					sc.nextLine();
					String ue,us;
					if(p==1)
					{
						three:
						while(true)
						{
							System.out.print("\nEnter To address:");
							ue=sc.nextLine();
								if(ac[gl].check(ue))
									break three;
							System.out.print("\nNo such email id found...\nPlease enter a valid email id");
						}
						System.out.print("\nEnter the message:");
						us=sc.nextLine();
						ac[gl].compose(ue,us);
					}
					else if(p==2)
					{
						String n[][]=ac[gl].sent();
						
						if(ac[gl].checkout())
							System.out.println("\n\nNo Emails.....\n\n");
						else
						{
							System.out.println("\n\nEmails.....\n\n");
							
							for (String[] i :n)
							{
								System.out.println("\nTo:"+i[0]);
								System.out.println("mail:"+i[1]);
							}
						}
					}
					else if(p==3)
					{
						String v[][]=ac[gl].inbox();
						
						if(ac[gl].checkin())
							System.out.println("\nNo Emails.....");
						else
						{
		                    System.out.println("\nEmails.....");
							
							for (String[] i :v)
							{
								System.out.println("\nfrom:"+i[0]);
								System.out.println("mail:"+i[1]);
							}
						}
						
					}
					else if(p==4)
					{
						gl=0;
						System.out.println("\nLogged out....\n");
						continue one;
					}
						
					else if(p==5){
						sc.close();
						break one;
					}
						
					else
					{
						System.out.print("\nInvalid option");
					}
				}
			}
		}
	}

	public static accounts2[] increase(accounts2 ac[]){
		accounts2 temp[]=new accounts2[ac.length+1];

		for(int i=0;i<ac.length;i++){
			temp[i]=ac[i];
		}

		return temp;
	}
}

