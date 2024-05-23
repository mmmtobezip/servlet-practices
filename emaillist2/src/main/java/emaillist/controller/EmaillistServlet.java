package emaillist.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import emaillist.dao.EmaillistDao;
import emaillist.vo.EmaillistVo;

public class EmaillistServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("a");
    
    // 들어오는 action 요청에 따라 제어 -> Servlet의 역할
    if ("form".equals(action)) {
      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
      rd.forward(request, response); 

    } else if ("add".equals(action)) {
      String firstName = request.getParameter("fn"); 
      String lastName = request.getParameter("ln");
      String email = request.getParameter("email");
      
      EmaillistVo vo = new EmaillistVo();
      vo.setFirstName(firstName);
      vo.setLastName(lastName);
      vo.setEmail(email);
      
      new EmaillistDao().insert(vo);
      
      response.sendRedirect(request.getContextPath() + "/el");

    } else {
      // default action(= 전체 리스트 보여주기)
      List<EmaillistVo> list = new EmaillistDao().findAll();
      request.setAttribute("list", list); 
      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp"); //응답을 분기처리하기 위해 어떤 jsp를 선택할 지 선택(코드의 흐름을 Servlet -> JSP로 넘기는)
      rd.forward(request, response); //Servlet의 request와 JSP의 request가 같아짐. -> 동일한 request 객체를 바라봄. 
    }


  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
