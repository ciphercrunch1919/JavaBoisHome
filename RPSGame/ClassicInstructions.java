import javax.swing.*;
import java.awt.*;

public class ClassicInstructions extends JPanel {

    JLabel gameMode;
    JLabel instructions;

    JLabel logicIcon;

    JButton Continue;

    public ClassicInstructions()
    {
        setLayout(new BorderLayout());

        ImageIcon logicImage = new ImageIcon("src/menuIcons/RPS_Logic.png");
        logicIcon = new JLabel(logicImage);

        gameMode = new JLabel("Classic");
        gameMode.setFont(new Font("Comic Sans", ~Font.BOLD, 30));
        gameMode.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        instructions = new JLabel
                ("Play Until you lose" );
        instructions.setFont(new Font("Comic Sans", ~Font.BOLD, 20));
        gameMode.setAlignmentX(JPanel.CENTER_ALIGNMENT);

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
