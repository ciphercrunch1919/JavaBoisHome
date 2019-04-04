import java.util.Random;

public class Question
{
   private int value1;
   private int value2;
   private boolean operator;
   
   public Question()
   {
      Random rand = new Random();

      value1 = rand.nextInt(100);
      value2 = rand.nextInt(100);
      operator = rand.nextInt(2) == 1;
   }

   public String toString()
   {
      if(operator)
      {
         String val = this.value1 + " - " + this.value2;
         return val;
      }
      else
      {
         String val = this.value1 + " + " + this.value2;
         return val;
      }
   }

   public int getAnswer()
   {
      if(operator)
      {
         return value1 - value2;
      }
      else
      {
         return value1 + value2;
      }
   }
}
