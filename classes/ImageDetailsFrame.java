package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageDetailsFrame extends JFrame implements ActionListener 
{
    private JLabel addressLabel, rentLabel, availableLabel;
    private JButton backButton, rentButton;
    private Dashboard parentFrame; 

    public ImageDetailsFrame(Dashboard parentFrame, String address, String rent, String available) 
	{
        this.parentFrame = parentFrame; 

        setTitle("Room Details");

        addressLabel = new JLabel("Address: " + address);
        rentLabel = new JLabel("Rent: " + rent);
        availableLabel = new JLabel("Available From: " + available);

        backButton = new JButton("Back");
        rentButton = new JButton("Rent");

        addressLabel.setBounds(50, 20, 300, 30);
        rentLabel.setBounds(50, 60, 300, 30);
        availableLabel.setBounds(50, 100, 300, 30);
        backButton.setBounds(50, 140, 100, 30);
        rentButton.setBounds(160, 140, 100, 30);
		
		backButton.setBackground(new Color(255,255,255,255)); 
		rentButton.setBackground(new Color(255,255,255,255)); 

        backButton.addActionListener(this);
        rentButton.addActionListener(this);

        add(addressLabel);
        add(rentLabel);
        add(availableLabel);
        add(backButton);
        add(rentButton);

        setSize(300, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
		getContentPane().setBackground(Color.PINK); 
    }

    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == backButton) 
		{
            dispose();
        } 
		else if (e.getSource() == rentButton) 
		{
            int option = JOptionPane.showConfirmDialog(this, "Do you want to proceed with the rent?", "Rent Confirmation", JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.YES_OPTION) 
			{
                dispose();
                new BookingConfirmationFrame(parentFrame, rentLabel.getText().substring(6));
            }
        }
    }

    public static void main(String[] args) 
	{
        new ImageDetailsFrame(null, "XXXX", "TK5000/month", "January 1, 2023"); 
    }
}
