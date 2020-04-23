<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Created Chats</title>
</head>
<body>
<#list chats as chat>
    <a href="/chat?name=${chat.name}">${chat.name}</a>
    <br>
</#list>
</body>
</html>