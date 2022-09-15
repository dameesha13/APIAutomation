package service;

import constant.RelativeURLs;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import responsedto.FoodServiceResponseDTO;
import util.bases.APIServicesBase;
import util.data.Config;

import java.util.Map;

public class FoodService extends APIServicesBase {

    private final String baseURI;
    private FoodServiceResponseDTO foodServiceResponseDTO;


    public FoodService() {
        this.baseURI = Config.getProperty("foodService.baseurl");
    }

    //Service for nutrients
    public FoodServiceResponseDTO nutrientsCreation(JSONObject body, Map<String, Object> headers,Map<String, Object> query) throws Exception {

        try {
            Response response = postRequest(body,headers, baseURI, RelativeURLs.POST_NUTRIENTS,query);
            System.out.println(response.asString());
            if (response.statusCode() == 201)
                foodServiceResponseDTO = objectMapper.readValue(response.asString(), FoodServiceResponseDTO.class);
            else
                foodServiceResponseDTO = new FoodServiceResponseDTO();

            foodServiceResponseDTO.setResponse(response);

        } catch (Exception ex) {
            throw ex;
        }
        return foodServiceResponseDTO;
    }
}
