package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpFrame extends JFrame implements ActionListener  
{ 
    private LoginFrame parentFrame;
    private JLabel titleLabel, nameLabel, usernameLabel, ageLabel, genderLabel, passwordLabel;
    private JTextField nameField, usernameField, ageField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderButtonGroup;
    private JPasswordField passwordField;
    private JButton signUpButton, backButton;
    private JCheckBox showHidePassword;

    public SignUpFrame(LoginFrame parentFrame) {
        this.parentFrame = parentFrame;

        titleLabel = new JLabel("ROOM FINDING APP");
        nameLabel = new JLabel("Name:");
        usernameLabel = new JLabel("Username:");
        ageLabel = new JLabel("AGE:");
        genderLabel = new JLabel("Gender:");
        passwordLabel = new JLabel("Password:");

        nameField = new JTextField();
        usernameField = new JTextField();
        ageField = new JTextField();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        passwordField = new JPasswordField();
        signUpButton = new JButton("Sign Up");
        backButton = new JButton("Back");

        showHidePassword = new JCheckBox("Show Password");

        Font labelFont = new Font("Arial", Font.BOLD, 24);
        titleLabel.setFont(labelFont);

        titleLabel.setBounds(200, 50, 400, 50);
        nameLabel.setBounds(200, 120, 80, 20);
        usernameLabel.setBounds(200, 160, 80, 20);
        ageLabel.setBounds(200, 200, 80, 20);
        genderLabel.setBounds(200, 240, 80, 20);
        passwordLabel.setBounds(200, 280, 80, 20);
        nameField.setBounds(300, 120, 200, 20);
        usernameField.setBounds(300, 160, 200, 20);
        ageField.setBounds(300, 200, 200, 20);
        maleRadioButton.setBounds(300, 240, 80, 20);
        femaleRadioButton.setBounds(400, 240, 80, 20);
        passwordField.setBounds(300, 280, 200, 20);
        showHidePassword.setBounds(300, 310, 150, 20);
        signUpButton.setBounds(250, 350, 80, 30);
        backButton.setBounds(340, 350, 80, 30);
		
		signUpButton.setBackground(new Color(255,255,255,255)); 
		backButton.setBackground(new Color(255,255,255,255));  
		maleRadioButton.setBackground(Color.PINK);  
		femaleRadioButton.setBackground(Color.PINK);   
		showHidePassword.setBackground(Color.PINK); 

        add(titleLabel);
        add(nameLabel);
        add(usernameLabel);
        add(ageLabel);
        add(genderLabel);
        add(passwordLabel);
        add(nameField);
        add(usernameField);
        add(ageField);
        add(maleRadioButton);
        add(femaleRadioButton);
        add(passwordField);
        add(signUpButton);
        add(backButton);
        add(showHidePassword);

        setTitle("Sign Up");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
		getContentPane().setBackground(Color.PINK);
		setVisible(true);

        signUpButton.addActionListener(this);
        backButton.addActionListener(this);
        showHidePassword.addActionListener(this);

        
    }

    private void signUp() 
	{

        String name = nameField.getText().trim();
        String username = usernameField.getText().trim();
        String age = ageField.getText().trim();
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars).trim();
	    
        if (name.isEmpty() || username.isEmpty() || age.isEmpty() || password.isEmpty()) 
		{
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
		else 
		{
            User user = new User(name, username, age, gender, password);
	        boolean signUpSuccess = user.signUp();
	    
            if (signUpSuccess) 
			{
                JOptionPane.showMessageDialog(this, "Sign Up Successful!");
                setVisible(false);
                parentFrame.setVisible(true);
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "Sign Up Failed! Please try again.", "Error", JOptionPane.ERROR_MESSAGE); 
            }
        }
        for (int i = 0; i < passwordChars.length; i++) {
            passwordChars[i] = ' '; 
        } 
    }


    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == signUpButton)
		{
            signUp();
        } 
		else if (e.getSource() == backButton) 
		{
            setVisible(false);
            parentFrame.setVisible(true);
        } 
		else if (e.getSource() == showHidePassword) 
		{
            if (showHidePassword.isSelected()) 
			{
                passwordField.setEchoChar((char) 0); 
            } 
			else 
			{
                passwordField.setEchoChar('*');  
            }
        }
    }

    public static void main(String[] args) 
	{
        new SignUpFrame(null); 
    } 
} 