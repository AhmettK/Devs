package kod.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kod.devs.business.abstracts.SoftwareLanguageService;
import kod.devs.business.requests.CreateSoftwareLanguageRequest;
import kod.devs.business.requests.UpdateSoftwareLanguageRequest;
import kod.devs.business.responses.GetAllSoftwareLanguagesResponse;
import kod.devs.business.responses.GetByIdSoftwareLanguageResponse;

@RestController
@RequestMapping("/api/softwarelanguages")
public class SoftwareLanguagesController {
	
	private SoftwareLanguageService _softwareLanguageService;

	@Autowired
	public SoftwareLanguagesController(SoftwareLanguageService softwareLanguageService) {
		_softwareLanguageService = softwareLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllSoftwareLanguagesResponse> getAll() {
		return _softwareLanguageService.getAll();
	}
	@GetMapping("/getbyid")
	public GetByIdSoftwareLanguageResponse getById(int id) {
		return _softwareLanguageService.getById(id);
	}
	@PostMapping("/add")
	public void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) throws Exception {
		_softwareLanguageService.add(createSoftwareLanguageRequest);
	}
	@PostMapping("/delete")
	public void delete(int id) {
		_softwareLanguageService.delete(id);
	}
	@PostMapping("/update")
	public void update(UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest) throws Exception{
		_softwareLanguageService.update(updateSoftwareLanguageRequest);
	}

}
