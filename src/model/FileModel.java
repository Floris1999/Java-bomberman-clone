package model;


import java.io.*;
import java.util.ArrayList;

public class FileModel {
    public static ArrayList<String> readFile(String location) {
        ArrayList<String>userDate = new ArrayList<>();
        try {
            File file                   = new File(location);
            FileReader fileReader       = new FileReader(file);
            BufferedReader bufReader    = new BufferedReader(fileReader);

            String regel = bufReader.readLine();
            while (regel != null) {
                userDate.add(regel);
                regel = bufReader.readLine();
            }
                bufReader.close();
                fileReader.close();

        }catch(FileNotFoundException fnfe){
            System.out.println("Exception opgetreden: " + fnfe.toString());
            System.out.println("Stack trace:");
            fnfe.printStackTrace();
        } catch(IOException ioe){
            System.out.println("Exception opgetreden: " + ioe.toString());
            System.out.println("Stack trace:");
            ioe.printStackTrace();
        }
//        System.out.println(userDate.get(0));
        return userDate;
    }


}
