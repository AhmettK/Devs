package kod.devs.business.abstracts;

import java.util.List;

import kod.devs.entities.concretes.SoftwareLanguage;

public interface SoftwareLanguageService {
	void add(SoftwareLanguage softwareLanguage) throws Exception;
	void delete(SoftwareLanguage softwareLanguage);
	void update(SoftwareLanguage softwareLanguage)throws Exception;
	List<SoftwareLanguage> getAll();
	SoftwareLanguage getById(int id);

}
