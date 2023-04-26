package in.eshwarnaz.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "CITEZEN_PALN_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class CitizenPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CITEGEN_ID;
	private String CITEGEN_NAME;
	private String CITEGEN_GENDER;
	private String CITEGENPLANNAME;
	private String CITEGENPLANSTATUS;
	private LocalDate START_DATE;
	private LocalDate END_DATE;
	private Double BENFITAMOUNT;
	private String DENAIAL_REASON;
	private LocalDate TERIMINATED_DATE;
	private String TERMNATION_REASON;

}
