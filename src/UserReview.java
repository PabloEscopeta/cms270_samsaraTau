
public class UserReview extends ReviewAbstract {

    private String reviewerName;
    private String reviewerID;
    private int score;
    private String comment;
    private String reviewDate;

    // Constructor
    public UserReview(String reviewerName, String reviewerID, int score, 
                      String comment, String reviewDate) {
    	
    	
        this.reviewerName = reviewerName;
        this.reviewerID = reviewerID;
        this.score = score;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    
    
   // Will return the information the User will input themselves
    public String toString() {
        return "Reviewer: " + reviewerName + " (ID: " + reviewerID + ")\n" +
               "Score: " + score + "/100\n" +
               "Comment: " + comment + "\n" +
               "Date made: " + reviewDate;
    }
}
