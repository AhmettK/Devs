package kod.devs.business.abstracts;

import java.util.List;

import kod.devs.business.requests.CreateSubTechnologyRequest;
import kod.devs.business.requests.UpdateSubTechnologyRequest;
import kod.devs.business.responses.GetAllSubTechnologiesResponse;
import kod.devs.business.responses.GetByIdSubTechnologyRepsonse;

public interface SubTechnologyService {
	void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;
	void delete(int id);
	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest)throws Exception;
	List<GetAllSubTechnologiesResponse> getAll();
	GetByIdSubTechnologyRepsonse getById(int id);
}
