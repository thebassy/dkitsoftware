/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

public class Users {

    private int userId;
    private String lastName;
    private String firstName;
    private String userLogin;
    private String password;
    private String address;
    private String email;
    private int userType;

    public Users(int userId, String lastName, String firstName, String userLogin, String password, String address, String email, int userType) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userLogin = userLogin;
        this.password = password;
        this.address = address;
        this.email = email;
        this.userType = userType;
    }

    public Users() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.userId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "users{" + "userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", userLogin=" + userLogin + ", password=" + password + ", address=" + address + ", email=" + email + ", userType=" + userType + '}';
    }

}
