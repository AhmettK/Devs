package kod.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kod.devs.entities.concretes.SubTechnology;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer>{

}
