<%-- 
    Document   : OrderHistory
    Created on : Aug 19, 2024, 9:46:25 AM
    Author     : AnhVuNAV
--%>

<c:forEach var="order" items="${orders}">
    <tr>
        <td>${order.id}</td>
        <td>${order.created_date}</td>
        <td>${order.status}</td>
        <td>
            <c:if test="${order.status != 'Cancelled'}">
                <a href="customer?service=cancelOrder&orderId=${order.id}">Cancel</a>
            </c:if>
        </td>
    </tr>
</c:forEach>
