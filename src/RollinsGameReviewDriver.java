
// Import JFrame from javax.swing
import javax.swing.*;
import java.awt.*; // Imports Border & Color 
import java.util.ArrayList;


public class RollinsGameReviewDriver {
    private static ArrayList<UserReview> allReviews = new ArrayList<>();
    private static JTextArea displayArea = new JTextArea(22, 75);

    
    // Static used here
    static {
    	// Each User review listed below here will create & print out a review for each
    	// with their own name, ID, The score/100 they give, any comment they made
    	// & the year when they where born
        allReviews.add(new UserReview("Gray_Fox08", "R12124228", 96, "Great sequel to an already great game!, weird third act though...", "2000-11-20")); 
        allReviews.add(new UserReview("LowerCaseGuy", "R13334065", 86, "Here's the deal: Gameplay: Solid, Music: FIRE, Story: is alright, but 30FPS on CONSOLE, SMH", "2002-04-04"));
        allReviews.add(new UserReview("Campus_Security012", "R02339811", 70, "Game is to hard, even on easy, with Aim Assist, Music is lit though", "1994-11-01"));
        allReviews.add(new UserReview("OhNoItsEustace", "R00045516", 80, "Game is good, but these publishers need to stop making everything cross-platform ", "2005-03-17"));
    }

    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RollinsGameReviewDriver::createAndShowGUI);
    }

    
    
    private static void createAndShowGUI() {
    	
    	// The main window the forum is in, the Rollins Game Review Forum window
        JFrame frame = new JFrame("ROLLINS GAME REVIEW FORUM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Displays the game title being reviewed
        JLabel title = new JLabel("Tommy The Tar 2 — Community Reviews", JLabel.CENTER);
          
        // Set a unique font for the reviews in Comic Sans
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        title.setForeground(new Color(0, 80, 150));

        // Preventing editing within the display
        displayArea.setEditable(false);
        
        // Different font than the title in
        displayArea.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        
        // Set background as Yellow to make it feel more "Rollins"
        displayArea.setBackground(Color.YELLOW);
        
        refreshDisplay();

        
        
        
        // Boarder for window where the user will submit their review
        JPanel input = new JPanel(new GridLayout(4, 2, 10, 10));
        input.setBorder(BorderFactory.createTitledBorder("Create A Review Below:"));

        JTextField NameField = new JTextField(15);
        JTextField IDField = new JTextField(12);
        JTextField ScoreField = new JTextField(5);
        JTextField CommentField = new JTextField(25);
        
        
        
        // Info for the button for submitting user review
        // Includes text
        JButton submit = new JButton("Submit Review");
        
        submit.setBackground(new Color(0, 120, 200));
        submit.setForeground(Color.YELLOW);
        submit.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        submit.setOpaque(true);       
        submit.setBorderPainted(false);       
        
        
        
        submit.addActionListener(e -> {
        	
            try {
                String name = NameField.getText().trim();
                if (name.isEmpty()) name = "Anonymous Fox";
                String id = IDField.getText().trim();
                if (id.isEmpty()) id = "guest";
                int score = Integer.parseInt(ScoreField.getText().trim());
                if (score < 0 || score > 100) throw new Exception();
                String comment = CommentField.getText().trim();
                if (comment.isEmpty()) comment = "No comment";

                allReviews.add(new UserReview(name, id, score, comment, "2025-11-29"));
                refreshDisplay();
                
                NameField.setText(""); IDField.setText(""); ScoreField.setText(""); CommentField.setText("");

                
                
                JOptionPane.showMessageDialog(frame,"Thank You, " + name + "!\nYour review has been added!",
                    "Review Submitted", JOptionPane.INFORMATION_MESSAGE);

                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Your score MUST be from 0–100", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        
        input.add(new JLabel(" Name:"));     input.add(NameField);
        input.add(new JLabel(" ID:"));       input.add(IDField);
        input.add(new JLabel(" Score:"));    input.add(ScoreField);
        input.add(new JLabel(" Comment:"));  input.add(CommentField);

        
        JPanel bottom = new JPanel();
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

        sb.append(String.format(" CURRENT AVERAGE: %.1f/100 → %s\n\n", avg, perception));
        sb.append("═".repeat(60)).append("\n\n");

        for (UserReview r : allReviews) {
            sb.append(r.toString()).append("\n");
        }
        
        
        
        displayArea.setText(sb.toString());
    }
}
