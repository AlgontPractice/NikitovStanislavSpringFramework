<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Проект</title>
    <style><%@include file="/WEB-INF/styles/style.css"%></style>
</head>
<body>
    <header>
        <nav>
            <a href="/" class="flex-item">SignIn</a>
        </nav>
      </header>
<div>
    <p>Регистрация</p>
    <form  action="/signup/Up" method="get">
        <label>Введите Ваш имейл</label>
        <input type="text" name="login" placeholder="Введите Ваш имейл" required >
        <label>Введите Ваш пароль</label>
        <input type="text" name="password" placeholder="Введите пароль" required >
        <button type="submit" name="form_auth_submit">Войти</button>
    </form>
</div>

<footer>
</footer>

</body>
</html>