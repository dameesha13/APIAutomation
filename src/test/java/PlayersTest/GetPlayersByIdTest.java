package PlayersTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import responsedto.GetAllPlayersByIdResponseDTO;
import responsedto.GetAllPlayersResponseDTO;
import service.PlayerService;
import util.bases.TestBase;

public class GetPlayersByIdTest extends TestBase {

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

    @Test
    public void getAllPlayerDetailsById() throws Exception {
        try {
            logger.info("## Start | getAllPlayerDetailsById ##" + this.getClass().getName());

            getAllPlayersByIdResponseDTO = playerService.getPlayersDetailsById("237");
            Assert.assertEquals(getAllPlayersByIdResponseDTO.getStatusCode(), 200); //Assert the status code
            Assert.assertEquals(getAllPlayersByIdResponseDTO.getId(),"237");//Assert the id
            Assert.assertEquals(getAllPlayersByIdResponseDTO.getFirst_name(), "LeBron"); //Assert the first_name

        } catch (Exception e) {
            logger.info("getAllPlayerDetailsById : FAIL");
            throw e;
        }
    }

    @Test
    public void getAllPlayerDetailsWithoutId() throws Exception {
        try {
            logger.info("## Start | getAllPlayerDetailsWithoutId ##" + this.getClass().getName());

            getAllPlayersByIdResponseDTO = playerService.getPlayersDetailsById(" ");
            Assert.assertEquals(getAllPlayersByIdResponseDTO.getStatusCode(), 404); //Assert the status code

        } catch (Exception e) {
            logger.info("getAllPlayerDetailsWithoutId : FAIL");
            throw e;
        }
    }

    @Test
    public void getAllPlayerDetailsInvalidPlayerId() throws Exception {
        try {
            logger.info("## Start | getAllPlayerDetailsInvalidPlayerId ##" + this.getClass().getName());

            getAllPlayersByIdResponseDTO = playerService.getPlayersDetailsById("qa");
            Assert.assertEquals(getAllPlayersByIdResponseDTO.getStatusCode(), 404); //Assert the status code

        } catch (Exception e) {
            logger.info("getAllPlayerDetailsInvalidPlayerId : FAIL");
            throw e;
        }
    }

}
