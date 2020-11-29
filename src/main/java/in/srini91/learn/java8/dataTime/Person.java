package in.srini91.learn.java8.dataTime;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

	private String name;
	private LocalDate dob;

}
