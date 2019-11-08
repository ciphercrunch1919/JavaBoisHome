import javax.swing.*;
import java.awt.*;

public class StartMenuScreen extends JPanel {


    JLabel welcome;
    JButton classic;
    JButton strike;
    JButton highscore;
    JButton exit;

    public StartMenuScreen()
    {
        //initializing panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(250,210));

        //initializing label
        welcome = new JLabel("Welcome Player!");
        welcome.setAlignmentX(this.CENTER_ALIGNMENT);

        classic = new JButton("Classic");
        classic.setMaximumSize(new Dimension(200, 50));
        classic.setAlignmentX(this.CENTER_ALIGNMENT);

        strike = new JButton("Strike");
        strike.setMaximumSize(new Dimension(200, 50));
        strike.setAlignmentX(this.CENTER_ALIGNMENT);

        highscore = new JButton("Highscores");
        highscore.setMaximumSize(new Dimension(200, 50));
        highscore.setAlignmentX(this.CENTER_ALIGNMENT);

        exit = new JButton("Exit");
        exit.setMaximumSize(new Dimension(200, 50));
        exit.setAlignmentX(this.CENTER_ALIGNMENT);

        //adding everything to panel
        this.add(welcome);
        this.add(classic);
        this.add(strike);
        this.add(highscore);
        this.add(exit);

    }

    public JButton getClassic()
    {
        return classic;
    }

    public JButton getStrike()
    {
        return strike;
    }

    public JButton getHighscore()
    {
        return highscore;
    }

    public JButton getExit()
    {
        return exit;
    }
}
