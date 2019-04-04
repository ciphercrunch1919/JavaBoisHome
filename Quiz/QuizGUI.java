import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class QuizGUI extends JFrame
{
   private JButton submit;
   private JButton newquestion;
   private JButton retry;
   private JPanel mainpanel;
   private JPanel submitpanel;
   private JLabel label;
   private JLabel result;
   private JTextField input;
   private Question question;

   public QuizGUI()
   {
      initQuiz();
   }
   
   private void initQuiz()
   {
      mainpanel = new JPanel();
      mainpanel.setLayout(null);
      submitpanel = new JPanel();
      submitpanel.setLayout(null);
      
      label = new JLabel("Question", SwingConstants.CENTER);
      label.setBounds(150, 50, 100, 25);
      result = new JLabel("Result", SwingConstants.CENTER);
      result.setBounds(150, 50, 100, 25);
     
      input = new JTextField();
      input.setPreferredSize(new Dimension(40, 30));
      input.setBounds(115, 100, 170, 25);

      newQuestion();

      submit = new JButton("Submit");
      submit.setBounds(150, 130, 100, 25);
      submit.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if(checkIt(input.getText()))
            {
               mainpanel.setVisible(false);
               if(check())
               {
                  result.setText("Correct");
               }
               else
               {
                  result.setText("Wrong");
                  submitpanel.add(retry);
               }
               submitpanel.add(result);
               submitpanel.add(newquestion);
               submitpanel.setVisible(true);
               QuizGUI.this.getContentPane().add(submitpanel);
            }
         }
      });

      newquestion = new JButton("New Question");
      newquestion.setBounds(125, 115, 150, 25);
      newquestion.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            mainpanel.remove(label);
            newQuestion();
            mainpanel.add(label);
            submitpanel.remove(retry);
            submitpanel.setVisible(false);
            mainpanel.setVisible(true);
         }
      });

      retry = new JButton("Try Again");
      retry.setBounds(125, 85, 150, 25);
      retry.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            submitpanel.remove(retry);
            submitpanel.setVisible(false);
            mainpanel.setVisible(true);
         }
      });

      mainpanel.add(label);
      mainpanel.add(submit);
      mainpanel.add(input);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().add(mainpanel);
      getContentPane().setPreferredSize(new Dimension(400, 200));
      pack();
      setVisible(true);
   }

   private boolean checkIt(String s)
   {
      try
      {
         new Integer(s);
         return true;
      }
      catch(Exception error)
      {
         System.out.println("Invalid input");
         return false;
      }
   }

   private void newQuestion()
   {
      question = new Question();
      label.setText(question.toString());
   }

   private boolean check()
   {
      String text = input.getText();
      Integer ans = new Integer(text);

      if (question.getAnswer() == ans)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}
