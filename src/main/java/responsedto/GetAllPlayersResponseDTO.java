package responsedto;

import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;

import java.util.List;

@Getter
@Setter
public class GetAllPlayersResponseDTO extends BaseResponseDTO {

    private List<GetAllPlayersDataResponseDTO> data;
    private GetAllPlayersMetaResponseDTO meta;
}
