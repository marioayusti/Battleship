package components;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author lili_work1
 */
public class JPanelBGImage extends JPanel
{

    private Image bgImage = null;

    public JPanelBGImage(LayoutManager layout, String path)
    {
        super(layout);
        this.setOpaque(false);
        URL imgURL = getClass().getResource(path);
        if (imgURL != null)
            bgImage = new ImageIcon(imgURL).getImage();
    }

    @Override
    public void paint(Graphics g)
    {
        if (bgImage != null)
            g.drawImage(bgImage, 0, 0, null);

        super.paint(g);
    }
}
