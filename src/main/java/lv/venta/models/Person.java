package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Person {
	
	@Column(name = "Idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idp;
	
	@Column(name = "Name") 
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	@Size(min = 4, max = 100)
	private String name;
	
	@Column(name = "Surname")  
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	@Size(min = 4, max = 100)
	private String surname;

	public Person(@NotNull @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") @Size(min = 4, max = 100) String name,
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") @Size(min = 4, max = 100) String surname) {
		this.name = name;
		this.surname = surname;
	}
	

}
