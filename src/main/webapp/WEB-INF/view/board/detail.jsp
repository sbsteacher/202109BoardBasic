<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <c:if test="${sessionScope.loginUser.iuser == requestScope.data.writer}">
    <div>
        <a href="/board/del?iboard=${requestScope.data.iboard}"><button>삭제</button></a>
        <a href="/board/regmod?iboard=${requestScope.data.iboard}"><button>수정</button></a>
    </div>
    </c:if>
    <div>글번호: ${requestScope.data.iboard}</div>
    <div>조회수 : <c:out value="${requestScope.data.hit}"/></div>
    <div>작성자 : <c:out value="${requestScope.data.writerNm}"/></div>
    <div>등록일시 : <c:out value="${requestScope.data.rdt}"/></div>
    <div>제목 : <c:out value="${requestScope.data.title}"/></div>
    <div><c:out value="${requestScope.data.ctnt}"/></div>
</div>
