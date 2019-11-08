//Reduces code repetition
public interface GameMode
{
    void updateLife();
    void resetPlayerLostRound();
    boolean isGameOver();
    boolean didPlayerLose();
    int getRound();
    int getLives();
}
