package util.bases;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import util.rest.RestUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class APIServicesBase extends RestUtil {

    protected static String Environment = null;
    protected ObjectMapper objectMapper = new ObjectMapper();

    public APIServicesBase() {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String getEnvironment() {
        return Environment;
    }

    public static void setEnvironment(String environment) {
        Environment = environment;
    }

    public Response postRequest(JSONObject body, Map<String, Object> headers, String baseURI, String relativeURI, Map<String, Object> query) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);

            Response response =
                    given()
                            .headers(headers)
                            .body(body.toJSONString())
                            .queryParams(query)
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public Response getRequest(String baseURI, String relativeURI) throws Exception {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);

            Response response = given().when().get();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public Response deleteRequest(String baseURI, String relativeURI) throws Exception {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);

            Response response =
                    given()
                            .when()
                            .delete();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public Response putRequest(JSONObject body, Map<String, Object> headers, String baseURI, String relativeURI) throws Exception {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);

            Response response =
                    given()
                            .headers(headers)
                            .body(body.toJSONString())
                            .when()
                            .put();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
            throw ex;
        }
    }
}
