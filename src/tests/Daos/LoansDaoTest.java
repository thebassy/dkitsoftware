/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.Daos;

import Daos.LoansDao;
import Dtos.Books;
import Dtos.Loans;
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
public class LoansDaoTest {
    
    public LoansDaoTest() {
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
     * Test of getAllLoans method, of class LoansDao.
     */
    @Test
    public void testGetAllLoans() {
        System.out.println("getAllLoans");
        LoansDao instance = new LoansDao();
        ArrayList<Loans> expResult = null;
        ArrayList<Loans> result = instance.getAllLoans();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBooksLoaned method, of class LoansDao.
     */
    @Test
    public void testGetAllBooksLoaned() {
        System.out.println("getAllBooksLoaned");
        int id = 0;
        LoansDao instance = new LoansDao();
        ArrayList<Books> expResult = null;
        ArrayList<Books> result = instance.getAllBooksLoaned(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrowBook method, of class LoansDao.
     */
    @Test
    public void testBorrowBook() {
        System.out.println("borrowBook");
        int userId = 0;
        LoansDao instance = new LoansDao();
        instance.borrowBook(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isReturnDateNull method, of class LoansDao.
     */
    @Test
    public void testIsReturnDateNull() {
        System.out.println("isReturnDateNull");
        int userId = 0;
        int bookId = 0;
        LoansDao instance = new LoansDao();
        boolean expResult = false;
        boolean result = instance.isReturnDateNull(userId, bookId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnBook method, of class LoansDao.
     */
    @Test
    public void testReturnBook() {
        System.out.println("returnBook");
        int userId = 0;
        LoansDao instance = new LoansDao();
        instance.returnBook(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
