package in.pkg.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.pkg.entity.CitizenPlan;
import in.pkg.repository.CitizenPlanRepository;
@Component
public class Dataloder implements ApplicationRunner {
	@Autowired
private CitizenPlanRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		// cash plan info
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("kana");
		c1.setGender("male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmt(5000.00);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("smith");
		c2.setGender("male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReson("Rental Income");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("cathely");
		c3.setGender("Female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmt(5000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationRsn("Employed");

		// food plan info
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("sasi");
		c4.setGender("male");
		c4.setPlanName("food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmt(4000.00);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("robert");
		c5.setGender("male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReson("Property Income");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("orlen");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitAmt(5000.00);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationRsn("Employed");

		// Medical plan info
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("saransh");
		c7.setGender("male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmt(4000.00);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("robert");
		c8.setGender("male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReson("Property Income");

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Radha");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifitAmt(5000.00);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationRsn("Gov. job");

		// Employment plan info
		CitizenPlan c10 = new CitizenPlan();
				c10.setCitizenName("abhijit");
				c10.setGender("male");
				c10.setPlanName("Employment");
				c10.setPlanStatus("Approved");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenifitAmt(4000.00);

				CitizenPlan c11 = new CitizenPlan();
				c11.setCitizenName("ram");
				c11.setGender("male");
				c11.setPlanName("Employment");
				c11.setPlanStatus("Denied");
				c11.setDenialReson("Property Income");

				CitizenPlan c12 = new CitizenPlan();
				c12.setCitizenName("Nesha");
				c12.setGender("Female");
				c12.setPlanName("Employment");
				c12.setPlanStatus("Terminated");
				c12.setPlanStartDate(LocalDate.now().minusMonths(4));
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				c12.setBenifitAmt(5000.00);
				c12.setTerminatedDate(LocalDate.now());
				c12.setTerminationRsn("Gov. job");
			List<CitizenPlan>list=	Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
			repo.saveAll(list);	
		
	}

}
