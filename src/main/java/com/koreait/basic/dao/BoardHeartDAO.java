package com.koreait.basic.dao;

import com.koreait.basic.DbUtils;
import com.koreait.basic.board.model.BoardDTO;
import com.koreait.basic.board.model.BoardHeartEntity;

import java.sql.*;

public class BoardHeartDAO {

    // 리턴: 좋아요 했다면 1, 아니면 0 ||||| 글번호 iboard, 로그인한 사람의 loginUserPk
    public static int selIsHeart(BoardHeartEntity param) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT iuser FROM t_board_heart " +
                    " WHERE iuser = ? AND iboard = ? ";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIuser());
            ps.setInt(2, param.getIboard());
            rs = ps.executeQuery();
            if(rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return 0;
    }
}
