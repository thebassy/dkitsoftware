/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author niall
 */

import java.util.Objects;
import java.sql.Date;

public class Loans {
    
    private int loanId;
    private int bookId;
    private int userId;
    private Date dateStamp;
    private Date dueDate;
    private Date returnDate;

    public Loans(int loanId, int bookId, int userId, Date dateStamp, Date dueDate, Date returnDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.userId = userId;
        this.dateStamp = dateStamp;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }
    public Loans(int loanId, int bookId, int userId, Date dateStamp, Date dueDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.userId = userId;
        this.dateStamp = dateStamp;
        this.dueDate = dueDate;
        
    }
    public Loans() {
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.loanId;
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
        final Loans other = (Loans) obj;
        if (this.loanId != other.loanId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Loans{" + "loanId=" + loanId + ", bookId=" + bookId + ", userId=" + userId + ", dateStamp=" + dateStamp + ", dueDate=" + dueDate + ", returnDate=" + returnDate + '}';
    }
    
    
}
