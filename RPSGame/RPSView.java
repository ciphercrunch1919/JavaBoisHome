import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * The purpose of the view is to manage every screen that will be displayed to the user
 * The view also sends information inputed from the user gui to the controller and model
 *  */

public class RPSView extends JFrame
{
    GameOverScreen gameOver;
    RoundOverScreen roundOver;
    StartMenuScreen startMenu;
    SelectionScreen selectionScreen;
    Animator animator;
    LoadingScreen loadingScreen;
    HighScore highScore;
    ClassicInstructions classicInstructions;
    StrikeInstructions strikeInstructions;

    JFrame frame;
    JPanel mainPanel; //The main panel that has all of the card panels
    CardLayout screenManager; //Manages which card to show

    //Constructs the frame and instantiates all of the screen objects
    public RPSView()
    {
        frame = new JFrame("Medieval Rock Paper Scissors");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        screenManager = new CardLayout();
        highScore = new HighScore();
        startMenu = new StartMenuScreen();
        selectionScreen = new SelectionScreen();
        loadingScreen = new LoadingScreen();
        animator = new Animator();
        roundOver = new RoundOverScreen();
        gameOver = new GameOverScreen();
        strikeInstructions = new StrikeInstructions();
        classicInstructions = new ClassicInstructions();

        manageScreens();

        frame.add(mainPanel);
        startMenuScreen();
        frame.pack();
    }

    //Add constants and place the cards into the mainPanel(new CardLayout)
    public void manageScreens()
    {
        mainPanel = new JPanel();
        mainPanel.setSize(500,500);
        mainPanel.setLayout(screenManager);
        mainPanel.add(startMenu, "START_MENU");
        mainPanel.add(selectionScreen, "SELECTION_SCREEN");
        mainPanel.add(animator,"ANIMATOR");
        mainPanel.add(roundOver,"ROUND_OVER");
        mainPanel.add(gameOver, "GAME_OVER");
        mainPanel.add(loadingScreen, "LOADING_SCREEN");
        mainPanel.add(highScore, "HIGH_SCORE");
        mainPanel.add(classicInstructions, "CLASSIC_INSTRUCTIONS");
        mainPanel.add(strikeInstructions, "STRIKE_INSTRUCTIONS");

    }

    //This adds the action listeners to the objects (function is used in the Driver class)
    public void addListeners(RPSController controller)
    {
        //Instruction listeners
        strikeInstructions.getContinue().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.Continue();
            }
        });

        classicInstructions.getContinue().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.Continue();
            }
        });

        //Start menu Listeners
        startMenu.getClassic().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.classic();
            }
        });

        startMenu.getStrike().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.strike();
            }
        });

        startMenu.getHighscore().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                controller.highscore();
            }
        });

        startMenu.getExit().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                controller.exit();
            }
        });

        //Selection menu Listeners
        selectionScreen.getSword().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                controller.sword();
            }
        });

        selectionScreen.getSpear().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                controller.spear();
            }
        });

        selectionScreen.getBow().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                controller.bow();
            }
        });

        //Animator Listener
        animator.getAnimate().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                animator.start();
                controller.showRoundOver();
            }
        });

        //Roundover Listener
        roundOver.getNextRound().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                controller.showNextRound();
            }
        });
        
        highScore.getBack().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                startMenuScreen();
            }
        });
        
        gameOver.getExit().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {   
                startMenuScreen();
            }   
        }); 
    }
     /*
 *     These functions will be used to "Show" a specific card on the screen
 *         IE: the startMenuScreen -> selectionScreen -> loadingScreen -> battleScreen -> roundOverScreen
 *              */

    public void startMenuScreen()
    {
        screenManager.show(mainPanel, "START_MENU");
        frame.setVisible(true);
    }

    public void highScoreScreen()
    {
        screenManager.show(mainPanel, "HIGH_SCORE");
        frame.setVisible(true);
    }


    public void loadingScreen()
    {
        screenManager.show(mainPanel, "LOADING_SCREEN");
        frame.setVisible(true);
    }

    public void battleScreen()
    {
        screenManager.show(mainPanel, "ANIMATOR");
        frame.setVisible(true);
    }

    public void gameOverScreen()
    {
        screenManager.show(mainPanel, "GAME_OVER");
        frame.setVisible(true);
    }

    public void roundOver()
    {
        screenManager.show(mainPanel, "ROUND_OVER");
        frame.setVisible(true);
    }

    public void selectionScreen()
    {
        screenManager.show(mainPanel, "SELECTION_SCREEN");
        frame.setVisible(true);
    }

    public void newRound()
    {
        screenManager.show(mainPanel, "SELECTION_SCREEN");
        frame.setVisible(true);
    }

    public void classicInstructions()
    {
        screenManager.show(mainPanel, "CLASSIC_INSTRUCTIONS");
        frame.setVisible(true);
    }

    public void strikeInstructions()
    {
        screenManager.show(mainPanel, "STRIKE_INSTRUCTIONS");
    }
}
