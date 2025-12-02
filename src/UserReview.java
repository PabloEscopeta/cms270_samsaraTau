
public class UserReview extends ReviewAbstract {
	
	// The variables / data that the user will input
    private String reviewerName;
    private String reviewerID;
    private int score;
    private String comment;
    private String reviewDate;
    private String gameName;
    private String gameGenre;

    // Constructor to help create UserReview object
    public UserReview(String reviewerName, String reviewerID, int score, String comment, String reviewDate,
                      String gameName, String gameGenre) {
    	
        this.reviewerName = reviewerName;
        this.reviewerID = reviewerID;
        this.score = score;
        
     // If the comment is left empty, will print out a "No Comment" response
        this.comment = (comment != null && !comment.trim().isEmpty()) ? comment : "No Comment";
        this.reviewDate = reviewDate;
        
     // If the Game Name is left empty, will print out a "Game not specified" response
        this.gameName = gameName != null && !gameName.trim().isEmpty() ? gameName : "Game Not Specified";
        
     // If the Genre is left empty, will print out a "No Genre Specified" response
        this.gameGenre = gameGenre != null && !gameGenre.trim().isEmpty() ? gameGenre : "No Genre Specified";
    }

    
    // Get method getScore
    public int getScore() { return score; }
   //Get method for Game
    public String getGame() {
    	return gameName;
    }
    public String toString() {
    	
        return "Game: " + gameName + " (" + gameGenre + ")\n" +
               "Reviewer: " + reviewerName + " (ID: " + reviewerID + ")\n" +
               "Score: " + score + "/100\n" + // (Score/100)
               "Comment: " + comment + "\n" +
               "Date: " + reviewDate + "\n";
    }
}
