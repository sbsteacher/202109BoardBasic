package com.koreait.basic.board;

import com.koreait.basic.Utils;
import com.koreait.basic.board.model.BoardEntity;
import com.koreait.basic.dao.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/regmod")
public class BoardRegModServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = "글등록";
        Utils.displayView(title, "board/regmod", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int loginUserPk = Utils.getLoginUserPk(req);
        if(loginUserPk == 0) {
            res.sendRedirect("/user/login");
            return;
        }

        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");

        BoardEntity entity = new BoardEntity();
        entity.setTitle(title);
        entity.setCtnt(ctnt);
        entity.setWriter(loginUserPk);

        int result = BoardDAO.insBoardWithPk(entity);

        System.out.println("after-insert-iboard : " + entity.getIboard());
        switch (result) {
            case 1:
                if(entity.getIboard() != 0) {
                    res.sendRedirect("/board/detail?iboard=" + entity.getIboard());
                    return;
                }
                break;
        }
        res.sendRedirect("/board/list");
    }
}