

import java.io.*;
import java.util.ArrayList;


public class accounts2 {
	
	String id;
	String pass;
	static int count;
	static ArrayList<String> all_id =new ArrayList<String>();
	static ArrayList<String> sender =new ArrayList<String>();
	static ArrayList<String> msg=new ArrayList<String>();
	static ArrayList<String> receiver=new ArrayList<String>();



	
	
	public accounts2(){
		try {
			File file1=new File(".\\messages.txt");
			FileReader r = new FileReader(file1);
			BufferedReader br =new BufferedReader(r);
			
			String s;
			String []g=new String[3];
			s=br.readLine();
			while(s!=null)
			{
				g=s.split("~");
				sender.add(g[0]);
				msg.add(g[1]);
				receiver.add(g[2]);
				s=br.readLine();
			}
			br.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
		public ArrayList<String> getAccounts() throws IOException
		{
			File file=new File(".\\emails.txt");
			FileReader r = new FileReader(file);
			BufferedReader br =new BufferedReader(r);
			
			String s;
			
			ArrayList<String> al=new ArrayList<>();

			s=br.readLine();
			while(s!=null){	
						
				al.add(s);
				s=br.readLine();
			}
			br.close();
			count=al.size();

			return al;
		}
	
	public accounts2(String a,String b) throws IOException
	{
		id=a;
		pass=b;
		all_id.add(a);
		count++;
	}
	public void compose(String a,String b) throws IOException
	{
		sender.add(this.id);
		msg.add(b);
		receiver.add(a);
		
		File file1=new File(".\\messages.txt");
		
		FileWriter w =new FileWriter(file1,true);
		BufferedWriter bw =new BufferedWriter(w);
		
		bw.write(this.id+"~"+b+"~"+a);
		bw.newLine();
		bw.flush();
		bw.close();
	}
	public String[][] sent()
	{
		int k=sender.size();
		ArrayList<Integer> count=new ArrayList<Integer>();
		count.clear();
		for(int i=0;i<k;i++)
		{
			if(this.id.equals(sender.get(i)))
			{
				count.add(i);
			}	
		}
		int j=0;
		int w=count.size();
		String c[][]=new String[w][2];
		for(int i:count)
		{
			c[j][0]=receiver.get(i);
			c[j][1]=msg.get(i);
			j++;
		}
		return c;
	}
	
	public String[][] inbox()
	{
		
		int k=receiver.size();
		
		ArrayList<Integer> count=new ArrayList<Integer>();
		for(int i=0;i<k;i++)
		{
			if(this.id.equals(receiver.get(i)))
				count.add(i);
				
		}
		int j=0;
		int w=count.size();
		String c[][]=new String[w][2];
		for(int i:count)
		{
			c[j][0]=sender.get(i);
			c[j][1]=msg.get(i);
			j++;
		}
		return c;
		
	}
	
	public boolean check(String a)
	{

		for(String i:all_id)
		{
			if(i.equals(a))
				return true;
		}
		return false;
				
	}

	public accounts2 register(String e,String p) throws IOException{

		File file1=new File(".\\emails.txt");
		
		FileWriter w =new FileWriter(file1,true);
		BufferedWriter bw =new BufferedWriter(w);
		

		bw.write(e+"~"+p);
		bw.newLine();
		bw.flush();
		bw.close();

		all_id.add(e);

		return new accounts2(e,p);
	}
	
	public boolean checkin()
	{

		int ch=0;
		for(String i:receiver)
		{
			if(i.equals(id))
				ch=1;	
		}
		if(ch==0)
			return true;
		return false;
	}
	
	public boolean checkout()
	{
		int ch=0;
		for(String i:sender)
		{
			if(i.equals(id))
				ch=1;	
		}
		if(ch==0)
			return true;
		return false;
	}
}

