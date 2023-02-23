package kod.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kod.devs.business.abstracts.SoftwareLanguageService;
import kod.devs.entities.concretes.SoftwareLanguage;

@RestController
@RequestMapping("/api/softwarelanguages")
public class SoftwareLanguagesController {
	
	private SoftwareLanguageService _softwareLanguageService;

	@Autowired
	public SoftwareLanguagesController(SoftwareLanguageService softwareLanguageService) {
		_softwareLanguageService = softwareLanguageService;
	}
	
	@GetMapping("/getall")
	public List<SoftwareLanguage> getAll() {
		return _softwareLanguageService.getAll();
	}
	@GetMapping("/getbyid")
	public SoftwareLanguage getById(int id) {
		return _softwareLanguageService.getById(id);
	}
	@PostMapping("/add")
	public void add(SoftwareLanguage softwareLanguage) throws Exception {
		_softwareLanguageService.add(softwareLanguage);
	}
	@PostMapping("/delete")
	public void delete(SoftwareLanguage softwareLanguage) {
		_softwareLanguageService.delete(softwareLanguage);
	}
	@PostMapping("/update")
	public void update(SoftwareLanguage softwareLanguage) throws Exception{
		_softwareLanguageService.update(softwareLanguage);
	}

}
