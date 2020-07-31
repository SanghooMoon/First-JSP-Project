package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dto.Member;
import member.model.service.MemberService;
import member.model.service.MemberServiceImpl;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MemberService mService;   
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		mService = new MemberServiceImpl();
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String path = request.getPathInfo();
		System.out.println("MemberController : " + path);
		
		String nextPage = null;	// 이동할 페이지
		
		if(path.equals("/login")) {				// 로그인(화면) 
			nextPage = "/membership/login.jsp";
		} else if(path.equals("/signIn")) {			// 로그인(서비스), 스프링때는 ajax로도 해보자
			
			// 기본 다음페이지는 로그인(로그인실패), 성공 시 메인으로
			nextPage = "/membership/login.jsp";

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			System.out.println(id);
			System.out.println(pwd);
			
			Member member = mService.signIn(id);
			
			if(member!=null && pwd.equals(member.getPwd())) {
				
				if(member.getUse().equals("N")) {
					request.setAttribute("msg", "승인되지 않은 사용자입니다. 관리자에게 문의해주세요.");
				} else if(member.getGrade().equals("ADMIN")) {
					nextPage = "/admin/home";
					HttpSession session = request.getSession();
					session.setAttribute("loginUserInfo", member);
				} else {
					nextPage = "/index";
					HttpSession session = request.getSession();
					session.setAttribute("loginUserInfo", member);
				}

			} else {
				request.setAttribute("msg", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			}
			
		} else if(path.equals("/logout")) {		// 로그아웃(서비스)
			nextPage = "/index";
			HttpSession session = request.getSession();
			session.invalidate();	// 세션 해제
			
		} else if(path.equals("/agree")) {		// 회원가입-약관동의(화면)
			nextPage = "/membership/agree.jsp";
		} else if(path.equals("/register")) {	// 회원가입-정보입력(화면)
			
			if(!"true".equals(request.getParameter("continue")))
				nextPage = "/membership/agree.jsp";
			else
				nextPage = "/membership/register.jsp";
			
		} else if(path.equals("/duplicateChk")) {	// 회원가입 - 아이디 중복체크(서비스)
			String id = request.getParameter("id");
			PrintWriter writer = response.getWriter();
			if(mService.idDuplicateChk(id)) {
				System.out.println("존재하는 아이디");
				writer.print("used");
			} else {
				System.out.println("사용가능한 아이디");
				writer.print("not_used");
			}
			
			return;
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
