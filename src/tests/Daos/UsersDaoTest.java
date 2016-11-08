/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.Daos;

import Daos.UsersDao;
import Dtos.Users;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bassy
 */
public class UsersDaoTest {
    
    public UsersDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllUsers method, of class UsersDao.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UsersDao instance = new UsersDao();
        ArrayList<Users> expResult = null;
        ArrayList<Users> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UsersDao.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        int id = 0;
        UsersDao instance = new UsersDao();
        Users expResult = null;
        Users result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInfo method, of class UsersDao.
     */
    @Test
    public void testGetUserInfo() {
        System.out.println("getUserInfo");
        String login = "";
        String password = "";
        UsersDao instance = new UsersDao();
        Users expResult = null;
        Users result = instance.getUserInfo(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShortUserInfo method, of class UsersDao.
     */
    @Test
    public void testGetShortUserInfo() {
        System.out.println("getShortUserInfo");
        String login = "";
        String password = "";
        UsersDao instance = new UsersDao();
        String expResult = "";
        String result = instance.getShortUserInfo(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserLogin method, of class UsersDao.
     */
    @Test
    public void testCheckUserLogin() {
        System.out.println("checkUserLogin");
        Users u = null;
        UsersDao instance = new UsersDao();
        boolean expResult = false;
        boolean result = instance.checkUserLogin(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserEmail method, of class UsersDao.
     */
    @Test
    public void testCheckUserEmail() {
        System.out.println("checkUserEmail");
        Users u = null;
        UsersDao instance = new UsersDao();
        boolean expResult = false;
        boolean result = instance.checkUserEmail(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserDetails method, of class UsersDao.
     */
    @Test
    public void testCheckUserDetails() {
        System.out.println("checkUserDetails");
        boolean email = false;
        boolean login = false;
        UsersDao instance = new UsersDao();
        boolean expResult = false;
        boolean result = instance.checkUserDetails(email, login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UsersDao.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        UsersDao instance = new UsersDao();
        instance.addUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UsersDao.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        UsersDao instance = new UsersDao();
        instance.deleteUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readString method, of class UsersDao.
     */
    @Test
    public void testReadString() {
        System.out.println("readString");
        UsersDao instance = new UsersDao();
        String expResult = "";
        String result = instance.readString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
