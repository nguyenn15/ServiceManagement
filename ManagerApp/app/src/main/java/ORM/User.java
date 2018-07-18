package ORM;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("address")
	@Expose
	private String address;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("fone")
	@Expose
	private String fone;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("idType")
	@Expose
	private Integer idType;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("password")
	@Expose
	private String password;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}