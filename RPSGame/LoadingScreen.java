import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JPanel {

    JLabel user;
    JLabel vs;
    JLabel player;
    JLabel computer;

    ImageIcon playerIcon;
    ImageIcon computerIcon;

    private RPSModel.Fighter userSelection;
    private RPSModel.Fighter computerSelection;

    public LoadingScreen() {}

    public void setLoadingScreen() {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 250));

        user = new JLabel("Player VS Computer");
        user.setFont(new Font("Comic Sans", ~Font.BOLD, 26));
        user.setHorizontalAlignment(JLabel.CENTER);

        vs = new JLabel(userSelection + " vs " + computerSelection);
        vs.setFont(new Font("Comic Sans", ~Font.BOLD, 20));
        vs.setHorizontalAlignment(JLabel.CENTER);

        this.removeAll();
        this.revalidate();
        this.repaint();

        if (userSelection == RPSModel.Fighter.SWORD) {
            this.playerIcon = new ImageIcon("src/menuIcons/Player_Swordman.png");
            if (computerSelection == RPSModel.Fighter.SPEAR) {
                this.computerIcon = new ImageIcon("src/menuIcons/Comp_Spearman.png");
            } else if (computerSelection == RPSModel.Fighter.BOW) {
                this.computerIcon = new ImageIcon("src/menuIcons/Comp_Bowman.png");
            } else if (computerSelection == RPSModel.Fighter.SWORD) {
                this.computerIcon = new ImageIcon("src/menuIcons/Comp_Swordman.png");
            }
        }

             else if (userSelection == RPSModel.Fighter.BOW) {
                this.playerIcon = new ImageIcon("src/menuIcons/Player_Bowman.png");
                if (computerSelection == RPSModel.Fighter.SPEAR) {
                    this.computerIcon = new ImageIcon("src/menuIcons/Comp_Spearman.png");
                } else if (computerSelection == RPSModel.Fighter.BOW) {
                    this.computerIcon = new ImageIcon("src/menuIcons/Comp_Bowman.png");
                } else if (computerSelection == RPSModel.Fighter.SWORD) {
                    this.computerIcon = new ImageIcon("src/menuIcons/Comp_Swordman.png");
                }
             }
             else if (userSelection == RPSModel.Fighter.SPEAR) {
                this.playerIcon = new ImageIcon("src/menuIcons/Player_Spearman.png");
                if (computerSelection == RPSModel.Fighter.SPEAR) {
                    this.computerIcon = new ImageIcon("src/menuIcons/Comp_Spearman.png");
                } else if (computerSelection == RPSModel.Fighter.BOW) {
                    this.computerIcon = new ImageIcon("src/menuIcons/Comp_Bowman.png");
                } else if (computerSelection == RPSModel.Fighter.SWORD) {
                    this.computerIcon = new ImageIcon("src/menuIcons/Comp_Swordman.png");
                }
            }

            player = new JLabel(playerIcon);
            computer = new JLabel(computerIcon);


            this.add(computer, BorderLayout.WEST);
            this.add(player, BorderLayout.EAST);
            this.add(vs, BorderLayout.SOUTH);
            this.add(user, BorderLayout.NORTH);
        }

    public void setLoadingFighter (RPSModel.Fighter userSelection, RPSModel.Fighter computerSelection)
    {
        this.computerSelection = computerSelection;
        this.userSelection = userSelection;

    }
}
