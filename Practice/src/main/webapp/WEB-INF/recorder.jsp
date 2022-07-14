<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<main class="mainTag">
    <!--<div class="mainClass"></div>-->
    <video id="videoId" controls="controls" width="720px" height="480px" autoplay="autoplay">
        <source src="" type="video/mp4">
    </video>
    <iframe class="container_for_listing_logic" height="100%" width="500px" src="/fragment"></iframe>
</main>

<footer>
        <button class="start">
            Start
        </button>
        <button class="stop" disabled>
            Stop
        </button>
</footer>
<script><%@include file="/WEB-INF/scripts/list_fragment.js"%></script>
<script><%@include file="/WEB-INF/scripts/start.js"%></script>
<script><%@include file="/WEB-INF/scripts/stop.js"%></script>
</body>
</html>