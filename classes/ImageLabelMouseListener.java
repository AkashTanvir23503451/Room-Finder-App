package classes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageLabelMouseListener extends MouseAdapter 
{
    private final Dashboard parentFrame; 
    private final String address;
    private final String rent;
    private final String availableDate;

    public ImageLabelMouseListener(Dashboard parentFrame, String address, String rent, String availableDate) 
	{
        this.parentFrame = parentFrame;
        this.address = address;
        this.rent = rent;
        this.availableDate = availableDate;
    }

    @Override
    public void mouseClicked(MouseEvent e) 
	{
        new ImageDetailsFrame(parentFrame, address, rent, availableDate); 
    }
}
