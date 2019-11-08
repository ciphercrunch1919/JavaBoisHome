import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Animator extends JPanel {

    protected Swordsman swordsman;
    protected Spearman spearman;
    protected Bowman bowman;

    public RPSModel.FightScene animation;
    private RPSModel.Fighter userSelection;

    Timer t;
    TimerTask task;

    private JButton animate;

    //Constructor
    public Animator()
    {
        animate = new JButton();
        this.setLayout(new BorderLayout());
        animate.setText("Fight");
        this.add(animate, BorderLayout.SOUTH);
    }

    public void setResult(RPSModel.FightScene result, RPSModel.Fighter userSelection)
    {
        this.animation = result;
        this.userSelection = userSelection;

        if (userSelection == RPSModel.Fighter.SWORD)
        {
            swordsman = new Swordsman();
            swordsman.setScene(result);
        }
        else if (userSelection == RPSModel.Fighter.SPEAR)
        {
            spearman = new Spearman();
            spearman.setScene(result);
        }
        else if (userSelection == RPSModel.Fighter.BOW)
        {
            bowman = new Bowman();
            bowman.setScene(result);
        }


        chooseAnimation();
    }

    public JButton getAnimate()
    {
        return animate;
    }


    public void chooseAnimation()
    {
       //Select animation
       switch (userSelection)
        {
            case SWORD: //Sword scenarios
                if (animation == RPSModel.FightScene.SWORDVSSWORD)
                {
                    this.add(swordsman, BorderLayout.CENTER);
                    this.setAlignmentX(swordsman.CENTER_ALIGNMENT);
                    swordsman.swordAnimation();
                }
                else if (animation == RPSModel.FightScene.SWORDVSSPEAR)
                {
                    this.add(swordsman, BorderLayout.CENTER);
                    this.setAlignmentX(swordsman.CENTER_ALIGNMENT);
                    swordsman.swordAnimation();
                }
                else if (animation == RPSModel.FightScene.SWORDVSBOW)
                {
                    this.add(swordsman, BorderLayout.CENTER);
                    this.setAlignmentX(swordsman.CENTER_ALIGNMENT);
                    swordsman.swordAnimation();
                }

            case SPEAR: //Spear scenarios
                if (animation == RPSModel.FightScene.SPEARVSSPEAR)
                {
                    this.add(spearman, BorderLayout.CENTER);
                    spearman.spearAnimation();
                }
                else if (animation == RPSModel.FightScene.SPEARVSBOW)
                {
                    this.add(spearman, BorderLayout.CENTER);
                    spearman.spearAnimation();
                }
                else if (animation == RPSModel.FightScene.SPEARVSSWORD)
                {
                    this.add(spearman, BorderLayout.CENTER);
                    spearman.spearAnimation();
                }

            case BOW: //Bow scenarios
                if (animation == RPSModel.FightScene.BOWVSBOW)
                {
                    this.add(bowman, BorderLayout.CENTER);
                    bowman.bowAnimation();
                }
                else if (animation == RPSModel.FightScene.BOWVSSWORD)
                {
                    this.add(bowman, BorderLayout.CENTER);
                    bowman.bowAnimation();
                }
                else if (animation == RPSModel.FightScene.BOWVSSPEAR)
                {
                    this.add(bowman, BorderLayout.CENTER);
                    bowman.bowAnimation();
                }
        }
    }

    public void start()
    {

        t = new Timer();
        task = new TimerTask() {
            private int seconds = 0;
            private final int maxSeconds = 20;

            @Override
            public void run() {
                if (seconds < maxSeconds) {
                    seconds++;
                    chooseAnimation();
                }
                else
                {
                    cancel();
                }
            }
        };
        t.schedule(task,0,100);
    }
}
