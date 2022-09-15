package responsedto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FoodServiceCautionsResponseDTO extends BaseResponseDTO {

}
