package Servier;

public class Service {
	public boolean checkUser(String username,String password)
	{
		if("root".equals(username)&&"yuanyang".equals(password))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

}
