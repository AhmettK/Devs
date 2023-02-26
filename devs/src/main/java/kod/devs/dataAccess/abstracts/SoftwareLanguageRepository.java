package kod.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kod.devs.entities.concretes.SoftwareLanguage;

public interface SoftwareLanguageRepository extends JpaRepository<SoftwareLanguage, Integer>{

}
