package util.rest;

import io.restassured.RestAssured;

public class RestUtil {

    public static String path; // Rest request path

    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public static void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

}
