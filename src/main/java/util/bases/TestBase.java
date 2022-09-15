package util.bases;

import com.fasterxml.jackson.databind.ObjectMapper;
import constant.RelativeURLs;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import util.data.Config;

import java.io.File;
import java.io.FileReader;

public abstract class TestBase extends RelativeURLs {

    protected ObjectMapper objectMapper;
    private static String templateBodyPath;
    private static String foodTemplateBodyPath;
    private static String templateHeaderPath;
    private static JSONParser parser;
    private static File file;
    private static String FilePath;
    public Logger logger = LoggerFactory.getLogger("Test Logger");

    @BeforeSuite(alwaysRun = true)
    public void startUp() throws Exception {

        try {
            Config.setConfigFilePath("/config/configuration.properties");
            templateBodyPath = Config.getProperty("template.body.path");
            foodTemplateBodyPath = Config.getProperty("template.body.path.food");
            templateHeaderPath = Config.getProperty("template.header.path");
            FilePath=Config.getProperty("File.path");
            parser = new JSONParser();
            objectMapper = new ObjectMapper();

        } catch (Exception e) {
            throw e;
        }
    }

    public abstract void serviceSetUp() throws Exception;


    public JSONObject getJSONBodyTemplate(String filename) throws Exception {

        try {
            file = new File(templateBodyPath, filename);
            return (JSONObject) parser.parse(new FileReader(file));

        } catch (Exception e) {
            throw e;
        }
    }

    public JSONObject getFoodJSONBodyTemplate(String filename) throws Exception {

        try {
            file = new File(foodTemplateBodyPath, filename);
            return (JSONObject) parser.parse(new FileReader(file));

        } catch (Exception e) {
            throw e;
        }
    }

}
