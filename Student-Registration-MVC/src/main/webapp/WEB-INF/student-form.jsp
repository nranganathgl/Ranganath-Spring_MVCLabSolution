<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Save Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleStudent.css"></link>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-student-style.css"></link>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Students Registration Form</h2>
    </div>
    <div id="container">
        <h3>Save Student</h3>
        <form:form action="saveStudent" modelAttribute="student" method="post">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><label>Name: </label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><label>Department </label></td>
                    <td><form:input path="department"/></td>
                </tr>
                <tr>
                    <td><label>Country: </label></td>
                    <td><form:input path="country"/></td>
                </tr>
                <tr>
                    <td><label> </label></td>
                    <td><input type="submit" value="save" class="save"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <!--<div style="clear; both;"></div>-->
        <p>
            <a href="${pageContext.request.contextPath}/showStudents">Back to List</a>
        </p>
    </div>
</div>
</body>
</html>