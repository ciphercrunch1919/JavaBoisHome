import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOverScreen extends JPanel
{

    JLabel gameOver;
    JLabel score;
    JButton exitToStartMenu;

    public GameOverScreen()
    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(250, 210));

        gameOver = new JLabel("Game Over");
        gameOver.setAlignmentX(this.CENTER_ALIGNMENT);

        score = new JLabel();
        score.setAlignmentX(this.CENTER_ALIGNMENT);


        exitToStartMenu = new JButton("Exit");
        exitToStartMenu.setMaximumSize(new Dimension(200, 50));
        exitToStartMenu.setAlignmentX(this.CENTER_ALIGNMENT);

        this.add(gameOver);
        this.add(score);
        this.add(exitToStartMenu);
    }

    public JButton getExit()
    {
        return exitToStartMenu;
    }

    public void setFinalScore(int finalScore)
    {
        score.setText("Your Score is: " + finalScore);
    }
}
