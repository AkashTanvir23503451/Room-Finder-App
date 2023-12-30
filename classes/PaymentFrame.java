package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentFrame extends JFrame implements ActionListener 
{
    private JLabel rentLabel, paymentMethodLabel;
    private JRadioButton bkashRadioButton, nagadRadioButton;
    private JButton payButton;
    private Dashboard parentFrame;

    public PaymentFrame(Dashboard parentFrame, String rent) 
	{
        this.parentFrame = parentFrame;

        setTitle("Payment");

        rentLabel = new JLabel("Rent: " + rent);
        paymentMethodLabel = new JLabel("Select Payment Method:");

        bkashRadioButton = new JRadioButton("Bkash");
        nagadRadioButton = new JRadioButton("Nagad");

        ButtonGroup paymentMethodGroup = new ButtonGroup();
        paymentMethodGroup.add(bkashRadioButton);
        paymentMethodGroup.add(nagadRadioButton);

        payButton = new JButton("Pay");

        rentLabel.setBounds(50, 20, 300, 30);
        paymentMethodLabel.setBounds(50, 60, 200, 30);
        bkashRadioButton.setBounds(50, 90, 100, 30);
        nagadRadioButton.setBounds(160, 90, 100, 30);
        payButton.setBounds(70, 140, 100, 30);
		
		payButton.setBackground(new Color(255,255,255,255)); 
		bkashRadioButton.setBackground(Color.PINK);  
		nagadRadioButton.setBackground(Color.PINK); 

        payButton.addActionListener(this);

        add(rentLabel);
        add(paymentMethodLabel);
        add(bkashRadioButton);
        add(nagadRadioButton);
        add(payButton);

        setSize(400, 250);
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
            if (bkashRadioButton.isSelected()) 
			{
                new BkashGateway(parentFrame, rentLabel.getText().substring(6));
            } 
			else if (nagadRadioButton.isSelected()) 
			{
                new NagadGateway(parentFrame, rentLabel.getText().substring(6));
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "Please select a payment method"); 
            }
        }
    }
}
