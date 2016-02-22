//package bbc.gameoflifestub;

import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;

public class Life {

	private Set<Cell> liveCells;
    private int gridSize;

	public Life(Set<Cell> initialLiveCells, int gridSize) {
		this.liveCells = initialLiveCells;
        this.gridSize = gridSize;
	}
	
    // Read-only access to the game state
    public Set<Cell> getLiveCells() {
        return this.liveCells;
    }
    
    public Set<Cell> evolve() {
        Set<Cell> evolvedCells = new HashSet<Cell>();
        
        //Determines if existing cells die or survive
        for (Iterator<Cell> it = liveCells.iterator(); it.hasNext(); ) {
            Cell c = it.next();
            int numNeighbours = cellNeighbours(c);
            if (cellShouldSurvive(numNeighbours)) {
                evolvedCells.add(c);
            }
        }
        
        //Determines if any cells are created
        for (int y=1; y<=gridSize; y++) {
            for (int x=1; x<=gridSize; x++) {
                if (cellCreation(new Cell(x,y))) {
                    evolvedCells.add(new Cell(x,y));
                }
            }
        }
        
        this.liveCells = evolvedCells;
        return evolvedCells;
    }
    
    //Retuns the number of neighbours for a given cell
    private int cellNeighbours(Cell cell) {
        int numNeighbours = 0;
        for (Iterator<Cell> it = liveCells.iterator(); it.hasNext(); ) {
            Cell c = it.next();
            if (isNeighbour(cell,c)) {
                numNeighbours++;
            }
        }
        return numNeighbours;
    }

    private boolean cellShouldSurvive(int numNeighbours) {
        switch (numNeighbours) {
            case 2:
                return true;
            case 3:
                return true;
            default:
                return false;
        }
    }
    
    
    // Determines whether a new cell is created in the position of newCell
    private boolean cellCreation (Cell newCell) {
        for (Iterator<Cell> it = liveCells.iterator(); it.hasNext(); ) {
            if (newCell.equals(it.next())) {
                return false;
            }
        }
        
        int numNeighbours = cellNeighbours(newCell);
        if (cellIsCreated(numNeighbours)) {
            return true;
        } else {
            return false;
        }
 
    }
    
    private boolean cellIsCreated (int numNeighbours) {
        switch (numNeighbours) {
            case 3:
                return true;
            default:
                return false;
        }
    }
    
    private boolean isNeighbour(Cell c1, Cell c2) {
        int x = c1.x();
        int y = c1.y();
        
        if (c1.equals(c2)) {
            return false;
        } else if (c2.x() >= (x-1) && c2.x() <= (x+1)) {
            if (c2.y() >= (y-1) && c2.y() <= (y+1)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        
    }
}
