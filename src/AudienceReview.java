
public class AudienceReview extends ReviewAbstract {
	
	// constructor
	public AudienceReview(String newGameName, String newGameGenre, String newGameReviewer, 
			String newReviewerID, int newUserGameReviewScore, String newUserReviewComment,
			String newUserReviewDate) {
		// these fields are all inherited from ReviewAbstract
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
	
	@Override
	public String toString() {
		return "Game: " + gameName + "\n" +
				"Genre: " + gameGenre + "\n" + 
				"Reviewer: " + gameReviewer + "\n" +
				"ID: " + reviewerID + "\n" +
				"Review Score: " + userGameReviewScore + " /10" + "\n" +
				"Review: " + userReviewComment + "\n" +
				"Posted on: " + userReviewDate; 
	}
	

}
