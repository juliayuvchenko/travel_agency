<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Booking form</title>
</head>
<body>
<div style="text-align: center">
    <h2>Booking form</h2>
    <div style="text-align: center">
        <form action="${pageContext.request.contextPath}/reg" method="post">
            <table cellpadding="3pt" style="display: flex;justify-content: center;">
                <tr>
                    <td> Luxury type :</td>
                    <td><input type="text" name="luxury" size="30" value="ECONOM"></td>
                </tr>
                <tr>
                    <td> Bedrooms type :</td>
                    <td><input type="text" name="bedrooms" size="30"  value="DOUBLE"></td>
                </tr>
                <tr>
                    <td> Quantity of rooms :</td>
                    <td><input type="text" name="quantity" size="30"  value="1"></td>
                </tr>
                <tr>
                    <td> Start date :</td>
                    <td><input type="text" name="start" size="30"  value="2020-03-14"></td>
                </tr>
                <tr>
                    <td> End date :</td>
                    <td><input type="text" name="end" size="30" value="2020-03-15"></td>
                </tr>
                <tr>
                    <td> City name :</td>
                    <td><input type="text" name="end" size="30" value="Lviv"></td>
                </tr>
            </table>
            <p/>
            <input type="submit" value="Show available hotels">
        </form>
    </div>
</div>
</body>
</html>
