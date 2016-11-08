/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/*Author Sebastian Bekx */
import Dtos.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BooksDao extends Dao implements BooksDaoInterface {

    /**
     * Returns an ArrayList of {@code Books} objects based on information in the
     * database. All book entries in the Books table are selected from the
     * database and stored as {@code Books} objects in a {@code ArrayList}.
     *
     * @return The {@code ArrayList} of all book entries in the Books table.
     * This {@code ArrayList} may be empty where no products are present in the
     * database.
     */
    @Override
    public ArrayList<Books> getAllBooks() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Books> allBooks = new ArrayList<>();

        try {
            con = getConnection();
            String query = "Select * from books";
            ps = con.prepareStatement(query);
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

                allBooks.add(b);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllbooks() method");
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
                System.out.println("Exception occured in the finally section of the getAllBooks() method");
                e.printStackTrace();
            }
        }
        return allBooks;
    }

    /**
     *
     * @return
     */
    @Override
    public Books showAllBooks() {
        int j = 0;
        for (int i = 0; i < getAllBooks().size(); i++) {
            System.out.println("Book: " + getAllBooks().get(i));
            j += j;
        }
        return getAllBooks().get(j);
    }

    /**
     * Formats and Prints out the details of each book in the library
     *
     * @param library {@code String} stores a string command and if it is
     * correct will print out book details
     * @return {@code String} the formatted book information returned as a
     * string
     */
    @Override
    public String getLibraryInfo(String library) {
        int i = 0;
        String bookInfo = "";
        ArrayList<Books> bookStuff = getAllBooks();
        if (library.equals("library")) {
            for (Books b : bookStuff) {
                bookInfo = "\nTitle: " + b.getTitle()
                        + "\nSurname: " + b.getAuthorLastName()
                        + "\nFirst name: " + b.getAuthorFirstName()
                        + "\nPublisher: " + b.getPublisher()
                        + "\nSubject: " + b.getSubject()
                        + "\nISBN: " + b.getIsbn();
            }

        } else {
            System.out.println(bookInfo = "Wrong Command");
        }
        return bookInfo;
    }

    /**
     * Adds a new {@code Books} to the database in Books table Prompts you to
     * enter new Book, author LastName, author FirstName, Publisher, Year
     * Published, Subject, Isbn and Copies Remaining.
     */
    @Override
    public void addBooks() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Book Name: ");
        String newBook = readString();
        System.out.println("Enter Author's Last Name:");
        String aLastName = input.next();
        System.out.println("Enter Author's First Name:");
        String aFirstName = input.next();
        System.out.println("Enter Book Publisher:");
        String newPub = readString();
        System.out.println("Enter Year Book Published:");
        int newYrPub = input.nextInt();
        System.out.println("Enter Book Subject:");
        String newSubject = readString();
        System.out.println("Enter Book ISBN:");
        String newIsbn = input.next();
        System.out.println("Enter how many copies remain:");
        int newCopiesRemain = input.nextInt();
        Books newBooks = new Books(0, newBook, aLastName, aFirstName, newPub, newYrPub, newSubject, newIsbn, newCopiesRemain);

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Books add = newBooks;

        int rowsAffected = 0;
        try {

            conn = getConnection();
            ps = conn.prepareStatement("INSERT INTO `books`(`title`, `authorLastName`, `authorFirstName`, `publisher`, `yearPublished`, `subject`, `isbn`, `copiesRemaining`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, add.getTitle());
            ps.setString(2, add.getAuthorLastName());
            ps.setString(3, add.getAuthorFirstName());
            ps.setString(4, add.getPublisher());
            ps.setInt(5, add.getYearPublished());
            ps.setString(6, add.getSubject());
            ps.setString(7, add.getIsbn());
            ps.setInt(8, add.getCopiesRemaining());
            ps.execute();
            rowsAffected++;

        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
            rowsAffected--;
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
            System.out.println("Book added successfully.");
        } else if (rowsAffected == -1) {
            System.out.println("The Book id supplied already exists. Please check the Customer details and try again.");
        } else if (rowsAffected == 0) {
            System.out.println("Nothing Happened");
        } else {
            System.out.println("The Book could not be added at this time.");
        }
    }

    /**
     * Deletes an {@code Books} from the Books table of the database based on
     * the BookId provided
     *
     */
    @Override
    public void deleteBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("input the BookID of book to delete");
        int id = input.nextInt();

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement("DELETE FROM books WHERE bookId = ?");

            ps.setInt(1, id);

            ps.execute();
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

    /**
     *
     * @return
     */
    @Override
    public String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Searches for a Books entry from the database by matching the bookId
     * supplied as a parameter
     *
     * @param id the id of the book to be found in the database
     * @return the {@code Books} contained in the database matching the book Id
     * supplied
     */
    @Override
    public Books getBookById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Books bookById = new Books();

        try {
            con = getConnection();
            String query = "SELECT * FROM books WHERE bookId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                bookById = new Books(rs.getInt("bookId"), rs.getString("title"), rs.getString("authorLastName"), rs.getString("authorFirstName"), rs.getString("publisher"), rs.getInt("yearPublished"), rs.getString("subject"), rs.getString("isbn"), rs.getInt("copiesRemaining"));

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllbooks() method");
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
                System.out.println("Exception occured in the finally section of the getAllBooks() method");
                e.printStackTrace();
            }
        }
        return bookById;
    }

    /**
     * Provides an update book menu which allows the user to select the field on
     * the book table that needs to be changed
     */
    @Override
    public void updateBook() {

        Scanner input = new Scanner(System.in);
        String command = "";

        System.out.println("Enter the id of the title you wish to update");
        int id = input.nextInt();
        System.out.println(getBookById(id));
        System.out.println("Type one of the following fields to update:");
        System.out.println("1.TITLE");
        System.out.println("2.AUTHORLASTNAME");
        System.out.println("3.AUTHORFIRSTNAME");
        System.out.println("4.PUBLISHER");
        System.out.println("5.YEARPUBLISHED");
        System.out.println("6.SUBJECT");
        System.out.println("7.ISBN");
        System.out.println("8.COPIESREMAINING");
        command = input.next().toLowerCase();

        if ("title".equals(command)) {
            System.out.println("Type new title:");
            String title = input.next();
            updateTitle(id, title);
        } else if ("authorlastname".equals(command)) {
            System.out.println("Type new author last name:");
            String last = input.next();
            updateAuthorLast(id, last);
        } else if ("authorfirstname".equals(command)) {
            System.out.println("Type new author first name:");
            String first = input.next();
            updateAuthorFirst(id, first);
        } else if ("publisher".equals(command)) {
            System.out.println("Type new publisher:");
            String publisher = input.next();
            updatePublisher(id, publisher);
        } else if ("yearpublished".equals(command)) {
            System.out.println("Type new year of publication:");
            int yearPublished = input.nextInt();
            updateYearPublished(id, yearPublished);
        } else if ("subject".equals(command)) {
            System.out.println("Type new subject:");
            String subject = input.next();
            updateSubject(id, subject);
        } else if ("isbn".equals(command)) {
            System.out.println("Type new isbn:");
            String isbn = input.next();
            updateIsbn(id, isbn);
        } else if ("copiesremaining".equals(command)) {
            System.out.println("Type new number of copies available:");
            int copiesRemaining = input.nextInt();
            updateCopies(id, copiesRemaining);
        }
    }

    /**
     * Amends the name of any title in the book table of the database matching
     * the Id of the book and the new title.
     *
     * @param id the id of the book that needs changing
     * @param title the new title for the book
     */
    @Override
    public void updateTitle(int id, String title) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "UPDATE books SET title = ? WHERE bookId= ?";

            ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateTitle() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updateTitle() method");
                e.getMessage();
            }
        }

    }

    /**
     * Amends the last name of the author in the book table of the database
     * matching the Id of the book.
     *
     * @param id the id of the book that needs changing
     * @param last the new author last name for the book
     */
    @Override
    public void updateAuthorLast(int id, String last) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "UPDATE books SET authorLastName = ? WHERE bookId= ?";

            ps = con.prepareStatement(query);
            ps.setString(1, last);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateAuthorLast() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updateAuthorLast() method");
                e.getMessage();
            }
        }

    }

    /**
     * Amends the author first name in the book table of the database matching
     * the Id of the book.
     *
     * @param id the id of the book that needs changing
     * @param first the new author first name for the book
     */
    @Override
    public void updateAuthorFirst(int id, String first) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "UPDATE books SET authorfirstName = ? WHERE bookId= ?";

            ps = con.prepareStatement(query);
            ps.setString(1, first);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateAuthorFirst() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updateAuthorFirst() method");
                e.getMessage();
            }
        }

    }

    /**
     * Amends the publisher in the book table of the database matching the Id of
     * the book.
     *
     * @param id the id of the book that needs changing
     * @param publisher the new publisher for the book
     */
    @Override
    public void updatePublisher(int id, String publisher) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "UPDATE books SET publisher = ? WHERE bookId= ?";

            ps = con.prepareStatement(query);
            ps.setString(1, publisher);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updatePublished() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updatePublished() method");
                e.getMessage();
            }
        }

    }

    /**
     * Amends the year published in the book table of the database matching the
     * Id of the book.
     *
     * @param id the id of the book that needs changing
     * @param yearPublished the new year published for the book
     */
    @Override
    public void updateYearPublished(int id, int yearPublished) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "UPDATE books SET yearPublished = ? WHERE bookId= ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, yearPublished);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateYearPublished() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updateYearPublished() method");
                e.getMessage();
            }
        }

    }

    /**
     * Amends the subject in the book table of the database matching the Id of
     * the book.
     *
     * @param id the id of the book that needs changing
     * @param subject the new subject for the book
     */
    @Override
    public void updateSubject(int id, String subject) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "UPDATE books SET subject = ? WHERE bookId= ?";

            ps = con.prepareStatement(query);
            ps.setString(1, subject);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateSubject() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updateSubject() method");
                e.getMessage();
            }
        }

    }

    /**
     * Amends the isbn in the book table of the database matching the Id of the
     * book.
     *
     * @param id the id of the book that needs changing
     * @param isbn the new isbn for the book
     */
    @Override
    public void updateIsbn(int id, String isbn) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "UPDATE books SET isbn = ? WHERE bookId= ?";

            ps = con.prepareStatement(query);
            ps.setString(1, isbn);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateIsbn() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updateIsbn() method");
                e.getMessage();
            }
        }

    }

    /**
     * Amends the number of copies in the book table of the database matching
     * the Id of the book.
     *
     * @param bookId the id of the book that needs changing
     * @param copiesRemaining the new number of copies for the book
     */
    @Override
    public void updateCopies(int bookId, int copiesRemaining) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "UPDATE books SET copiesRemaining = ? WHERE bookId= ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, copiesRemaining);
            ps.setInt(2, bookId);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateCopies() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the updateCopies() method");
                e.getMessage();
            }
        }

    }

    /**
     * Searches for the number of copies remaining based on the book id
     *
     * @param bookId the id of the book that is being searched for
     * @return {@code int} the number of book copies remaining
     */
    @Override
    public int getNumberOfCopies(int bookId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int copiesById = 0;

        try {
            con = getConnection();
            String query = "SELECT copiesRemaining FROM books WHERE bookId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, bookId);
            rs = ps.executeQuery();

            if (rs.next()) {
                copiesById = rs.getInt("copiesRemaining");
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCopiesById() method");
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
                System.out.println("Exception occured in the finally section of the getCopiesById() method");
                e.printStackTrace();
            }
        }
        return copiesById;
    }
}
