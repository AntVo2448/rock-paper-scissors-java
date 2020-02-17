import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RPSVisual extends JFrame implements ActionListener {

  private String result;
  private String playerChoice; // what player chooses as answer
  private JTextField displayResult;
  private JButton rock, paper, scissors;

  // All necessary for displaying images
  private BufferedImage imgPlayer, imgComputer;
  private Image resizePlayer, resizeComputer; // resized images to fit JLabel
  private ImageIcon iconPlayer, iconComputer;
  private JFrame frame = new JFrame(); // main frame
  private JLabel labelPlayer, labelComputer;
  private boolean hasHappenedPlayer = false; // has the image been added to frame yet?
  private boolean hasHappenedComputer = false;

  // relative paths to images
  private static final String ROCK_IMG_PATH = "images\\rock.png";
  private static final String PAPER_IMG_PATH = "images\\paper.png";
  private static final String SCISSORS_IMG_PATH = "images\\scissors.png";

  // object construction to access methods
  RPSGameLogic game = new RPSGameLogic();

  // main constructor
  public RPSVisual() {
    // Objects appear left to right
    frame.setLayout(new FlowLayout());

    setImagePlayer();
    setImageComputer();

    // "Select a move" text
    frame.add(new JLabel("Select a move"));

    // Rock Button
    rock = new JButton("Rock");
    frame.add(rock);
    rock.addActionListener(new ActionListener() { // upon button hit
      @Override
      public void actionPerformed(ActionEvent evt) {
        playerChoice = "rock";
        result = game.rpsLogic(playerChoice, game.randomChoice()); // result = verdict of game
        displayResults(); // sends results to "displayResult" textField
      }
    }
  );

    // Paper Button
    paper = new JButton("Paper");
    frame.add(paper);
    paper.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        playerChoice = "paper";
        result = game.rpsLogic(playerChoice, game.randomChoice());
        displayResults();
      }
    }
  );

    // Scissors Button
    scissors = new JButton("Scissors");
    frame.add(scissors);
    scissors.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        playerChoice = "scissors";
        result = game.rpsLogic(playerChoice, game.randomChoice());
        displayResults();
      }
    }
  );


    // displayResults text field (displays rpsLogic return string)
    // System.out.println(result);
    displayResult = new JTextField(result, 30);
    displayResult.setEditable(false);
    frame.add(displayResult);

    // Create frame
    frame.setTitle("Rock Paper Scissors");
    frame.setSize(600, 600);
    frame.setVisible(true);

  }

  // updates displayResult w latest result
  public void displayResults() {
    displayResult.setText(result);

    // Display images
    // setImagePlayer();
    // setImageComputer();
    updateImages();

  }

  public void setImagePlayer() {
    try {
      if (playerChoice == "rock") {
        imgPlayer = ImageIO.read(new File(ROCK_IMG_PATH));
      } else if (playerChoice == "paper") {
        imgPlayer = ImageIO.read(new File(PAPER_IMG_PATH));
      } else {
        imgPlayer = ImageIO.read(new File(SCISSORS_IMG_PATH));
      }
    } catch (IOException ie) {
      ie.printStackTrace();
    }

    resizePlayer = imgPlayer.getScaledInstance(200, 200, 
    Image.SCALE_SMOOTH); // resizes image
    iconPlayer = new ImageIcon(resizePlayer);
    labelPlayer = new JLabel(iconPlayer);

    frame.add(labelPlayer);

  }

  public void setImageComputer() {
    try{
      if (game.getComputerGuess() == "rock") {
        imgComputer = ImageIO.read(new File(ROCK_IMG_PATH));
      } else if (game.getComputerGuess() == "paper") {
        imgComputer = ImageIO.read(new File(PAPER_IMG_PATH));
      } else {
        imgComputer = ImageIO.read(new File(SCISSORS_IMG_PATH));
      }
    } catch (IOException ie) {
      ie.printStackTrace();
    }

    resizeComputer = imgComputer.getScaledInstance(200, 200, 
    Image.SCALE_SMOOTH);
    iconComputer = new ImageIcon(resizeComputer);
    labelComputer = new JLabel(iconComputer);

    frame.add(labelComputer);

  }

  public void updateImages() {
    labelPlayer.setIcon(iconPlayer);
    labelComputer.setIcon(iconComputer);
    
    frame.revalidate();
    frame.repaint();
  }

  // auto-generated stub
  @Override
  public void actionPerformed(ActionEvent e) {

  }
}