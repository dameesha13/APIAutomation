package util.bases;

import io.restassured.response.Response;

public class BaseResponseDTO {

    private Response response;
    private int statusCode;
    private String contentType;
    private String body;

    public Response getResponse() {

        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
        this.statusCode = response.statusCode();
        this.contentType = response.contentType();
        this.body = response.toString();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public String getBody() {
        return body;
    }

}
