import java.util.HashSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.Iterator;
import java.io.BufferedInputStream;

public class GameofLife {
    
    private static int rowLength;
    private static Life life;
    private static final char liveCell = '*';
    private static final char deadCell = '.';
    
    public static void main(String[] args){
        System.out.println("Welcome to the Game of Life!");
        
        System.out.println("Please enter the initial state, then hit return twice:");
        
        Scanner userInput = new Scanner(new BufferedInputStream(System.in));
        String inputStateString;
        Set<Cell> liveCells = new HashSet<Cell>();
        
        rowLength = 0;
        int x = 1; int y = 1;
        while (!(inputStateString = userInput.nextLine()).isEmpty()){
            rowLength = inputStateString.length();
            for (int i=0; i<inputStateString.length(); i++) {
                char c = inputStateString.charAt(i);
                if (c == deadCell) {
                    x++;
                } else if (c == liveCell) {
                    liveCells.add(new Cell(x,y));
                    x++;
                }
            }
            x = 1;
            y++;
        }
        
        life = new Life(liveCells, rowLength);
        
        System.out.print("Hit return to advance the game one turn at a time, or enter 'exit' to end the game of life.");
        
        while (userInput.hasNextLine()) {
            inputStateString = userInput.nextLine();
            if (inputStateString.equals("")) {
                life.evolve();
                printLife();
            } else if (inputStateString.equals("exit")) {
                System.out.println("Thank you for playing the game of life.");
                return;
            } else {
                System.out.print("Invalid input. Please hit return to advance the game one turn at a time, or enter 'exit' to end the game of life.");
            }
        }
        
    }
    
    // Prints the grid of live and dead cells to the console
    private static void printLife() {
        String outputStateString = new String();
        for (int y=1; y<=rowLength; y++) {
            for (int x=1; x<=rowLength; x++) {
                if (life.containsLiveCell(new Cell(x,y))) {
                    outputStateString += liveCell;
                } else {
                    outputStateString += deadCell;
                }
            }
            if (y !=rowLength) {
                outputStateString += "\n";
            }
        }
        System.out.println(outputStateString);
    }

}