package FoodServiceTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import responsedto.FoodServiceResponseDTO;
import util.bases.TestBase;

import java.util.HashMap;
import java.util.Map;

public class NutrientsCreation extends TestBase {

    private FoodServiceResponseDTO foodServiceResponseDTO;
    private service.FoodService foodService;
    protected JSONObject body;
    protected Map<String, Object> headers;
    private Map<String, Object> query;


    @BeforeClass
    public void serviceSetUp() throws Exception {
        foodService = new service.FoodService();
        envSetup();
    }

    /**
     * Environment Set up for authentication tokens generation
     */
    private void envSetup() throws Exception {

        try {

        } catch (Exception ex) {
            throw ex;
        }
    }

    /********************************* POST - nutrients creation Test Cases ***************************************/

    //Verify nutrients creation
    @Test
    public void nutrientsCreation() throws Exception {

        try {
            logger.info("## Start | nutrientsCreation ##" + this.getClass().getName());

            //headers = HeaderProvider.getHeaders("Header1");
            //headers.put("Content-Type", "application/json");
            Map map=new HashMap();
            map.put("Content-Type", "application/json");

            body = getFoodJSONBodyTemplate("FoodNutrientsV2");
            body.put("quantity", 0);

            query = new HashMap<>();
            query.put("app_id", "d2dc3e20");
            query.put("app_key", "d5106d8077c4a6f17c8f44034fbae5e3");

            foodServiceResponseDTO = foodService.nutrientsCreation(body,map, query);
            Assert.assertEquals(foodServiceResponseDTO.getStatusCode(), 200); //Assert the Status code
            Assert.assertNotNull(foodServiceResponseDTO.getTotalWeight()); //totalWeight
            Assert.assertTrue(foodServiceResponseDTO.getResponse().asString().contains("http://www.edamam.com/ontologies"));//Assert the uri

        } catch (Exception ex) {
            logger.info("nutrientsCreation : FAIL");
            throw ex;
        }
    }

    //Verify nutrients creation with empty AppId
    @Test
    public void nutrientsCreationWithEmptyAppId() throws Exception {

        try {
            logger.info("## Start | nutrientsCreationWithEmptyAppId ##" + this.getClass().getName());

            Map map=new HashMap();
            map.put("Content-Type", "application/json");

            body = getFoodJSONBodyTemplate("FoodNutrientsV2");
            body.put("quantity", 0);

            query = new HashMap<>();
            query.put("app_id", "");
            query.put("app_key", "d5106d8077c4a6f17c8f44034fbae5e3");

            foodServiceResponseDTO = foodService.nutrientsCreation(body,map, query);
            Assert.assertEquals(foodServiceResponseDTO.getStatusCode(), 401); //Assert the Status code
            Assert.assertTrue(foodServiceResponseDTO.getResponse().asString().contains("Unauthorized app_id")); //Assert the message

        } catch (Exception ex) {
            logger.info("nutrientsCreationWithEmptyAppId : FAIL");
            throw ex;
        }
    }

    //Verify nutrients creation with null AppId
    @Test
    public void nutrientsCreationWithNullAppId() throws Exception {

        try {
            logger.info("## Start | nutrientsCreationWithNullAppId ##" + this.getClass().getName());

            Map map=new HashMap();
            map.put("Content-Type", "application/json");

            body = getFoodJSONBodyTemplate("FoodNutrientsV2");
            body.put("quantity", 0);

            query = new HashMap<>();
            query.put("app_id", null);
            query.put("app_key", "d5106d8077c4a6f17c8f44034fbae5e3");

            foodServiceResponseDTO = foodService.nutrientsCreation(body,map, query);
            Assert.assertEquals(foodServiceResponseDTO.getStatusCode(), 401); //Assert the Status code
            Assert.assertTrue(foodServiceResponseDTO.getResponse().asString().contains("Unauthorized app_id")); //Assert the message

        } catch (Exception ex) {
            logger.info("nutrientsCreationWithNullAppId : FAIL");
            throw ex;
        }
    }

    //Verify nutrients creation with invalid AppId
    @Test
    public void nutrientsCreationWithInvalidAppId() throws Exception {

        try {
            logger.info("## Start | nutrientsCreationWithInvalidAppId ##" + this.getClass().getName());

            Map map=new HashMap();
            map.put("Content-Type", "application/json");

            body = getFoodJSONBodyTemplate("FoodNutrientsV2");
            body.put("quantity", 0);

            query = new HashMap<>();
            query.put("app_id", "12");
            query.put("app_key", "d5106d8077c4a6f17c8f44034fbae5e3");

            foodServiceResponseDTO = foodService.nutrientsCreation(body,map, query);
            Assert.assertEquals(foodServiceResponseDTO.getStatusCode(), 401); //Assert the Status code
            Assert.assertTrue(foodServiceResponseDTO.getResponse().asString().contains("Unauthorized app_id")); //Assert the message

        } catch (Exception ex) {
            logger.info("nutrientsCreationWithInvalidAppId : FAIL");
            throw ex;
        }
    }

    //Verify nutrients creation with empty AppKey
    @Test
    public void nutrientsCreationWithoutAppKey() throws Exception {

        try {
            logger.info("## Start | nutrientsCreationWithoutAppKey ##" + this.getClass().getName());

            Map map=new HashMap();
            map.put("Content-Type", "application/json");

            body = getFoodJSONBodyTemplate("FoodNutrientsV2");
            body.put("quantity", 0);

            query = new HashMap<>();
            query.put("app_id", "d2dc3e20");
            query.put("app_key", "");

            foodServiceResponseDTO = foodService.nutrientsCreation(body,map, query);
            Assert.assertEquals(foodServiceResponseDTO.getStatusCode(), 401); //Assert the Status code
            Assert.assertTrue(foodServiceResponseDTO.getResponse().asString().contains("Unauthorized app_id")); //Assert the message

        } catch (Exception ex) {
            logger.info("nutrientsCreationWithoutAppKey : FAIL");
            throw ex;
        }
    }

    //Verify nutrients creation with invalid AppKey
    @Test
    public void nutrientsCreationInvalidAppKey() throws Exception {

        try {
            logger.info("## Start | nutrientsCreationInvalidAppKey ##" + this.getClass().getName());

            Map map=new HashMap();
            map.put("Content-Type", "application/json");

            body = getFoodJSONBodyTemplate("FoodNutrientsV2");
            body.put("quantity", 0);

            query = new HashMap<>();
            query.put("app_id", "d2dc3e20");
            query.put("app_key", "123");

            foodServiceResponseDTO = foodService.nutrientsCreation(body,map, query);
            Assert.assertEquals(foodServiceResponseDTO.getStatusCode(), 401); //Assert the Status code
            Assert.assertTrue(foodServiceResponseDTO.getResponse().asString().contains("Unauthorized app_id")); //Assert the message

        } catch (Exception ex) {
            logger.info("nutrientsCreationInvalidAppKey : FAIL");
            throw ex;
        }
    }

    //Verify nutrients creation with null AppKey
    @Test
    public void nutrientsCreationNullAppKey() throws Exception {

        try {
            logger.info("## Start | nutrientsCreationNullAppKey ##" + this.getClass().getName());

            Map map=new HashMap();
            map.put("Content-Type", "application/json");

            body = getFoodJSONBodyTemplate("FoodNutrientsV2");
            body.put("quantity", 0);

            query = new HashMap<>();
            query.put("app_id", "d2dc3e20");
            query.put("app_key", null);

            foodServiceResponseDTO = foodService.nutrientsCreation(body,map, query);
            Assert.assertEquals(foodServiceResponseDTO.getStatusCode(), 401); //Assert the Status code
            Assert.assertTrue(foodServiceResponseDTO.getResponse().asString().contains("Unauthorized app_id")); //Assert the message

        } catch (Exception ex) {
            logger.info("nutrientsCreationNullAppKey : FAIL");
            throw ex;
        }
    }
}
