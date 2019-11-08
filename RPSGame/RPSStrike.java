/*
 * RPSStrike is when the player has three lives and plays until those are up
 *  */
public class RPSStrike implements GameMode
{
    public int lives = 3;
    public int round;
    public boolean playerLostRound = false;

    private boolean lost = false;

    //Deducts life if the player lost
    public void updateLife()
    {
        lives--;
        playerLostRound = true;
        System.out.println("you have " + lives + " lives");
    }

    //Determines if the game is lost
    public boolean isGameOver()
    {
        if(lives == 0)
        {
            lost = true;
            System.out.println("You lost");
        }
        else
        {
            this.round++;
            System.out.println("Continue to next round");
        }
        return lost;
    }

    public int getLives()
    {
        return lives;
    }

    public int getRound() { return round; }

    //sets the winner of the round
    public boolean didPlayerLose()
    {
        return playerLostRound;
    }

    public void resetPlayerLostRound()
    {
        playerLostRound = false;
    }
}
