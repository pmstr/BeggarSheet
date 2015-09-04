import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	static BeggarSheet masterSheet;
	
	public static void main(String[] args) 
	{
		System.out.println("\n\n-------BeggarSheet Version 1.1a-------\n\n");
		Scanner console = new Scanner(System.in);
		boolean go = true;
		boolean truego = true;
		while(truego == true)
		{
			while(go == true)
			{
				try
				{
					System.out.println("Commands:\n-new\n-save\n-load\n-disp\n-quit/exit");
					String input = console.next();
					if(input.equalsIgnoreCase("new"))
					{
						System.out.println("How many floors do you have?");
						int inFloors = console.nextInt();
						masterSheet = new BeggarSheet(inFloors);
					}
					else if(input.equalsIgnoreCase("disp"))
					{
						System.out.println(masterSheet);
					}
					else if(input.equalsIgnoreCase("load"))
					{
						System.out.println("Please enter the file name you wish to open: ");
						String temp = console.next();
						Scanner f = new Scanner("this");
						try
						{
							f = new Scanner(new File(temp + "txt"));
						} catch (FileNotFoundException e)
						{
							e.printStackTrace();
						}
						masterSheet = new BeggarSheet(f.nextInt(), true);
						masterSheet.load();
					}
					else if(input.equalsIgnoreCase("save"))
					{
						String outStr = masterSheet.getInfo();
						System.out.println("Please enter the file name you wish to save this as: ");
						String temp = console.next();
						try
						{
							File saving = new File(temp + ".txt");
							BufferedWriter output = new BufferedWriter(new FileWriter(saving));
							output.write(outStr);
							output.close();
						}
						catch ( IOException e ) 
						{
							System.out.println("Error: " + e.getMessage());
						}
					}
					else if(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit"))
					{
						go = false;
					}
					else
					{
						System.out.println("What the fuck did you just say? Try that again.");
					}
				}catch(Exception e )
				{
					System.out.println("There was an error: " + e.getMessage());
				}
				
			}//end while
			System.out.println("Are you sure? Type anything other than no to exit.");
			if(console.next().equals("no"))
			{
				go = true;
			}
			else
			{
				truego = false;
			}
		}//end backup while
		console.close();
	}

}