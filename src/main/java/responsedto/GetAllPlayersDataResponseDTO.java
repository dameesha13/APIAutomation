package responsedto;

import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;

@Getter
@Setter
public class GetAllPlayersDataResponseDTO extends BaseResponseDTO {

    private Integer id;
    private String first_name;
    private String height_feet;
    private String height_inches;
    private String last_name;
    private String position;
    private TeamResponseDTO team;
    private String weight_pounds;

}
