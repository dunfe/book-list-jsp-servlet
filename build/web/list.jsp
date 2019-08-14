<%-- 
    Document   : list
    Created on : Aug 14, 2019, 2:54:03 PM
    Author     : Admin
--%>

<%@page import="model.Key"%>
<%@page import="java.util.Set"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="model.ListAll"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
    </style>
    <body>
        <table>
            <tr>
                <td>Title</td>
                <td>Date</td>
                <td>Author</td>
            </tr>
            <c:forEach items="${mapList}" var="list">
                <tr>
                    <td>
                        <c:out value="${list.key.title}"></c:out>
                    </td>
                    <td>
                        <c:out value="${list.key.date}"></c:out>
                    </td>
                    <td>
                        <c:forEach items="${list.value}" var="a">
                            <c:out value="${a}"></c:out></br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
