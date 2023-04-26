package in.eshwarnaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.eshwarnaz.entity.CitizenPlan;

public interface CitizenPlanRepositroy extends JpaRepository<CitizenPlan, Integer> {

	@Query("select distinct(CITEGENPLANNAME) from CitizenPlan")
	public List<String> getPlanNames();

	@Query("select distinct(CITEGENPLANSTATUS) from CitizenPlan")
	public List<String> getPlanStatus();

}
