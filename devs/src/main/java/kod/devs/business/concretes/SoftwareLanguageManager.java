package kod.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kod.devs.business.abstracts.SoftwareLanguageService;
import kod.devs.business.requests.CreateSoftwareLanguageRequest;
import kod.devs.business.requests.UpdateSoftwareLanguageRequest;
import kod.devs.business.responses.GetAllSoftwareLanguagesResponse;
import kod.devs.business.responses.GetByIdSoftwareLanguageResponse;
import kod.devs.dataAccess.abstracts.SoftwareLanguageRepository;
import kod.devs.entities.concretes.SoftwareLanguage;

@Service
public class SoftwareLanguageManager implements SoftwareLanguageService{
	
	private SoftwareLanguageRepository _softwareLanguageRepository;

	@Autowired
	public SoftwareLanguageManager(SoftwareLanguageRepository softwareLanguageRepository) {
		_softwareLanguageRepository = softwareLanguageRepository;
	}

	@Override
	public void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) throws Exception {
		if(createSoftwareLanguageRequest.getName().isEmpty()) {
			throw new Exception("İsim boş bırakılamaz");
		}
		for(GetAllSoftwareLanguagesResponse language:getAll()) {
			if(createSoftwareLanguageRequest.getName().equals(language.getName())) {
				throw new Exception("İsimler tekrar edemez");
			}
		}
		SoftwareLanguage softwareLanguage = new SoftwareLanguage();
		softwareLanguage.setName(createSoftwareLanguageRequest.getName());
		_softwareLanguageRepository.save(softwareLanguage);
	}

	@Override
	public void delete(int id) {
		_softwareLanguageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest) throws Exception{
		if(updateSoftwareLanguageRequest.getName().isEmpty()) {
			throw new Exception("İsim boş bırakılamaz");
		}
		for(GetAllSoftwareLanguagesResponse language:getAll()) {
			if(updateSoftwareLanguageRequest.getName().equals(language.getName())) {
				throw new Exception("İsimler tekrar edemez");
			}
		}
		SoftwareLanguage language=_softwareLanguageRepository.findById(updateSoftwareLanguageRequest.getId()).get();
		language.setName(updateSoftwareLanguageRequest.getName());
		_softwareLanguageRepository.save(language);
		
	}

	@Override
	public List<GetAllSoftwareLanguagesResponse> getAll() {
		List<SoftwareLanguage> languages=_softwareLanguageRepository.findAll();
		List<GetAllSoftwareLanguagesResponse> responses=new ArrayList<GetAllSoftwareLanguagesResponse>();
		
		for(SoftwareLanguage language:languages) {
			GetAllSoftwareLanguagesResponse responseItem= new GetAllSoftwareLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			responses.add(responseItem);
		}
		return responses;
	}
	
	@Override
	public GetByIdSoftwareLanguageResponse getById(int id) {
		SoftwareLanguage language = _softwareLanguageRepository.findById(id).get();
		GetByIdSoftwareLanguageResponse response= new GetByIdSoftwareLanguageResponse();
		response.setName(language.getName());
		return response;
	}

}
