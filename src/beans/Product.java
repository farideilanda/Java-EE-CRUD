package beans;

public class Product {
	
	private String designation, quantity, client;

	public Product(String designation, String quantity, String client) {
		super();
		this.designation = designation;
		this.quantity = quantity;
		this.client = client;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	
}
