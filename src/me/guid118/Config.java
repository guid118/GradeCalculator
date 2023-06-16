package me.guid118;

import java.io.*;

public class Config {
    static File file;
    static String configFilePath = "config.properties";
    public static OrderedProperties prop = new OrderedProperties();

    public static void CreateFile() {

        try {
            file = new File(configFilePath);

            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream propsInput = new FileInputStream(configFilePath);
            prop.load(propsInput);

            setdefaults();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setdefaults() {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(configFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop.putIfAbsent("points", "");
        prop.putIfAbsent("maximum_points", "");
        prop.putIfAbsent("n-term", "");
        try {
            prop.store(os,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static double getvalue(String path) {
        return Double.parseDouble(prop.getProperty(path));
    }




}
