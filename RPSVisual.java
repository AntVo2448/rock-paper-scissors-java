import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class RPSVisual extends JFrame implements ActionListener {

  private String result;
  private JTextField displayResult;
  private JButton rock, paper, scissors;
  RPSGameLogic game = new RPSGameLogic();

  public RPSVisual() {
    // Objects appear left to right
    setLayout(new FlowLayout());

    // "Select a move" text
    add(new JLabel("Select a move"));

    // Rock Button
    rock = new JButton("Rock");
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
    paper = new JButton("Paper");
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
    scissors = new JButton("Scissors");
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
    displayResult = new JTextField(result, 30);
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

  // auto-generated stub
  @Override
  public void actionPerformed(ActionEvent e) {

  }
}