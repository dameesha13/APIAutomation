package responsedto;

import lombok.Getter;
import lombok.Setter;
import util.bases.BaseResponseDTO;

import java.util.List;

@Getter
@Setter
public class FoodServiceResponseDTO extends BaseResponseDTO {

    private String uri;
    private Integer calories;
    private double totalWeight;
    private List<FoodServiceDietLabelsResponseDTO> dietLabels;
    private List<FoodServiceHealthLabelsResponseDTO> healthLabels;
    private List<FoodServiceCautionsResponseDTO> cautions;
    private FoodServiceTotalNutrientsResponseDTO totalNutrients;
    private FoodServiceTotalDailyResponseDTO totalDaily;
    private List<FoodServiceIngredientsResponseDTO> ingredients;


}
