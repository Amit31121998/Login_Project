<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML Aside tag</title>
    <style>
         body{
            margin: 0;
            font-family: Calibri,sans-serif;
        }
        aside{
            padding-top: 20px;
            background-color: black;
            width: 200px;
            height: 100vh;
            text-align: center;
        }
        aside a{
            display: block;
            color: white;
            text-decoration: none;
            font-size: 20px;
            padding: 10px 20px;
        }
        aside a:hover{
            background-color: lightseagreen;
            color: black;
        }
    </style>
</head>
<body>

    <aside>
        <a href="address.jsp">Address</a>
        <a href="education.jsp">Education</a>
        <a href="family.jsp">Family Details</a>
        <a href="LogoutServlet">Logout</a>
    </aside>
    
</body>
</html>