package classes;

import java.io.FileWriter;
import java.io.IOException;

public class User 
{
    private String name;
    private String username;
    private String age;
    private String gender;
    private String password;

    public User(String name, String username, String age, String gender, String password) 
	{
        this.name = name;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.password = password;
    }

    public boolean signUp() 
	{
        try (FileWriter fileWriter = new FileWriter("data\\user.txt", true)) 
		{
            String userData = name + ":" + username + ":" + age + ":" + gender + ":" + password + "\n"; 
            fileWriter.write(userData);
            return true; 
        } 
		catch (IOException e) 
		{
            return false; 
        }
    } 
}
