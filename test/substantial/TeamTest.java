package substantial;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob Fusco
 */
public class TeamTest {
    private String name;
    private Team team;
    
    public TeamTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        name = "Test Team";
        team = new Team(name);
    }

    /**
     * Test of win and getWins methods, of class Team.
     */
    @Test
    public void testWin() {
        System.out.println("win and getWins");
        team.win();
        assertEquals(1, team.getWins());
        assertEquals(0, team.getDraws());
        assertEquals(0, team.getLosses());
    }

    /**
     * Test of draw and getDraw methods, of class Team.
     */
    @Test
    public void testDraw() {
        System.out.println("draw and getDraws");
        team.draw();
        assertEquals(0, team.getWins());
        assertEquals(1, team.getDraws());
        assertEquals(0, team.getLosses());
    }

    /**
     * Test of lose and getLosses methods, of class Team.
     */
    @Test
    public void testLose() {
        System.out.println("lose and getLosses");
        team.lose();
        assertEquals(0, team.getWins());
        assertEquals(0, team.getDraws());
        assertEquals(1, team.getLosses());
    }

    /**
     * Test of getName method, of class Team.
     */
    @Test
    public void testGetName() {
        String result = team.getName();
        assertEquals(name, result);
    }

    /**
     * Test of getPoints method, of class Team.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        int wins = 2;
        int draws = 4;
        int losses = 3;
        for (int i = 0; i < wins; i++) { team.win(); } 
        for (int i = 0; i < draws; i++) { team.draw(); }
        for (int i = 0; i < losses; i++) { team.lose(); }

        int result = team.getPoints();
        assertEquals(10, result);
    }

    /**
     * Test of toString method, of class Team.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int wins = 1;
        int draws = 2;
        int losses = 3;
        for (int i = 0; i < wins; i++) { team.win(); } 
        for (int i = 0; i < draws; i++) { team.draw(); }
        for (int i = 0; i < losses; i++) { team.lose(); }
        String result = team.toString();
        assertEquals("Test Team, 5 pts", result);
    }

    /**
     * Test of equals method, of class Team.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        team.draw();
        Team otherTeam = new Team(name);
        otherTeam.win();
        Team diffTeam = new Team("Diff");
        Object notTeam = new Object();
        
        assertTrue(team.equals(otherTeam));
        assertFalse(team.equals(diffTeam));
        assertFalse(team.equals(notTeam));
    }

    /**
     * Test of compareTo method, of class Team.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        team.draw();
        Team winner = new Team("Winner");
        winner.win();
        Team loser = new Team("Loser");
        loser.lose();
        // If score is the same Team's are ordered alphabetically by name
        Team drawer = new Team("ABC");
        drawer.draw();
        
        assertTrue(team.compareTo(winner) > 0);
        assertTrue(team.compareTo(drawer) > 0);
        assertEquals(team.compareTo(team), 0);
        assertTrue(team.compareTo(loser) < 0);
    }
    
    @Test(expected=ClassCastException.class)
    public void tesCompareToClassCastException() {
        System.out.println(team.compareTo(new Object()));
    }
    
    /**
     * Test of hashCode method, of class Team.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        team.draw();
        Team otherTeam = new Team(name);
        otherTeam.win();
        Team diffTeam = new Team("Diff");

        assertTrue(team.hashCode()==otherTeam.hashCode());
        assertTrue(team.hashCode()!=diffTeam.hashCode());
    }
}