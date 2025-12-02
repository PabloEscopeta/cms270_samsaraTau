
// Import JFrame from javax.swing
import javax.swing.*;
import java.awt.*; // Imports Border & Color
import java.util.ArrayList;



public class RollinsGameReviewDriver {
    private static ArrayList<UserReview> allReviews = new ArrayList<>();
    private static JTextArea displayArea = new JTextArea(22, 75);

    
    
    // Static used here
    static {
        allReviews.add(new UserReview("Gray_Fox08", "R12124228", 96,
            "Great sequel to an already great game!, weird third act though...", "2025-11-14",
            "Tommy The Tar 2", "Adventure"));
        
        allReviews.add(new UserReview("LowerCaseGuy", "R13334065", 86,
            "Here's the deal: Gameplay: Solid, Music: FIRE, Story: is alright, but 30FPS on CONSOLE, SMH", "2025-11-16",
            "Tommy The Tar 2", "Adventure"));
        
        allReviews.add(new UserReview("Campus_Security012", "R02339811", 70,
            "Game is to hard, even on easy, with Aim Assist, Music is lit though", "2025-12-01",
            "Tommy The Tar 2", "Adventure"));
        
        allReviews.add(new UserReview("OhNoItsEustace", "R00045516", 80,
            "Game is good, but these publishers need to stop making everything cross-platform", "2025-12-01",
            "Super mario bros.", "Adventure"));
    }

    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RollinsGameReviewDriver::createAndShowGUI);
        
        
    }

    private static void createAndShowGUI() {
    	// Title of Forum page for the window
        JFrame frame = new JFrame("ROLLINS GAME REVIEW FORUM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the whole window background A navy shade of blue, closer to a "Rollins" blue
        frame.getContentPane().setBackground(new Color(46, 90, 200));

        frame.setForeground(Color.WHITE);

        // Comic Sans MS being used for the font to give the text a more classic review forum feel
        // Use BOLD to make font clearer to read
        JLabel title = new JLabel("Rollins Reviews", JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
 
        displayArea.setEditable(false); 
        displayArea.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); 
        displayArea.setBackground(Color.WHITE);
        
        refreshDisplay();

        
        
        JPanel input = new JPanel(new GridLayout(6, 2, 10, 10));
        input.setBorder(BorderFactory.createTitledBorder("Create A Review Below:"));
        
        // Background painted blue
        input.setBackground(new Color(255, 255, 110));

        
        JTextField NameField      = new JTextField(15);
        JTextField IDField        = new JTextField(12);
        JTextField ScoreField     = new JTextField(5);
        JTextField CommentField   = new JTextField(25);
        JTextField GameNameField  = new JTextField();
        JTextField GameGenreField = new JTextField();

        
        // Button to submit user review
        // Button font & base color inspired by Rollins colors 
        JButton submit = new JButton("Submit Review");
        
        submit.setBackground(new Color(0, 120, 200));
        submit.setForeground(Color.YELLOW);
        submit.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        submit.setOpaque(true);
        submit.setBorderPainted(false);

        
        
        submit.addActionListener(e -> {
        	
            try {
                String name = NameField.getText().trim();
                
                // If review has no name, will output: "Anonymous Fox"
                if (name.isEmpty()) name = "Anonymous Fox";
                String id = IDField.getText().trim();
                
                // If review has no ID, will output: "guest"
                if (id.isEmpty()) id = "guest";
                int score = Integer.parseInt(ScoreField.getText().trim());
                if (score < 0 || score > 100) throw new Exception();
                String comment = CommentField.getText().trim();
                
                // Outputs "No Comment" for no comment given reviews
                if (comment.isEmpty()) comment = "No Comment";
                String gameName = GameNameField.getText().trim();
                String gameGenre = GameGenreField.getText().trim();

                // Reviews made by the user will be from the data they make it (presentation day)
                allReviews.add(new UserReview(name, id, score, comment, "2025-12-02", gameName, gameGenre));
                refreshDisplay();

                NameField.setText(""); IDField.setText(""); ScoreField.setText(""); CommentField.setText("");
                GameNameField.setText(""); GameGenreField.setText("");

                
                
                JOptionPane.showMessageDialog(frame,
                    "Thank You, " + name + "!\nYour review has been added!",
                    "Review Submitted", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Your score MUST be from 0–100", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        
        input.add(new JLabel(" Name:"));     input.add(NameField);
        input.add(new JLabel(" ID:"));       input.add(IDField);
        input.add(new JLabel(" Score:"));    input.add(ScoreField);
        input.add(new JLabel(" Comment:"));  input.add(CommentField);
        input.add(new JLabel(" Game Name:"));input.add(GameNameField);
        input.add(new JLabel(" Genre:"));    input.add(GameGenreField);

        
        JPanel bottom = new JPanel();
        bottom.setBackground(new Color(46, 90, 200));  // "Rollins" blue applied here too
        bottom.add(input);
        bottom.add(submit);

        
        frame.add(title, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    
    
    private static void refreshDisplay() {
    	
        StringBuilder sb = new StringBuilder();
        double avg = allReviews.stream().mapToInt(r -> r.getScore()).average().orElse(0.0);
        String perception = avg >= 70 ? "POSITIVE" : avg >= 40 ? "MIXED" : "NEGATIVE";

        sb.append(String.format(" Overall mood: %.1f/100 → %s\n\n", avg, perception));
        sb.append("═".repeat(100)).append("\n\n");

        for (UserReview r : allReviews) {
            sb.append(r.toString()).append("\n");
        }
        
        
        
    
    
    	//three list to contain all of the info needed for averages
    	ArrayList<String> newGames=new ArrayList<>();
    	ArrayList<Integer> totals=new ArrayList<>();
    	ArrayList<Integer> count=new ArrayList<>();
    	//Nested for loop so it can scan through the list and do various things like
    	//Scans through games
    	for(UserReview review: allReviews) {
    	String gameName=review.getGame();
    	int index=-1;
    	for (int i=0;i<newGames.size();i++) {
    		if (newGames.get(i).equalsIgnoreCase(gameName)) {
    			index=i; 
    			break;
    		}
    		
    	}
    	//If this is the first instance of the game it will add it to the list
    	if(index==-1) {
    		newGames.add(gameName);
    	totals.add(0); 
    	count.add(0);
    	index=newGames.size()-1;
    	}
    	
    	 
        totals.set(index, totals.get(index) + review.getScore());
       count.set(index, count.get(index) + 1);
    	}
       for(int i=0;i<newGames.size();i++) {
    	//Uses each of the list to get the count and totals of each game to find the average   
       String game=newGames.get(i);
       int totalScore=totals.get(i);
       int counter=count.get(i);
    	double gameAverage=(counter>0) ? (double) totalScore/counter:0;
       
    	sb.append(String.format("  %s: %.1f/100\n", game, gameAverage));
    	}
    	displayArea.setText(sb.toString());
    	
    	}
    
}
