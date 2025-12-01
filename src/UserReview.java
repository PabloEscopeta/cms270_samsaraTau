public class UserReview extends ReviewAbstract {
	

	 // The variables / data that the user will input
    private String reviewerName;
    private String reviewerID;
    private int score;
    private String comment;
    private String reviewDate;

    
    // Constructor to help create UserReview object
    public UserReview(String reviewerName, String reviewerID, int score, 
                      String comment, String reviewDate) {
    	
   
    	
        this.reviewerName = reviewerName;
        this.reviewerID = reviewerID;
        this.score = score;
        
        // If the comment is left empty, will print out a "No Comment" response
        this.comment = (comment != null && !comment.trim().isEmpty()) ? comment : "No Comment";
        this.reviewDate = reviewDate;
    }

    
    
    // get method getScore
    public int getScore() { return score; }

 
    public String toString() {
    	
        return "Reviewer: " + reviewerName + " (ID: " + reviewerID + ")\n" +
               "Score: " + score + "/100\n" + // (Score/100)
               "Comment: " + comment + "\n" +
               "Date: " + reviewDate + "\n";
    }
}

