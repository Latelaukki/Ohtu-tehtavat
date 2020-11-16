
package ohtu;

public class Player {
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

    public String getName() {
        return name;
    }

    public String getNationality(String nationality) {
        return nationality;
    }

    public String getTeam(String team) {
        return team;
    }

    public int getAssists(int assists) {
        return assists;
    }

    public int getGoals(int goals) {
        return goals;
    }

    @Override
    public String toString() {
        return name + " " + nationality + " team: " + team + " assists: " + assists + " goals: " + goals;
    }      
}
