package classes;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginFrame extends JFrame implements ActionListener {
    private RoomFindingApp parentFrame;
    private JLabel titleLabel, usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signUpButton, backButton, adminButton;
    private JCheckBox showHidePassword;

    public LoginFrame(RoomFindingApp parentFrame) {
        this.parentFrame = parentFrame;

        titleLabel = new JLabel("ROOM FINDING APP");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        signUpButton = new JButton("SignUp");
        backButton = new JButton("Back");
        adminButton = new JButton("Admin");

        showHidePassword = new JCheckBox("Show Password");
		
		loginButton.setBackground(new Color(255,255,255,255)); 
		signUpButton.setBackground(new Color(255,255,255,255)); 
		backButton.setBackground(new Color(255,255,255,255)); 
		adminButton.setBackground(new Color(255,255,255,255)); 
		showHidePassword.setBackground(Color.PINK); 

        Font labelFont = new Font("Arial", Font.BOLD, 24);
        titleLabel.setFont(labelFont);

        titleLabel.setBounds(200, 50, 400, 50);
        usernameLabel.setBounds(200, 120, 80, 20);
        passwordLabel.setBounds(200, 160, 80, 20);

        usernameField.setBounds(300, 120, 200, 20);
        passwordField.setBounds(300, 160, 200, 20);

        showHidePassword.setBounds(300, 190, 150, 20);

        loginButton.setBounds(250, 230, 80, 30);
        signUpButton.setBounds(340, 230, 80, 30);
        backButton.setBounds(250, 270, 80, 30);
        adminButton.setBounds(340, 270, 80, 30);

        add(titleLabel);
        add(usernameLabel);
        add(passwordLabel);
        add(usernameField);
        add(passwordField);
        add(loginButton);
        add(signUpButton);
        add(backButton);
        add(adminButton);
        add(showHidePassword);

        setTitle("Login");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
		setVisible(true); 
		getContentPane().setBackground(Color.PINK);

        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        backButton.addActionListener(this);
        adminButton.addActionListener(this);
		showHidePassword.addActionListener(this); 

                
    }

    private void checkLogin() 
	{
        try (Scanner scanner = new Scanner(new File("data\\user.txt"))) 
	    {
            while (scanner.hasNextLine()) 
	    	{
                String line = scanner.nextLine();
                String[] userData = line.split(":");
	    
                if (userData.length >= 3) 
	    		{
                    String userNameFromFile = userData[1].trim();
                    String passwordFromFile = userData[4].trim();
                    String enteredUsername = usernameField.getText().trim();
                    String enteredPassword = new String(passwordField.getPassword()).trim();
	    
                    if (enteredUsername.equals(userNameFromFile) && enteredPassword.equals(passwordFromFile)) 
	    			{
                        JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        new Dashboard(this, enteredUsername);
                        return; 
                    }
                }
            } 
            JOptionPane.showMessageDialog(this, "Login Failed! Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
	    catch (FileNotFoundException e)
	    {
            JOptionPane.showMessageDialog(this, "User Data Not Found", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public void resetFields() 
	{
        usernameField.setText("");
        passwordField.setText("");
        showHidePassword.setSelected(false);
        passwordField.setEchoChar('*'); 
    }


    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == loginButton) 
		{
            checkLogin();
        } 
		else if (e.getSource() == signUpButton) 
		{
            setVisible(false);
            new SignUpFrame(this); 
        } 
		else if (e.getSource() == backButton) 
		{
            setVisible(false);
            new RoomFindingApp().setVisible(true);
        } 
		else if (e.getSource() == adminButton) 
		{
             setVisible(false);
             new AdminFrame();
        } 
		else if (e.getSource() == showHidePassword)  
		{
            passwordField.setEchoChar((char) 0); 
        } 
		else  
		{
            passwordField.setEchoChar('*');   
        } 
          
    }

    public static void main(String[] args) 
	{
        new LoginFrame(null); 
    }
}
