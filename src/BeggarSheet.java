import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BeggarSheet 
{
	Worker[][] building;
	public int floors;
	
	BeggarSheet(int inFloors, boolean what)
	{
		floors = inFloors;
		newSheet();
	}
	
	BeggarSheet(int inFloors)
	{
		floors = inFloors;
		newSheet();
		System.out.println("I will now ask for each worker's name, money produced (no commas), and time worked.\n");
		Scanner console = new Scanner(System.in);
		for(int floor = 0; floor < floors; floor++)
		{
			for(int room = 0; room < 3; room++)
			{
				System.out.println("Name?");
				building[floor][room].name = console.next();
				System.out.println("Money produced?");
				building[floor][room].gold = console.nextInt();
				System.out.println("Hours?");
				building[floor][room].hours = console.nextInt();
				System.out.println("Minutes?");
				building[floor][room].minutes = console.nextInt();
				System.out.println("Seconds?");
				building[floor][room].seconds = console.nextInt();
				building[floor][room].setTime();
				building[floor][room].getGPS();
			}
		}
		console.close();
	}
	
	public void load()
	{
		Scanner f = new Scanner("this");
		try
		{
			f = new Scanner(new File("test.txt"));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		floors = f.nextInt();
		for(int floor = 0; floor < floors; floor++)
		{
			for(int room = 0; room < 3; room++)
			{
				building[floor][room].name = f.next();
				building[floor][room].gold = f.nextInt();
				building[floor][room].hours = f.nextInt();
				building[floor][room].minutes = f.nextInt();
				building[floor][room].seconds = f.nextInt();
				building[floor][room].setTime();
				building[floor][room].getGPS();
			}
		}
	}
	
	public void newSheet()
	{
		building = new Worker[floors][3];
		for(int floor = 0; floor < floors; floor++)
		{
			for(int room = 0; room < 3; room++)
			{
				building[floor][room] = new Worker();
			}
		}
	}
	
	public String getInfo()
	{
		String out = floors + "\n";
		for(int floor = 0; floor < floors; floor++)
		{
			for(int room = 0; room < 3; room++)
			{
				out += building[floor][room].getInfo();
			}
		}
		return out;
	}
	@Override
	public String toString()
	{
//		return
//				"+---------------------------------------------------+\n" +
//				"|            |     A      |     B      |     C      |\n" +
//				"+------------+------------+------------+------------|\n" + 
//				"|     1      |" + building[1][0] + "|" + building[1][1] + "|" + building[1][2] + "|\n" + 
//				"+------------+------------+------------+------------|\n" + 
//				"|     2      |" + building[0][0] + "|" + building[0][1] + "|" + building[0][2] + "|\n" + 
//				"+------------+------------+------------+------------+";
		String out = "+---------------------------------------------------+\n|            |     A      |     B      |     C      |\n";
		for(int floor = floors - 1; floor > -1; floor--)
		{
			out+= "+------------+------------+------------+------------|\n|     " + floor + "      |";
			for(int room = 0; room < 3; room++)
			{
				out += building[floor][room] + "|";
				if(room == 2)
					out += "\n";
			}
		}
		out += "+------------+------------+------------+------------+";
		return out;
	}
}