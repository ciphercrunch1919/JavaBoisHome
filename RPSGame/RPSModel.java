import java.util.ArrayList;
import java.util.Random;

/*
 * The model handles all logic within the game. Model generates random computer Fighters and
 * also keeps track of score and who won the round. game modes were split into RPSClassic and
 * RPSStrike and connected using an interface
 *  */

public class RPSModel
{
    GameMode gameMode;
    protected Fighter comp;

    public ArrayList<Fighter> selection;
    public boolean tie = false;

    private int score = 0;
    private Boolean player = true;

    //Enum for fight scenes that will be played
    public enum FightScene
    {
        SWORDVSSWORD,SWORDVSSPEAR,SWORDVSBOW,
        SPEARVSSPEAR,SPEARVSBOW,SPEARVSSWORD,
        BOWVSBOW,BOWVSSWORD,BOWVSSPEAR
    }

/* 
Determines which scenario will play out and funnels the users choices. For example, User clicks Sword button -> Fighter Sword constant is passed to Model -> Model will return a string to Controller and View to be played
*/
    public enum Fighter
    {
        SWORD,SPEAR,BOW
    }

    //Constructor
    public RPSModel()
    {
        compSelection();
        this.score = 0;
    }

    // chooses a random string from the ArrayList
    public void compSelection()
    {
        this.selection = new ArrayList<Fighter>();
        this.selection.add(Fighter.SWORD);
        this.selection.add(Fighter.SPEAR);
        this.selection.add(Fighter.BOW);

        Random rand = new Random();
        int nextRandom = rand.nextInt(3);

        this.comp = selection.get(nextRandom);
    }

    /*
 *     Logic for the battle. This will return who won the battle and return
 *         an enum to play the correct animation
 *             */
    public FightScene battle(Fighter userChoice) {

        compSelection();
        switch (userChoice) {
            case SWORD:
                if (comp == Fighter.SWORD){ //Tie
                    tie = true;
                    return FightScene.SWORDVSSWORD;
                } else if (comp == Fighter.SPEAR){ //Lose
                    gameMode.updateLife();
                    return FightScene.SWORDVSSPEAR;
                } else if (comp == Fighter.BOW) { //Win
                    this.score++;
                    return FightScene.SWORDVSBOW;
                }

            case BOW:
                if (comp == Fighter.SWORD){ //Lose
                    gameMode.updateLife();
                    return FightScene.BOWVSSWORD;

                }
                else if (comp == Fighter.SPEAR){ //Win
                    this.score++;
                    return FightScene.BOWVSSPEAR;
                }
                else if (comp == Fighter.BOW){ //Tie
                    tie = true;
                    return FightScene.BOWVSBOW;
                }

            case SPEAR:
                if (comp == Fighter.SWORD){ //Win
                    this.score++;
                    return FightScene.SPEARVSSWORD;
                }
                else if (comp == Fighter.SPEAR) { //Tie
                    tie = true;
                    return FightScene.SPEARVSSPEAR;
                }
                else if (comp == Fighter.BOW){ //Lose
                    gameMode.updateLife();
                    return FightScene.SPEARVSBOW;
                }
                break;
        }
        return null;
    }

    public void setGameMode(GameMode gameMode){ this.gameMode = gameMode; }

    public Fighter getComp() { return comp; }

    public int getScore(){ return score; }
 
    public void resetScore()
    {
        this.score = 0;
    }

    public Boolean isItATie()
    {
        if(tie)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public void resetTie()
    {
        tie = false;
    }
}
