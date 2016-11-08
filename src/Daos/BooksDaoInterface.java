/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Books;
import java.util.ArrayList;

public interface BooksDaoInterface {

    public ArrayList<Books> getAllBooks();

    public Books showAllBooks();

    public String getLibraryInfo(String library);

    public void addBooks();

    public void deleteBook();

    public String readString();

    public Books getBookById(int id);

    public void updateBook();

    public void updateTitle(int id, String title);

    public void updateAuthorLast(int id, String last);

    public void updateAuthorFirst(int id, String first);

    public void updatePublisher(int id, String publisher);

    public void updateYearPublished(int id, int yearPublished);

    public void updateSubject(int id, String subject);

    public void updateIsbn(int id, String isbn);

    public void updateCopies(int id, int copiesRemaining);

    public int getNumberOfCopies(int bookId);
}
