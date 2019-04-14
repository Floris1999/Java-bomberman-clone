package impl;
import service.FirebaseService;

import java.util.*;

public class Highscores {

    public String player1;
    public static int score1;
    public String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1ODQ3MTEyNDQsInYiOjAsImlhdCI6MTU1NDM3MDM3MSwiZCI6eyJ1aWQiOiJkNDk4ZGJjOC1lOWJjLTRmMTAtOGFhZC1mZmFkMmE3N2I4YmIifX0.kxRl8p_g5QkR6q9EEer0DBmQ_7pFqZ9hz7Ic_t_UauQ";
    public String groupname = "Steve Wozniak";
    public List<String> x = new ArrayList<String>();
    public List<String> y = new ArrayList<String>();
    FirebaseService highscores = new FirebaseService();
    public List<String> tail = new ArrayList<String>();

    public Highscores() {

    }

    public void setHighscores(int score1, String player1) {
        this.score1 = score1;
        this.player1 = player1;

        sendHighscore();
    }

    public void sendHighscore() {
        try {
            highscores.saveHighscore(groupname, token, this.score1, this.player1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<String>  getHighscore() {
        String alleScores = "";
        try {
            alleScores =  highscores.getHighscores(groupname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> tempscores = new ArrayList<String>();
        String tempnaam = "";
        List<String> naamlijst = new ArrayList<String>();
        naamlijst = Arrays.asList(alleScores.split(","));
        for (int n = 0; n< naamlijst.size(); n++) {
            if (naamlijst.get(n).startsWith("\"playerName")){
                this.x.add(naamlijst.get(n).split(":")[1].replace("\"", ""));
            }
            else if (naamlijst.get(n).startsWith("\"score")){
                this.y.add(naamlijst.get(n).split(":")[1].replace("}",""));
            }
        }
        for (int m = 0; m < x.size(); m++) {
            tempnaam = this.y.get(m) + ":"+ this.x.get(m);
            tempscores.add(tempnaam);
        }
        return (sorteren(tempscores));
    }

    public List<String> sorteren(List<String> tempscores) {
        Collections.sort(tempscores, new Comparator<String>(){
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }
            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });
        this.tail = tempscores.subList(0, 5);
        return (this.tail);
    }



}
