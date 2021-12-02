<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <table>
        <tr>
            <th>no</th>
            <th>title</th>
            <th>hits</th>
            <th>writer</th>
            <th>reg-datetime</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="item">
            <tr>
                <td>${item.iboard}</td>
                <td><c:out value="${item.title}"/></td>
                <td>${item.hit}</td>
                <td><c:out value="${item.writerNm}"/></td>
                <td>${item.rdt}</td>
            </tr>
        </c:forEach>
    </table>
</div>