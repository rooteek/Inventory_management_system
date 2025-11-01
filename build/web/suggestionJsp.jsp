<%-- 
    Document   : suggestionJsp
    Created on : 06-Apr-2024, 5:58:25 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%
    ResultSet rs = (ResultSet) request.getAttribute("resultSet");
    while (rs.next()) {
%>
<option><%= rs.getString(1)%></option>
<%
    }
%>    


