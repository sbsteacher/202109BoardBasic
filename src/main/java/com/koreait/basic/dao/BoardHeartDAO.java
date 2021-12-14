package com.koreait.basic.dao;

import com.koreait.basic.DbUtils;
import com.koreait.basic.board.model.BoardHeartEntity;

import java.sql.*;

public class BoardHeartDAO {
    // 좋아요 처리
    public static int insBoardHeart(BoardHeartEntity entity) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = " INSERT INTO t_board_heart (iuser, iboard) " +
                    " VALUES (?, ?) ";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, entity.getIuser());
            ps.setInt(2, entity.getIboard());
            return ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace();
        } finally { DbUtils.close(con, ps); }
        return 0;
    }

    // 좋아요 취소 처리
    public static int delBoardHeart(BoardHeartEntity entity) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = " DELETE FROM t_board_heart WHERE iuser = ? AND iboard = ? ";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, entity.getIuser());
            ps.setInt(2, entity.getIboard());
            return ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace();
        } finally { DbUtils.close(con, ps); }
        return 0;
    }

    // return 1: 좋아요 했음, 2: 좋아요 안 했음, 0: 에러
    // select 파라미터는 DTO (FM)인데 오바인거 같아서 Entity를 사용함.
    public static int selIsHeart(BoardHeartEntity entity) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT iuser FROM t_board_heart WHERE iuser = ? AND iboard = ? ";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, entity.getIuser());
            ps.setInt(2, entity.getIboard());
            rs = ps.executeQuery();
            if(rs.next()) { return 1; }
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return 0;
    }
}
