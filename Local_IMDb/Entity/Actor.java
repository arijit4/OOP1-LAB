package Entity;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actor {
    private String name;
    private String year;

    public Actor() {
        this.name = "";
        this.year = "";
    }

    public Actor(
            String name, String year
    ) {
        this.name = name;
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public String getYear() {
        return this.year;
    }

    public boolean addToDataBase() {
        if (this.name.isEmpty() && this.year.isEmpty()) return false;

        try {
            File f = new File("Actors.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);

            fw.write(this.name + "\t" + this.year + "\n");
            fw.flush();
            fw.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean searchDataBase(String name, String year) {
        try {
            File f = new File("Actors.txt");
            f.createNewFile();
            Scanner sc = new Scanner(f);

            boolean found = false;

            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split("\t");
                if (data[0].equals(name) && data[1].equals(year)) {
                    found = true;
                    break;
                }
            }

            return found;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
