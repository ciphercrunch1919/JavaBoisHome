import java.util.Timer;
import java.util.TimerTask;

/*
 * The controller controls what the user is seeing and what is being sent to the model
 *  */
public class RPSController
{
    private Timer timer = new Timer();
    private Timer timer2 = new Timer();
    private Timer timer3 = new Timer();

    RPSModel model;
    RPSView view;
    GameMode gameMode;
    private RPSModel.Fighter userSelection;
    private RPSModel.FightScene result;

    public void addModel(RPSModel model)
    {
        this.model = model;
    }

    public void addView(RPSView view)
    {
        this.view = view;
    }

    public void sword()
    {
        this.userSelection = RPSModel.Fighter.SWORD;
        this.result = model.battle(userSelection);
        showResult();
    }

    public void spear()
    {
        this.userSelection = RPSModel.Fighter.SPEAR;
        this.result = model.battle(userSelection);
        showResult();
    }

    public void bow()
    {
        this.userSelection = RPSModel.Fighter.BOW;
        this.result = model.battle(userSelection);
        showResult();
    }

    public void classic()
    {
        model.resetScore();
        gameMode = new RPSClassic();
        model.setGameMode(gameMode);
        view.classicInstructions();
    }

    public void strike()
    {
        model.resetScore();
        gameMode = new RPSStrike();
        model.setGameMode(gameMode);
        view.strikeInstructions();
    }

    public void Continue()
    {
        view.selectionScreen();
    }

    public void highscore()
    {
        view.highScoreScreen();

    }
    
    public void exit()
    {   
        System.exit(0);
    }   


    public void showNextRound()
    {
        view.newRound();
    }

    public void showResult()
    {
        view.animator.setResult(result,userSelection);
        view.loadingScreen.repaint();
        view.loadingScreen.setLoadingFighter(userSelection,model.getComp());
        view.loadingScreen.setLoadingScreen();
        view.loadingScreen();
        TimerTask animation = new TimerTask() {
            private int seconds = 0;
            private final int maxSeconds = 2;

            @Override
            public void run() {
                if (seconds < maxSeconds) {
                    seconds++;
                } else {
                    cancel();
                    view.battleScreen();
                }
            }
        };
        timer.schedule(animation,0,1000);
    }

    public void showRoundOver()
    {
       //show gameover
       if(gameMode.isGameOver())
        {

            TimerTask gameOver = new TimerTask() {
                private int seconds = 0;
                private final int maxSeconds = 2;

                @Override
                public void run() {
                    if (seconds < maxSeconds) {
                        seconds++;
                    } else {
                        cancel();
                        int score = model.getScore();
                        view.gameOver.setFinalScore(score);
                        view.gameOverScreen();
                        view.highScore.newHigh(score);
                    }
                }
            };

            timer3.schedule(gameOver,0,1000);
        }
        else
        {
           //round over screen
           TimerTask roundOver = new TimerTask() {
                private int seconds = 0;
                private final int maxSeconds = 2;

                @Override
                public void run() {
                    if (seconds < maxSeconds) {
                        seconds++;
                    } else {
                        cancel();
                        if(model.isItATie())
                        {
                            view.roundOver.setWinner("It's a TIE!");
                            model.resetTie();
                        }
                        else
                        {
                            if(gameMode.didPlayerLose())
                            {
                                view.roundOver.setWinner("Computer Won :(");
                                gameMode.resetPlayerLostRound();
                            }
                            else
                            {
                                view.roundOver.setWinner("Player Won!");
                            }
                        }

                        System.out.println("Your score is: " + model.getScore());

                        view.roundOver.setScore(model.getScore());
                        view.roundOver.setRound(gameMode.getRound());
                        view.roundOver.setLives(gameMode.getLives());
                        view.roundOver();

                    }
                }
            };
            timer2.schedule(roundOver,0,1000);
        }
    }
}
