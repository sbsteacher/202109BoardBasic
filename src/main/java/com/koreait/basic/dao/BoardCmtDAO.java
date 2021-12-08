package com.koreait.basic.dao;

import com.koreait.basic.DbUtils;
import com.koreait.basic.board.cmt.model.BoardCmtEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardCmtDAO {
    public static int insBoardCmt(BoardCmtEntity param) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = " INSERT INTO t_board_cmt " +
                    " ( iboard, ctnt, writer ) " +
                    " VALUES " +
                    " ( ?, ?, ? ) ";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            ps.setString(2, param.getCtnt());
            ps.setInt(3, param.getWriter());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }
}
