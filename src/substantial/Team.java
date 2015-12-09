/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package substantial;

/**
 *
 * @author Rob Fusco
 */
class Team implements Comparable {
    private final String name;
    private int wins;
    private int draws;
    private int losses;
    
    protected enum Result {
        WIN(3),
        DRAW(1),
        LOSS(0);
        private final int points;

        private Result(int points) {
            this.points = points;
        }

        public int getPoints() {
            return this.points;
        }
    }

    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
    }

    public void win() {
        this.wins++;
    }

    public void draw() {
        this.draws++;
    }

    public void lose() {
        this.losses++;
    }

    public String getName() {
        return this.name;
    }

    public int getWins() {
        return this.wins;
    }

    public int getDraws() {
        return this.draws;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getPoints() {
        return wins * Result.WIN.getPoints() + draws * Result.DRAW.getPoints() + losses * Result.LOSS.getPoints();
    }

    @Override
    public String toString() {
        return getName() + ", " + getPoints() + " pts";
    }

    @Override
    public boolean equals(Object team) {
        if (team instanceof Team) {
            return this.getName().equals(((Team)team).getName());
        }
        return false;
    }

    @Override
    public int compareTo(Object teamObj) {
        if (teamObj instanceof Team) {
            Team team = (Team) teamObj;
            int leftPoints = this.getPoints();
            int rightPoints = team.getPoints();
            if (leftPoints > rightPoints) {
                return -1;
            } else if (leftPoints < rightPoints) {
                return 1;
            }
            return this.getName().compareTo(team.getName());
        }
        throw new ClassCastException();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
    
}
