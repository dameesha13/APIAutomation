package PlayersTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import responsedto.GetAllPlayersResponseDTO;
import service.PlayerService;
import util.bases.TestBase;

public class GetAllPlayersDetails extends TestBase {

    private PlayerService playerService;
    private GetAllPlayersResponseDTO getAllPlayersResponseDTO;

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

    /********************************* GET - get all Player details Test Cases ***************************************/

    //Verify all player details
    @Test
    public void getAllPlayerDetails() throws Exception {
        try {
            logger.info("## Start | getAllPlayerDetails ##" + this.getClass().getName());

            getAllPlayersResponseDTO = playerService.getPlayersDetails();
            Assert.assertEquals(getAllPlayersResponseDTO.getStatusCode(), 200); //Assert the status code
            Assert.assertEquals(getAllPlayersResponseDTO.getData().get(0).getFirst_name(),"Ike");//Assert the first_name
            Assert.assertEquals(getAllPlayersResponseDTO.getData().get(0).getTeam().getCity(), "Indiana"); //Assert the city

        } catch (Exception e) {
            logger.info("getAllPlayerDetails : FAIL");
            throw e;
        }
    }

}
