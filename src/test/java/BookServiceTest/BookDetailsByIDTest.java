package BookServiceTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import responsedto.GetBookResponseDTO;
import service.BookService;
import util.bases.TestBase;

public class BookDetailsByIDTest extends TestBase {

    private BookService bookService;
    private GetBookResponseDTO getBookResponseDTO;

    @BeforeClass
    public void serviceSetUp() throws Exception {

        try {
            bookService = new BookService();
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
    public void getBookDetailsById() throws Exception {
        try {
            logger.info("## Start | getBookDetailsById ##" + this.getClass().getName());

            getBookResponseDTO = bookService.getBookDetailsById("1");
            Assert.assertEquals(getBookResponseDTO.getStatusCode(), 200); //Assert the status code
            Assert.assertEquals(getBookResponseDTO.getId(), "1"); //Assert the ID
            Assert.assertEquals(getBookResponseDTO.getTitle(),"Dune");//Assert the title
            Assert.assertEquals(getBookResponseDTO.getYear(), "1965");//Assert the year

        } catch (Exception e) {
            logger.info("getBookDetailsById : FAIL");
            throw e;
        }
    }

    //TODO - Return 200 for negative scenarios from the API
    @Test
    public void getBookDetailsByInvalidId() throws Exception {
        try {
            logger.info("## Start | getBookDetailsByInvalidId ##" + this.getClass().getName());

            getBookResponseDTO = bookService.getBookDetailsById("qa");
            Assert.assertEquals(getBookResponseDTO.getStatusCode(), 404); //Assert the status code

        } catch (Exception e) {
            logger.info("getBookDetailsByInvalidId : FAIL");
            throw e;
        }
    }

}
