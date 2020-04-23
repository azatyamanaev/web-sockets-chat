<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<body>
<form action="/logIn" method="post">
    <input name="login" placeholder="Login">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" value="LogIn">
</form>
<p>Don't have an account?</p>
<a href="/signUp">SignUp</a>
</body>
</html>