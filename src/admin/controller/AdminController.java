package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dto.Member;


@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String nextPage = null;	// 이동할 페이지

		String path = request.getPathInfo();
		System.out.println("AdminController : " + path);
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUserInfo");
		
		// 로그인상태가 아니거나, 관리자가 아닌 유저이면 사용자 메인페이지로 이동
		if(member==null || !member.getGrade().equals("ADMIN")) {
			nextPage = "/index";
			request.getRequestDispatcher(nextPage).forward(request, response);
		}

		if(path.equals("/home")) {				// 관리자화면으로 이동
			nextPage = "/indexAdmin.jsp";
		} 
		
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
