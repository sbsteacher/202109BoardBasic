package com.koreait.basic.board.cmt;

import com.koreait.basic.Utils;
import com.koreait.basic.board.cmt.model.BoardCmtEntity;
import com.koreait.basic.dao.BoardCmtDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/cmt/mod")
public class BoardCmtModServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = Utils.getParameterInt(req, "iboard");
        int icmt = Utils.getParameterInt(req, "icmt");
        String ctnt = req.getParameter("ctnt");
        int writer = Utils.getLoginUserPk(req);

        BoardCmtEntity param = new BoardCmtEntity();
        param.setIcmt(icmt);
        param.setCtnt(ctnt);
        param.setWriter(writer);

        int result = BoardCmtDAO.updBoardCmt(param);

        res.sendRedirect("/board/detail?nohits=1&iboard=" + iboard);
    }
}