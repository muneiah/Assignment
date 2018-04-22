package com.itbt.assignment.framework;

public final class Config {

    private static String url = getEnvVar("url");

    private static String browser = getEnvVar("browser");

    private static String chromeDriver = getEnvVar("chrome_driver");
    private static String firefoxDriver = getEnvVar("firefox_driver");


    private static String getEnvVar(String name) {
        String value = System.getenv(name);
        value = value == null ? null : value.trim();
        if (value != null && !value.isEmpty()) {
            return value;
        }
        return null;
    }

    private static boolean getEnvBoolean(String name) {
        String param = getEnvVar(name);
        return param != null && param.matches("t|true");
    }

    public static String getBrowser() {
        if (browser == null) {
            browser = "chrome";
        }
        return browser;
    }

    public static String getUrl() {
        if (url == null) {
            url = "http://www.seleniumeasy.com/test/input-form-demo.html";
        }
        return url;
    }

    public static boolean isOSX() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    private static String getDriverEnd() {
        if (isWindows()) {
            return ".exe";
        } else if (isOSX()) {
            return "Mac";
        } else {
            return "Linux";
        }
    }

    public static String getChromeDriver() {
        if (chromeDriver == null) {
            chromeDriver = Config.class.getResource("/drivers" + "/chromedriver" + getDriverEnd()).getPath();
        }
        return chromeDriver;
    }

    public static String getFirefoxDriver() {
        if (firefoxDriver == null) {
            firefoxDriver = Config.class.getResource("/drivers" + "/geckodriver" + getDriverEnd()).getPath();
        }
        return firefoxDriver;
    }
}
