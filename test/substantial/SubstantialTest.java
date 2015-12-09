package substantial;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob Fusco
 */
public class SubstantialTest {
    public SubstantialTest() {
    }
    
    @After
    public void tearDown() {
        Substantial.teams = new ArrayList<>();
    }

    /**
     * Test of enterScore method, of class Substantial.
     */
    @Test
    public void testEnterScore() {
        System.out.println("enterScore");
        Team lions = new Team("Lions");
        Team snakes = new Team("Snakes");
        Team tarantulas = new Team("Tarantulas");
        Team fcAwesome = new Team("FC Awesome");
        
        Substantial.enterScore("Lions 3, Snakes 3");
        lions.draw();
        snakes.draw();
        assertEquals(Substantial.teams.get(0), lions);
        assertEquals(Substantial.teams.get(1), snakes);
        
        Substantial.enterScore("Tarantulas 1, FC Awesome 0");
        tarantulas.win();
        fcAwesome.lose();
        assertEquals(Substantial.teams.get(0), lions);
        assertEquals(Substantial.teams.get(1), snakes);
        assertEquals(Substantial.teams.get(2), tarantulas);     
        assertEquals(Substantial.teams.get(3), fcAwesome);
       
        Substantial.enterScore("Tarantulas 3, Snakes 1");  
        tarantulas.win();
        snakes.lose();
        assertEquals(Substantial.teams.get(0), lions);
        assertEquals(Substantial.teams.get(1), snakes);
        assertEquals(Substantial.teams.get(2), tarantulas);
        assertEquals(Substantial.teams.get(3), fcAwesome);
    }

    /**
     * Test of parseScoreLine method, of class Substantial.
     */
    @Test
    public void testParseScoreLine() {
        System.out.println("parseScoreLine");
        Team team = new Team("Test Team");
        int score = 5;
        TeamScoreCombo result = Substantial.parseScoreLine("Test Team 5");
        TeamScoreCombo other = new TeamScoreCombo(team, score);
        assertEquals(other.getTeam(), result.getTeam());
        assertEquals(other.getScore(), result.getScore());
    }

    
    /**
     * Test of getStandings method, of class Substantial.
     */
    @Test
    public void testGetStandings() {    
        System.out.println("getStandings");

        Team lions = new Team("Lions");
        lions.win();
        lions.draw();
        Team snakes = new Team("Snakes");
        snakes.draw();
        Team tarantulas = new Team("Tarantulas");
        tarantulas.win();
        tarantulas.win();
        Team fcAwesome = new Team("FC Awesome");
        
        Substantial.teams.add(lions);
        Substantial.teams.add(snakes);
        Substantial.teams.add(tarantulas);
        Substantial.teams.add(fcAwesome);
        
        assertEquals("Tarantulas, 6 pts\n"
                + "Lions, 4 pts\n"
                + "Snakes, 1 pts\n"
                + "FC Awesome, 0 pts\n", Substantial.getStandings());
    }
    
    /**
     * Test full typical use cases
     */
    @Test
    public void endToEnd() {    
        System.out.println("getStandings");
        Substantial.enterScore("Lions 3, Snakes 3");
        assertEquals("Lions, 1 pts\n"
                + "Snakes, 1 pts\n", Substantial.getStandings());
        
        Substantial.enterScore("Tarantulas 1, FC Awesome 0");
        assertEquals("Tarantulas, 3 pts\n"
                + "Lions, 1 pts\n"
                + "Snakes, 1 pts\n"
                + "FC Awesome, 0 pts\n", Substantial.getStandings());
        
        Substantial.enterScore("Lions 1, FC Awesome 1");
        assertEquals("Tarantulas, 3 pts\n"
                + "Lions, 2 pts\n"
                + "FC Awesome, 1 pts\n"
                + "Snakes, 1 pts\n", Substantial.getStandings());
                
        Substantial.enterScore("Tarantulas 3, Snakes 1");
        assertEquals("Tarantulas, 6 pts\n"
                + "Lions, 2 pts\n"
                + "FC Awesome, 1 pts\n"
                + "Snakes, 1 pts\n", Substantial.getStandings());
                
        Substantial.enterScore("Lions 4, Grouches 0");
        assertEquals("Tarantulas, 6 pts\n"
                + "Lions, 5 pts\n"
                + "FC Awesome, 1 pts\n"
                + "Snakes, 1 pts\n"
                + "Grouches, 0 pts\n", Substantial.getStandings());
    } 
}