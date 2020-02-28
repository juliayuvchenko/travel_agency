<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration form</title>
</head>
<body>
<div style="text-align: center">
    <h2>Registration form</h2>
    <div style="text-align: center">
        <form action="${pageContext.request.contextPath}/reg" method="post">
            <table cellpadding="3pt" style="display: flex;justify-content: center;">
                <tr>
                    <td>Person FirstName :</td>
                    <td><input type="text" name="firstName" size="30"></td>
                </tr>
                <tr>
                    <td>Person LastName :</td>
                    <td><input type="text" name="lastName" size="30"></td>
                </tr>
                <tr>
                    <td>Person Passport :</td>
                    <td><input type="text" name="passport" size="30"></td>
                </tr>
                <tr>
                    <td>Person Age :</td>
                    <td><input type="text" name="age" size="30"></td>
                </tr>
            </table>
            <p/>
            <input type="submit" value="Register">
        </form>
    </div>
</div>
</body>
</html>
