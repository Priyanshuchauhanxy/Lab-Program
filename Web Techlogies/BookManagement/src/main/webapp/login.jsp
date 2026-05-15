<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
</head>
<body class="auth-page">
<main class="auth-shell">
    <section class="auth-panel">
        <div>
            <div class="eyebrow">Book Management</div>
            <h1>Manage your library records with confidence.</h1>
            <p>Keep book details organized, searchable, and ready for everyday updates.</p>
        </div>
        <p>Admin access</p>
    </section>

    <section class="auth-card">
        <h2>Login</h2>
        <p>Enter your credentials to continue.</p>

        <% if(request.getAttribute("error") != null) { %>
            <div class="alert alert-error"><%= request.getAttribute("error") %></div>
        <% } %>

        <form class="form-stack" action="${pageContext.request.contextPath}/loginservlet" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" type="text" name="username" autocomplete="username" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" type="password" name="password" autocomplete="current-password" required>
            </div>

            <button class="btn btn-primary btn-full" type="submit">Login</button>
        </form>
    </section>
</main>
</body>
</html>
