package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.AdminService;
import admin.model.service.AdminServiceImpl;
import member.model.dto.Member;



@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private AdminService aService; 
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		aService = new AdminServiceImpl();
	}

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
		} else if(path.equals("/approval")) {	// 회원가입 승인 페이지로 이동
			nextPage = "/administrator/approval.jsp";
			
			ArrayList<Member> list = aService.approvalList();
			request.setAttribute("list", list);
			
		} else if(path.equals("/update/approval")) {	// 가입 승인
			nextPage = "/admin/approval";
			
			// 선택되어온 회원들의 아이디
			String[] checked = request.getParameterValues("checked");
			if(checked==null) {
				request.getRequestDispatcher(nextPage).forward(request, response);
				return;
			}
			
			for(String chk : checked) {
				System.out.println("체크된 id : " + chk);
				aService.approvalMember(chk);
			}
			
		} else if(path.equals("/update/reject")) {		// 가입 거절
			nextPage = "/admin/approval";
			
			String[] checked = request.getParameterValues("checked");
			if(checked==null) {
				request.getRequestDispatcher(nextPage).forward(request, response);
				return;
			}
			
			for(String chk : checked) {
				System.out.println("삭제 시 체크된 id : " + chk);
				aService.rejectMember(chk);
			}
		} else if(path.equals("/management")) {			// 가입 승인된 회원 리스트
			nextPage = "/administrator/memberList.jsp";
			
			// 가입된 목록 확인
			ArrayList<Member> list = aService.MemberList();
			request.setAttribute("list", list);
			
		} else if(path.equals("/update/modify")) {		// 회원 등급 수정
			nextPage = "/administrator/memberList.jsp";

			System.out.println("회원등급 수정");
			
			String[] grades = request.getParameterValues("grade");
			String[] ids = request.getParameterValues("id");
			
			for(int i=0; i<grades.length; i++) {
				aService.modifyGrade(grades[i], ids[i]);
			}
			// 목록 확인
			ArrayList<Member> list = aService.MemberList();
			request.setAttribute("list", list);
			
		}
		
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
