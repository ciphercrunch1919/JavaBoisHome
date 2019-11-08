import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Timer;


public class Spearman extends JPanel {

    protected ArrayList<File> pngFiles = new ArrayList<File>(); //Parse PNG's into array
    protected File [] listOfFiles; //Extract PNG files from a Folder
    private File folder; //contains animation contents, IE: SWORDVSBOW, SWORDVSSWORD, etc

    public int count = 0; // pointer for which animation is being played

    private ImageIcon icon;
    private RPSModel.FightScene scene;

    //Constructor
    public Spearman() { }


    //Loads image and puts images into an array
    private void loadImage() {
        if (scene == RPSModel.FightScene.SPEARVSSPEAR)
        {
            folder = new File("src/SpearVSSpear");
        }
        else if (scene == RPSModel.FightScene.SPEARVSBOW)
        {
            folder = new File("src/SpearVSBow");
        }
        else if (scene == RPSModel.FightScene.SPEARVSSWORD)
        {
            folder = new File("src/SpearVSSword");
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
    public void spearAnimation()
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
        if (scene == RPSModel.FightScene.SPEARVSSPEAR)
        {
            icon = new ImageIcon
                    ("src/SpearVSSpear/Spearman_SpearVSSpear_" + count + ".png");
        }
        else if (scene == RPSModel.FightScene.SPEARVSBOW)
        {
            icon = new ImageIcon
                    ("src/SpearVSBow/Spearman_SpearVSBow_" + count + ".png");
        }
        else if (scene == RPSModel.FightScene.SPEARVSSWORD)
        {
            icon = new ImageIcon
                    ("src/SpearVSSword/Spearman_SpearVSSword_" + count + ".png");
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        icon.paintIcon(this, g, 50, 0);
    }
}
