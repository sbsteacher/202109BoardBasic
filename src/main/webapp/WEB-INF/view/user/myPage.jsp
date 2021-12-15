<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
- 2차 메뉴 나타나게 한다.
- 2차 메뉴에서 선택되어진 화면을 나타나게 한다.
- layout.jsp와 같은 역할을 한다.
-->
<div class="subContainer">
    <div class="subMenus">
        <ul>
            <li><a href="/user/profile">프로필</a></li>
            <li><a href="/user/password">비밀번호 변경</a></li>
        </ul>
    </div>
    <div class="subBody"><jsp:include page="/WEB-INF/view/${requestScope.subPage}.jsp"></jsp:include></div>
</div>