/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Daos.UsersDao;
import Daos.BooksDao;
import Daos.LoansDao;
import java.util.Scanner;
import java.util.ArrayList;

public class library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UsersDao ud = new UsersDao();
        BooksDao bd = new BooksDao();
        LoansDao ld = new LoansDao();

        Scanner input = new Scanner(System.in);
        String command = "";

        /* bd.showAllBooks();
        System.out.println("Please type 'library' to view all books");
        command = input.next().toLowerCase();
        bd.getLibraryInfo(command);*/
        while (!(command.equals("logout"))) {
            System.out.println("type LOGIN to access your account.\n"
                    + "type JOIN to create new user\n"
                    + "or type LOGOUT to finish");
            command = input.next().toLowerCase();

            if ("login".equals(command)) {
                System.out.println("Enter username: ");
                String username = input.next();
                System.out.println("Enter password: ");
                String password = input.next();
                System.out.println(ud.getShortUserInfo(username, password));
                int userId = ud.getUserInfo(username, password).getUserId();
                System.out.println("Books currently on loan for this user:\n");
                System.out.println(ld.getAllBooksLoaned(userId));

                if (ud.getUserInfo(username, password).getUserLogin() == null) {
                    System.out.println("User does not exist");
                } else {
                    if (ud.getUserInfo(username, password).getUserType() == 1) {

                        String adminCommand = "";
                        while (!(adminCommand.equals("exit"))) {
                            System.out.println("MENU:");
                            System.out.println("1. type DELETEUSER to delete student member to the library");
                            System.out.println("2. type SHOWUSERS to view all users");
                            System.out.println("3. type SHOWBOOKS to view all books");
                            System.out.println("4. type SHOWLOANEDBOOKS to view all books you have on loan");
                            System.out.println("5. type ADDBOOK to add a new book to the library");
                            System.out.println("6. type DELETEBOOK to delete a book for the library");
                            System.out.println("7. type UPDATEBOOK to update a book for the library");
                            System.out.println("8. type BORROWBOOK to update a book for the library");
                            System.out.println("9. type RETURNBOOK to update a book for the library");
                            System.out.println("0. type EXIT to end program");
                            adminCommand = input.next().toLowerCase();

                            switch (adminCommand) {
                                case "deleteuser":
                                    ud.deleteUser();
                                    break;

                                case "showusers":
                                    System.out.println(ud.getAllUsers());
                                    break;

                                case "showbooks":
                                    System.out.println(bd.getAllBooks());
                                    break;

                                case "showloanedbooks":
                                    System.out.println(ld.getAllBooksLoaned(userId));
                                    break;

                                case "addbook":
                                    bd.addBooks();
                                    break;

                                case "deletebook":
                                    bd.deleteBook();
                                    break;

                                case "updatebook":
                                    bd.updateBook();
                                    break;

                                case "borrowbook":
                                    ld.borrowBook(userId);
                                    break;

                                case "returnbook":
                                    ld.returnBook(userId);
                                    break;
                            }

                        }

                    } else if (ud.getUserInfo(username, password).getUserType() == 0) {
                        String studentCommand = "";
                        while (!(studentCommand.equals("exit"))) {
                            System.out.println("MENU:");
                            System.out.println("1. type SHOWBOOKS to view all books");
                            System.out.println("2. type SHOWLOANEDBOOKS to view all books you have on loan");
                            System.out.println("3. type BORROWBOOK to update a book for the library");
                            System.out.println("4. type RETURNBOOK to update a book for the library");
                            System.out.println("0. type EXIT to end program");
                            studentCommand = input.next().toLowerCase();

                            switch (studentCommand) {

                                case "showbooks":
                                    System.out.println(bd.getAllBooks());
                                    break;

                                case "showloanedbooks":
                                    System.out.println(ld.getAllBooksLoaned(userId));
                                    break;

                                case "borrowbook":
                                    ld.borrowBook(userId);
                                    break;

                                case "returnbook":
                                    ld.returnBook(userId);
                                    break;
                            }
                        }
                    }
                }
            } else if (command.equals("join")) {
                ud.addUser();
            } else {
                System.out.println("not a valid command");
            }
        }
    }
}
