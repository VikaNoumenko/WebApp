package model;

import java.util.List;
import java.util.Map;

public interface DAO {

	public String getPassword(String password);
	public void createUser(Map<String, String> info);
	public boolean resetPassword(String userName,String password);
	public boolean setMessage(String from, String to, String text);
	public List<?> getUserInfo(String userName);
	public List<?> getUserMessages(String userName);
	public List<?> getUsersList();

}

