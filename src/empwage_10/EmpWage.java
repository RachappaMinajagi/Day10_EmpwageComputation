package empwage_10;
import java.util.Random; // import Random class

public class EmpWage {
    public static void EmpWageStatus(int num){
        int Wage_HR = 20;
        int Day_HRs = 8;
        int Part_HRs = 4;
/*
 * Switch case
 */
        switch (num){
            case 1:
                System.out.println("Employee Present");
                System.out.println("DayWage = " + Wage_HR * Day_HRs);
                break;
            case 2:
                System.out.println("Employee Present");
                System.out.println("DayWage with Part Time = " + Wage_HR *Part_HRs);
                break;
            case 0:
                System.out.println("Employee Absent");
                System.out.println("DayWage = "+0);
        }


    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        Random random = new Random();
        int r = random.nextInt(3);
        EmpWageStatus(r);

    }
}