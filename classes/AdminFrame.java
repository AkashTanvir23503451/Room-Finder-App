package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminFrame extends JFrame implements ActionListener 
{
    private JLabel userDataLabel; 
    private JTable userTable;
    private DefaultTableModel tableModel;
    private JButton addButton, editButton, deleteButton, logoutButton;

    public AdminFrame() 
	{ 
        setTitle("Admin Panel");
        setLayout(null);

        userDataLabel = new JLabel("User Data");
        userDataLabel.setBounds(20, 20, 150, 30);
        add(userDataLabel);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Username");
        tableModel.addColumn("Age");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Password");

        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable); 
        scrollPane.setBounds(20, 60, 750, 350);
        add(scrollPane);

        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        logoutButton = new JButton("Logout");

        addButton.setBounds(20, 420, 80, 30);
        editButton.setBounds(110, 420, 80, 30);
        deleteButton.setBounds(200, 420, 80, 30);
        logoutButton.setBounds(650, 20, 100, 30);
		
		addButton.setBackground(new Color(255,255,255,255)); 
		logoutButton.setBackground(new Color(255,255,255,255)); 
		editButton.setBackground(new Color(255,255,255,255)); 
		deleteButton.setBackground(new Color(255,255,255,255)); 

        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        logoutButton.addActionListener(this);

        add(addButton);
        add(editButton);
        add(deleteButton);
        add(logoutButton);

        loadUserDataFromFile();

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		getContentPane().setBackground(Color.PINK); 
    }

    private void loadUserDataFromFile() 
	{
        try {
            File file = new File("data\\user.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) 
	    	{
                String userData = scanner.nextLine();
                String[] userDataArray = userData.split(":");
                tableModel.addRow(userDataArray);
            }
            scanner.close();
        } 
	    catch (FileNotFoundException e) 
	    {
            JOptionPane.showMessageDialog(this, "Error Reading User Data");
        } 
    } 


    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == addButton) 
		{
            new AddUserFrame(this);
        } 
		else if (e.getSource() == editButton) 
		{
            int selectedRow = userTable.getSelectedRow();
            if (selectedRow != -1) 
			{
                String[] userData = getUserDataFromSelectedRow(selectedRow);
                new EditUserFrame(this, selectedRow, userData);
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "Please select a user to edit.");
            }
        } 
		else if (e.getSource() == deleteButton) 
		{
            int selectedRow = userTable.getSelectedRow();
            if (selectedRow != -1) 
			{
                tableModel.removeRow(selectedRow);
                saveUserDataToFile();
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "Please select a user to delete.");
            }
        } else if (e.getSource() == logoutButton) 
		{
            dispose();
            new LoginFrame(null); 
        }
    }

    public void addUser(String[] userData) 
	{
        tableModel.addRow(userData);
        saveUserDataToFile();
    }

    public void editUser(int row, String[] userData) 
	{
        for (int i = 0; i < userData.length; i++) 
		{
            tableModel.setValueAt(userData[i], row, i);
        }
        saveUserDataToFile(); 
    }

    private void saveUserDataToFile() {
        try {
            File file = new File("data\\user.txt");
            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < tableModel.getColumnCount(); i++) 
			{ 
                writer.write(tableModel.getColumnName(i));
                if (i < tableModel.getColumnCount() - 1) 
				{
                    writer.write(":");
                }
            }
            writer.write(System.lineSeparator()); 

            for (int i = 0; i < tableModel.getRowCount(); i++) 
			{
                for (int j = 0; j < tableModel.getColumnCount(); j++) 
				{
                    writer.write(tableModel.getValueAt(i, j).toString());
                    if (j < tableModel.getColumnCount() - 1) 
					{
                        writer.write(":");
                    }
                }
                writer.write(System.lineSeparator());
            }

            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Accessing User Data");
        }
    }

    private String[] getUserDataFromSelectedRow(int selectedRow) 
	{
        String[] userData = new String[tableModel.getColumnCount()];
        for (int i = 0; i < tableModel.getColumnCount(); i++) 
		{
            userData[i] = String.valueOf(tableModel.getValueAt(selectedRow, i)); 
        }
        return userData;
    }

    public static void main(String[] args)  
	{
        new AdminFrame();
    }
}
