package service;

import constant.RelativeURLs;
import io.restassured.response.Response;
import responsedto.GetAllPlayersByIdResponseDTO;
import responsedto.GetAllPlayersResponseDTO;
import responsedto.GetBookResponseDTO;
import util.bases.APIServicesBase;
import util.data.Config;

public class PlayerService extends APIServicesBase {

    private final String baseURI;
    private GetAllPlayersResponseDTO getAllPlayersResponseDTO;
    private GetAllPlayersByIdResponseDTO getAllPlayersByIdResponseDTO;

    public PlayerService(){
        this.baseURI = Config.getProperty("playersService.baseurl");
    }

    //Service for get all player details
    public GetAllPlayersResponseDTO getPlayersDetails() throws Exception {

        try {
            Response response = getRequest(baseURI, RelativeURLs.GET_ALL_PLAYERS);

            if (response.statusCode() == 200)
                getAllPlayersResponseDTO = objectMapper.readValue(response.asString(), GetAllPlayersResponseDTO.class);
            else
                getAllPlayersResponseDTO = new GetAllPlayersResponseDTO();

            getAllPlayersResponseDTO.setResponse(response);

        } catch (Exception ex) {
            throw ex;
        }
        return getAllPlayersResponseDTO;
    }

    //Service for get specific player detail
    public GetAllPlayersByIdResponseDTO getPlayersDetailsById(String playerId) throws Exception {

        try {
            Response response = getRequest(baseURI, RelativeURLs.GET_DELETE_ALL_PLAYERS_BY_ID.replace("{id}", playerId));
            if (response.statusCode() == 200)
                getAllPlayersByIdResponseDTO = objectMapper.readValue(response.asString(), GetAllPlayersByIdResponseDTO.class);
            else
                getAllPlayersByIdResponseDTO = new GetAllPlayersByIdResponseDTO();

            getAllPlayersByIdResponseDTO.setResponse(response);

        } catch (Exception ex) {
            throw ex;
        }
        return getAllPlayersByIdResponseDTO;
    }

    //Service for delete player detail
    public Response deletePlayer(String playerId) throws Exception {

        try {
            Response response = deleteRequest(baseURI, RelativeURLs.GET_DELETE_ALL_PLAYERS_BY_ID.replace("{id}", playerId));

            return response;

        } catch (Exception ex) {
            throw ex;
        }
    }
}
