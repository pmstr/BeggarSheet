
public class Worker 
{
	public String name;
	public int gold;
	public int time;
	public double gps;
	public int hours;
	public int minutes;
	public int seconds;
	
	public void setTime()
	{
		int thours = hours * 60;
		int tminutes = (minutes + thours) * 60;
		int tseconds = seconds + tminutes;
		time = tseconds;
	}
	
	public void getGPS()
	{
		gps = (double)gold / (double)time;
	}
	
	public String getInfo()
	{
		return name + " " + gold + " " + hours + " " + minutes + " " + seconds + "\n";
	}
	
	@Override
	public String toString()
	{
		String inString = String.format("%f", gps);
		String outString = "";
		if(inString.length() < 12)
		{
			int blanks = 12 - inString.length();
			if(blanks % 2 == 0)
			{
				for(int i = 0; i < blanks / 2; i++)
				{
					outString += " ";
				}
				outString += inString;
				for(int i = 0; i < blanks / 2; i++)
				{
					outString += " ";
				}
				return outString;
			}
			else
			{
				for(int i = 0; i < blanks / 2; i++)
				{
					outString += " ";
				}
				outString += inString;
				for(int i = 0; i <= blanks / 2; i++)
				{
					outString += " ";
				}
				return outString;
			}
		}
		else if(inString.length() > 12)
		{
			return inString.substring(0,11) + '>';
		}
		else
		{
			return inString;
		}
	}
}