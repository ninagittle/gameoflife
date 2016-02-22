//package bbc.gameoflifestub;

import java.util.HashSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.Iterator;
import java.io.BufferedInputStream;

public class GameofLife {
    
    private static int gridSize;
    
    public static void main(String[] args){
        System.out.println("Welcome to the Game of Life!");
        
        System.out.println("Please enter the initial state, then hit return twice:");
        
        Scanner user_input = new Scanner(new BufferedInputStream(System.in));
        String inputStateString;
        Set<Cell> liveCells = new HashSet<Cell>();
        
        gridSize = 0;
        int x = 1;
        int y = 1;
        while (!(inputStateString = user_input.nextLine()).isEmpty()){
            gridSize = inputStateString.length();
            for (int i=0; i<inputStateString.length(); i++) {
                char c = inputStateString.charAt(i);
                if (c == '.') {
                    x++;
                } else if (c == '*') {
                    liveCells.add(new Cell(x,y));
                    x++;
                }
            }
            x = 1;
            y++;
        }
        
        Life life = new Life(liveCells, gridSize);
        
        System.out.print("Hit return to advance the game one turn, or enter 'exit' to end the game of life.");
        
        while (user_input.hasNextLine()) {
            inputStateString = user_input.nextLine();
            if (inputStateString.equals("")) {
                Set<Cell> evolvedCells = life.evolve();
                
                String outputStateString = new String();
                for (int yo=1; yo<=gridSize; yo++) {
                    for (int xo=1; xo<=gridSize; xo++) {
                        if (withinSet(new Cell(xo,yo), evolvedCells)) {
                            outputStateString += "*";
                        } else {
                            outputStateString += ".";
                        }
                    }
                    if (yo !=gridSize) {
                        outputStateString += "\n";
                    }
                    
                }
                    System.out.println(outputStateString);
            }
            
            else if (inputStateString.equals("exit")) {
                System.out.println("Thank you for playing the game of life.");
                return;
            } else {
                System.out.print("Invalid input. Please hit return to advance the game one turn at a time, or enter 'exit' to end the game of life.");
            }
        }
        
    }
    
    private static boolean withinSet(Cell cell, Set<Cell> setOfCells) {
        for (Iterator<Cell> it = setOfCells.iterator(); it.hasNext(); ) {
            Cell c = it.next();
            if (c.equals(cell)) {
                return true;
            }
        }
        return false;
    }

}