
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private String team;
    private int assists;
    private int goals;
    private int penalties;
    private int games;

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getNationality() {
        return nationality;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    @Override
    public int compareTo(Player player) {
        return (this.getGoals() + this.getAssists()) - (player.getGoals() + player.getAssists());
    }

    @Override
    public String toString() {
        return name + " team: " + team + " " + goals + " + " + assists + " = " + (goals + assists);
    }      
}
