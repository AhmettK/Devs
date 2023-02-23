package kod.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kod.devs.dataAccess.abstracts.SoftwareLanguageRepository;
import kod.devs.entities.concretes.SoftwareLanguage;

@Repository
public class InMemorySoftwareLanguageRepository implements SoftwareLanguageRepository{
	
	List<SoftwareLanguage> softwareLanguages;

	public InMemorySoftwareLanguageRepository() {
		softwareLanguages=new ArrayList<SoftwareLanguage>();
		softwareLanguages.add(new SoftwareLanguage(1,"C#"));
		softwareLanguages.add(new SoftwareLanguage(2,"Java"));
		softwareLanguages.add(new SoftwareLanguage(3,"Python"));
	}

	@Override
	public void add(SoftwareLanguage softwareLanguage) {
		softwareLanguages.add(softwareLanguage);
		
	}

	@Override
	public void delete(SoftwareLanguage softwareLanguage) {
		int counter=0;
		for(SoftwareLanguage language:softwareLanguages) {
			if(language.getId()==softwareLanguage.getId()) {
				softwareLanguages.remove(counter);
			}
			counter++;
		}
	}

	@Override
	public void update(SoftwareLanguage softwareLanguage) {
		int counter=0;
		for(SoftwareLanguage language:softwareLanguages) {
			if(language.getId()==softwareLanguage.getId()) {
				softwareLanguages.set(counter, softwareLanguage);
			}
			counter++;
		}
	}

	@Override
	public List<SoftwareLanguage> getAll() {
		return softwareLanguages;
	}
	
	@Override
	public SoftwareLanguage getById(int id) {
		for(SoftwareLanguage language:softwareLanguages) {
			if(language.getId()==id) {
				return language;
			}
		}
		return null;
	}

}
