package responsedto;

import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;

import java.util.List;

@Getter
@Setter
public class GetAllPlayersByIdResponseDTO extends BaseResponseDTO {

    private String id;
    private String first_name;
    private Integer height_feet;
    private Integer height_inches;
    private String last_name;
    private String position;
    private GetAllPlayersByIdTeamResponseDTO team;
    private String weight_pounds;
}
