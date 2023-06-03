package in.pkg.service;

import java.util.List;

import in.pkg.entity.CitizenPlan;
import in.pkg.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf();
}
