package beans;

public class Client {
	
	private String login, password, lastname, firstname;
	
	public Client() {}

	public Client(String login, String password, String firstname, String lastname) {
		super();
		this.login = login;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	
	
}
