package model;

import java.io.File;

public class User {
    private String username;
    private String password;
    private String voornaam;
    private String achternaam;


    public User(String username) {
        String curDir = System.getProperty("user.dir") + "\\src\\resources\\wachtwoorden.csv";
        curDir = curDir.replace("\\","/");
        curDir = curDir.replace(" ", "%20");

        String soundDir =  System.getProperty("user.dir") + "/src/resources/wachtwoorden.csv/";

        //File file = new File(curDir);
        for (String line : FileModel.readFile(soundDir)){
            if (line.contains(username)) {
                String[] userData = line.split(",");
                this.voornaam   = userData[0].trim();
                this.achternaam = userData[1].trim();
                this.username   = userData[2].trim();
                this.password   = userData[3].trim();
            }
        }
    }

    public static boolean userExist(String username) {
        String curDir = System.getProperty("user.dir") + "\\src\\resources\\wachtwoorden.csv";
        curDir = curDir.replace("\\","/");
        curDir = curDir.replace(" ", "%20");

        String soundDir =  System.getProperty("user.dir") + "/src/resources/wachtwoorden.csv/";

        File file = new File(soundDir);


        System.out.println(file);
        for (String line : FileModel.readFile(soundDir)) {
            if (line.contains(username)) {
                return true;
            }
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }
}
