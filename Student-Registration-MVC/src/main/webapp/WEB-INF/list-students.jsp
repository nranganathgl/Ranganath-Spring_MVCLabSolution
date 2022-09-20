<%--
  Created by IntelliJ IDEA.
  User: ranganath
  Date: 11/09/22
  Time: 8:53 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List Students</title>
         <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleStudent.css"/>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Students Registration Form</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <input type="button" value="Add Student" onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"/>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Country</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="student" items="${students}">
                    <c:url var="updateLink" value="/showFormForUpdate">
                        <c:param name="studentId" value="${student.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/delete">
                        <c:param name="studentId" value="${student.id}"/>
                    </c:url>
                    <tr>
                        <td>${student.name}</td>
                        <td>${student.department}</td>
                        <td>${student.country}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this student? '))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
