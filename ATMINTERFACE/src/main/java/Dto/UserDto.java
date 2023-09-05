package Dto;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class UserDto {
	@Id
	@SequenceGenerator(initialValue = 2801, allocationSize = 1, sequenceName = "user_id", name = "user_id")
	@GeneratedValue(generator = "user_id")
	int user_id;
	String name;
	String pin;
	long mobile;
	Date dob;
	String gender;
	
	

}
