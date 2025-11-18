import java.util.Scanner;

public class RollinsGameReviewDriver {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        

        // Will promt the user to input their information & review
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter your review score (0-100): ");
        int score = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Input your comment: ");
        String comment = scanner.nextLine();

        System.out.print("Please enter today's date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        
        // Object for the user's review based on their own input
        UserReview myReview = new UserReview(name, id, score, comment, date);

        System.out.println("\n" + myReview);
    }
}
