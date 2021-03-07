package Logic;

import java.util.Arrays;



public class Formatter {

	public String upAllWords(String text)
	{

		boolean up = false;
		char c;
		String retrunString = "";
		text = takeOutSpaces(text);
		
		for(int i=0;i<text.length();i++)
		{
			
			//primer letra mayuscula y cada letra despues de un espacio
			if(i==0 || up)
			{
				c = Character.toUpperCase(text.charAt(i));
				up = false;
			}
			else
			{
				//hay espacios?
				if(text.charAt(i) == ' ')
				{
					c = ' ';
					up = true;
				}
				else
				{
					c = Character.toLowerCase(text.charAt(i));
				}
				
			}
			
			//agregar char
			retrunString += c;
		}
		
		return retrunString;
	}
	
	public String upFirstWord(String text)
	{

		char c;
		String retrunString = "";
		text = takeOutSpaces(text);
		
		for(int i=0;i<text.length();i++)
		{
			
			//primer letra mayuscula y cada letra despues de un espacio
			if(i==0)
			{
				c = Character.toUpperCase(text.charAt(i));
			}
			else
			{
				c = Character.toLowerCase(text.charAt(i));
			}
			
			//agregar char
			retrunString += c;
		}
		
		return retrunString;
	}
	
	public String downAllWords(String text)
	{
		char c;
		String retrunString = "";
		text = takeOutSpaces(text);
		
		for(int i=0;i<text.length();i++)
		{
			c = Character.toLowerCase(text.charAt(i));
			
			//agregar char
			retrunString += c;
		}
				
		return retrunString;
	}
	
	public static String takeOutSpaces(String text)
	{	
		String retrunString = text.trim();
		return retrunString;
	}
}
