<%@ page import="com.model.*" %>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<%
BookDao dao = new BookDao();
Book b = dao.getBookById(
Integer.parseInt(request.getParameter("id")));
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Book</title>
</head>
<body>
<div class="wrapper">
    <aside class="sidebar">
        <div class="logo">Book CRUD</div>
        <nav class="menu">
            <a href="view-books.jsp">Books</a>
            <a href="addbook.jsp">Add Book</a>
            <a href="${pageContext.request.contextPath}/logoutservlet">Logout</a>
        </nav>
    </aside>

    <main class="main">
        <div class="topbar">
            <div class="page-title">
                <h1>Edit Book</h1>
                <p>Update the selected book record.</p>
            </div>
            <div class="topbar-actions">
                <a class="btn btn-secondary" href="view-books.jsp">Back to Books</a>
            </div>
        </div>

        <section class="card">
            <div class="card-body">
                <form action="updateservlet" method="post">
                    <div class="form-grid">
                        <div class="form-group">
                            <label for="book_id">Book ID</label>
                            <input id="book_id" type="number" name="book_id" value="<%= b.getId() %>" readonly>
                        </div>

                        <div class="form-group">
                            <label for="book_name">Book Name</label>
                            <input id="book_name" type="text" name="book_name" value="<%= b.getBname() %>" required>
                        </div>

                        <div class="form-group">
                            <label for="book_price">Book Price</label>
                            <input id="book_price" type="number" name="book_price" min="0" value="<%= b.getPrice() %>" required>
                        </div>

                        <div class="form-actions">
                            <a class="btn btn-secondary" href="view-books.jsp">Cancel</a>
                            <button class="btn btn-success" type="submit">Update Book</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </main>
</div>
</body>
</html>
