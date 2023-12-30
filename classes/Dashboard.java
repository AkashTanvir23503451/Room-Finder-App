package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Dashboard extends JFrame implements ActionListener 
{
    private LoginFrame parentFrame;
    private JLabel titleLabel, welcomeLabel, userLabel, line;
    private JButton logoutButton;
    private JLabel[] imageLabels;

    public Dashboard(LoginFrame parentFrame, String username) 
	{
        this.parentFrame = parentFrame;

        titleLabel = new JLabel("ROOM FINDING APP");
        welcomeLabel = new JLabel("Welcome, " + username + "!"); 
        userLabel = new JLabel("User: " + username);
        line = new JLabel("Select an image to rent the room: ");

        logoutButton = new JButton("Logout");

        Font labelFont = new Font("Arial", Font.BOLD, 24);
        titleLabel.setFont(labelFont);
        welcomeLabel.setFont(labelFont);
        userLabel.setFont(labelFont);
        line.setFont(labelFont);

        titleLabel.setBounds(200, 30, 400, 50);
        welcomeLabel.setBounds(200, 80, 400, 30);
        userLabel.setBounds(200, 120, 200, 20);
        line.setBounds(100, 145, 500, 30);
        logoutButton.setBounds(600, 30, 100, 30);
		
		logoutButton.setBackground(new Color(255,255,255,255)); 

        logoutButton.addActionListener(this);

        add(titleLabel);
        add(welcomeLabel);
        add(userLabel);
        add(line);
        add(logoutButton);

        setTitle("Dashboard");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.PINK); 
        addImageLabels();

        
    }

    private void addImageLabels() 
	{
        String[] imagePaths = {"image\\bedroom 1.png", "image\\bedroom 2.png", "image\\bedroom 3.png", "image\\bedroom 4.png", "image\\bedroom 5.png", "image\\bedroom 6.png"}; 

        imageLabels = new JLabel[imagePaths.length];

        int x = 200;
        int y = 180;
        int width = 150;
        int height = 150;
        int gap = 20;

        String[] addresses = {"Kuratoli, Kuril, Dhaka", "Kuril Chowrasta, Dhaka", "C/212, Bashundhara R/A, Dhaka", "B/15, Bashundhara R/A", "Ghatpar, Kuril, Dhaka", "Nikunja, Dhaka"};

        String[] rents = {"TK 6000/month", "TK 7000/month", "TK 8500/month", "TK 9000/month", "TK 4500/month", "TK 8000/month"};

        String[] availableDates = {"January 1, 2024", "February 1, 2024", "January 1, 2024", "January 1, 2024", "February 1, 2024", "January 1, 2024"}; 

        for (int i = 0; i < imagePaths.length; i++) 
		{
            imageLabels[i] = new JLabel();
            ImageIcon imageIcon = createResizedImageIcon(imagePaths[i], width, height);
            imageLabels[i].setIcon(imageIcon);
            imageLabels[i].setBounds(x, y, width, height);
            add(imageLabels[i]);
            imageLabels[i].addMouseListener(new ImageLabelMouseListener(this, addresses[i], rents[i], availableDates[i]));

            x += width + gap;

            if (i == 2) 
			{
                x = 200; 
                y += height + gap;
            }
        }
    }

    private ImageIcon createResizedImageIcon(String path, int width, int height) 
	{
        ImageIcon originalIcon = new ImageIcon(path);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage); 
    }


    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == logoutButton) 
		{
            parentFrame.resetFields();
            setVisible(false);
            parentFrame.setVisible(true);
        }
    }

    public static void main(String[] args) 
	{
        new Dashboard(null, "TestUser"); 
    }
}
