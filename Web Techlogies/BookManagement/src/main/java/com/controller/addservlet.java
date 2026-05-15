package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.Book;
import com.model.BookDao;

@WebServlet("/addservlet")
public class addservlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        int id =
                Integer.parseInt(req.getParameter("book_id"));

        String bname =
                req.getParameter("book_name");

        int price =
                Integer.parseInt(req.getParameter("book_price"));

        Book b = new Book();

        b.setId(id);
        b.setBname(bname);
        b.setPrice(price);

        BookDao dao = new BookDao();

        boolean status = dao.addBook(b);

        if(status) {

            resp.sendRedirect("view-books.jsp");

        } else {

            resp.sendRedirect("addbook.jsp");
        }
    }
}