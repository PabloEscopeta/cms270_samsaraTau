import java.util.ArrayList; 

public class RollinsGameReviewForum {
	// Create ArrayList for reviews.
	private ArrayList<AudienceReview> reviews = new ArrayList<>();
	
	// addReview mthod
	public void addReview(AudienceReview review) {
		reviews.add(review);
	}
	
	// display review method
	// prints out review in console as of this moment;
		// rework when implementing UI / JavaFX
	public void displayReview() {
		for (AudienceReview review : reviews) {
			System.out.println(review);
		}
	}

}
