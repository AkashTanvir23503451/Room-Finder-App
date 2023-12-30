package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingConfirmationFrame extends JFrame implements ActionListener 
{
    private JLabel rentLabel;
    private JButton payButton, cancelButton;
    private Dashboard parentFrame;
	private String rent; 

    public BookingConfirmationFrame(Dashboard parentFrame, String rent) 
	{
        this.parentFrame = parentFrame;
		this.rent = rent; 

        setTitle("Room Booking Confirmation");
		Font labelFont = new Font("Arial", Font.BOLD, 24);
        rentLabel = new JLabel("One Month Rent: " + rent);
		payButton = new JButton("Pay");
        cancelButton = new JButton("Cancel");
		
		rentLabel.setFont(labelFont);

        rentLabel.setBounds(20, 20, 500, 30);
        payButton.setBounds(50, 100, 100, 30);
        cancelButton.setBounds(160, 100, 100, 30);
		
		payButton.setBackground(new Color(255,255,255,255)); 
		cancelButton.setBackground(new Color(255,255,255,255)); 

        payButton.addActionListener(this);
        cancelButton.addActionListener(this); 

        add(rentLabel);
        add(payButton);
        add(cancelButton);

        setSize(500, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setVisible(true);
		getContentPane().setBackground(Color.PINK); 
    }

    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == payButton) 
		{
            dispose();
            new PaymentFrame(parentFrame, rent);
        } 
		else if (e.getSource() == cancelButton) 
		{
            dispose();
            if (parentFrame != null) 
			{
                parentFrame.setVisible(true); 
            }
        }
    }
}
