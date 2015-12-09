package substantial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rob Fusco
 */
public class Substantial {
    static ArrayList<Team> teams = new ArrayList<>();
    static final String END = "END";

    public static void main(String[] args) {
        boolean end = false;
        do {
            System.out.print("Enter a game score (<Team 1> <Score 1>, <Team 2> <Score 2>), type " + END + " to finish: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String input = null;
            try {
                input = br.readLine();

            } catch (IOException ioe) {
                System.out.println("IO error trying to read your input");
                System.exit(1);
            }

            if (input.compareTo(END) == 0) {
                end = true;
            } else {
                enterScore(input);
                System.out.print(getStandings());
            }

        } while (!end);
    }

    protected static void enterScore(String scoreLine) {
        String[] teamScores = scoreLine.split(", ");

        TeamScoreCombo left = parseScoreLine(teamScores[0]);
        TeamScoreCombo right = parseScoreLine(teamScores[1]);

        if (left.getScore() == right.getScore()) {
            left.getTeam().draw();
            right.getTeam().draw();
        } else if (left.getScore() > right.getScore()) {
            left.getTeam().win();
            right.getTeam().lose();
        } else if (right.getScore() > left.getScore()) {
            left.getTeam().lose();
            right.getTeam().win();
        }
    }

    protected static TeamScoreCombo parseScoreLine(String scoreLine) {
        String spaceDelimiter = " ";

        String[] split = scoreLine.split(spaceDelimiter);
        String partialName = "";
        for (int i = 0; i < split.length - 1; i++) {
            partialName += split[i] + " ";
        }
        String name = partialName.substring(0, partialName.length() - 1);

        List<Team> matches = teams
                .stream()
                .filter( team -> team.getName().equals(name))
                .collect(Collectors.toList());
        Team team;
        if (matches.isEmpty()) {
            team = new Team(name);
            teams.add(team);
        } else {
            team = matches.get(0);
        }

        return new TeamScoreCombo(team, Integer.parseInt(split[split.length - 1]));
    }

    protected static String getStandings() {
        String standings = "";
        Collections.sort(teams);
        Iterator<Team> iter = teams.iterator();
        while (iter.hasNext()) {
            standings += iter.next() + "\n";
        }
        return standings;
    }
}