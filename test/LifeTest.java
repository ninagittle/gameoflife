import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
	
public class LifeTest {

	protected Set<Cell> setOfCells;
    protected Set<Cell> setOfCellsEv;
	protected Life life;
	
	@Before
	public void setUp() {
    	setOfCells = new HashSet<Cell>();
    	setOfCells.add(new Cell(1,1));
    	setOfCells.add(new Cell(2,2));
        life = new Life(setOfCells,2);
    }
	
	@Test
	public void testInitialisation() {
		assertEquals(2, life.getLiveCells().size());
	}
    
    @Test
    public void testContainsLiveCell() {
        setOfCells = new HashSet<Cell>();
        setOfCells.add(new Cell(1,1));
        setOfCells.add(new Cell(2,2));
        setOfCells.add(new Cell(3,3));
        life = new Life(setOfCells,3);
        
        assertTrue(life.containsLiveCell(new Cell(1,1)));
        assertTrue(life.containsLiveCell(new Cell(2,2)));
        assertTrue(life.containsLiveCell(new Cell(3,3)));
        
        assertFalse(life.containsLiveCell(new Cell(1,2)));
        assertFalse(life.containsLiveCell(new Cell(3,1)));
        assertFalse(life.containsLiveCell(new Cell(2,3)));
    }
    
    @Test
    public void testEvolution_deadGrid() {
        setOfCells = new HashSet<Cell>();
        life = new Life(setOfCells,3);
        life.evolve();
        
        setOfCellsEv = new HashSet<Cell>();
        
        assertEquals(setOfCellsEv, life.getLiveCells());
    }
    
    @Test
    public void testEvolution_1() {
        setOfCells = new HashSet<Cell>();
        setOfCells.add(new Cell(2,1));
        setOfCells.add(new Cell(2,2));
        setOfCells.add(new Cell(2,3));
        life = new Life(setOfCells,3);
        life.evolve();
        
        setOfCellsEv = new HashSet<Cell>();
        setOfCellsEv.add(new Cell(1,2));
        setOfCellsEv.add(new Cell(2,2));
        setOfCellsEv.add(new Cell(3,2));
        
        assertEquals(setOfCellsEv, life.getLiveCells());
    }
    
    @Test
    public void testEvolution_2() {
        setOfCells = new HashSet<Cell>();
        setOfCells.add(new Cell(1,1));
        setOfCells.add(new Cell(3,1));
        setOfCells.add(new Cell(1,2));
        setOfCells.add(new Cell(1,3));
        setOfCells.add(new Cell(2,3));
        setOfCells.add(new Cell(3,3));
        life = new Life(setOfCells,3);
        life.evolve();
        
        setOfCellsEv = new HashSet<Cell>();
        setOfCellsEv.add(new Cell(2,1));
        setOfCellsEv.add(new Cell(1,2));
        setOfCellsEv.add(new Cell(3,2));
        setOfCellsEv.add(new Cell(1,3));
        setOfCellsEv.add(new Cell(2,3));
        
        assertEquals(setOfCellsEv, life.getLiveCells());
    }
    
    @Test
    public void testEvolution_3() {
        setOfCells = new HashSet<Cell>();
        setOfCells.add(new Cell(3,1));
        setOfCells.add(new Cell(4,1));
        setOfCells.add(new Cell(2,2));
        setOfCells.add(new Cell(3,2));
        setOfCells.add(new Cell(4,2));
        setOfCells.add(new Cell(5,2));
        setOfCells.add(new Cell(1,3));
        setOfCells.add(new Cell(2,3));
        setOfCells.add(new Cell(5,3));
        setOfCells.add(new Cell(6,3));
        setOfCells.add(new Cell(1,4));
        setOfCells.add(new Cell(2,4));
        setOfCells.add(new Cell(5,4));
        setOfCells.add(new Cell(6,4));
        setOfCells.add(new Cell(2,5));
        setOfCells.add(new Cell(3,5));
        setOfCells.add(new Cell(4,5));
        setOfCells.add(new Cell(5,5));
        setOfCells.add(new Cell(3,6));
        setOfCells.add(new Cell(4,6));
        life = new Life(setOfCells,6);
        life.evolve();
        
        setOfCellsEv = new HashSet<Cell>();
        setOfCellsEv.add(new Cell(2,1));
        setOfCellsEv.add(new Cell(5,1));
        setOfCellsEv.add(new Cell(1,2));
        setOfCellsEv.add(new Cell(6,2));
        setOfCellsEv.add(new Cell(1,5));
        setOfCellsEv.add(new Cell(6,5));
        setOfCellsEv.add(new Cell(2,6));
        setOfCellsEv.add(new Cell(5,6));
        
        assertEquals(setOfCellsEv, life.getLiveCells());
    }
    
    
}
