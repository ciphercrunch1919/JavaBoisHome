import java.util.*;
import java.util.Iterator;

public class Driver
{
   public static void main(String []args)
   {
      List names = new ArrayList();
      names.add("Adam");
      names.add("Bernie");
      names.add("Charles");
      names.add("Dennis");
      names.add("Elisa");
      names.add("Francis");      

      for (Object o : names)
      {
         System.out.println(o.toString());
      }   
   }
}
