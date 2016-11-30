package ua.com.tartustour.framemanagers;

import org.apache.log4j.Logger;;
import java.io.*;
import java.util.Properties;

/**
 * Created by Administrator on 11/4/2016.
 */
public class ConfigManager {

    private static Logger logger = Logger.getLogger(ConfigManager.class);
    private static Properties props;

    protected static String BROWSER = "";
    protected static String MAIN_URL = "";

    static{
        setProp();
        MAIN_URL=props.getProperty("main.url");
        BROWSER=props.getProperty("browser");
        logger.info("MAIN URL : "+MAIN_URL+" :: BROWSER CHOSEN: "+BROWSER);
    }

    // ---------------------------------------------------------------------------------------------
    public static void setProp() {
        if (props == null) {
            props = new Properties();
        }
        try {
            props.load(ConfigManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            logger.warn("| Properties file was not found |");
        }
        logger.info("| Properties file is recongnized and data is sourced |");
    }

    public static String getProp(String key) {
        logger.info("| Getting property value by key:"+key+" |");
        return props.getProperty(key);
    }

    public static void addProp(String key, String value) {
        logger.info("| Updating config.properties file with key:value - "+key+":"+value+" |");
        try {
            FileOutputStream output = new FileOutputStream(new File("src/main/resources/config.properties").getAbsolutePath().replace("\\", "/"));
            props.setProperty(key, value);
            props.store(output, null);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBROWSER() {
        return BROWSER;
    }

    public static String getMAIN_URL() {
        return MAIN_URL;
    }

}
