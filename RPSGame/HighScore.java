import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class HighScore extends JPanel
{
    JLabel leaders;
    JLabel leader1;
    JLabel leader2;
    JLabel leader3;

    JButton back;
    JPanel bpanel;

    private int l1;
    private int l2;
    private int l3;
    private int[] l;

    public FileWriter writer;
    private Scanner s;
    private File file; 


    public HighScore()
    {

        this.setPreferredSize(new Dimension(250,210));
        
        //initialize label
        JLabel leaders = new JLabel("Leaderboard");
        leaders.setFont(new Font("Arial", ~Font.BOLD, 48));
        leaders.setHorizontalAlignment(JLabel.CENTER);

        //making leaders
        leader1 = new JLabel();
        leader1.setFont(new Font("Arial", ~Font.BOLD, 36));
        leader1.setHorizontalAlignment(JLabel.CENTER);
        leader2 = new JLabel();
        leader2.setFont(new Font("Arial", ~Font.BOLD, 36));
        leader2.setHorizontalAlignment(JLabel.CENTER);
        leader3 = new JLabel();
        leader3.setFont(new Font("Arial", ~Font.BOLD, 36));
        leader3.setHorizontalAlignment(JLabel.CENTER);

        back = new JButton("Back");
        back.setHorizontalAlignment(JLabel.CENTER);
        back.setPreferredSize(new Dimension(200,100));
        bpanel = new JPanel();
        bpanel.add(back);

        //Layouts!
        GridLayout layout = new GridLayout(5,1);
        this.setLayout(layout);

        //read from file
        l = new int[3];
        int i = 0;  
        try
        {
            file = new File("scores.txt");
            if (!file.exists())
            {
                file.createNewFile();
                FileWriter fw = new FileWriter("scores.txt", false);
                fw.write(0+"\n"+0+"\n"+0+"\n");
                fw.close();
            }
            s = new Scanner(new File("scores.txt"));
            while (s.hasNext())
            {
               l[i] = s.nextInt();
               i += 1;
            }
            l1 = l[0];
            leader1.setText(Integer.toString(l1));
            l2 = l[1];
            leader2.setText(Integer.toString(l2));
            l3 = l[2];
            leader3.setText(Integer.toString(l3)); 
        }
        catch (Exception e)
        {
        System.out.println(e);
        }

        //add everything to panel
        this.add(leaders);
        this.add(leader1);
        this.add(leader2);
        this.add(leader3);
        this.add(bpanel);
    }

    public void newHigh(int score)
    {
        if ( score > l1){
            this.l3 = this.l2;
            this.l2 = this.l1;
            this.l1 = score;
            leader3.setText(Integer.toString(l3));
            leader2.setText(Integer.toString(l2));
            leader1.setText(Integer.toString(l1));
        }
        else if (score > l2){
            this.l3 = this.l2;
            this.l2 = score;
            leader3.setText(Integer.toString(l3));
            leader2.setText(Integer.toString(l2));
        }
        else if (score > l3){
            this.l3 = score;
            leader3.setText(Integer.toString(l3));
        }

        try
        {
            writer = new FileWriter("scores.txt", false);
            writer.write(l1+"\n"+l2+"\n"+l3+"\n");
            writer.close();
        }   
        catch (IOException e)
        {
            System.out.println("Could not write to file");
            System.out.println(e);
        }


    }

    public JButton getBack()
    {
        return back;
    }
}
