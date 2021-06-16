package p8_cleancode_refactoring.baitap;

public class TennisGame {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static final String ADDTION = "-";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String SPACE = "";
    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";

    public static String getScore(String playOne, String playTwo, int scopeOne, int scoreTwo) {
        String score = SPACE;

        if (scopeOne==scoreTwo)
        {
            switch (scopeOne)
            {
                case ZERO:
                    score = LOVE_ALL;
                    break;
                case ONE:
                    score = FIFTEEN_ALL;
                    break;
                case TWO:
                    score = THIRTY_ALL;
                    break;
                case THREE:
                    score = FORTY_ALL;
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else {
            boolean moreCompare = scopeOne >= 4;
            boolean lessCompare = scoreTwo >= 4;
            if (moreCompare || lessCompare)
            {
                score = getResult(scopeOne, scoreTwo);
            }
            else
            {
                score = getScope(scopeOne, scoreTwo, score);
            }
        }
        return score;
    }

    private static String getResult(int scopeOne, int scoreTwo) {
        String score;
        int result = scopeOne-scoreTwo;
        if (result==1) score ="Advantage player1";
        else if (result ==-1) score ="Advantage player2";
        else if (result>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String getScope(int scopeOne, int scoreTwo, String score) {
        int tempScore=0;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = scopeOne;
            else { score+= ADDTION; tempScore = scoreTwo;}
            switch(tempScore)
            {
                case 0:
                    score+= LOVE;
                    break;
                case 1:
                    score+= FIFTEEN;
                    break;
                case 2:
                    score+= THIRTY;
                    break;
                case 3:
                    score+= FORTY;
                    break;
            }
        }
        return score;
    }
}
