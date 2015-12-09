/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package substantial;

/**
 * Simple pair class that contains a Team object and an int
 * @author Rob Fusco
 */
class TeamScoreCombo {
    private Team team;
    private int score;

    public TeamScoreCombo(Team team, int score) {
        this.team = team;
        this.score = score;
    }

    public Team getTeam() {
        return this.team;
    }

    public int getScore() {
        return this.score;
    }
    
}
