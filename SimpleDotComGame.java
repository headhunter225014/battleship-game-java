package Damir.App;
import java.util.*;


public class SimpleDotComGame {
    private GameHelper helper = new GameHelper();
    private ArrayList<SimpleDotCom> dotComsList = new ArrayList<SimpleDotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        SimpleDotCom one = new SimpleDotCom();
        SimpleDotCom two = new SimpleDotCom();
        SimpleDotCom three = new SimpleDotCom();

        one.setName("Damir");
        two.setName("Glebs");
        three.setName("Marko");

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to destroy three ships");
        System.out.println("Damir, Glebs, Marko");
        System.out.println("Try to destroy them using least amount of shots");

        for (SimpleDotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    public void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Take a hit");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Missed";

        for (SimpleDotCom dotComToSet : dotComsList) {
            result = dotComToSet.checkYourself(userGuess);
            if (result.equals("Hit")) {
                break;
            }
            if (result.equals("Destroyed")) {
                dotComsList.remove(dotComToSet);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All ships are destroyed");
        if (numOfGuesses <= 18) {
            System.out.println("It took only " + numOfGuesses + " amount og guesses");
        } else {
            System.out.println("It took you quite a long time: " + numOfGuesses + "Guesses ");
        }
    }

    public static void main(String[] args) {
        SimpleDotComGame game = new SimpleDotComGame();
        game.setUpGame();
        game.startPlaying();
    }
}
