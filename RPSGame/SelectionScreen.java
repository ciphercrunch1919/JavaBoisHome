import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class SelectionScreen extends JPanel
{
    JLabel label;
    JButton sword;
    JButton spear;
    JButton bow;

    public SelectionScreen()
    {
        //initializing panel
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500,250));

        //initializing label
        label = new JLabel("Choose your Champion");
        label.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        //initializing buttons
        ImageIcon swordIcon = new ImageIcon("src/menuIcons/Sword.png");
        Image image = swordIcon.getImage();
        Image newImage = image.getScaledInstance(155, 150, Image.SCALE_SMOOTH);
        swordIcon = new ImageIcon(newImage);
        sword = new JButton(swordIcon);
        sword.setPreferredSize(new Dimension(165,150));

        ImageIcon spearIcon = new ImageIcon("src/menuIcons/Spear.png");
        Image image2 = spearIcon.getImage();
        Image newImage2 = image2.getScaledInstance(155, 150, Image.SCALE_SMOOTH);
        spearIcon = new ImageIcon(newImage2);
        spear = new JButton(spearIcon);
        spear.setPreferredSize(new Dimension(165,150));

        ImageIcon bowIcon = new ImageIcon("src/menuIcons/Bow.png");
        Image image3 = bowIcon.getImage();
        Image newImage3 = image3.getScaledInstance(155, 150, Image.SCALE_SMOOTH);
        bowIcon = new ImageIcon(newImage3);
        bow = new JButton(bowIcon);
        bow.setPreferredSize(new Dimension(165,150));

        add(label, BorderLayout.PAGE_START);
        add(sword, BorderLayout.LINE_START);
        add(spear, BorderLayout.CENTER);
        add(bow, BorderLayout.LINE_END);

        setVisible(true);
    }

    public JButton getSword() {
        return sword;
    }

    public JButton getSpear() {
        return spear;
    }

    public JButton getBow() {
        return bow;
    }
}
