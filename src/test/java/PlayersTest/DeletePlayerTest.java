package PlayersTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import responsedto.GetAllPlayersByIdResponseDTO;
import service.PlayerService;
import util.bases.TestBase;

public class DeletePlayerTest extends TestBase {

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

    @Test
    public void getAllPlayerDetailsById() throws Exception {
        try {
            logger.info("## Start | getAllPlayerDetailsById ##" + this.getClass().getName());

            Response response = playerService.deletePlayer("237");
            Assert.assertEquals(response.getStatusCode(), 404); //Assert the status code

        } catch (Exception e) {
            logger.info("getAllPlayerDetailsById : FAIL");
            throw e;
        }
    }
}
