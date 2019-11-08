import javax.swing.*;
import java.awt.*;

public class RoundOverScreen extends JPanel
{
    JLabel winner;
    JLabel score1;
    JLabel livesLeft;
    JButton next;

    public int round;

    public RoundOverScreen()
    {
       //initializing panel
       setPreferredSize(new Dimension(250,210));

        GridLayout layout = new GridLayout(4, 1);
        setLayout(layout);
        next = new JButton("Next Round");
        next.setPreferredSize(new Dimension(50, 25));

    }

    public void setWinner(String win)
    {
        this.removeAll();
        this.revalidate();
        this.repaint();

        winner = new JLabel(win);
        winner.setFont(new Font("Arial", ~Font.BOLD, 36));
        add(winner);
    }

    public void setScore(int currentScore)
    {

        score1 = new JLabel("Player Score: " + currentScore);
        score1.setFont(new Font("Arial", ~Font.BOLD, 20));
        add(score1);
    }

    public void setLives(int l)
    {
        livesLeft = new JLabel("Lives: " + l);
        livesLeft.setFont(new Font("Arial", ~Font.BOLD, 20));
        add(livesLeft);
        add(next);
    }

    public void setRound(int currentRound)
    {
        round = currentRound;
    }

    public JButton getNextRound()
    {
        return next;
    }
}
