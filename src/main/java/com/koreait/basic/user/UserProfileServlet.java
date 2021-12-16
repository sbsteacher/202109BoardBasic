package com.koreait.basic.user;

import com.koreait.basic.FileUtils;
import com.koreait.basic.Utils;
import com.koreait.basic.dao.UserDAO;
import com.koreait.basic.user.model.UserEntity;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import org.apache.catalina.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/user/profile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int loginUserPk = Utils.getLoginUserPk(req);
        UserEntity entity = new UserEntity();
        entity.setIuser(loginUserPk);
        req.setAttribute("data", UserDAO.selUser(entity));

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
        if(targetFolder.exists()) {
            FileUtils.delFolderFiles(targetPath, false);
        } else {
            targetFolder.mkdirs();
        }
        MultipartRequest mr
                = new MultipartRequest(req, targetPath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());

        String changedFileNm = mr.getFilesystemName("profileImg");
        UserEntity entity = new UserEntity();
        entity.setIuser(loginUserPk);
        entity.setProfileImg(changedFileNm);
        int result = UserDAO.updUser(entity);
        //doGet(req, res);
        res.sendRedirect("/user/profile");
    }



    protected void doGet2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = "프로필";
        req.setAttribute("subPage", "user/profile"); //열어야 될 jsp파일명
        Utils.displayView(title, "user/myPage", req, res);
    }

    protected void doPost2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int loginUserPk = Utils.getLoginUserPk(req);
        int maxSize = 10_485_760; // 1024 * 1024 * 10 (10mb)

        ServletContext application = req.getServletContext();
        String targetPath =  application.getRealPath("/res/img/profile/" + loginUserPk);
        File targetFolder = new File(targetPath);
        if(targetFolder.exists()) {
            FileUtils.delFolderFiles(targetPath, false);
        } else {
            targetFolder.mkdirs();
        }
        System.out.println("targetPath : " + targetPath);

        MultipartRequest mr = new MultipartRequest(req, targetPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
        String changedFileNm = mr.getFilesystemName("profileImg");

        UserEntity entity = new UserEntity();
        entity.setIuser(loginUserPk);
        entity.setProfileImg(changedFileNm);

        int result = UserDAO.updUser(entity);
        if(result == 1) {
            UserEntity loginUser = Utils.getLoginUser(req);
            loginUser.setProfileImg(changedFileNm);
        }
        //doGet(req, res);
        res.sendRedirect("/user/profile");
    }
}