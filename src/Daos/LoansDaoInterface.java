/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Books;
import Dtos.Loans;
import java.util.ArrayList;

public interface LoansDaoInterface {

    public ArrayList<Loans> getAllLoans();

    public ArrayList<Books> getAllBooksLoaned(int id);

    public boolean isReturnDateNull(int userId, int bookId);

    public void borrowBook(int userId);

    public void returnBook(int userId);
}
