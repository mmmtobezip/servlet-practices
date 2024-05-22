package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import guestbook.vo.GuestBookVo;

public class GuestBookDao {

  public boolean insert(GuestBookVo vo) {
    boolean result = false;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      // 1. JDBC Driver 로딩
      Class.forName("org.mariadb.jdbc.Driver");

      // 2. 연결하기
      String url = "jdbc:mariadb://192.168.0.191:3306/webdb?charset=utf8";
      conn = DriverManager.getConnection(url, "webdb", "webdb");

      // 3. Statement 준비
      String sql = "insert into guestbook values(null, ?, ?, ?, now())";
      // datetime 가져온다음
      pstmt = conn.prepareStatement(sql);

      // 4. Binding
      pstmt.setString(1, vo.getName());
      pstmt.setString(2, vo.getPassword());
      pstmt.setString(3, vo.getContents());
      pstmt.setString(4, vo.getRegDate());

      // 5. SQL 실행
      int count = pstmt.executeUpdate();

      // 6. 결과 처리
      result = count == 1;
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패:" + e);
    } catch (SQLException e) {
      System.out.println("error:" + e);
    } finally {
      try {
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException e) {
        System.out.println("error: " + e);
      }
    }
    return result;
  }


  public void deleteByNoAndPassword(Long no, String password) {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      // 1. JDBC Driver 로딩
      Class.forName("org.mariadb.jdbc.Driver");

      // 2. 연결하기
      String url = "jdbc:mariadb://192.168.0.191:3306/webdb?charset=utf8";
      conn = DriverManager.getConnection(url, "webdb", "webdb");

      // 3. Statement 준비시키기(prepare)
      String sql = "delete from guestbook where no = ? and password = ?";
      pstmt = conn.prepareStatement(sql);

      // 4. Parameter Binding
      pstmt.setLong(1, no);
      pstmt.setString(2, password);

      // 5. SQL 실행
      pstmt.executeUpdate();
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패:" + e);
    } catch (SQLException e) {
      System.out.println("error:" + e);
    } finally {
      try {
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException e) {
        System.out.println("error: " + e);
      }
    }
  }


  public List<GuestBookVo> findAll() {
    List<GuestBookVo> result = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {

      // 1. JDBC Driver 로딩
      Class.forName("org.mariadb.jdbc.Driver");

      // 2. 연결하기
      String url = "jdbc:mariadb://192.168.0.191:3306/webdb?charset=utf8";
      conn = DriverManager.getConnection(url, "webdb", "webdb");

      // 3. Statement 준비시키기(prepare)
      String sql = "select no, name, contents, date_format(reg_date, '%Y/%m/%d %H:%i:%s')"
          + "     from guestbook" + " order by reg_date desc";
      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      // 6. 결과 처리
      while (rs.next()) {
        Long no = rs.getLong(1);
        String name = rs.getString(2);
        String contents = rs.getString(3);
        String regDate = rs.getString(4);

        GuestBookVo vo = new GuestBookVo();
        vo.setNo(no);
        vo.setName(name);
        vo.setContents(contents);
        vo.setRegDate(regDate);

        result.add(vo);
      }
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패:" + e);
    } catch (SQLException e) {
      System.out.println("error:" + e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException e) {
        System.out.println("error: " + e);
      }
    }
    return result;
  }

}

