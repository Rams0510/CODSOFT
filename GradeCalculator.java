//TASK 2(STUDENT GRADE CALCULATOR)
import java.util.*;
public class GradeCalculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int num=sc.nextInt();
        int arr[]=new int[num];
        for(int i=0;i<num;i++){
            System.out.print("Enter the marks(0-100): ");
            arr[i]=sc.nextInt();
        }
        int total_marks=0;
        for(int i:arr){
            total_marks+=i;
        }
        double average_percentage=total_marks/num;
        System.out.println("Total Marks: "+total_marks);
        System.out.println("Average Percentage: "+average_percentage);
        if(average_percentage>=90 && average_percentage<=100) System.out.println("Grade: "+'O');
        else if(average_percentage>=80 && average_percentage<90) System.out.println("Grade: "+'A');
        else if(average_percentage>=70 && average_percentage<80) System.out.println("Grade: "+'B');
        else if(average_percentage>=60 && average_percentage<70) System.out.println("Grade: "+'C');
        else if(average_percentage>=40 && average_percentage<60) System.out.println("Grade: "+'D');
        else System.out.println("Grade: "+'F');
        sc.close();
    }
}