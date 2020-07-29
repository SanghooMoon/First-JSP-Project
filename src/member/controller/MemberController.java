package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dto.Member;
import member.model.service.MemberService;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MemberService mService;   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String path = request.getPathInfo();
		System.out.println("MemberController : " + path);
		
		String nextPage = null;	// 이동할 페이지
		
		if(path.equals("/login")) {				// 로그인(화면) 
			nextPage = "/membership/login.jsp";
		} else if(path.equals("/agree")) {		// 회원가입-약관동의(화면)
			nextPage = "/membership/agree.jsp";
		} else if(path.equals("/register")) {	// 회원가입-정보입력(화면)
			if(!"true".equals(request.getParameter("continue")))
				nextPage = "/membership/agree.jsp";
			else
				nextPage = "/membership/register.jsp";
		} else if(path.equals("/signUp")) {		// 회원가입-정보입력(서비스)
			nextPage = "/membership/login.jsp";
			
			// 회원 생성 후 입력받은 정보 저장
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setPwd(request.getParameter("pwd"));
			member.setName(request.getParameter("name"));
			member.setPhone(request.getParameter("phone"));
			
			mService.singUp(member); // 회원가입 서비스 실행
			

			
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
