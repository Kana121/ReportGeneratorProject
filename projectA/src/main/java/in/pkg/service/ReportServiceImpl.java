package in.pkg.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.pkg.entity.CitizenPlan;
import in.pkg.repository.CitizenPlanRepository;
import in.pkg.request.SearchRequest;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public List<String> getPlanNames() {
		
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		
		return repo.getPlanStatuses();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity=new CitizenPlan();
		if(null!=request.getPlanName()&&"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null!=request.getGender()&&"".equals(request.getGender())) {
			entity.setGender(request.getGender());
			
		}if(null!=request.getPlanStatus()&&"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		return repo.findAll(Example.of(entity));
		 
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
	List<CitizenPlan> records=repo.findAll();
	Workbook workbook=new HSSFWorkbook();
	Sheet sheet=workbook.createSheet("plans-data");
	Row headerRow=sheet.createRow(0);
	headerRow.createCell(0).setCellValue("Id");
	headerRow.createCell(1).setCellValue("Citizen Name");
	headerRow.createCell(2).setCellValue("gender");
	headerRow.createCell(3).setCellValue("plan Name");
	headerRow.createCell(4).setCellValue("plan Status");
	headerRow.createCell(5).setCellValue("plan Start Date");
	headerRow.createCell(6).setCellValue("plan End Date");
	headerRow.createCell(7).setCellValue("benifit Ammount ");
	
//	List<CitizenPlan> records=repo.findAll();
	int dataRowIndx=1;
	for(CitizenPlan plan:records) {
		Row dataRow=sheet.createRow(dataRowIndx);
		dataRow.createCell(0).setCellValue(plan.getCitizenId());
		dataRow.createCell(1).setCellValue(plan.getCitizenName());
		dataRow.createCell(2).setCellValue(plan.getGender());
		dataRow.createCell(3).setCellValue(plan.getPlanName());
		dataRow.createCell(4).setCellValue(plan.getPlanStatus());
		dataRow.createCell(5).setCellValue(plan.getPlanStartDate());
		dataRow.createCell(6).setCellValue(plan.getPlanEndDate());
		if(null !=plan.getBenifitAmt())
		dataRow.createCell(7).setCellValue(plan.getBenifitAmt());
		else
			dataRow.createCell(7).setCellValue("N/A");
		dataRowIndx++;
	}
//	FileOutputStream fos=new FileOutputStream(new File("plan.xls"));
//	workbook.write(fos);
//	workbook.close();
 ServletOutputStream outputStream=	response.getOutputStream();
 workbook.write(outputStream);
 workbook.close();
		return true;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
