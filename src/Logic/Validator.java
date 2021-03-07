package Logic;


public class Validator {
	
	public boolean numberOk(Integer numb,Integer min,Integer max) {
		
		int length = (int) (Math.log10(numb) + 1);
		if(length <= max && length >= min)
			{
			return true;
			}
		else
			{
			return false;
			}
	}
	
	
	public boolean stringOk(String str,Integer min,Integer max) {
		if(str.length() <= max && str.length() >= min)
			{
			return true;
			}
		else
			{
			return false;
			}
	}
	
	public boolean emailOk(String email,Integer min,Integer max) {
		
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    if(email.matches(regex)) {
	    	if(email.length() <= max && email.length() >= min)
				{
				return true;
				}
			else
				{
				return false;
				}
	    }
	    else
		    {
		    	return false;
		    }
			
		
	}
}
