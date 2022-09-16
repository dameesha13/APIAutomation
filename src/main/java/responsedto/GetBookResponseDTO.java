package responsedto;

import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;

import java.util.List;

@Getter
@Setter
public class GetBookResponseDTO extends BaseResponseDTO {

    private String id;
    private String title;
    private String year;
    private List author;
    private String wiki_url;
}
