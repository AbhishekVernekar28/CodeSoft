package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Studentdto {
	@Id
	int Rollnumber;
	String Name;
	String Grade;
	
}
