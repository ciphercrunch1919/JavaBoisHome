import javax.swing.*;
import java.awt.*;

public class StrikeInstructions extends JPanel {
    JLabel gameMode;
    JLabel instructions;

    JLabel logicIcon;

    JButton Continue;

    public StrikeInstructions()
    {
        setLayout(new BorderLayout());

        ImageIcon logicImage = new ImageIcon("src/menuIcons/RPS_Logic.png");
        logicIcon = new JLabel(logicImage);

        gameMode = new JLabel("Strike");
        gameMode.setFont(new Font("Comic Sans", ~Font.BOLD, 30));
        gameMode.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        instructions = new JLabel
                ("You have 3 lives!" );
        instructions.setFont(new Font("Comic Sans", ~Font.BOLD, 20));

        Continue = new JButton("Continue");

        this.add(instructions, BorderLayout.WEST);
        this.add(logicIcon, BorderLayout.EAST);
        this.add(Continue, BorderLayout.SOUTH);
        this.add(gameMode, BorderLayout.NORTH);

    }

    public JButton getContinue()
    {
        return Continue;
    }
}
