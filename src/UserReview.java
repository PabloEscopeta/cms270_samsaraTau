import java.util.Scanner;

public class UserReview extends ReviewAbstract{
	
	private AudienceReview review;
	
	public void submitReview(
		// Collect score, comment, and date, and create an AudienceReview object
		// Update numberOfReviews 
		String gameName,
		String gameGenre,
		String reviewerName,
		String reviewerID,
		int score,
		String comment,
		String date
		) { 
		review = new AudienceReview(
				gameName,
				gameGenre,
				reviewerName,
				reviewerID,
				score,
				comment,
				date
				);
		numberOfReviews++;
		
	}
	
	@Override
	public void displayReview() {
		// Display review details (toString() for console/debugg?)
		if (review == null) {
			System.out.println("No review available.");
		} else {
			System.out.println(review.toString());
		}
	}
	
	public String getReviewText() {
		return (review == null)
				? "No review available."
						: review.toString();
	}

	@Override
	public void submitReview() {
		// TODO Auto-generated method stub
		
	}

}
