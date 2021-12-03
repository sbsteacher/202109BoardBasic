package com.koreait.basic.board;

import com.koreait.basic.Utils;
import com.koreait.basic.board.model.BoardDTO;
import com.koreait.basic.board.model.BoardVO;
import com.koreait.basic.dao.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = Utils.getParameterInt(req, "iboard");
        BoardDTO param = new BoardDTO();
        param.setIboard(iboard);

        BoardVO data = BoardDAO.selBoardDetail(param);

        int loginUserPk = Utils.getLoginUserPk(req);
        if(data.getWriter() != loginUserPk) { //로그인 안 되어 있으면 0, 로그인 되어 있으면 pk값
            BoardDAO.updBoardHitUp(param);
        }
        req.setAttribute("data", data);
        Utils.displayView(data.getTitle(), "board/detail", req, res);
    }
}