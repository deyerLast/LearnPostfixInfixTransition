
/**
 * DavidMeyer_5_01
 *    @author: David Meyer
 *    Program development environment (macOS High Sierra, MacBook pro, IntelliJ)
 *
 *    carphology - Convulsive or involuntary moments made by delirious
 *    patients, such as plucking at the bedclothes.
 *
 *     "You have to create your life. You have to carve it, like a sculpture."
 *          - William Shatner (1931 - current)
 *
 *    @Version 1
 *    Due: November 5, 2018
 *    Main(DavidMeyer_03) uses the classes object classes Student and GradeItem
 *     to run tests to create a list of information that is contained within
 *     a .txt file.  Reads the information, puts students together and then
 *     creates a new .txt file and puts all information into that file.
 */

import java.util.Scanner;

public class DavidMeyer_05 {
    static Scanner std = new Scanner(System.in);
    static PostFix stack = new PostFix();
    //static Stack stack1;
    static String entered;


    public static void main(String[] args){
        do{
            System.out.println("Enter infix form. Type 'y' to quit.");
            entered = std.nextLine();

            System.out.println("Postfix Form:  " + stack.convertToPostfix(entered));
        }while(!"y".equalsIgnoreCase(entered));


    }

}

