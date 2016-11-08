/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/**
 *
 * @author niall, sebastian
 */
import Dtos.Loans;
import Dtos.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LoansDao extends Dao implements LoansDaoInterface {

    /**
     * Returns an ArrayList of {@code Loans} objects based on information in the
     * database. All loan entries in the Loan table are selected from the
     * database and stored as {@code Loans} objects in a {@code ArrayList}.
     *
     * @return The {@code ArrayList} of all book entries in the Books table.
     * This {@code ArrayList} may be empty where no products are present in the
     * database.
     */
    @Override
    public ArrayList<Loans> getAllLoans() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Loans> allLoans = new ArrayList<>();

        try {
            con = getConnection();
            String query = "SELECT * FROM loan";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                Loans l = new Loans();

                l.setLoanId(rs.getInt("loanId"));
                l.setBookId(rs.getInt("bookId"));
                l.setUserId(rs.getInt("userId"));
                l.setDateStamp(rs.getDate("dateStamp"));
                l.setDueDate(rs.getDate("dueDate"));
                l.setReturnDate(rs.getDate("returnDate"));

                allLoans.add(l);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllLoans() method");
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
                System.out.println("Exception occured in the finally section of the getAllLoans() method");
                e.printStackTrace();
            }
        }
        return allLoans;
    }

    /**
     * Searches for a Loan entry from the database by matching the userId
     * supplied as a parameter
     * 
     * @param userId the id of the user used to get all loans
     * @return {@code ArrayList} returns an ArrayList of books based on userId
     * in the loan table
     */
    @Override
    public ArrayList<Books> getAllBooksLoaned(int userId) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Books> allBooks = new ArrayList<>();

        try {
            con = getConnection();
            String query = "SELECT * FROM loan, books WHERE loan.bookId = books.bookId AND loan.userId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {

                Books b = new Books();

                b.setBookId(rs.getInt("bookId"));
                b.setTitle(rs.getString("title"));
                b.setAuthorLastName(rs.getString("authorLastName"));
                b.setAuthorFirstName(rs.getString("authorFirstName"));
                b.setPublisher(rs.getString("publisher"));
                b.setYearPublished(rs.getInt("yearPublished"));
                b.setSubject(rs.getString("subject"));
                b.setIsbn(rs.getString("isbn"));
                b.setCopiesRemaining(rs.getInt("copiesRemaining"));

                LoansDao ld = new LoansDao();
                boolean isReturned = ld.isReturnDateNull(userId, b.getBookId());

                if (isReturned == true) {
                    allBooks.add(b);
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllBooksLoaned() method");
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
                System.out.println("Exception occured in the finally section of the getAllBooksLoaned() method");
                e.printStackTrace();
            }
        }

        return allBooks;
    }

    /**
     * checks if a return date has been entered in the returnDate column of the database
     * based on the userId and bookId supplied for the loan
     * 
     * @param userId the userId in the loan entry
     * @param bookId the bookId in the loan entry
     * @return {@code boolean} is true if the returnDate is still null 
     * otherwise returns a false value
     */
    @Override
    public boolean isReturnDateNull(int userId, int bookId) {
        boolean isReturnDateNull = false;
        Date isNull = null;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String query = "SELECT returnDate FROM loan WHERE userId = ? AND bookId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            rs = ps.executeQuery();

            if (rs.next()) {

                isNull = rs.getDate("returnDate");

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the isReturnDateNull() method");
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
                System.out.println("Exception occured in the finally section of the isReturnDateNull() method");
                e.printStackTrace();
            }
        }

        if (isNull == null) {
            isReturnDateNull = true;
        } else {
            isReturnDateNull = false;
        }
        return isReturnDateNull;

    }

    /**
     * Borrows a book by inserting a new loan into the Loan table with the userId and asks for 
     * the corresponding bookId that the user wishes to loan. Also sets the dateStamp and return date
     * in the database and changes the number of copies by 1 of the book with the bookId that is borrowed
     * 
     * @param userId the id of the user borrowing the book
     */
    @Override
    public void borrowBook(int userId) {
        Scanner input = new Scanner(System.in);
        int copiesRemaining = 0;

        System.out.println("Please enter the bookId of the book you wish to borrow:");
        int bookId = input.nextInt();

        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-mm-dd");

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date dateStamp = new java.sql.Date(utilDate.getTime());
        sdfInput.format(dateStamp);
        java.sql.Date dueDate = new java.sql.Date(dateStamp.getTime() + (1000 * 60 * 60 * 504));
        BooksDao bd = new BooksDao();
        copiesRemaining = bd.getNumberOfCopies(bookId);

        Loans newLoans = new Loans(0, bookId, userId, dateStamp, dueDate, null);

        if (copiesRemaining > 0) {

            Connection conn = null;
            PreparedStatement ps = null;

            Loans add = newLoans;
            int rowsAffected = 0;

            try {

                conn = getConnection();
                ps = conn.prepareStatement("INSERT INTO loan(bookId, userId, dateStamp, dueDate) VALUES (?,?,?,?)");
                ps.setInt(1, add.getBookId());
                ps.setInt(2, add.getUserId());
                ps.setDate(3, add.getDateStamp());
                ps.setDate(4, add.getDueDate());

                rowsAffected = ps.executeUpdate();
                bd.updateCopies(bookId, copiesRemaining - 1);

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
            if (rowsAffected > 0) {
                System.out.println("Book borrowed successfully.");
            } else if (rowsAffected == -1) {
                System.out.println("The Book is unavailable.");
            } else if (rowsAffected == 0) {
                System.out.println("Nothing Happened");
            } else {
                System.out.println("The Book could not be borrowed at this time.");
            }

        } else {
            System.out.println("No copies of this book are currently available");
        }

    }

    /**
     * Returns a book by checking the loan table based on the userId and then checking that the 
     * returnDate is null meaning it has not been returned. Also prompts for the id of the Book 
     * to be returned and checks that this user has the book on loan
     * 
     * @param userId the id of the user borrowing the book
     */
    @Override
    public void returnBook(int userId) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the bookId you wish to return");
        int bookId = input.nextInt();

        ArrayList<Books> booksOnLoan = getAllBooksLoaned(userId);
        int loanedBookId = 0;

        for (Books b : booksOnLoan) {
            if (bookId == b.getBookId()) {
                if (isReturnDateNull(userId, bookId) == true) {
                    loanedBookId = b.getBookId();
                }
            }
        }

        if (loanedBookId == 0) {
            System.out.println("You do not have this book on loan");
        } else {

            Connection conn = null;
            PreparedStatement ps = null;

            int rowsAffected = 0;

            SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date returnDate = new java.sql.Date(utilDate.getTime());
            sdfInput.format(returnDate);

            BooksDao bd = new BooksDao();
            int copiesRemaining = bd.getNumberOfCopies(bookId);

            Loans insert = new Loans(0, bookId, userId, null, null, returnDate);

            try {

                conn = getConnection();
                ps = conn.prepareStatement("UPDATE loan SET returnDate = ? WHERE userId = ? AND bookId = ?");
                ps.setDate(1, insert.getReturnDate());
                ps.setInt(2, insert.getUserId());
                ps.setInt(3, insert.getBookId());
                rowsAffected = ps.executeUpdate();
                bd.updateCopies(bookId, copiesRemaining + 1);

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
            if (rowsAffected > 0) {
                System.out.println("Book returned successfully.");
            } else if (rowsAffected == -1) {
                System.out.println("The Book is unavailable.");
            } else if (rowsAffected == 0) {
                System.out.println("Nothing Happened");
            } else {
                System.out.println("The Book could not be returned at this time.");
            }
        }
    }
}
