package com.beans;

public class User implements Bean {
	private String name, email, password;
	private String role;

    public String getRole() {
		return role;
	}

	public void setRole(String admin) {
		this.role = admin;
	}

	public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", admin=" + role + "]";
	}
}
