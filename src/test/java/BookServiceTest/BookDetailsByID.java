package BookServiceTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import responsedto.GetBookResponseDTO;
import service.BookService;
import util.bases.TestBase;

public class BookDetailsByID extends TestBase {

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

    /********************************* GET - get book detail Test Cases ***************************************/

    //Verify get book details by Id
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

    //Verify get book details by different Id
    @Test
    public void getBookDetailsByDifferentId() throws Exception {
        try {
            logger.info("## Start | getBookDetailsByDifferentId ##" + this.getClass().getName());

            getBookResponseDTO = bookService.getBookDetailsById("22");
            Assert.assertEquals(getBookResponseDTO.getStatusCode(), 200); //Assert the status code
            Assert.assertEquals(getBookResponseDTO.getId(), "22"); //Assert the ID
            Assert.assertEquals(getBookResponseDTO.getAuthor().get(0),"Brian Herbert");//Assert the title
            Assert.assertEquals(getBookResponseDTO.getTitle(),"Dune: The Heir of Caladan");//Assert the title
            Assert.assertEquals(getBookResponseDTO.getYear(), "TBA");//Assert the year

        } catch (Exception e) {
            logger.info("getBookDetailsByDifferentId : FAIL");
            throw e;
        }
    }
}
