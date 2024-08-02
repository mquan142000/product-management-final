<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management Product</title>
    <link rel="stylesheet" href="product/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Management Product</h1>
        <h2>Find Product</h2>
        <button class="add-button"
                onclick="window.location.href='${pageContext.request.contextPath}/product?action=create'">
            + Add Product
        </button>
    </div>
    <form action="${pageContext.request.contextPath}/products" method="get">
        <div class="search-bar">
            <div class="search-field">
                <label for="productName">Product Name</label>
                <input type="text" id="productName" name="name" placeholder="Enter Product Name">
            </div>
            <div class="search-field">
                <label for="price">Price</label>
                <input type="text" id="price" name="price" placeholder="Enter Price">
            </div>
            <div class="search-field">
                <label for="category">Category</label>
                <input type="text" id="category" name="category" placeholder="Enter Category">
            </div>
            <div class="search-field">
                <label for="color">Color</label>
                <input type="text" id="color" name="color" placeholder="Enter Color">
            </div>
            <div class="search-field">
                <label for="clear">Clear</label>
                <button type="reset" id="clear" class="search-button" class="btn"><i class="fa fa-trash"></i></button>

            </div>
            <button type="submit" class="search-button">Search</button>
            <input type="hidden" name="action" value="search">
        </div>
    </form>

    <table>
        <thead>
        <tr>
            <th>STT</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.nameProduct}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.category}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/product?action=edit&id=${product.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/product?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
