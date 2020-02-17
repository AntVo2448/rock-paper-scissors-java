import java.awt.*;
import java.awt.event.*;

public class RPSVisual extends Frame implements ActionListener {

  private String result;
  private TextField displayResult;
  private Button rock, paper, scissors;
  RPSGameLogic game = new RPSGameLogic();

  public RPSVisual() {
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
        result = game.rpsLogic("rock", game.randomChoice()); // result = verdict of game
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
        result = game.rpsLogic("paper", game.randomChoice());
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
        result = game.rpsLogic("scissors", game.randomChoice());
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

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

  }
}