import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;

public class Life {

	private Set<Cell> liveCells;
    private int rowLength;

	public Life(Set<Cell> initialLiveCells, int rowLength) {
		this.liveCells = initialLiveCells;
        this.rowLength = rowLength;
	}
	
    // Read-only access to the game state
    public Set<Cell> getLiveCells() {
        return this.liveCells;
    }
    
    // Evolves the grid of cells by one iteration
    public void evolve() {
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
        for (int y=1; y<=rowLength; y++) {
            for (int x=1; x<=rowLength; x++) {
                if (cellCreation(new Cell(x,y))) {
                    evolvedCells.add(new Cell(x,y));
                }
            }
        }
        
        this.liveCells = evolvedCells;
    }
    
    // Returns true if a given cell is contained within the set liveCells
    public boolean containsLiveCell(Cell cell) {
        for (Iterator<Cell> it = liveCells.iterator(); it.hasNext(); ) {
            if (cell.equals(it.next())) {
                return true;
            }
        }
        return false;
    }
    
    // Returns the number of neighbours for a given cell
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
    
    // Returns true if a live cell should survive given its number of neighbours
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
    
    // Determines whether a new cell is created in the position of newCell. If a cell already exists in the position of newCell, the function returns false
    private boolean cellCreation (Cell newCell) {
        if (containsLiveCell(newCell)) {
            return false;
        }
        int numNeighbours = cellNeighbours(newCell);
        return cellIsCreated(numNeighbours);
    }
    
    // Returns true if a dead cell should become alive given its number of neighbours
    private boolean cellIsCreated (int numNeighbours) {
        switch (numNeighbours) {
            case 3:
                return true;
            default:
                return false;
        }
    }
    
    // Returns true if cells c1 and c2 are neighbours. If c1 and c2 are equal, the function returns false.
    private boolean isNeighbour(Cell c1, Cell c2) {
        int x = c1.getX();
        int y = c1.getY();
        
        if (c1.equals(c2)) {
            return false;
        } else if (c2.getX() >= (x-1) && c2.getX() <= (x+1) && c2.getY() >= (y-1) && c2.getY() <= (y+1)) {
            return true;
        } else {
            return false;
        }
    }
    
}
