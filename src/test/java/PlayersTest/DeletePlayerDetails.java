package PlayersTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.PlayerService;
import util.bases.TestBase;

public class DeletePlayerDetails extends TestBase {

    private PlayerService playerService;

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
            Assert.assertEquals(response.getStatusCode(), 404); //Assert the status code
        } catch (Exception e) {
            logger.info("deletePlayerDetailsById : FAIL");
            throw e;
        }
    }
}
