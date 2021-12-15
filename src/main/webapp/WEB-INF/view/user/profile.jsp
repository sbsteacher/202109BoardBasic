<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div>${requestScope.data.profileImg}</div>
    <div>
        <div>아이디 : ${requestScope.data.uid}</div>
        <div>이름 : ${requestScope.data.nm}</div>
        <div>성별 : ${requestScope.data.gender}</div>
        <div>가입일 : ${requestScope.data.rdt}</div>
    </div>
    <div>
        <form action="/user/profile" method="post" enctype="multipart/form-data">
            <div><label>이미지 : <input type="file" name="profileImg" accept="image/*"></label></div>
            <div><input type="submit" value="이미지 업로드"></div>
        </form>
    </div>
</div>