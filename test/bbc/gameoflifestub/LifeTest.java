//package bbc.gameoflifestub;

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
    public void testEvolution1() {
        setOfCells = new HashSet<Cell>();
        setOfCells.add(new Cell(2,1));
        setOfCells.add(new Cell(2,2));
        setOfCells.add(new Cell(2,3));
        life = new Life(setOfCells,3);
        
        setOfCellsEv = new HashSet<Cell>();
        setOfCellsEv.add(new Cell(1,2));
        setOfCellsEv.add(new Cell(2,2));
        setOfCellsEv.add(new Cell(3,2));
        
        assertEquals(setOfCellsEv, life.evolve());
    }
    
    @Test
    public void testEvolution2() {
        setOfCells = new HashSet<Cell>();
        setOfCells.add(new Cell(1,1));
        setOfCells.add(new Cell(3,1));
        setOfCells.add(new Cell(1,2));
        setOfCells.add(new Cell(1,3));
        setOfCells.add(new Cell(2,3));
        setOfCells.add(new Cell(3,3));
        life = new Life(setOfCells,3);
        
        setOfCellsEv = new HashSet<Cell>();
        setOfCellsEv.add(new Cell(2,1));
        setOfCellsEv.add(new Cell(1,2));
        setOfCellsEv.add(new Cell(3,2));
        setOfCellsEv.add(new Cell(1,3));
        setOfCellsEv.add(new Cell(2,3));
        
        assertEquals(setOfCellsEv, life.evolve());
    }
    
    
}
