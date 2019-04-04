import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree
{
   private ArrayList<FamilyMember> relatives;

   public FamilyTree()
   {
      relatives = new ArrayList<FamilyMember>();
   } 

   public void fromCSV(String fileName)
   {
      try
      {
         Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));
         fromScanner(s);
      }
      catch(Exception e)
      {}
   }

   private void fromScanner(Scanner s)
   {
      while (s.hasNext())
      {
         String nextLine = s.nextLine();
         String[] names = nextLine.split(",");
         for (int i = 0; i < names.length; i++)
         {
            names[i] = names[i].trim();
         }
         FamilyMember r = findFamilyMember(names[0], names[1]);
         if (r == null)
         {
            r = new FamilyMember(names[0], names[1]);
            relatives.add(r);
         }
         FamilyMember father = findFamilyMember(names[2], names[3]);
         if (father == null)
         {
            father = new FamilyMember(names[2], names[3]);
            relatives.add(father);
         }
         r.setFather(father);
         FamilyMember mother = findFamilyMember(names[4], names[5]);
         if (mother == null)
         {
            mother = new FamilyMember(names[4], names[5]);
            relatives.add(mother);
         }
         r.setMother(mother);
      }
   }

   public FamilyMember[] list()
   {
      FamilyMember []listOfPeople = {};
      return relatives.toArray(listOfPeople);   
   }

   public void add(FamilyMember r)
   {
      relatives.add(r);
   }

   private FamilyMember findFamilyMember(String firstName, String lastName)
   {
      FamilyMember found = null;
      for (int i = 0; i < relatives.size(); i++)
      {
         if (relatives.get(i).is(firstName, lastName))
         {
            found = relatives.get(i);
         }
      }
      return found;
   }

   public FamilyMember[] getSiblings(String firstName, String lastName)
   {
      ArrayList<FamilyMember> siblings = new ArrayList<FamilyMember>();
      FamilyMember person = findFamilyMember(firstName, lastName);
      if (person != null)
      {
         FamilyMember mother = person.getMother();
         FamilyMember father = person.getFather();
         if (mother != null && father != null)
         {
            for (int i = 0; i < relatives.size(); i++)
            {
               FamilyMember nextPerson = relatives.get(i);
               if (nextPerson != person && 
                   nextPerson.getMother() == mother && 
                   nextPerson.getFather() == father)
               {
                  siblings.add(nextPerson);
               } 
            }
         }
      }
      FamilyMember []sib = {};
      return siblings.toArray(sib);
   }

   public FamilyMember[] getChildren(String firstName, String lastName)
   {
      ArrayList<FamilyMember>children = new ArrayList<FamilyMember>();
      FamilyMember person = findFamilyMember(firstName, lastName);

      if (person != null)
      {
         for (int i = 0; i < relatives.size(); i++)
         {
            FamilyMember nextPerson = relatives.get(i);
            if (nextPerson != person && 
                nextPerson.getMother() == person || 
                nextPerson.getFather() == person)
            {
               children.add(nextPerson);
            } 
         }
      }
      FamilyMember []kids = {};
      return children.toArray(kids);
   }

   public FamilyMember getMother(String firstName, String lastName)
   {
      FamilyMember mother = null;
      FamilyMember person = findFamilyMember(firstName, lastName);
      if (person != null)
      {
         mother = person.getMother();
      }
      return mother;
   }

   public FamilyMember getFather(String firstName, String lastName)
   {
      FamilyMember father = null;
      FamilyMember person = findFamilyMember(firstName, lastName);
      if (person != null)
      {
         father = person.getFather();
      }
      return father;
   }
}
