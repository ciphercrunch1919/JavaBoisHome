import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Swordsman extends JPanel {

    protected static ArrayList<File> pngFiles = new ArrayList<File>(); //Parse PNG's into array
    protected File [] listOfFiles; //Extract PNG files from a Folder
    private File folder; //contains animation contents, IE: SWORDVSBOW, SWORDVSSWORD, etc

    private int count = 0; // pointer for which animation is being played

    private ImageIcon icon;
    private RPSModel.FightScene scene;

    //Constructor
    public Swordsman() { }

    //Loads image and puts images into an array
    private void loadImage() {
        if (scene == RPSModel.FightScene.SWORDVSSWORD)
        {
            folder = new File("src/SwordVSSword");
        }
        else if (scene == RPSModel.FightScene.SWORDVSSPEAR)
        {
            folder = new File("src/SwordVSSpear");
        }
        else if (scene == RPSModel.FightScene.SWORDVSBOW)
        {
            folder = new File("src/SwordVSBow");
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
    public void swordAnimation()
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
    }

    public void setIcon()
    {
        if (scene == RPSModel.FightScene.SWORDVSSWORD)
        {
            icon = new ImageIcon
                    ("src/SwordVSSword/Sword_SwordVSSword_" + count + ".png");
        }
        else if (scene == RPSModel.FightScene.SWORDVSSPEAR)
        {
            icon = new ImageIcon
                    ("src/SwordVSSpear/Sword_SwordVsSpear_" + count + ".png");
        }
        else if (scene == RPSModel.FightScene.SWORDVSBOW)
        {
            icon = new ImageIcon
                    ("src/SwordVSBow/Sword_SwordVSBow_" + count + ".png");
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        icon.paintIcon(this, g, 50, 0);
    }
}
