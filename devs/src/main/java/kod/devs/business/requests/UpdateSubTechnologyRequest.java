package kod.devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSubTechnologyRequest {
	private int id;
	private String name;
	private int softwareLanguageId;

}
