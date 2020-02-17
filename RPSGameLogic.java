public class RPSGameLogic {

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

}