package reports;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static constants.GlobalConstants.*;

public class PropertyReader {
    private static final Properties properties = new Properties();
    private static String filePath;

    public static String getProperty(String key,ModuleName moduleName) {
        switch (moduleName){
            case api -> filePath=API_CONFIG_FILE_PATH;
            case web -> filePath=WEB_CONFIG_FILE_PATH;
            case mobile -> filePath=MOBILE_CONFIG_FILE_PATH;
            default -> throw new IllegalArgumentException("Invalid module name: " + moduleName);
        }
        System.out.println("Loading config file: " + filePath);
        try {
            FileInputStream input = new FileInputStream(filePath);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }

    public enum ModuleName{
        api,
        mobile,
        web
    }
}
