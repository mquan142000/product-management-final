<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<center>
    <h1>Edit Product</h1>
    <h2>
        <a href="products?action=products">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
            </c:if>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.nameProduct}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="15"
                           value="<c:out value='${product.quantity}' />"
                    />
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
                <th>Category:</th>
                <td>
                    <input type="text" name="category" size="15"
                           value="<c:out value='${product.category}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>