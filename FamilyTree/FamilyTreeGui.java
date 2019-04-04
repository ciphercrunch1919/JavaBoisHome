import javax.swing.*;
import javax.swing.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FamilyTreeGui
{
   public static JList<FamilyMember> getPeopleList(FamilyTree family)
   {
      JList<FamilyMember> list = new JList<FamilyMember>();
      FamilyMember []fam = family.list();
      list.setListData(fam);
      return list;
   }

   public static String selectFile()
   {
      String fileName = null;
      JFileChooser fc = new JFileChooser();
      int retVal = fc.showOpenDialog(null);
   
      if(retVal == JFileChooser.APPROVE_OPTION)
      {
         File file = fc.getSelectedFile();
         fileName = file.getAbsolutePath();
      }
      return fileName;
   }

   public static void main(String []args)
   {
      JFrame bFrame = new JFrame("Button");
      bFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel bPanel = new JPanel();
      bPanel.setLayout(new BorderLayout());
      
      JButton button = new JButton("Select a file");
      button.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            JFrame frame = new JFrame("Family Tree");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            String csvFile = selectFile();
            FamilyTree family = new FamilyTree();
            family.fromCSV(csvFile);

            JList<FamilyMember> peopleList = getPeopleList(family);
            peopleList.setPreferredSize(new Dimension(200, 200));
            mainPanel.add(peopleList, BorderLayout.WEST);

            JTextArea personalInfo = new JTextArea("Select a person");
            personalInfo.setPreferredSize(new Dimension(200, 200));
            personalInfo.setEditable(false);

            mainPanel.add(personalInfo, BorderLayout.EAST);

            peopleList.addListSelectionListener(new ListSelectionListener(){
               public void valueChanged(ListSelectionEvent e)
               {
                  FamilyMember selection = peopleList.getSelectedValue();
                  String fName = selection.getFirstName();
                  String lName = selection.getLastName();
                  personalInfo.setText(selection.toString() + "\n");
                  personalInfo.append("Mother: " + family.getMother(fName, lName) + "\n");
                  personalInfo.append("Father: " + family.getFather(fName, lName) + "\n");
                  FamilyMember []siblings = family.getSiblings(fName, lName);
                  for (FamilyMember f: siblings)
                  {
                     personalInfo.append("Sibling: " + f + "\n");
                  }
                  FamilyMember []children = family.getChildren(fName, lName);
                  for (FamilyMember f: children)
                  {
                     personalInfo.append("Child: " + f + "\n");
                  } 
               }
            });

            frame.add(mainPanel);
            frame.pack();
            frame.setVisible(true);
            }
         });
      bPanel.add(button);
      bFrame.add(bPanel);
      bFrame.pack();
      bFrame.setVisible(true);
   }
}
