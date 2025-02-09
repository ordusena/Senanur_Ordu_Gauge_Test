package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.io.File;
import java.net.URL;

public class LocatorReader {
    private static JsonArray allLocators = new JsonArray();

    static {
        loadAllLocators();
    }

    private static void loadAllLocators() {
        try {
            ClassLoader classLoader = LocatorReader.class.getClassLoader();
            Enumeration<URL> resources = classLoader.getResources("locators");
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File directory = new File(resource.toURI());
                File[] files = directory.listFiles((dir, name) -> name.endsWith(".json"));
                if (files != null) {
                    for (File file : files) {
                        try (InputStream input = classLoader.getResourceAsStream("locators/" + file.getName())) {
                            if (input != null) {
                                Scanner scanner = new Scanner(input, StandardCharsets.UTF_8).useDelimiter("\\A");
                                String json = scanner.hasNext() ? scanner.next() : "";
                                JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
                                mergeLocators(jsonArray);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load locators", e);
        }
    }

    private static void mergeLocators(JsonArray newLocators) {
        for (JsonElement element : newLocators) {
            allLocators.add(element);
        }
    }

    public static String getLocatorValue(String key) {
        for (JsonElement element : allLocators) {
            JsonObject locator = element.getAsJsonObject();
            if (locator.get("key").getAsString().equals(key)) {
                return locator.get("value").getAsString();
            }
        }
        throw new RuntimeException("Locator key not found: " + key);
    }

    public static String getLocatorType(String key) {
        for (JsonElement element : allLocators) {
            JsonObject locator = element.getAsJsonObject();
            if (locator.get("key").getAsString().equals(key)) {
                return locator.get("type").getAsString();
            }
        }
        throw new RuntimeException("Locator type not found for key: " + key);
    }
}
