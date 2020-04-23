<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<#if auth == true>
    <button onclick="location.href='/profile'">Profile</button>
<#else>
    <button onclick="location.href='/logIn'">LogIn</button>
    <button onclick="location.href='/signUp'">SignUp</button>
</#if>
<button onclick="location.href='/chats'">Chats</button>
</body>
</html>