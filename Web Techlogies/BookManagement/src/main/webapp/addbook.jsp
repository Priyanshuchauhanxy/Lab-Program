<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Book</title>
</head>
<body>
<div class="wrapper">
    <aside class="sidebar">
        <div class="logo">Book CRUD</div>
        <nav class="menu">
            <a href="view-books.jsp">Books</a>
            <a class="active" href="addbook.jsp">Add Book</a>
            <a href="${pageContext.request.contextPath}/logoutservlet">Logout</a>
        </nav>
    </aside>

    <main class="main">
        <div class="topbar">
            <div class="page-title">
                <h1>Add Book</h1>
                <p>Create a new record in the book catalog.</p>
            </div>
            <div class="topbar-actions">
                <a class="btn btn-secondary" href="view-books.jsp">Back to Books</a>
            </div>
        </div>

        <section class="card">
            <div class="card-body">
                <form action="addservlet" method="post">
                    <div class="form-grid">
                        <div class="form-group">
                            <label for="book_id">Book ID</label>
                            <input id="book_id" type="number" name="book_id" required>
                        </div>

                        <div class="form-group">
                            <label for="book_name">Book Name</label>
                            <input id="book_name" type="text" name="book_name" required>
                        </div>

                        <div class="form-group">
                            <label for="book_price">Book Price</label>
                            <input id="book_price" type="number" name="book_price" min="0" required>
                        </div>

                        <div class="form-actions">
                            <a class="btn btn-secondary" href="view-books.jsp">Cancel</a>
                            <button class="btn btn-success" type="submit">Save Book</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </main>
</div>
</body>
</html>
