package kod.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kod.devs.business.abstracts.SubTechnologyService;
import kod.devs.business.requests.CreateSubTechnologyRequest;
import kod.devs.business.requests.UpdateSubTechnologyRequest;
import kod.devs.business.responses.GetAllSubTechnologiesResponse;
import kod.devs.business.responses.GetByIdSubTechnologyRepsonse;
import kod.devs.dataAccess.abstracts.SoftwareLanguageRepository;
import kod.devs.dataAccess.abstracts.SubTechnologyRepository;
import kod.devs.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {
	private SubTechnologyRepository _subTechnologyRepository;
	private SoftwareLanguageRepository _softwareLanguageRepository;
	
	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository,SoftwareLanguageRepository softwareLanguageRepository) {
		_subTechnologyRepository = subTechnologyRepository;
		_softwareLanguageRepository = softwareLanguageRepository;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		SubTechnology subTechnology=new SubTechnology();
		subTechnology.setName(createSubTechnologyRequest.getName());
		subTechnology.setSoftwareLanguage(_softwareLanguageRepository.findById(createSubTechnologyRequest.getSoftwareLanguageId()).get());
		_subTechnologyRepository.save(subTechnology);
		
	}

	@Override
	public void delete(int id) {
		_subTechnologyRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		SubTechnology subTechnology=_subTechnologyRepository.findById(updateSubTechnologyRequest.getId()).get();
		subTechnology.setName(updateSubTechnologyRequest.getName());
		subTechnology.setSoftwareLanguage(_softwareLanguageRepository.findById(updateSubTechnologyRequest.getSoftwareLanguageId()).get());
		_subTechnologyRepository.save(subTechnology);
		
	}

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<SubTechnology> technologies=_subTechnologyRepository.findAll();
		List<GetAllSubTechnologiesResponse> responses=new ArrayList<GetAllSubTechnologiesResponse>();
		
		for(SubTechnology technology:technologies) {
			GetAllSubTechnologiesResponse responseItem=new GetAllSubTechnologiesResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			responseItem.setSoftwareLanguage(technology.getSoftwareLanguage());
			responses.add(responseItem);
		}
		return responses;
	}

	@Override
	public GetByIdSubTechnologyRepsonse getById(int id) {
		SubTechnology technology = _subTechnologyRepository.findById(id).get();
		GetByIdSubTechnologyRepsonse response = new GetByIdSubTechnologyRepsonse();
		response.setName(technology.getName());
		response.setSoftwareLanguage(technology.getSoftwareLanguage());
		return response;
	}

}
