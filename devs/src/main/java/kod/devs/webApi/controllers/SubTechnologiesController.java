package kod.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kod.devs.business.abstracts.SubTechnologyService;
import kod.devs.business.requests.CreateSubTechnologyRequest;
import kod.devs.business.requests.UpdateSubTechnologyRequest;
import kod.devs.business.responses.GetAllSubTechnologiesResponse;
import kod.devs.business.responses.GetByIdSubTechnologyRepsonse;

@RestController
@RequestMapping("/api/subtechnology")
public class SubTechnologiesController {
	private SubTechnologyService _subTechnologyService;

	@Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		_subTechnologyService = subTechnologyService;
	}

	@GetMapping("/getall")
	public List<GetAllSubTechnologiesResponse> getAll() {
		return _subTechnologyService.getAll();
	}
	@GetMapping("/getbyid")
	public GetByIdSubTechnologyRepsonse getById(int id) {
		return _subTechnologyService.getById(id);
	}
	@PostMapping("/add")
	public void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		_subTechnologyService.add(createSubTechnologyRequest);
	}
	@PostMapping("/delete")
	public void delete(int id) {
		_subTechnologyService.delete(id);
	}
	@PostMapping("/update")
	public void update(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception{
		_subTechnologyService.update(updateSubTechnologyRequest);
	}
	//git deneme
}
