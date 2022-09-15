package responsedto;

import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;

@Getter
@Setter
public class GetAllPlayersMetaResponseDTO extends BaseResponseDTO {

    private Integer total_pages;
    private Integer current_page;
    private Integer next_page;
    private Integer per_page;
    private Integer total_count;
}
