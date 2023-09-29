package dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AdminDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String user_name;
	private String password;
	
	@OneToMany(mappedBy = "adminDto")
	private List<LibrarianDto> librarianDto;
	

	public List<LibrarianDto> getLibrarianDto() {
		return librarianDto;
	}

	public void setLibrarianDto(List<LibrarianDto> librarianDto) {
		this.librarianDto = librarianDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
