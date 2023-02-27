<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Order Management</h1>
<table border="1" cellpadding="10">
    <thread>
        <tr>
            <th>Order ID </th>
            <th>Order Number </th>
            <th>Client Name </th>
        </tr>
    </thread>
    <tbody>
    <tr th:each="order : ${listOrders}">
        <td th:text="${order.getId()}">1</td>
        <td th:text="${order.getOrderNumber()}">...</td>
        <td th:text="${order.getClient().getFirstName()} ${order.getClient().getLastName()}">...</td>
    </tr>

    </tbody>
</table>
</body>
</html>