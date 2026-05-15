package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.db;

public class BookDao {

	    // Insert Book
	    public boolean addBook(Book b) {

	        boolean status = false;

	        String sql = "INSERT INTO book1(id,bname,price) VALUES(?,?,?)";

	        try (Connection conn = db.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, b.getId());
	            ps.setString(2, b.getBname());
	            ps.setInt(3, b.getPrice());

	            int i = ps.executeUpdate();

	            if(i == 1) {
	                status = true;
	            }

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return status;
	    }

	    // VIEW ALL
	    public List<Book> getAllBooks() {

	        List<Book> list = new ArrayList<>();

	        String sql = "SELECT * FROM book1";

	        try (Connection conn = db.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            while(rs.next()) {

	                Book b = new Book();

	                b.setId(rs.getInt("id"));
	                b.setBname(rs.getString("bname"));
	                b.setPrice(rs.getInt("price"));

	                list.add(b);
	            }

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    // SEARCH
	    public List<Book> searchBooks(String keyword) {

	        List<Book> list = new ArrayList<>();

	        if(keyword == null || keyword.trim().isEmpty()) {
	            return getAllBooks();
	        }

	        String searchValue = "%" + keyword.trim() + "%";
	        String sql = "SELECT * FROM book1 WHERE CAST(id AS CHAR) LIKE ? OR bname LIKE ? OR CAST(price AS CHAR) LIKE ?";

	        try (Connection conn = db.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, searchValue);
	            ps.setString(2, searchValue);
	            ps.setString(3, searchValue);

	            try (ResultSet rs = ps.executeQuery()) {
	                while(rs.next()) {

	                    Book b = new Book();

	                    b.setId(rs.getInt("id"));
	                    b.setBname(rs.getString("bname"));
	                    b.setPrice(rs.getInt("price"));

	                    list.add(b);
	                }
	            }

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    // GET BY ID
	    public Book getBookById(int id) {

	        Book b = null;

	        String sql = "SELECT * FROM book1 WHERE id=?";

	        try (Connection conn = db.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);

	            try (ResultSet rs = ps.executeQuery()) {
	                if(rs.next()) {

	                    b = new Book();

	                    b.setId(rs.getInt("id"));
	                    b.setBname(rs.getString("bname"));
	                    b.setPrice(rs.getInt("price"));
	                }
	            }

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return b;
	    }

	    // UPDATE
	    public boolean updateBook(Book b) {

	        boolean status = false;

	        String sql = "UPDATE book1 SET bname=?,price=? WHERE id=?";

	        try (Connection conn = db.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, b.getBname());
	            ps.setInt(2, b.getPrice());
	            ps.setInt(3, b.getId());

	            int i = ps.executeUpdate();

	            if(i == 1) {
	                status = true;
	            }

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return status;
	    }

	    // DELETE
	    public boolean deleteBook(int id) {

	        boolean status = false;

	        String sql = "DELETE FROM book1 WHERE id=?";

	        try (Connection conn = db.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);

	            int i = ps.executeUpdate();

	            if(i == 1) {
	                status = true;
	            }

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return status;
	    }
	}

