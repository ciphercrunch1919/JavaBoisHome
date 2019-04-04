import javax.swing.*;
import java.awt.*;

public class SmileyFace extends JPanel
{
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      g.setColor(Color.yellow);
      g.fillOval(100, 25, 175, 175);
      
      g.setColor(Color.black);
      g.fillOval(135, 75, 25, 25);
      g.fillOval(200,75, 25, 25);
      
      g.fillArc(160, 150, 60, 20, 190, 175);
   }
    
   public static void main(String args[])
   {
         SmileyFace smiley = new SmileyFace();
         JFrame frame = new JFrame();
         frame.add(smiley);
         frame.setSize(300, 300);
         frame.setVisible(true);
   }
}
