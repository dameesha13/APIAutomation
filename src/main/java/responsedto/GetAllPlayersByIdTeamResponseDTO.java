package responsedto;

import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;
@Getter
@Setter
public class GetAllPlayersByIdTeamResponseDTO extends BaseResponseDTO {

    private Integer id;
    private String abbreviation;
    private String city;
    private String conference;
    private String division;
    private String full_name;
    private String name;
}
