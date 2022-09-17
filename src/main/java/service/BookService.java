package service;

import constant.RelativeURLs;
import io.restassured.response.Response;
import responsedto.GetBookResponseDTO;
import util.bases.APIServicesBase;
import util.data.Config;

public class BookService extends APIServicesBase {

    private final String baseURI;
    private GetBookResponseDTO getBookResponseDTO;

    public BookService() {
        this.baseURI = Config.getProperty("bookService.baseurl");

    }

    public GetBookResponseDTO getBookDetailsById(String bookId) throws Exception {

        try {
            Response response = getRequest(baseURI, RelativeURLs.GET_BOOK_DETAILS_BY_ID.replace("{id}", bookId));
           
            if (response.statusCode() == 200)
                getBookResponseDTO = objectMapper.readValue(response.asString(), GetBookResponseDTO.class);
            else
                getBookResponseDTO = new GetBookResponseDTO();

            getBookResponseDTO.setResponse(response);

        } catch (Exception ex) {
            throw ex;
        }
        return getBookResponseDTO;
    }

}
