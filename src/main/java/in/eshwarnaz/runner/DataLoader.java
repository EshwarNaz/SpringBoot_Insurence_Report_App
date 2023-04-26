package in.eshwarnaz.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.eshwarnaz.entity.CitizenPlan;
import in.eshwarnaz.repository.CitizenPlanRepositroy;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	CitizenPlanRepositroy repositroy;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		repositroy.deleteAll();
		// Cash plan
		CitizenPlan c1 = new CitizenPlan();
		c1.setCITEGEN_NAME("Santhosh");
		c1.setCITEGEN_GENDER("male");
		c1.setCITEGEN_PLAN_NAME("cash");
		c1.setCITEGEN_PLAN_STATUS("approved");
		c1.setSTART_DATE(LocalDate.now());
		c1.setEND_DATE(LocalDate.now().plusMonths(6));
		c1.setBENFITAMOUNT(3500.0);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCITEGEN_NAME("Teja");
		c2.setCITEGEN_GENDER("male");
		c2.setCITEGEN_PLAN_NAME("cash");
		c2.setCITEGEN_PLAN_STATUS("denied");
		c2.setDENAIAL_REASON("Over Account Balance");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCITEGEN_NAME("Ravi");
		c3.setCITEGEN_GENDER("male");
		c3.setCITEGEN_PLAN_NAME("cash");
		c3.setCITEGEN_PLAN_STATUS("terminated");
		c3.setSTART_DATE(LocalDate.now().minusMonths(6));
		c3.setEND_DATE(LocalDate.now().plusMonths(4));
		c3.setTERIMINATED_DATE(LocalDate.now());
		c3.setBENFITAMOUNT(1500.0);
		c3.setTERMNATION_REASON("Got a New Job");

		CitizenPlan c4 = new CitizenPlan();
		c4.setCITEGEN_NAME("ramya");
		c4.setCITEGEN_GENDER("female");
		c4.setCITEGEN_PLAN_NAME("cash");
		c4.setCITEGEN_PLAN_STATUS("approved");
		c4.setSTART_DATE(LocalDate.now());
		c4.setEND_DATE(LocalDate.now().plusMonths(6));
		c4.setBENFITAMOUNT(4500.0);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCITEGEN_NAME("anusha");
		c5.setCITEGEN_GENDER("female");
		c5.setCITEGEN_PLAN_NAME("cash");
		c5.setCITEGEN_PLAN_STATUS("denied");
		c5.setDENAIAL_REASON("Account Balance Is To low");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCITEGEN_NAME("Sindhu");
		c6.setCITEGEN_GENDER("female");
		c6.setCITEGEN_PLAN_NAME("cash");
		c6.setCITEGEN_PLAN_STATUS("terminated");
		c6.setSTART_DATE(LocalDate.now().minusMonths(6));
		c6.setEND_DATE(LocalDate.now().plusMonths(3));
		c6.setTERIMINATED_DATE(LocalDate.now());
		c6.setBENFITAMOUNT(1500.0);
		c6.setTERMNATION_REASON("Due to insecure funds");

		// Food Plan

		CitizenPlan c7 = new CitizenPlan();
		c7.setCITEGEN_NAME("raj");
		c7.setCITEGEN_GENDER("male");
		c7.setCITEGEN_PLAN_NAME("food");
		c7.setCITEGEN_PLAN_STATUS("approved");
		c7.setSTART_DATE(LocalDate.now());
		c7.setEND_DATE(LocalDate.now().plusMonths(6));
		c7.setBENFITAMOUNT(6500.0);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCITEGEN_NAME("Ram");
		c8.setCITEGEN_GENDER("male");
		c8.setCITEGEN_PLAN_NAME("food");
		c8.setCITEGEN_PLAN_STATUS("denied");
		c8.setDENAIAL_REASON("insuffient balance");

		CitizenPlan c9 = new CitizenPlan();
		c9.setCITEGEN_NAME("Ravi");
		c9.setCITEGEN_GENDER("male");
		c9.setCITEGEN_PLAN_NAME("food");
		c9.setCITEGEN_PLAN_STATUS("terminated");
		c9.setSTART_DATE(LocalDate.now().minusMonths(6));
		c9.setEND_DATE(LocalDate.now().plusMonths(4));
		c9.setTERIMINATED_DATE(LocalDate.now());
		c9.setBENFITAMOUNT(1500.0);
		c9.setTERMNATION_REASON("Got a New Job");

		CitizenPlan c10 = new CitizenPlan();
		c10.setCITEGEN_NAME("sita");
		c10.setCITEGEN_GENDER("female");
		c10.setCITEGEN_PLAN_NAME("food");
		c10.setCITEGEN_PLAN_STATUS("approved");
		c10.setSTART_DATE(LocalDate.now());
		c10.setEND_DATE(LocalDate.now().plusMonths(6));
		c10.setBENFITAMOUNT(7500.0);

		CitizenPlan c11 = new CitizenPlan();
		c11.setCITEGEN_NAME("vineetha");
		c11.setCITEGEN_GENDER("female");
		c11.setCITEGEN_PLAN_NAME("food");
		c11.setCITEGEN_PLAN_STATUS("denied");
		c11.setDENAIAL_REASON("Account Balance Is To low");

		CitizenPlan c12 = new CitizenPlan();
		c12.setCITEGEN_NAME("bindhu");
		c12.setCITEGEN_GENDER("female");
		c12.setCITEGEN_PLAN_NAME("food");
		c12.setCITEGEN_PLAN_STATUS("terminated");
		c12.setSTART_DATE(LocalDate.now().minusMonths(6));
		c12.setEND_DATE(LocalDate.now().plusMonths(4));
		c12.setTERIMINATED_DATE(LocalDate.now());
		c12.setBENFITAMOUNT(6500.0);
		c12.setTERMNATION_REASON("Due to insecure funds");

		// Medical Plan

		CitizenPlan c13 = new CitizenPlan();
		c13.setCITEGEN_NAME("Ramesh");
		c13.setCITEGEN_GENDER("male");
		c13.setCITEGEN_PLAN_NAME("medical");
		c13.setCITEGEN_PLAN_STATUS("approved");
		c13.setSTART_DATE(LocalDate.now());
		c13.setEND_DATE(LocalDate.now().plusMonths(6));
		c13.setBENFITAMOUNT(2500.0);

		CitizenPlan c14 = new CitizenPlan();
		c14.setCITEGEN_NAME("Suresh");
		c14.setCITEGEN_GENDER("male");
		c14.setCITEGEN_PLAN_NAME("medical");
		c14.setCITEGEN_PLAN_STATUS("denied");
		c14.setDENAIAL_REASON("Over Account Balance");

		CitizenPlan c15 = new CitizenPlan();
		c15.setCITEGEN_NAME("Viraj");
		c15.setCITEGEN_GENDER("male");
		c15.setCITEGEN_PLAN_NAME("medical");
		c15.setCITEGEN_PLAN_STATUS("terminated");
		c15.setSTART_DATE(LocalDate.now().minusMonths(6));
		c15.setEND_DATE(LocalDate.now().plusMonths(5));
		c15.setTERIMINATED_DATE(LocalDate.now());
		c15.setBENFITAMOUNT(3500.0);
		c15.setTERMNATION_REASON("Got a New Job");

		CitizenPlan c16 = new CitizenPlan();
		c16.setCITEGEN_NAME("vani");
		c16.setCITEGEN_GENDER("female");
		c16.setCITEGEN_PLAN_NAME("medical");
		c16.setCITEGEN_PLAN_STATUS("approved");
		c16.setSTART_DATE(LocalDate.now());
		c16.setEND_DATE(LocalDate.now().plusMonths(6));
		c16.setBENFITAMOUNT(9500.0);

		CitizenPlan c17 = new CitizenPlan();
		c17.setCITEGEN_NAME("Swathi");
		c17.setCITEGEN_GENDER("female");
		c17.setCITEGEN_PLAN_NAME("medical");
		c17.setCITEGEN_PLAN_STATUS("denied");
		c17.setDENAIAL_REASON("Account Balance Is To low");

		CitizenPlan c18 = new CitizenPlan();
		c18.setCITEGEN_NAME("indhu");
		c18.setCITEGEN_GENDER("female");
		c18.setCITEGEN_PLAN_NAME("medical");
		c18.setCITEGEN_PLAN_STATUS("terminated");
		c18.setSTART_DATE(LocalDate.now().minusMonths(6));
		c18.setEND_DATE(LocalDate.now().plusMonths(4));
		c18.setTERIMINATED_DATE(LocalDate.now());
		c18.setBENFITAMOUNT(2000.0);
		c18.setTERMNATION_REASON("Due to insecure funds");

		// employment Plan

		CitizenPlan c19 = new CitizenPlan();
		c19.setCITEGEN_NAME("Eshwar");
		c19.setCITEGEN_GENDER("male");
		c19.setCITEGEN_PLAN_NAME("employment");
		c19.setCITEGEN_PLAN_STATUS("approved");
		c19.setSTART_DATE(LocalDate.now());
		c19.setEND_DATE(LocalDate.now().plusMonths(6));
		c19.setBENFITAMOUNT(3500.0);

		CitizenPlan c20 = new CitizenPlan();
		c20.setCITEGEN_NAME("raju");
		c20.setCITEGEN_GENDER("male");
		c20.setCITEGEN_PLAN_NAME("employment");
		c20.setCITEGEN_PLAN_STATUS("denied");
		c20.setDENAIAL_REASON("Over Account Balance");

		CitizenPlan c21 = new CitizenPlan();
		c21.setCITEGEN_NAME("Bargav");
		c21.setCITEGEN_GENDER("male");
		c21.setCITEGEN_PLAN_NAME("employment");
		c21.setCITEGEN_PLAN_STATUS("terminated");
		c21.setSTART_DATE(LocalDate.now().minusMonths(6));
		c21.setEND_DATE(LocalDate.now().plusMonths(1));
		c21.setTERIMINATED_DATE(LocalDate.now());
		c21.setBENFITAMOUNT(500.0);
		c21.setTERMNATION_REASON("Got a New Job");

		CitizenPlan c22 = new CitizenPlan();
		c22.setCITEGEN_NAME("Bavya");
		c22.setCITEGEN_GENDER("female");
		c22.setCITEGEN_PLAN_NAME("employment");
		c22.setCITEGEN_PLAN_STATUS("approved");
		c22.setSTART_DATE(LocalDate.now());
		c22.setEND_DATE(LocalDate.now().plusMonths(6));
		c22.setBENFITAMOUNT(5500.0);

		CitizenPlan c23 = new CitizenPlan();
		c23.setCITEGEN_NAME("Geetha");
		c23.setCITEGEN_GENDER("female");
		c23.setCITEGEN_PLAN_NAME("employment");
		c23.setCITEGEN_PLAN_STATUS("denied");
		c23.setDENAIAL_REASON("Account Balance Is To low");

		CitizenPlan c24 = new CitizenPlan();
		c24.setCITEGEN_NAME("Shilpa");
		c24.setCITEGEN_GENDER("female");
		c24.setCITEGEN_PLAN_NAME("employment");
		c24.setCITEGEN_PLAN_STATUS("terminated");
		c24.setSTART_DATE(LocalDate.now().minusMonths(6));
		c24.setEND_DATE(LocalDate.now().plusMonths(5));
		c24.setTERIMINATED_DATE(LocalDate.now());
		c24.setBENFITAMOUNT(1500.0);
		c24.setTERMNATION_REASON("Due to insecure funds");

		List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16,
				c17, c18, c19, c20, c21, c22, c23, c24);
		repositroy.saveAll(list);

	}

}
