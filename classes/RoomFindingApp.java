package classes;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomFindingApp extends JFrame implements ActionListener {
    private JLabel titleLabel, imageLabel;
    private JButton getStartedButton;
	private ImageIcon background; 

    public RoomFindingApp() 
	{
        titleLabel = new JLabel("ROOM FINDING APP");
        getStartedButton = new JButton("GET STARTED");
		background = new ImageIcon("image\\Background 1.jpg");  
		imageLabel = new JLabel(background); 

        Font labelFont = new Font("Arial", Font.BOLD, 24);
        titleLabel.setFont(labelFont);

        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        getStartedButton.setFont(buttonFont);
		
		getStartedButton.setBackground(new Color(255,255,255,255)); 

        titleLabel.setBounds(200, 50, 400, 50);
        getStartedButton.setBounds(600, 500, 150, 30);
		imageLabel.setBounds(100,120, background.getIconWidth(), background.getIconHeight()); 

        add(titleLabel);
        add(getStartedButton);
		add(imageLabel); 

        setTitle("Room Finding App");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.PINK);
		
        getStartedButton.addActionListener(this);  

        
    }

    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == getStartedButton) 
		{
            setVisible(false);
            new LoginFrame(this); 
        }
    }

    public static void main(String[] args) {
        new RoomFindingApp();
    }
}
