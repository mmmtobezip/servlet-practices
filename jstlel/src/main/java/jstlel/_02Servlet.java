package jstlel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _02Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    /*
     * 1. 객체의 Scope(존속범위) 객체의 존재 범위(언제 생겨서 언제 죽니)
     * 
     * 2. 객체의 존속 주기(생명 주기) Application(Context) Scope > Session Scope > Request Scope > Page Scope
     * 
     * 3. EL이 이름으로 객체를 찾는 순서 ${vo.name } Page Scope > Request Scope > Session Scope >
     * Application(Context) Scope
     * 
     * [주의] 같은 이름으로 여러 범위에 객체를 저장하는 경우 주의 필요!
     * 
     */

    // 1. Reqeust Scope
    UserVo vo1 = new UserVo();
    vo1.setNo(1L);
    vo1.setName("둘리1");
    request.setAttribute("vo", vo1);

    // 2. Session Scope
    UserVo vo2 = new UserVo();
    vo2.setNo(1L);
    vo2.setName("둘리2");
    request.getSession(true);
    request.setAttribute("vo", vo2);

    // 3. Application Scope
    UserVo vo3 = new UserVo();
    vo3.setNo(1L);
    vo3.setName("둘리3");
    request.getSession(true).setAttribute("vo", vo3);

    request.getRequestDispatcher("/WEB-INF/views/02.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
