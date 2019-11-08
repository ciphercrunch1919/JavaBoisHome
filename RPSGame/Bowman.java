import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Timer;


public class Bowman extends JPanel {

    protected ArrayList<File> pngFiles = new ArrayList<File>(); //Parse PNG's into array
    protected File [] listOfFiles; //Extract PNG files from a Folder
    private File folder; //contains animation contents, IE: SWORDVSBOW, SWORDVSSWORD, etc

    public int count = 0; // pointer for which animation is being played

    private ImageIcon icon;
    private RPSModel.FightScene scene;

    //Constructor
    public Bowman() { }

   //Loads image and puts images into an array
   private void loadImage() {
        if (scene == RPSModel.FightScene.BOWVSBOW)
        {
            folder = new File("src/BowVSBow");
        }
        else if (scene == RPSModel.FightScene.BOWVSSWORD)
        {
            folder = new File("src/BowVSSword");
        }
        else if (scene == RPSModel.FightScene.BOWVSSPEAR)
        {
            folder = new File("src/BowVSSpear");
        }

        listOfFiles = folder.listFiles();

        //Load png files into an array
        for (int i = 0; i < listOfFiles.length; i++)
        {
            if (listOfFiles[i].isFile())
            {
                pngFiles.add(listOfFiles[i]);
            }
        }
    }

    //Display multiple icons (animation)
    public void bowAnimation()
    {
        repaint();
        setIcon();
        if (count <= pngFiles.size())
        {
            count++;
        }
    }

    public void setScene(RPSModel.FightScene scene)
    {
        this.scene = scene;

        loadImage();
        setIcon();

        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        setPreferredSize(new Dimension(w, h));
    }

    public void setIcon()
    {
        if (scene == RPSModel.FightScene.BOWVSBOW)
        {
            icon = new ImageIcon
                    ("src/BowVSBow/Bowman_BowVSBow_" + count + ".png");
        }
        else if (scene == RPSModel.FightScene.BOWVSSWORD)
        {
            icon = new ImageIcon
                    ("src/BowVSSword/Bowman_BowVSSword_" + count + ".png");
        }
        else if (scene == RPSModel.FightScene.BOWVSSPEAR)
        {
            icon = new ImageIcon
                    ("src/BowVSSpear/Bowman_BowVSSpear_" + count + ".png");
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        icon.paintIcon(this, g, 50, 0);
    }
}
