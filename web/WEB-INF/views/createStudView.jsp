<%-- 
    Document   : createStudView
    Created on : 26.04.2018, 23:31:12
    Author     : HP
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Stud</title>
    </head>
    <body>
       <h3>Create Stud</h3>
       <form method="POST" action="${pageContext.request.contextPath}/createStud">
         <table border="0">
            <tr>
               <td>Номер зачетки</td>
               <td><input type="text" name="NomerZachetki" value="" /></td>
            </tr>
            <tr>
               <td>Фамилия</td>
               <td><input type="text" name="Familiya" value="" /></td>
            </tr>
            <tr>
               <td>Имя</td>
               <td><input type="text" name="Imya" value="" /></td>
            </tr>
            <tr>
               <td>Отчество</td>
               <td><input type="text" name="Otchestvo" value="" /></td>
            </tr>
            <tr>
               <td>Город</td>
               <td><input type="text" name="Gorod" value="" /></td>
            </tr>
            <tr>
               <td>Группа</td>
               <td><select name="ShifrGruppyi" >
                <c:forEach items="${grList}" var="gr">
                 <option value ="${gr.getShifr()}">${gr.getNazvanie()}</option>
                </c:forEach>
                 </select></td>
            </tr>
            <tr>
               <td>Адрес</td>
               <td><input type="text" name="Adres" value="" /></td>
            </tr>
            <tr>
               <td>Телефон</td>
               <td><input type="text" name="Tel" value="" /></td>
            </tr>
            <tr>
               <td>Статус</td>
               <td><input type="text" name="Status" value="" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="studList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
    </body>
</html>
