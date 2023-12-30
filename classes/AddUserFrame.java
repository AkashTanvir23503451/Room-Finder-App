package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserFrame extends JFrame implements ActionListener 
{
    private JTextField nameField, usernameField, ageField, passwordField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JButton addButton, cancelButton;
    private AdminFrame parentFrame;
    private ButtonGroup genderGroup;

    public AddUserFrame(AdminFrame parentFrame) 
	{
        this.parentFrame = parentFrame;

        setTitle("Add User");
        setLayout(null);

        nameField = new JTextField();
        usernameField = new JTextField();
        ageField = new JTextField();
        passwordField = new JTextField();

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        addButton.addActionListener(this);
        cancelButton.addActionListener(this);

        JLabel nameLabel = new JLabel("Name:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel passwordLabel = new JLabel("Password:");

        nameLabel.setBounds(20, 20, 80, 25);
        nameField.setBounds(100, 20, 180, 25);
        usernameLabel.setBounds(20, 50, 80, 25);
        usernameField.setBounds(100, 50, 180, 25);
        ageLabel.setBounds(20, 80, 80, 25);
        ageField.setBounds(100, 80, 180, 25);
        genderLabel.setBounds(20, 110, 80, 25);
        maleRadioButton.setBounds(100, 110, 80, 25);
        femaleRadioButton.setBounds(180, 110, 80, 25);
        passwordLabel.setBounds(20, 140, 80, 25);
        passwordField.setBounds(100, 140, 180, 25);

        addButton.setBounds(20, 180, 80, 25);
        cancelButton.setBounds(110, 180, 80, 25);
		
		addButton.setBackground(new Color(255,255,255,255)); 
		cancelButton.setBackground(new Color(255,255,255,255)); 

        add(nameLabel);
        add(nameField);
        add(usernameLabel);
        add(usernameField);
        add(ageLabel);
        add(ageField);
        add(genderLabel);
        add(maleRadioButton);
        add(femaleRadioButton);
        add(passwordLabel);
        add(passwordField);
        add(addButton);
        add(cancelButton);

        setSize(300, 250); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
		getContentPane().setBackground(Color.PINK); 
    }

    @Override
    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == addButton) 
		{
            String name = nameField.getText();
            String username = usernameField.getText();
            String age = ageField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String password = passwordField.getText(); 

            if (name.isEmpty() || username.isEmpty() || age.isEmpty() || password.isEmpty() || gender.isEmpty()) 
			{
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            } 
			else 
			{
                String[] userData = {name, username, age, gender, password}; 
                parentFrame.addUser(userData);
                dispose();
            }
        } else if (e.getSource() == cancelButton) 
		{
            dispose();
        }
    }

    public static void main(String[] args) 
	{
        new AddUserFrame(null); 
    }
}
