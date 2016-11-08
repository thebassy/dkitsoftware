/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/*Author Niall McHugh */
import Dtos.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UsersDao extends Dao implements UsersDaoInterface {

    /**
     * Returns an ArrayList of {@code Users} objects based on information in the database. All 
     * users entries in the Users table are selected from the database and stored
     * as {@code Users} objects in a {@code ArrayList}.
     * 
     * @return The {@code ArrayList} of all user entries in the Users table. 
     * This {@code ArrayList} may be empty where no products are present in the database.
     */
    @Override
    public ArrayList<Users> getAllUsers() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Users> allUsers = new ArrayList<>();

        try {
            con = getConnection();
            String query = "SELECT * FROM users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                Users u = new Users();

                u.setUserId(rs.getInt("userId"));
                u.setLastName(rs.getString("lastName"));
                u.setFirstName(rs.getString("firstName"));
                u.setUserLogin(rs.getString("userLogin"));
                u.setPassword(rs.getString("userPassword"));
                u.setAddress(rs.getString("address"));
                u.setEmail(rs.getString("email"));
                u.setUserType(rs.getInt("userType"));

                allUsers.add(u);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllUsers() method");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllUsers() method");
                e.printStackTrace();
            }
        }
        return allUsers;
    }

    /**
     * Searches for a Users entry from the database by matching the userId
     * supplied as a parameter
     *
     * @param id the id of the user to be found in the database
     * @return the {@code Users} contained in the database matching the user Id
     * supplied
     */
    @Override
    public Users getUserById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users userById = new Users();

        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE userId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                userById = new Users(rs.getInt("userId"), rs.getString("lastName"), rs.getString("firstName"), rs.getString("userLogin"), rs.getString("userPassword"), rs.getString("address"), rs.getString("email"), rs.getInt("userType"));

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getUserById() method");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getUserById() method");
                e.printStackTrace();
            }
        }
        return userById;
    }

    /**
     * Searches for a Users entry from the database by matching the user Login
     * and user password supplied as a parameter
     * 
     * @param login the user Login of the user to be found in the database
     * @param password the user password of the user to be found in the database
     * @return the {@code Users} contained in the database matching the
     * user login and password supplied
     */
    @Override
    public Users getUserInfo(String login, String password) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users userInfo = new Users();

        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE userLogin = ? AND userPassword = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {

                userInfo = new Users(rs.getInt("userId"), rs.getString("lastName"), rs.getString("firstName"), rs.getString("userLogin"), rs.getString("userPassword"), rs.getString("address"), rs.getString("email"), rs.getInt("userType"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getUserInfo() method");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getUserInfo() method");
                e.printStackTrace();
            }
        }

        return userInfo;
    }

    /**
     * Searches for a Users entry from the database by matching the user Login
     * and user password supplied as a parameter. Then takes certain fields from
     * the Users entry and adds them to a String to be returned. Also converts the
     * Users usertype to a readable String and adds this to the String information
     * to be returned
     * 
     * @param login the user Login of the user to be found in the database
     * @param password the user password of the user to be found in the database
     * @return the {@code String} populated by row entries from the database matching 
     * the user login and password supplied
     */
    @Override
    public String getShortUserInfo(String login, String password) {
        Users userInfo = getUserInfo(login, password);
        String userType = null;
        if (userInfo.getUserType() == 1) {
            userType = "Administrator";
        } else if (userInfo.getUserType() == 0) {
            userType = "Student";
        }
        String shortInfo = "\nUserDetails: \nSurname: " + userInfo.getLastName() + "\nFirst name: " + userInfo.getFirstName() + "\nAddress: " + userInfo.getAddress() + "\nEmail: " + userInfo.getEmail() + "\nUser Type: " + userType + "\n";
        return shortInfo;
    }

    /**
     * Gets the Users that has been passed in the parameters and finds the Users login
     * details, then checks it against Users login entries in the database. If it exists in
     * the database the boolean returns false, otherwise it returns a true value.
     * 
     * @param u the User which login data is to be checked
     * @return the {@code boolean} which will be false if the login exists in the database
     * but true otherwise
     */
    @Override
    public boolean checkUserLogin(Users u) {
        ArrayList<Users> checkList = getAllUsers();
        Users checkUser = u;
        boolean check = false;

        for (Users cl : checkList) {
            if (cl.getUserLogin().equals(checkUser.getUserLogin())) {
                check = false;
                System.out.println("Login already exists");
            } else {
                check = true;
            }
        }
        return check;
    }

    /**
     * Gets the Users that has been passed in the parameters and finds the Users email
     * details, then checks it against Users email entries in the database. If it exists in
     * the database the boolean returns false, otherwise it returns a true value.
     * 
     * @param u the User which email data is to be checked
     * @return the {@code boolean} which will be false if the email exists in the database
     * but true otherwise
     */
    @Override
    public boolean checkUserEmail(Users u) {
        ArrayList<Users> checkList = getAllUsers();
        Users checkUser = u;
        boolean check = false;

        for (Users cl : checkList) {
            if (cl.getEmail().equals(checkUser.getEmail())) {
                check = false;
                System.out.println("User already exists");
            } else {
                check = true;
            }
        }
        return check;
    }

    /**
     * checks if the email exists in the database and if it returns true then checks 
     * if the login exists in the database. if both return true then the method returns a 
     * true value
     * 
     * @param email the {@code boolean}email in the database which is to be checked. uses checkUserEmail()
     * @param login the {@code boolean}login in the database which is to be checked. uses checkUserLogin()
     * @return the {@code boolean} which will be false if the login or email exists in the database
     * but true otherwise
     */
    @Override
    public boolean checkUserDetails(boolean email, boolean login) {
        boolean check = false;

        if (email == true) {
            if (login == true) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    /**
     * Adds a new {@code Users} to the database in Users table
     * Prompts you to enter new Login, Password, LastName, FirstName, Address, and Email.
     */
    @Override
    public void addUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("input new users login name:");
        String newLogin = input.next();
        System.out.println("input new users password:");
        String newPassword = input.next();
        System.out.println("input new users last name:");
        String newLastName = input.next();
        System.out.println("input new users first name:");
        String newFirstName = input.next();
        System.out.println("input new users address:");
        String newAddress = readString();
        System.out.println("type new users email:");
        String newEmail = input.next();

        Users newUser = new Users(0, newLastName, newFirstName, newLogin, newPassword, newAddress, newEmail, 0);

        Connection conn = null;
        PreparedStatement ps = null;

        Users add = newUser;
        boolean check = checkUserDetails(checkUserEmail(newUser), checkUserLogin(newUser));
        int rowsAffected = 0;

        if (check == true) {
            try {

                conn = getConnection();
                ps = conn.prepareStatement("INSERT INTO users(lastName, firstName, userLogin, userPassword, address, email, userType) VALUES(?,?,?,?,?,?,0)");

                ps.setString(1, add.getLastName());
                ps.setString(2, add.getFirstName());
                ps.setString(3, add.getUserLogin());
                ps.setString(4, add.getPassword());
                ps.setString(5, add.getAddress());
                ps.setString(6, add.getEmail());

                rowsAffected = ps.executeUpdate();

            } catch (SQLException se) {
                System.out.println("SQL Exception occurred: " + se.getMessage());
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            } finally {

                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println("Exception occurred when attempting to close the PreparedStatement: " + ex.getMessage());
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        System.out.println("Exception occurred when attempting to close the Connection: " + ex.getMessage());
                    }
                }
            }
        }
        if (rowsAffected > 0) {
            System.out.println("User added successfully.");
        } else if (rowsAffected == -1) {
            System.out.println("The User id supplied already exists. Please check the Customer details and try again.");
        } else if (rowsAffected == 0) {
            System.out.println("Nothing Happened");
        } else {
            System.out.println("The User could not be added at this time.");
        }

    }

    /**
     * Deletes an {@code Users} from the Users table of the database
     * based on the UserId provided
     * Also checks that the User is not of type Administrator
     */
    @Override
    public void deleteUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("input the userid you wish to delete");
        int id = input.nextInt();
        Users u = getUserById(id);

        Connection conn = null;
        PreparedStatement ps = null;

        if (u.getUserType() == 0) {
            try {

                conn = getConnection();
                ps = conn.prepareStatement("DELETE FROM users WHERE userId = ? AND userType != 1");
                ps.setInt(1, id);
                ps.execute();
                System.out.println("User Deleted");
            } catch (SQLException se) {
                System.out.println("SQL Exception occurred: " + se.getMessage());
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            } finally {

                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println("Exception occurred when attempting to close the PreparedStatement: " + ex.getMessage());
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        System.out.println("Exception occurred when attempting to close the Connection: " + ex.getMessage());
                    }
                }
            }
        } else {
            System.out.println("Cannot delete an Administrator");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
