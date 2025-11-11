
public class AudienceReview {
	
	private String gameName;
	private String gameGenre;
	private String gameReviewer;
	private String reviewerID; 
	private int userGameReviewScore;
	private String userReviewComment;
	private String userReviewDate; 
	
	// constructor
	public AudienceReview(String newGameName, String newGameGenre, String newGameReviewer, 
			String newReviewerID, int newUserGameReviewScore, String newUserReviewComment,
			String newUserReviewDate) {
		this.gameName = newGameName;
		this.gameGenre = newGameGenre;
		this.gameReviewer = newGameReviewer;
		this.reviewerID = newReviewerID;
		this.userGameReviewScore = newUserGameReviewScore;
		this.userReviewComment = newUserReviewComment;
		this.userReviewDate = newUserReviewDate;
	}
	
	// getGameName
	public String getGameName() {
		return gameName;
	}
	
	// getGameGenre
	public String getGameGenre() {
		return gameGenre;
	}
	
	// getGameReviewer
	public String getGameReviewer() {
		return gameReviewer;
	}
	
	// getReviewerID
	public String getReviewerID() {
		return reviewerID; 
	}
	
	// get userGameReviewScore
	public int getUserGameReviewScore() { 
		return userGameReviewScore;
	}
	
	// getUserReviewComment
	public String getUserReviewComment() {
		return userReviewComment;
	}
	
	// getUserReviewDate
	public String getUserReviewDate() {
		return userReviewDate;
	}
	

}
