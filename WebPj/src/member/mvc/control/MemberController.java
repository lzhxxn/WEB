package member.mvc.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.mvc.model.MemberService;
import board.mvc.vo.ListResult;
import mvc.domain.Member;
import file.mvc.model.FileSet;
import member.mvc.model.MemberService;


@WebServlet("/member/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("list")) {
				list(request, response);
			}else if(m.equals("insert")) {
				insert(request, response);
			}else {
				list(request, response);
				System.out.println("se");
			}
		}else {
			list(request, response);
		}
    }

	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//<����¡������ session�� set / get ������� ���� �����Ѵ�.>//
		String cpStr = request.getParameter("cp"); //Ŭ���̾�Ʈ�κ��� �޾ƾ��Ѵ�. index (cp)(ps)
		String psStr = request.getParameter("ps"); //Ŭ���̾�Ʈ�κ��� �޾ƾ��Ѵ�. index (cp)(ps)
		//Member.do??m=list&cp=?&ps=? ���·� �Ѿ�´�.
		HttpSession session = request.getSession();
		//(1) cp 
				int cp = 1; // �ϴ� cp�� 1�̶�� �����Ѵ�. 
				if(cpStr == null) { // ���� �Ķ���ͷ� �Է� ���� ���� ���ٸ�,
					Object cpObj = session.getAttribute("cp"); 
					// ���� ���ǿ� �ԷµǾ��� cp���� �����ͼ� ������Ʈ���·� �����.
					if(cpObj != null) {
						cp = (Integer)cpObj; // �⺻������ �ٲ��ش�.
					}
				}else {  //if(cpStr != null)
					cpStr = cpStr.trim();
					cp = Integer.parseInt(cpStr);
				}
				session.setAttribute("cp", cp);
				
				/// (2) Page Size : ps 
				int ps = 3;  // �⺻��
				if(psStr == null) { // �Ķ���ͷ� ���� ���� ������,
					Object psObj = session.getAttribute("ps");
					// ���ǿ� �ִ� ps���� �����ͼ� psObj�� ���� �־��ش�.
					if(psObj != null) { // �� ���� ���� �ƴϸ�, 
						ps = (Integer)psObj; // �⺻������ �ٲ��ش�.
					}		
				}else { // null�� �ƴϸ� parameter ���� �Ѿ�� ��. if(psStr != null)
					psStr = psStr.trim();// ������ �����ؼ� ����
					int psParam = Integer.parseInt(psStr);// ����ȯ�ؼ� psParam���� ����
					Object psObj = session.getAttribute("ps");
					if(psObj != null) { //���ǿ� ��ϵ� ���� �ִٸ�,
						int psSession = (Integer)psObj;// �װ��������ͼ�, int�� ����ȯ �� psSession�� ����
						if(psSession != psParam) {// ���ǿ��ִ�����, �Ķ���ͷ� �Ѿ�� ���� �ٸ��ٸ�
							cp = 1; //������ ��������ؼ� cp���ٲ��. �Ǿ��������� cp �ٲ��!
							session.setAttribute("cp", cp);
						}
					}else {
						if(ps != psParam) { //�굵����
							cp = 1;
							session.setAttribute("cp", cp);
						}
					}
					
					ps = psParam; //�Ķ���Ϳ��� �Ѿ�� ������ ps�� �������ش�.
				}
				session.setAttribute("ps", ps); //������ ps���� ���ǿ� ����Ѵ�.
				
				MemberService service = MemberService.getInstance(); //���񽺰�üȣ��
				ListResult listResult = service.getListResult(cp, ps);		
				//cp�� ps�� ���ο� ����Ʈ����Ʈ ��ü�� �������ش�.
				request.setAttribute("listResult", listResult);	 
				//������ ��ü�� request�� ������ش�.
				
				if(listResult.getList(cp, ps).size() == 0 && cp>1) { 
					//�ش� ����������Ʈ�� �����, �������� 1������ �̻��� ���
					response.sendRedirect("Member.do?m=list&cp="+(cp-1));
					//������������ ���ư���.
				}else {
					String view = "list.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				}
		    }
    

    private void insert(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String phone = request.getParameter("phone");
    	String addr = request.getParameter("addr");
    	String grade = request.getParameter("grade");

    	Member dto = new Member(-1, name, email, phone, addr, grade, null);
    	MemberService service = MemberService.getInstance();
    	service.insertS(dto);
    	System.out.println("ȸ������ �Ϸ�!");
    	
    	String view = "../context/context.jsp";
    	response.sendRedirect(view);
    }
}