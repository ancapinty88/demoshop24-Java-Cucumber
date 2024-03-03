package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//configuration.proprieties file reader class
public class ConfigFileReader {

        Properties properties = new Properties();
        private final String propertyFilePath = "C:\\Users\\anca.pintilie\\IdeaProjects\\Cucumber-Java-Basic\\configs\\Configuration.proprieties";


        public ConfigFileReader() {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(propertyFilePath));
                try {
                    properties.load(reader);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
            }
        }

        public String getConfigVariable(String keyValue) {
        String value = properties.getProperty(keyValue);
        return value;

        }

        public String getDriverPath() {
            String driverPath = properties.getProperty("driverPath");
            if
            (driverPath != null) return driverPath;
            else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
        }

        public long getImplicitlyWait() {
            String implicitlyWait = properties.getProperty("implicitlyWait");
            if
            (implicitlyWait != null) return Long.parseLong(implicitlyWait);
            else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
        }

        public String getHomePageUrl() {
            String url = properties.getProperty("urlHomePage");
            if
            (url != null) return url;
            else throw new RuntimeException("urlHomePage not specified in the Configuration.properties file.");
        }

        public String getRegPageUrl() {
            String url = properties.getProperty("urlRegPage");
            if
            (url != null) return url;
            else throw new RuntimeException("urlRegPage not specified in the Configuration.properties file.");
        }

        public String getLoginPageUrl() {
            String url = properties.getProperty("urlLoginPage");
            if
            (url != null) return url;
            else throw new RuntimeException("urlLoginPage not specified in the Configuration.properties file.");
        }

        public String getMyAccountPageUrl() {
            String url = properties.getProperty("urlMyAccountPage");
            if
            (url != null) return url;
            else throw new RuntimeException("urlMyAccountPage not specified in the Configuration.properties file.");
        }
    }
