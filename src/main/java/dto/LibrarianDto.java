package dto;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LibrarianDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String User_name;
	private String Password;
	private String status;
	
	@OneToMany(mappedBy = "librarianDto")
	private List<BookDto> bookDto;	

	public List<BookDto> getBookDto() {
		return bookDto;
	}

	public void setBookDto(List<BookDto> bookDto) {
		this.bookDto = bookDto;
	}

	@ManyToOne
	@JoinColumn
	private AdminDto adminDto;

	public AdminDto getAdminDto() {
		return adminDto;
	}

	public void setAdminDto(AdminDto adminDto) {
		this.adminDto = adminDto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
