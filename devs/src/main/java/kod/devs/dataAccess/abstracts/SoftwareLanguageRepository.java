package kod.devs.dataAccess.abstracts;

import java.util.List;

import kod.devs.entities.concretes.SoftwareLanguage;

public interface SoftwareLanguageRepository {
	void add(SoftwareLanguage softwareLanguage);
	void delete(SoftwareLanguage softwareLanguage);
	void update(SoftwareLanguage softwareLanguage);
	List<SoftwareLanguage> getAll();
	SoftwareLanguage getById(int id);

}
