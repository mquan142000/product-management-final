<%--
  Created by IntelliJ IDEA.
  User: minhquan
  Date: 01/08/2024
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Creat Product</title>
</head>
<body>
<center>
    <h1>Creat Product</h1>
    <h2>
        <a href="products?action=products">Back list product</a>
    </h2>
</center>
<form method="post">
    <table border="1" cellpadding="5">
        <caption>
            <h2>Create New Product</h2>
        </caption>
        <tr>
            <th>Product name: </th>
            <td>
                <input type="text" name="nameProduct" id="nameProduct" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Price: </th>
            <td>
                <input type="text" name="price" id="price" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Quantity: </th>
            <td>
                <input type="text" name="quantity" id="quantity" size="45"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="color">Color: </label>
                <select id="color" name="color">
                    <option value="red">Đỏ</option>
                    <option value="green">Xanh</option>
                    <option value="yellow">Vàng</option>
                    <option value="black">Đen</option>
                    <option value="white">Trắng</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>Category: </th>
            <td>
                <input type="text" name="category" id="category" size="45">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
