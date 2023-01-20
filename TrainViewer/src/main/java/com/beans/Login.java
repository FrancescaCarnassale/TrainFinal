package com.beans;
/** The Login class is used to let the users login on the webpage **/
public class Login implements BeanVo{
	private String email, password;

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
}
