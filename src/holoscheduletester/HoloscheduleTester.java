/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holoscheduletester;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Pinapelz
 */
public class HoloscheduleTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd holoCli && python main.py");
        builder.redirectErrorStream(true);
        ArrayList<String> schedule = new ArrayList<String>();
        try {
            Process p = builder.start();
            try ( BufferedReader br = new BufferedReader(new FileReader("holoCli/hololive.txt"))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    schedule.add(line);
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR was not able to run the scraper\nPlease check that the holoCli directory is present and that Python is installed");
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.println(schedule.get(i));
        }

    }

}
