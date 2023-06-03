package in.pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.pkg.entity.CitizenPlan;
import in.pkg.request.SearchRequest;
import in.pkg.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response)throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plan.xls");
		service.exportExcel(response);
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search",new SearchRequest());
		init(model);
		return "index";
	}
	private void init(Model model) {
	//	model.addAttribute("search",new SearchRequest());
		model.addAttribute("names",service.getPlanNames());
		model.addAttribute("status",service.getPlanStatuses());
	}
	@PostMapping("/search")
	public String handelSearch(@ModelAttribute("search") SearchRequest search,Model model) {
		
		//System.out.println(request);
		 List<CitizenPlan>plans= service.search(search);
		 model.addAttribute("plans",plans);
		System.out.println(plans);
		 init(model);
		
		return "list";
	}
}
