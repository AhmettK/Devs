package kod.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kod.devs.business.abstracts.SoftwareLanguageService;
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
	public void add(SoftwareLanguage softwareLanguage) throws Exception {
		if(softwareLanguage.getName().isEmpty()) {
			throw new Exception("İsim boş bırakılamaz");
		}
		for(SoftwareLanguage language:getAll()) {
			if(softwareLanguage.getName().equals(language.getName())) {
				throw new Exception("İsimler tekrar edemez");
			}
		}
		_softwareLanguageRepository.add(softwareLanguage);
	}

	@Override
	public void delete(SoftwareLanguage softwareLanguage) {
		_softwareLanguageRepository.delete(softwareLanguage);
		
	}

	@Override
	public void update(SoftwareLanguage softwareLanguage) throws Exception{
		if(softwareLanguage.getName().isEmpty()) {
			throw new Exception("İsim boş bırakılamaz");
		}
		for(SoftwareLanguage language:getAll()) {
			if(softwareLanguage.getName().equals(language.getName())) {
				throw new Exception("İsimler tekrar edemez");
			}
		}
		_softwareLanguageRepository.update(softwareLanguage);
		
	}

	@Override
	public List<SoftwareLanguage> getAll() {
		return _softwareLanguageRepository.getAll();
	}
	
	@Override
	public SoftwareLanguage getById(int id) {
		return _softwareLanguageRepository.getById(id);
	}

}
