package responsedto;

import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;

@Getter
@Setter
public class GetBookResponseDTO extends BaseResponseDTO {

    private String id;
    private String title;
    private String year;
    private String author;
    private String wiki_url;
}
