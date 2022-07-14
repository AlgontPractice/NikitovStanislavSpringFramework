
<%--
  Created by IntelliJ IDEA.
  User: Ноу Хау
  Date: 7/12/2022
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/styles/style.css"%></style>
</head>
<body>
<div>
    <div class="list_form">
        <p>Лист</p>
        <form action="/fragment/list" method="post">

            <label>Начальная Дату и Время</label>
            <input type="datetime-local" name="date1" placeholder="Введите пароль" required >
            <br>
            <br>
            <label>Конечная Дату и Время</label>
            <input type="datetime-local" name="date2" placeholder="Введите Начало" required >
            <br>
            <button type="submit" name="form_auth_submit">Вывести список</button>
        </form>
    </div>
    <div class="listing">
        <c:forEach items="${list}" var="map">
            <table datasrc="${map.record_path}" border=\"1px\" class="clicker">
                <tr>
                <td> Дата и Время записи | ${map.datetime_start}</td>
               </tr>
            <tr>
                   <td>  <img width="200px" height="100px" src="${map.snapshot_path}" alt="Picture"></td>
                <!-- -->
            </tr>
            </table>
        </c:forEach>
    </div>
</div>
<script><%@include file="/WEB-INF/scripts/list_fragment.js"%></script>
</body>
</html>
