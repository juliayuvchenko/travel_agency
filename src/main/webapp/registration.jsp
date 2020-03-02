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
                    <td>Person Luxury :</td>
                    <td><input type="text" name="luxury" size="30" value="ECONOM"></td>
                </tr>
                <tr>
                    <td>Person Bedrooms :</td>
                    <td><input type="text" name="bedrooms" size="30"  value="DOUBLE"></td>
                </tr>
                <tr>
                    <td>Person start :</td>
                    <td><input type="text" name="start" size="30"  value="2020-03-14"></td>
                </tr>
                <tr>
                    <td>Person end :</td>
                    <td><input type="text" name="end" size="30" value="2020-03-15"></td>
                </tr>
            </table>
            <p/>
            <input type="submit" value="Register">
        </form>
    </div>
</div>
</body>
</html>
