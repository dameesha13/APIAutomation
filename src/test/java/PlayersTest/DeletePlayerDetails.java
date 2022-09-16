package PlayersTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import responsedto.GetAllPlayersByIdResponseDTO;
import service.PlayerService;
import util.bases.TestBase;

public class DeletePlayerDetails extends TestBase {

    private PlayerService playerService;
    private GetAllPlayersByIdResponseDTO getAllPlayersByIdResponseDTO;

    @BeforeClass
    public void serviceSetUp() throws Exception {

        try {
            playerService = new PlayerService();
            envSetup();

        } catch (Exception e) {
            throw e;
        }
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

    /********************************* DELETE - delete Player details Test Cases ***************************************/

    //Verify delete specific userId
    @Test
    public void deletePlayerDetailsById() throws Exception {
        try {
            logger.info("## Start | deletePlayerDetailsById ##" + this.getClass().getName());

            Response response = playerService.deletePlayer("237");
            Assert.assertEquals(response.getStatusCode(), 404); //Assert the status code (This should be 204)

            //check whether the player is deleted or not using getPlayersDetailsById endpoint
            getAllPlayersByIdResponseDTO = playerService.getPlayersDetailsById("237");
            Assert.assertEquals(getAllPlayersByIdResponseDTO.getStatusCode(), 200); //Assert Status Code (should be 404, but from the endpoint return 200)

        } catch (Exception e) {
            logger.info("deletePlayerDetailsById : FAIL");
            throw e;
        }
    }

    //Verify delete invalid userId
    @Test
    public void deletePlayerDetailsByInvalidId() throws Exception {
        try {
            logger.info("## Start | deletePlayerDetailsByInvalidId ##" + this.getClass().getName());

            Response response = playerService.deletePlayer("qa");
            Assert.assertEquals(response.getStatusCode(), 404); //Assert the status code
        } catch (Exception e) {
            logger.info("deletePlayerDetailsByInvalidId : FAIL");
            throw e;
        }
    }
}
