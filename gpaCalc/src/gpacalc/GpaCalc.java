package gpacalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GpaCalc {
    
    static Scanner sc = new Scanner(System.in);
        
    static List <String> courses = new ArrayList<>();
    static List <Character> grades = new ArrayList<>();
    static List <Integer> points = new ArrayList<>(), 
                   units = new ArrayList<>();
        
    static int counter = 1;
        
    public static void main(String[] args) {
        
        GpaCalc gpa = new GpaCalc();
        
        
        System.out.println("GPA CALCULATOR \nMinimun Entries Allowed is 5 and Maximum  is 20"
                + "\n\t where n is the number of entries");
             
        while (counter <=5)
            gpa.newEntry();
        
        
        while (counter <= 20) {
            System.out.println("\nDo you wish to make more entries? "
                    + "\n press 'y' for yes, otherwise press any other key");

            String check = sc.next();
            if (!"y".equals(check) && !"Y".equals(check)) 
               break;
            else
                gpa.newEntry();
        }
        
        System.out.println("COURSE CODE \t UNIT \t GRADE \t POINT \t UNIT * POINT \t TOTAL");
        for (int i=0; i<counter-1; i++) {
            System.out.println(courses.get(i) + "\t\t " +
                               units.get(i) + "  \t  " +
                               grades.get(i) + "  \t " +
                               points.get(i) + "  \t  " +
                               units.get(i).toString()+ " * " +points.get(i).toString()+ "  \t" +
                               units.get(i) * points.get(i)
            );
        }
        
        System.out.println("\n Total Point: " +gpa.calcTotalPoints() 
                            +"\n Total Unit: "+gpa.calcTotalUnits()
                            +"\n GPA: "+ gpa.calcGpa(gpa.calcTotalUnits(), gpa.calcTotalPoints()));
    }
    
    void newEntry () {
        System.out.println("\n COURSE "+counter+ " DATA\n");
        
        System.out.println("Enter Course Code: ");
        courses.add(sc.next());
                
        System.out.println("Enter Course Unit: ");
        addUnit();
        
        System.out.println("Enter Point: ");
        addPoint();

        counter++;
    }
    
    void addUnit(){
        try {
            Scanner sc = new Scanner(System.in);
            units.add(sc.nextInt());
        } catch (Exception e) {
            System.out.println("Invalid Input: Unit can only be an Integer");
            System.out.println("Enter Course Unit Again: ");
            addUnit();
        }         
    }
    
    void addPoint(){
        try {
            Scanner sc = new Scanner(System.in);
            int point = sc.nextInt();
            points.add(point);
            grades.add(newGrade(point));
        } catch (Exception e) {
            System.out.println("Invalid Input: Point can only be an Integer");
            System.out.println("Enter Point Again: ");
            addPoint();
        }
    }
    
    int calcTotalUnits () {
        int totalUnits = 0;
        
        for (int  i : units)
            totalUnits += i;
        
        return totalUnits;
    }
    
    int calcTotalPoints () {
        int totalPoints = 0;
        
        for (int  i=0; i<counter-1; i++)
            totalPoints += units.get(i)*points.get(i);
        
        return totalPoints;
    }
    
    double calcGpa (double totalUnits, double totalPoints) {
         return totalPoints/totalUnits;
    }

    private Character newGrade(int point) {
        switch (point) {
            case 5:return 'A'; 
            case 4: return 'B';
            case 3: return 'C';
            case 2: return 'D';
            default: return 'E';
        }
    }
    
}
