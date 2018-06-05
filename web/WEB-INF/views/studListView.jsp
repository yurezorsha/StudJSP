<%-- 
    Document   : studListView
    Created on : 26.04.2018, 22:18:44
    Author     : HP
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stud List</title>
    </head>
    <body>
        <table border=3>
             <tr><th>Номер зачетки</th>
             <th>Имя</th>
             <th>Фамилия</th>
             <th>Отчество</th>
             <th>Город</th>
             <th>Группа</th>
             <th>Адрес</th>
             <th>Телефон</th>
             <th>Статус</th>
             <th>Дата</th>
             <th>Редактировать</th>
             <th>Удалить</th></tr>
                 <c:forEach items="${studList}" var="stud" >
                 <tr>
                     <td>${stud.getNomerZachetki()}</td>
                     <td>${stud.getImya()}</td>
                     <td>${stud.getFamiliya()}</td>
                     <td>${stud.getOtchestvo()}</td>
                     <td>${stud.getGorod()}</td>
                     <td>${stud.getShifrGruppyi()}</td>
                     <td>${stud.getAdres()}</td>
                     <td>${stud.getTel()}</td>
                     <td>${stud.getStatus()}</td>
                     <td>${stud.getStatusDate()}</td>
                     
                     <td>
                <a href="editStud?id=${stud.getNomerZachetki()}">Edit</a>
             </td>
             <td>
                <a href="deleteStud?id=${stud.getNomerZachetki()}">Delete</a>
             </td>
                     
             
                 </c:forEach>
                     </tr>
        </table>
                     
                <a href="createStud" >Create Stud</a>     
             
        
    </body>
</html>
