package soo.sv.addr;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class AddrServletList extends HttpServlet 
{
	Connection con;
	Statement stmt;

	public void init(){ //서블릿 로딩 ( by 첫번째 요청) 
		System.out.println("init()수행");
	    String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "servlet", "java");
			stmt = con.createStatement();
		}catch(ClassNotFoundException cnfe){
			System.out.println("init() cnfe: 드라이버(ojbc8.jar)를 못찾음");
		}catch(SQLException se){
			System.out.println("init() se: " + se);
		}
	}
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException { //요청될 때마다 
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();

		//System.out.println("service()수행");
        pw.println("<meta charset='utf-8'>");
		pw.println("<style>");
			pw.println("table, th, td {");
			   pw.println("border: 1px solid black;");
			   pw.println("border-collapse: collapse;");
			pw.println("}");
			pw.println("th, td {");
			   pw.println("padding: 5px;");
			pw.println("}");
			pw.println("a { text-decoration:none }");
		pw.println("</style>");
		pw.println("<center>");
			pw.println("<h1>");
				pw.println("Address List ");
			pw.println("</h1>");
			pw.println("<a href='../'>index</a>");
			pw.println("&nbsp;&nbsp;&nbsp;");
			pw.println("<a href='input.html'>write</a>");
			pw.println("<table border='1' cellpadding='7' cellspacing='2' width='50%'>");
				pw.println("<tr>");
					pw.println("<th>번호</th>");
					pw.println("<th>이름</th>");
					pw.println("<th>주소</th>");
					pw.println("<th>날짜</th>");
					pw.println("<th>삭제</th>");
				pw.println("</tr>");
		ResultSet rs = null;
		String sql = "select * from ADDRESS order by SEQ desc";
		try{
			rs = stmt.executeQuery(sql);
			boolean flag = false;
			while(rs.next()){
				flag = true;
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				Date rdate = rs.getDate(4);
				pw.println("<tr>");
					pw.println("<td align='center'>"+seq+"</td>");
					pw.println("<td>"+name+"</td>");
					pw.println("<td>"+addr+"</td>");
					pw.println("<td>"+rdate+"</td>");
					pw.println("<td align='center'><a href='del.do?seq="+seq+"'>삭제</a></td>");
				pw.println("</tr>");
			}

			if(!flag){
				pw.println("<tr>");
					pw.println("<td colspan='5' align='center'>데이터 없음</a>");
				pw.println("</tr>");
			}
		}catch(SQLException se){
		}finally{
			try{
				if(rs != null) rs.close();
			}catch(SQLException se){}
		}
			pw.println("</table>");
		pw.println("</center>");
	}
	public void destroy(){ //서블릿 언로딩 ( by 서블릿 갱신 , 오랫동안 서비스를 호출하지X) 
        try{
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException se){
		}
	
		/*try{
			FileWriter fw = new FileWriter("AddrServletList.log");
			PrintWriter pw = new PrintWriter(fw, true);
			pw.println("destroy()수행 됨!!");
			pw.close();
			fw.close();
		}catch(IOException ie){}
		*/
		System.out.println("destroy()수행"); 
	}
}
//soo.sv.addr.AddrServletList
