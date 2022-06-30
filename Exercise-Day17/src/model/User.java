package model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable,Comparable<User>{

	int userId;
	String username;
	String password;
	String securityQuestion;
	String securityQuestionAns;
	int productId;
	List<Product> purchaseProduct;
	
	public User() {
		super();
	}

	
	
	public User(int userId, String username, String password, String securityQuestion, String securityQuestionAns) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityQuestionAns = securityQuestionAns;
	}



	public User(int userId, String username, String password, String securityQuestion, String securityQuestionAns,
			int productId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityQuestionAns = securityQuestionAns;
		this.productId = productId;
	}





	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}





	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityQuestionAns() {
		return securityQuestionAns;
	}
	public void setSecurityQuestionAns(String securityQuestionAns) {
		this.securityQuestionAns = securityQuestionAns;
	}
	public List<Product> getPurchaseProduct() {
		return purchaseProduct;
	}
	public void setPurchaseProduct(List<Product> purchaseProduct) {
		this.purchaseProduct = purchaseProduct;
	}
	
	
	@Override
	public String toString() {
		return "UserId=" + userId + ", username=" + username + ", password=" + password + ", securityQuestion="
				+ securityQuestion + ", securityQuestionAns=" + securityQuestionAns + ", purchaseProduct="
				+ purchaseProduct ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((purchaseProduct == null) ? 0 : purchaseProduct.hashCode());
		result = prime * result + ((securityQuestion == null) ? 0 : securityQuestion.hashCode());
		result = prime * result + ((securityQuestionAns == null) ? 0 : securityQuestionAns.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (purchaseProduct == null) {
			if (other.purchaseProduct != null)
				return false;
		} else if (!purchaseProduct.equals(other.purchaseProduct))
			return false;
		if (securityQuestion == null) {
			if (other.securityQuestion != null)
				return false;
		} else if (!securityQuestion.equals(other.securityQuestion))
			return false;
		if (securityQuestionAns == null) {
			if (other.securityQuestionAns != null)
				return false;
		} else if (!securityQuestionAns.equals(other.securityQuestionAns))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public int compareTo(User o2) {
		return this.userId-o2.userId;
	}
	
	
}
