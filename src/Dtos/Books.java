/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

public class Books {
    
    private int bookId;
    private String title;
    private String authorLastName;
    private String authorFirstName;
    private String publisher;
    private int yearPublished;
    private String subject;
    private String isbn;
    private int copiesRemaining;

    public Books(int bookId, String title, String authorLastName, String authorFirstName, String publisher, int yearPublished, String subject, String isbn, int copiesRemaining) {
        this.bookId = bookId;
        this.title = title;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.subject = subject;
        this.isbn = isbn;
        this.copiesRemaining = copiesRemaining;
    }

    public Books() {
        
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopiesRemaining() {
        return copiesRemaining;
    }

    public void setCopiesRemaining(int copiesRemaining) {
        this.copiesRemaining = copiesRemaining;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.bookId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Books other = (Books) obj;
        if (this.bookId != other.bookId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "books{" + "bookId=" + bookId + ",\n title=" + title + ",\n authorLastName=" + authorLastName + ",\n authorFirstName=" + authorFirstName + ",\n publisher=" + publisher + ",\n yearPublished=" + yearPublished + ",\n subject=" + subject + ",\n isbn=" + isbn + ",\n copiesRemaining=" + copiesRemaining  +'}' + "\n\n";
    }
    
    
}
