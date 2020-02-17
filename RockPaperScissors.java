import java.awt.*;
import java.awt.event.*;

public class RockPaperScissors extends Frame implements ActionListener {

  private String result;
  private TextField displayResult;
  private Button rock, paper, scissors;

  public RockPaperScissors() {
    // Objects appear left to right
    setLayout(new FlowLayout());

    // "Select a move" text
    add(new Label("Select a move"));

    // Rock Button
    rock = new Button("Rock");
    add(rock);
    rock.addActionListener(new ActionListener() { // upon button hit
      @Override
      public void actionPerformed(ActionEvent evt) {
        result = rpsLogic("rock", randomChoice()); // result = verdict of game
        displayResults(); // sends results to "displayResult" textField
      }
    }
  );

    // Paper Button
    paper = new Button("Paper");
    add(paper);
    paper.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        result = rpsLogic("paper", randomChoice());
        displayResults();
      }
    }
  );

    // Scissors Button
    scissors = new Button("Scissors");
    add(scissors);
    scissors.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        result = rpsLogic("scissors", randomChoice());
        displayResults();
      }
    }
  );

    // displayResults text field (displays rpsLogic return string)
    System.out.println(result);
    displayResult = new TextField(result, 30);
    displayResult.setEditable(false);
    add(displayResult);

    // Create frame
    setTitle("Rock Paper Scissors");
    setSize(600, 600);
    setVisible(true);

  }

  // updates displayResult w latest result
  public void displayResults() {
    displayResult.setText(result);
  }

  // computer makes random guess
  public String randomChoice() {
    String guess;

    // generates random # b/t 0 to 2
    int random = (int)(Math.random() * 3);

    // assigns guess to random value
    if (random == 2) {
      guess = "rock";
    } else if (random == 1) {
      guess = "paper";
    } else {
      guess = "scissors";
    }

    return guess;
  }

  // RPS game logic using nested-ifs
  public String rpsLogic(String playerGuess, String compGuess) {
    String pGuess = playerGuess;
    String cGuess = compGuess;
    String verdict = "";

    if (pGuess == "rock") {
      if (cGuess == "rock") {
        verdict =  "Tie!";
      } else if (cGuess == "paper") {
        verdict =  "You lose!";
      } else {
        verdict = "You win!";
      }
    }

    if (pGuess == "paper") {
      if (cGuess == "rock") {
        verdict = "You win!";
      } else if (cGuess == "paper") {
        verdict = "Tie!";
      } else {
        verdict = "You lose!";
      }
    }

    if (pGuess == "scissors") {
      if (cGuess == "rock") {
        verdict = "You lose!";
      } else if (cGuess == "paper") {
        verdict = "You win!";
      } else {
        verdict = "Tie!";
      }
    }

    return verdict + " The computer played: " + cGuess;

  }

  public static void main(String[] args) {
    
    // Calls instance of RockPaperScissors
    RockPaperScissors rps = new RockPaperScissors();
    
  }
}