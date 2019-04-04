public class FamilyMember
{
   private FamilyMember mother;
   private FamilyMember father;
   private String firstName;
   private String lastName;

   public FamilyMember(String fName, String lName)
   {
      firstName = fName;
      lastName = lName;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public boolean is(String fName, String lName)
   {
      return firstName.equals(fName) && lastName.equals(lName);
   }

   public void setMother(FamilyMember mother)
   {
      this.mother = mother;
   }

   public void setFather(FamilyMember father)
   {
      this.father = father;
   }

   public FamilyMember getMother()
   {
      return this.mother;
   }

   public FamilyMember getFather()
   {
      return this.father;
   }

   public String toString()
   {
      String descr = firstName + " " + lastName;
      return descr;
   }
}
