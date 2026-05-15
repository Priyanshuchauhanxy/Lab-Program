package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Book;
import com.model.BookDao;

/**
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int id =
	                Integer.parseInt(request.getParameter("book_id"));

	        String bname =
	                request.getParameter("book_name");

	        int price =
	                Integer.parseInt(request.getParameter("book_price"));

	        Book b = new Book();

	        b.setId(id);
	        b.setBname(bname);
	        b.setPrice(price);

	        BookDao dao = new BookDao();

	        boolean status = dao.updateBook(b);

	        if(status) {

	            response.sendRedirect("view-books.jsp");

	        } else {

	            response.sendRedirect("edit-book.jsp");
	        }
	        }

}
