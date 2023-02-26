package kod.devs.business.responses;

import kod.devs.entities.concretes.SoftwareLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSubTechnologiesResponse {
	private int id;
	private String name;
	private SoftwareLanguage softwareLanguage;

}
