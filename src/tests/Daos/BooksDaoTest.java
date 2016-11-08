/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.Daos;

import Daos.BooksDao;
import Dtos.Books;
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
public class BooksDaoTest {
    
    public BooksDaoTest() {
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
     * Test of getAllBooks method, of class BooksDao.
     */
    @Test
    public void testGetAllBooks() {
        System.out.println("getAllBooks");
        BooksDao instance = new BooksDao();
        ArrayList<Books> expResult = null;
        ArrayList<Books> result = instance.getAllBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAllBooks method, of class BooksDao.
     */
    @Test
    public void testShowAllBooks() {
        System.out.println("showAllBooks");
        BooksDao instance = new BooksDao();
        Books expResult = null;
        Books result = instance.showAllBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibraryInfo method, of class BooksDao.
     */
    @Test
    public void testGetLibraryInfo() {
        System.out.println("getLibraryInfo");
        String library = "";
        BooksDao instance = new BooksDao();
        String expResult = "";
        String result = instance.getLibraryInfo(library);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBooks method, of class BooksDao.
     */
    @Test
    public void testAddBooks() {
        System.out.println("addBooks");
        BooksDao instance = new BooksDao();
        instance.addBooks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBook method, of class BooksDao.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        BooksDao instance = new BooksDao();
        instance.deleteBook();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readString method, of class BooksDao.
     */
    @Test
    public void testReadString() {
        System.out.println("readString");
        BooksDao instance = new BooksDao();
        String expResult = "";
        String result = instance.readString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookById method, of class BooksDao.
     */
    @Test
    public void testGetBookById() {
        System.out.println("getBookById");
        int id = 0;
        BooksDao instance = new BooksDao();
        Books expResult = null;
        Books result = instance.getBookById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBook method, of class BooksDao.
     */
    @Test
    public void testUpdateBook() {
        System.out.println("updateBook");
        BooksDao instance = new BooksDao();
        instance.updateBook();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTitle method, of class BooksDao.
     */
    @Test
    public void testUpdateTitle() {
        System.out.println("updateTitle");
        int id = 0;
        String title = "";
        BooksDao instance = new BooksDao();
        instance.updateTitle(id, title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAuthorLast method, of class BooksDao.
     */
    @Test
    public void testUpdateAuthorLast() {
        System.out.println("updateAuthorLast");
        int id = 0;
        String last = "";
        BooksDao instance = new BooksDao();
        instance.updateAuthorLast(id, last);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAuthorFirst method, of class BooksDao.
     */
    @Test
    public void testUpdateAuthorFirst() {
        System.out.println("updateAuthorFirst");
        int id = 0;
        String first = "";
        BooksDao instance = new BooksDao();
        instance.updateAuthorFirst(id, first);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePublisher method, of class BooksDao.
     */
    @Test
    public void testUpdatePublisher() {
        System.out.println("updatePublisher");
        int id = 0;
        String publisher = "";
        BooksDao instance = new BooksDao();
        instance.updatePublisher(id, publisher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateYearPublished method, of class BooksDao.
     */
    @Test
    public void testUpdateYearPublished() {
        System.out.println("updateYearPublished");
        int id = 0;
        int yearPublished = 0;
        BooksDao instance = new BooksDao();
        instance.updateYearPublished(id, yearPublished);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSubject method, of class BooksDao.
     */
    @Test
    public void testUpdateSubject() {
        System.out.println("updateSubject");
        int id = 0;
        String subject = "";
        BooksDao instance = new BooksDao();
        instance.updateSubject(id, subject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateIsbn method, of class BooksDao.
     */
    @Test
    public void testUpdateIsbn() {
        System.out.println("updateIsbn");
        int id = 0;
        String isbn = "";
        BooksDao instance = new BooksDao();
        instance.updateIsbn(id, isbn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCopies method, of class BooksDao.
     */
    @Test
    public void testUpdateCopies() {
        System.out.println("updateCopies");
        int id = 0;
        int copiesRemaining = 0;
        BooksDao instance = new BooksDao();
        instance.updateCopies(id, copiesRemaining);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfCopies method, of class BooksDao.
     */
    @Test
    public void testGetNumberOfCopies() {
        System.out.println("getNumberOfCopies");
        int bookId = 0;
        BooksDao instance = new BooksDao();
        int expResult = 0;
        int result = instance.getNumberOfCopies(bookId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
