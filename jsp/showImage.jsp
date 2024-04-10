<%-- 
    Document   : showImage
    Created on : 31-Mar-2024, 6:28:53 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@page import="java.sql.DriverManager" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.IOException" %>


<%
    int productId = Integer.parseInt(request.getParameter("productId"));
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SA_MANAGEMENT","root","root");
        String query = "SELECT image FROM PRODUCT_MST WHERE PRODUCT_ID = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, productId);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            byte[] imageData = resultSet.getBytes("image");
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            os.write(imageData);
            os.close();
        }
        else{
        out.print("some Error Occured");
    }
    } catch (SQLException | IOException e) {
        e.printStackTrace();
    } finally {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
%>