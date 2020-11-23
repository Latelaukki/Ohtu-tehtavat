package ohtu;

public class TennisGame {
    
    private int score1 = 0;
    private int score2 = 0;
    private String player1;
    private String player2;

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String player) {
        if (player1.equals(player)) 
            score1 += 1;
        else
            score2 += 1;
    }
    
    

    public String getScore() {
        if (score1==score2) {
            return drawToString();
        }
        else if (score1>=4 || score2>=4) {
            return overFortyToString();
        }
        return pointsToString(score1) + "-" + pointsToString(score2);
    }
  
    public String pointsToString(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
    
    public String overFortyToString() {
        int minusResult = score1-score2;
        if (minusResult==1)  {
            return "Advantage " + player1;
        }
        else if (minusResult ==-1) {
            return "Advantage " + player2;
        }
        else if (minusResult>=2) {
            return "Win for " + player1;
        }
        else {
            return "Win for " + player2;
        }
    }
    
    public String drawToString() {
        switch (score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";        
            case 3:
                return "Forty-All";
            default:
                return "Deuce";           
        }
    }
}