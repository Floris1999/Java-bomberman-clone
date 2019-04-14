package model;

public class levens {
    private static int levensLink = 3;
    private static int levensPlayer2 = 3;

    public int levenLink(){
        levensLink--;
        System.out.println(levensLink);
        if(levensLink == 0){
            System.out.println("Game over Player 2 wint");
        }
        return levensLink;
    }
    public int levenPlayer2(){
        levensPlayer2--;
        System.out.println(levensPlayer2);
        if(levensPlayer2 == 0){
            System.out.println("Game over Player 1 wint");
        }
        return levensPlayer2;
    }


}
