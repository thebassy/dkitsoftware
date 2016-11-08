/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Users;
import java.util.ArrayList;

public interface UsersDaoInterface {

    public ArrayList<Users> getAllUsers();

    public Users getUserById(int id);

    public Users getUserInfo(String login, String password);

    public String getShortUserInfo(String login, String Password);

    public void addUser();

    public boolean checkUserLogin(Users u);

    public boolean checkUserEmail(Users u);

    public boolean checkUserDetails(boolean email, boolean login);

    public void deleteUser();

    public String readString();
}
