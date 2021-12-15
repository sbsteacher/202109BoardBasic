package com.koreait.basic.user;

import com.koreait.basic.Utils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/user/profile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = "프로필";
        req.setAttribute("subPage", "user/profile"); //열어야 될 jsp파일명
        Utils.displayView(title, "user/myPage", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int loginUserPk = Utils.getLoginUserPk(req);
        int fileMaxSize = 10_485_760; // 1024 * 1024 * 10 (10mb)

        ServletContext application = req.getServletContext();
        String targetPath = application.getRealPath("/res/img/profile/" + loginUserPk);  //톰캣에서 돌아가는 프로젝트 root경로값 문자열을 준다.

        System.out.println("targetPath : " + targetPath);

        File targetFolder = new File(targetPath);
        targetFolder.mkdirs();

        MultipartRequest mr
                = new MultipartRequest(req, targetPath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());
    }
}