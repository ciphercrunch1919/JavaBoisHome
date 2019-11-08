/*
RPSClassic is when the player only has one life and the game ends
 */
public class RPSClassic implements GameMode
{
    public int lives = 1;
    public int round;
    public boolean playerLostRound = false;

    private boolean lost = false;

    //deducts life if player has lost
    public void updateLife()
    {
        lives--;
        playerLostRound = true;
        System.out.println("you have " + lives + " lives");
    }

    //determines who lost
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
    public int getRound()
    {
        return round;
    }
    public int getLives() { return lives; }

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
