
package com.mailrutests.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesStorage {

    private static PropertiesStorage instance;

    private Properties properties;

    private PropertiesStorage() {

        try {
            File file = new File("test.properties");
            FileInputStream fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static PropertiesStorage getInstance() {
        if (instance == null) {
            return new PropertiesStorage();
        } else {
            return instance;
        }

    }
}
