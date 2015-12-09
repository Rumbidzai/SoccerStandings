package substantial;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob Fusco
 */
public class TeamScoreComboTest {
    Team team;
    int score;
    TeamScoreCombo instance;
    
    public TeamScoreComboTest() {
    }
 
    @Before
    public void setUp() {
        team = new Team("Test Team");
        score = 8;
        instance = new TeamScoreCombo(team, score);
    }

    /**
     * Test of getTeam method, of class TeamScoreCombo.
     */
    @Test
    public void testGetTeam() {
        System.out.println("getTeam");
        Team result = instance.getTeam();
        assertEquals(team, result);
    }

    /**
     * Test of getScore method, of class TeamScoreCombo.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        int result = instance.getScore();
        assertEquals(score, result);
    }  
}