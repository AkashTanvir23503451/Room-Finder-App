package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BkashGateway extends JFrame implements ActionListener 
{
    private JLabel accountLabel, amountLabel, pinLabel, headerLabel;
    private JTextField accountTextField;
    private JPasswordField pinField;
    private JButton payButton, cancelButton;
    private Dashboard parentFrame;

    public BkashGateway(Dashboard parentFrame, String amount) 
	{
        this.parentFrame = parentFrame;

        setTitle("Bkash Gateway");
        setLayout(null); 

        ImageIcon headerImageIcon = createResizedImageIcon("image\\bkash.png", 300, 100);
        headerLabel = new JLabel(headerImageIcon);
        headerLabel.setBounds(50, 20, 300, 100);
        add(headerLabel);

        amountLabel = new JLabel("Amount to Pay: $" + amount);
        amountLabel.setBounds(50, 130, 200, 30);
        add(amountLabel);

        accountLabel = new JLabel("Account Number:");
        accountTextField = new JTextField(15);
        pinLabel = new JLabel("PIN:");
        pinField = new JPasswordField(15);
        payButton = new JButton("Pay");
        cancelButton = new JButton("Cancel");

        getContentPane().setBackground(Color.PINK);

        accountLabel.setBounds(50, 170, 150, 30);
        accountTextField.setBounds(200, 170, 150, 30);
        pinLabel.setBounds(50, 210, 150, 30);
        pinField.setBounds(200, 210, 150, 30);
        payButton.setBounds(50, 250, 100, 30);
        cancelButton.setBounds(160, 250, 100, 30);
		
		payButton.setBackground(new Color(255,255,255,255)); 
		cancelButton.setBackground(new Color(255,255,255,255)); 

        payButton.addActionListener(this);
        cancelButton.addActionListener(this);

        add(accountLabel);
        add(accountTextField);
        add(pinLabel);
        add(pinField);
        add(payButton);
        add(cancelButton);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == payButton) 
		{
            String accountNumber = accountTextField.getText();
            char[] pin = pinField.getPassword();
            JOptionPane.showMessageDialog(this, "Payment Done. Rent Successful!");
            closeAllFrames();
            new LoginFrame(null);
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
	
	private ImageIcon createResizedImageIcon(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void closeAllFrames() 
	{
        Window[] windows = Window.getWindows();
        for (Window window : windows) 
		{
            window.dispose(); 
        }
    }

    public static void main(String[] args) 
	{        
	    new BkashGateway(null, "500"); 
    }
}
