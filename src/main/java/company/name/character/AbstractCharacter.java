package company.name.character;

import company.name.helpers.DriverHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractCharacter {

    private static String testStand;
    private static String preprodStand;

    static {
        InputStream inputStream = DriverHelper.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (
                IOException e) {
            throw new RuntimeException((e));
        }
        testStand = properties.getProperty("test.stand");
        preprodStand = properties.getProperty("preprod.stand");
    }

    public static String getStand() {
        return testStand;
    }
    public static String getPreprodStand() { return preprodStand; }
}
