<%@ page import="java.util.*" %>
<%@ page import="com.model.*" %>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}

String search = request.getParameter("q");
if(search == null) {
    search = "";
}
search = search.trim();
String safeSearch = search.replace("&", "&amp;")
                          .replace("<", "&lt;")
                          .replace(">", "&gt;")
                          .replace("\"", "&quot;")
                          .replace("'", "&#39;");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Books</title>
</head>
<body>
<div class="wrapper">
    <aside class="sidebar">
        <div class="logo">Book CRUD</div>
        <nav class="menu">
            <a class="active" href="view-books.jsp">Books</a>
            <a href="addbook.jsp">Add Book</a>
            <a href="${pageContext.request.contextPath}/logoutservlet">Logout</a>
        </nav>
    </aside>

    <main class="main">
        <div class="topbar">
            <div class="page-title">
                <h1><%= search.isEmpty() ? "All Books" : "Search Results" %></h1>
                <p><%= search.isEmpty() ? "Review, edit, and remove book records." : "Showing records that match \"" + safeSearch + "\"." %></p>
            </div>
            <div class="topbar-actions">
                <a class="btn btn-primary" href="addbook.jsp">Add New Book</a>
            </div>
        </div>

        <section class="card">
            <div class="card-body card-toolbar">
                <form class="search-form" action="view-books.jsp" method="get">
                    <label class="sr-only" for="bookSearch">Search books</label>
                    <input id="bookSearch" class="search-input" type="search" name="q" value="<%= safeSearch %>" placeholder="Search by ID, book name, or price">
                    <button class="btn btn-primary" type="submit">Search</button>
                    <% if(!search.isEmpty()) { %>
                        <a class="btn btn-secondary" href="view-books.jsp">Clear</a>
                    <% } %>
                </form>
            </div>
            <div class="table-wrap">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Book Name</th>
                            <th>Price</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    BookDao dao = new BookDao();
                    List<Book> list = search.isEmpty() ? dao.getAllBooks() : dao.searchBooks(search);

                    if(list.isEmpty()){
                    %>
                        <tr>
                            <td class="empty-state" colspan="4">No books found<%= search.isEmpty() ? "." : " for \"" + safeSearch + "\"." %></td>
                        </tr>
                    <%
                    }

                    for(Book b : list){
                    %>
                        <tr>
                            <td><%= b.getId() %></td>
                            <td><%= b.getBname() %></td>
                            <td><span class="price"><%= b.getPrice() %></span></td>
                            <td>
                                <div class="table-actions">
                                    <a class="btn btn-ghost" href="edit-book.jsp?id=<%= b.getId() %>">Edit</a>
                                    <a class="btn btn-danger" href="deleteservlet?id=<%= b.getId() %>">Delete</a>
                                </div>
                            </td>
                        </tr>
                    <%
                    }
                    %>
                    </tbody>
                </table>
            </div>
        </section>
    </main>
</div>
</body>
</html>
