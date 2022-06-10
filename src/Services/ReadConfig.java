package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadConfig {
    //make class read config file from Config/config.txt and return ArrayList<String>
    public static ArrayList<String> readConfig() {
        ArrayList<String> config = new ArrayList<String>();
        try {
            FileReader fr = new FileReader("Config/config.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                config.add(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }

    //check value of config file split by "=" and return value
    public static String getConfigValue(String key) {
        ArrayList<String> config = readConfig();
        String value = "";
        for (String line : config) {
            //split line by "="
            String[] split = line.split("=");
            if (split[0].equals(key)) {
                //check length of split
                if (split.length == 2) {
                    value = split[1];
                }
                //if split length is not 2, return empty string
                else {
                    value = "";
                }
            }
        }
        return value;
    }
}
