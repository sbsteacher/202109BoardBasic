<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="/user/login" method="post" id="frm">
        <div><input type="text" name="uid" placeholder="id"></div>
        <div><input type="text" name="upw" placeholder="password"></div>
        <div><input type="submit" value="login"></div>
    </form>
    <div>
        <a href="/user/join">join</a>
    </div>
</div>
<script src="/res/js/user/login.js"></script>