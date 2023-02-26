package kod.devs.business.abstracts;

import java.util.List;

import kod.devs.business.requests.CreateSoftwareLanguageRequest;
import kod.devs.business.requests.UpdateSoftwareLanguageRequest;
import kod.devs.business.responses.GetAllSoftwareLanguagesResponse;
import kod.devs.business.responses.GetByIdSoftwareLanguageResponse;

public interface SoftwareLanguageService {
	void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) throws Exception;
	void delete(int id);
	void update(UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest)throws Exception;
	List<GetAllSoftwareLanguagesResponse> getAll();
	GetByIdSoftwareLanguageResponse getById(int id);

}
