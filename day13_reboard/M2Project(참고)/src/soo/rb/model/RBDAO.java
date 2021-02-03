package soo.rb.model;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;
import java.util.*;

import soo.path.M2ProjectPath;
import soo.rb.controller.ReBoardEditForm;
import soo.sql.RBSQL;
import com.oreilly.servlet.MultipartRequest;

import java.io.*;

public class RBDAO {
	Connection con;
	
	// 1. listing 
	PreparedStatement pstmt0;
	ResultSet rs0;
	
	Statement stmt1;
	ResultSet rs1;
	
	// 2. writeOk
	PreparedStatement pstmt2;
	
	Statement stmt3;
	ResultSet rs3;
	
	PreparedStatement pstmt4;
	
	PreparedStatement pstmt5;
	ResultSet rs5;
	
	// 3. content 
	PreparedStatement pstmt6;
	ResultSet rs6;
	
	PreparedStatement pstmt7;
	
	PreparedStatement pstmt8;
	
	PreparedStatement pstmt9;
	ResultSet rs9;
	
	PreparedStatement pstmt10;
	ResultSet rs10;
	
	PreparedStatement pstmt11;
	
	PreparedStatement pstmt12;
	ResultSet rs12;
	
	PreparedStatement pstmt13;
	
	// 4. edit 
	PreparedStatement pstmt14;
	ResultSet rs14;
	
	PreparedStatement pstmt15;
	ResultSet rs15;
	
	PreparedStatement pstmt16;
	
	// 5. del 
	PreparedStatement pstmt17;
	ResultSet rs17;
	
	PreparedStatement pstmt18;
	
	PreparedStatement pstmt19;
	
	// 6. rewrite 
	PreparedStatement pstmt20;
	ResultSet rs20;
	
	PreparedStatement pstmt21;
	
	PreparedStatement pstmt22;
	
	public RBDAO()
    {
    	Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
	        DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
	        con = ds.getConnection();
	        System.out.println("## RBDAO()의 con 생성 : " + con);
		} 
		catch (NamingException e) 
		{
			System.out.println("jndi를 못찾음 : "  + e);
		}		
		catch(SQLException se)
		{
			System.out.println("con을 못얻음 : " + se);
		}
    }
	
	// 1. listing관련 메소드 
	public ArrayList dbDAOList(int tableNumber, int currentPage, int pageSize) 
	{
		String sql_list = null;
		
		switch(tableNumber)
		{
		      case 0 : sql_list = RBSQL.RB_SELECT_TN_0; break;
		      case 1 : sql_list = RBSQL.RB_SELECT_TN_1; break;
		      case 2 : sql_list = RBSQL.RB_SELECT_TN_2; break;
		      default : sql_list = "";
		}
		 
		ArrayList list = new ArrayList();
		
		try
		{   
		   pstmt0 = con.prepareStatement(sql_list); 
		   pstmt0.setInt(1, pageSize * (currentPage -1));
		   pstmt0.setInt(2, pageSize * currentPage);
		   rs0 = pstmt0.executeQuery();
		   
		   while(rs0.next()) // sql문에 의해 컬럼 순서가 뒤바꿔짐  
		   {
		   	   int idx = rs0.getInt("idx");
		   	   //System.out.println("idx : " + idx);
		   	   String writer = rs0.getString("writer");
		   	   //System.out.println("writer : "  + writer);
		   	   String email = rs0.getString("email");
		   	   //System.out.println("email : "  + email);
		   	   String homepage = rs0.getString("homepage");
		   	   //System.out.println("homepage : "  + homepage);
		   	   String pwd = rs0.getString("pwd");
		   	   //System.out.println("pwd : " + pwd);
		   	   String subject = rs0.getString("subject");
		   	   //System.out.println("subject : " + subject);
		   	   String content = rs0.getString("content");
		   	   //System.out.println("content : " + content);
		   	   java.sql.Date writedate = rs0.getDate("writedate");
		   	   //System.out.println("writedate : " + writedate.toString());
		   	   int readnum = rs0.getInt("readnum");
		   	   //System.out.println("readnum : " + readnum);
		   	   String filename = rs0.getString("filename");
		   	   //System.out.println("filename : " + filename);
		   	   int filesize = rs0.getInt("filesize");
		   	   //System.out.println("filesize : " + filesize);
		   	   int refer = rs0.getInt("refer");
		   	   //System.out.println("refer : " + refer);
		   	   int lev = rs0.getInt("lev");
		   	   //System.out.println("lev : " + lev);
		   	   int sunbun = rs0.getInt("sunbun");
		   	   //System.out.println("sunbun : " + sunbun);
		   	   
		   	   RBDTO dto = new RBDTO(idx, writer, email, homepage,
					pwd, subject, content, writedate,readnum, filename,filesize, 
					refer, lev, sunbun);
		   	   list.add(dto);
		   }
		   
		   return list;
		}
		catch(SQLException se)
		{
			System.out.println("RBDAO의 dbDAOList()에서 예외 : " + se);
			return null;
		}
		finally
		{
		    try
			{
		    	if(rs0 != null) rs0.close();
		    	if(pstmt0 != null) pstmt0.close();
		    	if(con != null) con.close(); //반드시 
			}catch(SQLException se){}
		}
	}
	
	public int dbDAOTotalGulCount(int tableNumber)
	{
		String sql_tgc = null;
		int totalGulCount = 0;
		
		switch(tableNumber)
		{
		      case 0 : sql_tgc = RBSQL.RB_TOTALCOUNT_TN_0; break;
		      case 1 : sql_tgc = RBSQL.RB_TOTALCOUNT_TN_1; break;
		      case 2 : sql_tgc = RBSQL.RB_TOTALCOUNT_TN_2; break;
		      default : sql_tgc = "";
		}
		
		try
		{
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery(sql_tgc);
			if(rs1.next())
			{
				totalGulCount = rs1.getInt(1);
			}
			
			return totalGulCount;
		}
		catch(SQLException se)
		{
			return -1;
		}
		finally
		{
			try
			{
				if(rs1 != null) rs1.close();
				if(stmt1 != null) stmt1.close();
				if(con != null) con.close(); //반드시 
			}
			catch(SQLException se){}
		}
	}
	
	// 2. writeOk관련 메소드 
	public boolean dbDAOWriteOk(MultipartRequest mr, int tableNumber)
	{
		// (1) client DATA를 받음 
		String subject = mr.getParameter("subject");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String email = mr.getParameter("email");
		String homepage = mr.getParameter("homepage");
		String pwd = mr.getParameter("pwd");
		  
		String filename = mr.getFilesystemName("filename");
		//String cType = mr.getContentType("filename");
	    //File f = mr.getFile("filename");
		long filesize = 0;
		int readnum = 0;

		if(filename == null)
		{
		   filename = "";
		}
		else 
		{
           filename = filename.trim();
		   filesize = mr.getFile("filename").length();
		}
		
		int refer_max = getRefer_max(tableNumber); // 2_1. 메소드 호출 
		System.out.println("dbDAOWriteOk()의 refer_max : " + refer_max);
		int refer = (refer_max + 1);
		int lev = 0;
		int sunbun = 0;
		
		// (2) sql문 실행 
		String sql_writeOk = null;
		
		switch(tableNumber)
		{
		      case 0 : sql_writeOk = RBSQL.RB_WRITEOK_TN_0; break;
		      case 1 : sql_writeOk = RBSQL.RB_WRITEOK_TN_1; break;
		      case 2 : sql_writeOk = RBSQL.RB_WRITEOK_TN_2; break;
		      default : sql_writeOk = "";
		}
		try
		{
			pstmt2 = con.prepareStatement(sql_writeOk);
			pstmt2.setString(1, writer);
			pstmt2.setString(2, email);
			pstmt2.setString(3, homepage);
			pstmt2.setString(4, pwd);
			pstmt2.setString(5, subject);
			pstmt2.setString(6, content);
			pstmt2.setInt(7, readnum);
			pstmt2.setString(8, filename);
			pstmt2.setLong(9, filesize);
			pstmt2.setInt(10, refer);
			pstmt2.setInt(11, lev);
			pstmt2.setInt(12, sunbun);
			int n = pstmt2.executeUpdate();
			if(n > 0)
			{
				if(!filename.equals(""))
				{
					if(dbDAOFilenameUpdate(tableNumber,filename, filesize)) //2_2 호출 
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return true;
				}
			}
			else 
			{
				return false;
			}
		}
		catch(SQLException se)
		{
			System.out.println("dbDAOWriteOk()에서 예외 se : " + se);
			return false;
		}
		finally
		{
			try
			{
				if(pstmt2 != null) pstmt2.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	
    //2_1. refer_max값 구하기 
	public int getRefer_max(int tableNumber)
	{
		String sql_referMax = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_referMax = RBSQL.RB_MAXREF_TN_0; break;
		    case 1 : sql_referMax = RBSQL.RB_MAXREF_TN_1; break;
		    case 2 : sql_referMax = RBSQL.RB_MAXREF_TN_2; break;
		    default : sql_referMax = "";
		}
		
		int refer_max = 0;
		try
		{
		    stmt3 = con.createStatement();
		    rs3 = stmt3.executeQuery(sql_referMax);
		    if(rs3.next())
		    {
		    	refer_max = rs3.getInt(1);
		    }
		    return refer_max;
		}
		catch(SQLException se)
		{
			return -1;
		}
		finally
		{
			try
			{
				if(rs3 != null) rs3.close();
				if(stmt3 != null) stmt3.close();
				//if(con != null) con.close();-같은 파일에서 호출되므로 close()하면 안됨
			}catch(SQLException se){}
		}
	}
	
	// 2_2. DB의 filename컬럼값을 변경하기 
	public boolean dbDAOFilenameUpdate(
			int tableNumber,String filename, long filesize)
	{
		String sql_fu = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_fu = RBSQL.RB_FNUPDATE_TN_0; break;
		    case 1 : sql_fu = RBSQL.RB_FNUPDATE_TN_1; break;
		    case 2 : sql_fu = RBSQL.RB_FNUPDATE_TN_2; break;
		    default : sql_fu = "";
		}
		
		String time_str = getWritedate(tableNumber, filename, filesize);//2_2_1호출 
		System.out.println("dbDAOFilenameUpdate()의 time_str : " + time_str);
        String filename_up = (time_str+"_"+filename);		
		try
		{
			
			pstmt4 = con.prepareStatement(sql_fu);
			pstmt4.setString(1, filename_up);
			pstmt4.setString(2, filename);
			pstmt4.setLong(3, filesize);
			int n = pstmt4.executeUpdate();
			if(n>0)
			{
				if(fileDAOFilenameUpdate(filename, filename_up)) // 2_2_2 호출
				{
				    return true;
				}
				else
				{
				    return false;
				}
			}
			else 
			{
				return false;
			}
		}
		catch(SQLException se)
		{
			return false;
		}
		finally
		{
			try
			{
				if(pstmt4 != null) pstmt4.close();
			}catch(SQLException se){}
		}
	}
	
    //2_2_1. writedate컬럼값 가져오기 
	public String getWritedate(int tableNumber,String filename, long filesize)
	{
		String sql_getDate = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_getDate = RBSQL.RB_GETDATE_TN_0; break;
		    case 1 : sql_getDate = RBSQL.RB_GETDATE_TN_1; break;
		    case 2 : sql_getDate = RBSQL.RB_GETDATE_TN_2; break;
		    default : sql_getDate = "";
		}
		
		try
		{
			pstmt5 = con.prepareStatement(sql_getDate);
			pstmt5.setString(1, filename);
			pstmt5.setLong(2, filesize);
			rs5 = pstmt5.executeQuery();
			if(rs5.next())
			{
			    String time_str = rs5.getString(1); // String으로 뽑는다.
			    //long time_long = date.getTime(); - day까지만 계산되기때문에  안됨 
			    //System.out.println("time_long : " + time_long);
			    System.out.println("time_str : " + time_str);
			    
			    return time_str;
			}
			else 
			{
				return "";
			}
		}
		catch(SQLException se)
		{
			 return "";
		}
		finally
		{
			try
			{
				if(rs5 != null) rs5.close();
				if(pstmt5 != null) pstmt5.close();
			}catch(SQLException se){}
		}
	}
	
	// 2_2_2. 실제 파일 시스템의  filename을 update 
	public boolean fileDAOFilenameUpdate(String filename, String filename_up)
	{
		File f = null;
		File f_children[] = null;
	    
    	f = new File(M2ProjectPath.RB_UPLOAD_DIR);
        f_children = f.listFiles();
        int len = f_children.length;
        for(int i=0; i<len; i++)
        {
        	String f_name = f_children[i].getName();
        	if(f_name.equals(filename))
        	{
        		System.out.println(
        				"fileDAOFilenameUpdate()의 f_name : " + f_name);
        		System.out.println(
        				"fileDAOFilenameUpdate()의 filename : " + filename);
        		System.out.println(
        				"fileDAOFilenameUpdate()의 filename_up : " + filename_up);
        		
        		f_children[i].renameTo(
        				new File(M2ProjectPath.RB_UPLOAD_DIR + "/" + filename_up));
        		return true;
        	}
        }
        return false;
	}
	
	
	
	// 3. content관련 메소드 
	public RBDTO dbDAOContent(int tableNumber, int idx)
	{
		String sql_content = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_content = RBSQL.RB_CONTENT_TN_0; break;
		    case 1 : sql_content = RBSQL.RB_CONTENT_TN_1; break;
		    case 2 : sql_content = RBSQL.RB_CONTENT_TN_2; break;
		    default : sql_content = "";
		}
		
		try
		{
			pstmt6 = con.prepareStatement(sql_content);
			pstmt6.setInt(1, idx);
			rs6 = pstmt6.executeQuery();
			if(rs6.next())
			{
				//int idx = rs6.getInt("idx");
		   	    String writer = rs6.getString("writer");
		   	    String email = rs6.getString("email");
		   	    String homepage = rs6.getString("homepage");
		   	    String pwd = rs6.getString("pwd");
		   	    String subject = rs6.getString("subject");
		   	    String content = rs6.getString("content");
		   	    java.sql.Date writedate = rs6.getDate("writedate");
		   	    int readnum = rs6.getInt("readnum");
		   	    String filename = rs6.getString("filename");
		   	    int filesize = rs6.getInt("filesize");
		   	    int refer = rs6.getInt("refer");
		   	    int lev = rs6.getInt("lev");
		   	    int sunbun = rs6.getInt("sunbun");
		   	   
		   	    RBDTO dto = new RBDTO(idx, writer, email, homepage,
					pwd, subject, content, writedate,readnum, filename,filesize, 
					refer, lev, sunbun);
		   	    
		   	    return dto;
			}
			else
			{
				return null;
			}
		}
		catch(SQLException se)
		{
			return null;
		}
		finally
		{
			try
			{
				if(rs6 != null) rs6.close();
				if(pstmt6 != null) pstmt6.close();
				//if(con != null) con.close(); - 아래의 dbDAOReadnum()에서 사용하므로..
			}
			catch(SQLException se){}
		}
	}
	// 3_1. content의 readnum증가 메소드 
    public boolean dbDAOReadnum(int tableNumber, int idx)
    {
    	String sql_readnum = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_readnum = RBSQL.RB_READNUM_TN_0; break;
		    case 1 : sql_readnum = RBSQL.RB_READNUM_TN_1; break;
		    case 2 : sql_readnum = RBSQL.RB_READNUM_TN_2; break;
		    default : sql_readnum = "";
		}
		
		try
		{
			pstmt7 = con.prepareStatement(sql_readnum);
			pstmt7.setInt(1, idx);
			int n = pstmt7.executeUpdate();
			if(n > 0) return true;
			else return false;
		}
		catch(SQLException se)
		{
			return false;
		}
		finally
		{
			try
			{
				if(pstmt7 != null) pstmt7.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
    
    // 3_2. content의 reply 저장  메소드 
    public boolean dbDAOReplySave(int tableNumber, int idx, 
    		String content_reply, String pwd_reply, String writer, String id)
    {
    	String sql_replySave = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_replySave = RBSQL.RB_REPLY_SAVE_TN_0; break;
		    case 1 : sql_replySave = RBSQL.RB_REPLY_SAVE_TN_1; break;
		    case 2 : sql_replySave = RBSQL.RB_REPLY_SAVE_TN_2; break;
		    default : sql_replySave = "";
		}
		
		try
		{
			pstmt8 = con.prepareStatement(sql_replySave);
			pstmt8.setString(1, writer);
			pstmt8.setString(2, pwd_reply);
			pstmt8.setString(3, content_reply);
			pstmt8.setString(4, id);  // member의 id 
			pstmt8.setInt(5, idx); // reboard의 글 idx 
			
			int n = pstmt8.executeUpdate();
			if(n > 0)
				return true;
			else
				return false;
		}
		catch(SQLException se)
		{
			return false;
		}
		finally
		{
			try
			{
				if(pstmt8 != null) pstmt8.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
    
    //  3_3. content의 reply 리스트  메소드
    public ArrayList dbDAOReplyList(int tableNumber, int idx)
    {
    	String sql_replyList = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_replyList = RBSQL.RB_REPLY_LIST_TN_0; break;
		    case 1 : sql_replyList = RBSQL.RB_REPLY_LIST_TN_1; break;
		    case 2 : sql_replyList = RBSQL.RB_REPLY_LIST_TN_2; break;
		    default : sql_replyList = "";
		}
		
		ArrayList list = new ArrayList();
		try
		{
			pstmt9 = con.prepareStatement(sql_replyList);
			pstmt9.setInt(1, idx);
			rs9 = pstmt9.executeQuery();
			while(rs9.next())
			{
				int idx_reply = rs9.getInt(1);
				String writer = rs9.getString(2);
				String pwd = rs9.getString(3);
				String content = rs9.getString(4);
				java.sql.Date writedate = rs9.getDate(5);
				String id = rs9.getString(6);
				//int idx = rs.get(7);
				ReplyDTO dto = new ReplyDTO(
						idx_reply, writer, pwd, content, writedate, id, idx);
				
				list.add(dto);
			}
			
			return list;
		}
		catch(SQLException se)
		{
		    return null;
		}
		finally
		{
			try
			{
				if(rs9 != null) rs9.close();
				if(pstmt9 != null) pstmt9.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
    
    
    // 3_4_1. content의 reply 삭제  메소드1
    public boolean dbDAOReplyDelToLoginid(int tableNumber, int idx_reply, String id)
    {
    	String sql_reply_sel_Id = null;
    	String sql_reply_del = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_reply_sel_Id = RBSQL.RB_REPLY_SEL_ID_TN_0;
		               sql_reply_del = RBSQL.RB_REPLY_DEL_TN_0; break;
		    case 1 : sql_reply_sel_Id = RBSQL.RB_REPLY_SEL_ID_TN_1; 
		               sql_reply_del = RBSQL.RB_REPLY_DEL_TN_1; break;
		    case 2 : sql_reply_sel_Id = RBSQL.RB_REPLY_SEL_ID_TN_2; 
		               sql_reply_del = RBSQL.RB_REPLY_DEL_TN_2; break;
		    default : sql_reply_sel_Id = ""; sql_reply_del = "";
		}
			
		try
		{
			pstmt10 = con.prepareStatement(sql_reply_sel_Id);
			pstmt10.setInt(1, idx_reply);
			rs10 = pstmt10.executeQuery();
			if(rs10.next())
			{
				String id_db = rs10.getString(1);
				if(id_db != null) id_db = id_db.trim();
				System.out.println("######id_db : " +id_db);
				
				if(id.equals(id_db) || id.equals("admin"))
				{
					pstmt11 = con.prepareStatement(sql_reply_del);
					pstmt11.setInt(1, idx_reply);
					int n = pstmt11.executeUpdate();
					if(n>0)
						return true;
					else 
						return false;
				}
				else
				{
				    return false;
				}
			}
			else
			{
				return false;
			}
		}
		catch(SQLException se)
		{
			return false;
		}
		finally
		{
			try
			{
				if(pstmt11 != null) pstmt11.close();
				if(rs10 != null) rs10.close();
				if(pstmt10 != null) pstmt10.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
    
    // 3_4_2. content의 reply 삭제  메소드2 
    public boolean dbDAOReplyDelToPwd(int tableNumber, int idx_reply, String pwd_reply)
    {
    	String sql_reply_sel_pwd = null;
    	String sql_reply_del = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_reply_sel_pwd = RBSQL.RB_REPLY_SEL_PWD_TN_0;
		               sql_reply_del = RBSQL.RB_REPLY_DEL_TN_0; break;
		    case 1 : sql_reply_sel_pwd = RBSQL.RB_REPLY_SEL_PWD_TN_1; 
		               sql_reply_del = RBSQL.RB_REPLY_DEL_TN_1; break;
		    case 2 : sql_reply_sel_pwd = RBSQL.RB_REPLY_SEL_PWD_TN_2; 
		               sql_reply_del = RBSQL.RB_REPLY_DEL_TN_2; break;
		    default : sql_reply_sel_pwd = ""; sql_reply_del = "";
		}
			
		try
		{
			pstmt12 = con.prepareStatement(sql_reply_sel_pwd);
			pstmt12.setInt(1, idx_reply);
			rs12 = pstmt12.executeQuery();
			if(rs12.next())
			{
				String pwd_db = rs12.getString(1);
				if(pwd_db != null) pwd_db = pwd_db.trim();
				if(pwd_reply.equals(pwd_db))
				{
					pstmt13 = con.prepareStatement(sql_reply_del);
					pstmt13.setInt(1, idx_reply);
					int n = pstmt13.executeUpdate();
					if(n > 0)
						return true;
					else 
						return false;
				}
				else 
				{
					return false;
				}
			}
			else 
			{
				return false;
			}
		}
		catch(SQLException se)
		{
			return false;
		}
		finally
		{
			try
			{
				if(pstmt13 != null) pstmt13.close();
				if(rs12 != null) rs12.close();
				if(pstmt12 != null) pstmt12.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
    
    // 4. edit 관련 메소드 
    public RBDTO dbDAOEdit(int tableNumber, int idx)
    {
    	String sql_edit = null;
		
		switch(tableNumber)
		{
		    case 0 : sql_edit = RBSQL.RB_EDIT_TN_0; break;
		    case 1 : sql_edit = RBSQL.RB_EDIT_TN_1; break;
		    case 2 : sql_edit = RBSQL.RB_EDIT_TN_2; break;
		    default : sql_edit = "";
		}
		try
		{
			pstmt14 = con.prepareStatement(sql_edit);
			pstmt14.setInt(1, idx);
			rs14 = pstmt14.executeQuery();
			if(rs14.next())
			{
//				int idx = rs14.getInt("idx");
		   	    String writer = rs14.getString("writer");
		   	    String email = rs14.getString("email");
		   	    String homepage = rs14.getString("homepage");
		   	    String pwd = rs14.getString("pwd");
		   	    String subject = rs14.getString("subject");
		   	    String content = rs14.getString("content");
		   	    java.sql.Date writedate = rs14.getDate("writedate");
		   	    int readnum = rs14.getInt("readnum");
		   	    String filename = rs14.getString("filename");
		   	    int filesize = rs14.getInt("filesize");
		   	    int refer = rs14.getInt("refer");
		   	    int lev = rs14.getInt("lev");
		   	    int sunbun = rs14.getInt("sunbun");
		   	   
		   	    RBDTO dto = new RBDTO(idx, writer, email, homepage,
					pwd, subject, content, writedate,readnum, filename,filesize, 
					refer, lev, sunbun);
		   	    
		   	    return dto;
			}
			else
			{
				return null;
			}
		}
		catch(SQLException se)
		{
			return null;
		}
		finally
		{
			try
			{
				if(rs14 != null) rs14.close();
				if(pstmt14 != null) pstmt14.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
    
    public boolean dbDAOEditOk(int tableNumber ,int idx, ReBoardEditForm rbEditForm)
	{
    	String sql_edit_pwd = null;
    	String sql_edit_ok = null;
		
		switch(tableNumber)
		{
		    case 0 : 
		    	sql_edit_pwd = RBSQL.RB_EDIT_PWD_TN_0;
		    	sql_edit_ok = RBSQL.RB_EDITOK_TN_0; 
		    	break;
		    case 1 : 
		    	sql_edit_pwd = RBSQL.RB_EDIT_PWD_TN_1;
		    	sql_edit_ok = RBSQL.RB_EDITOK_TN_1; 
		    	break;
		    case 2 : 
		    	sql_edit_pwd = RBSQL.RB_EDIT_PWD_TN_2;
		    	sql_edit_ok = RBSQL.RB_EDITOK_TN_2; 
		    	break;
		    default : sql_edit_pwd = ""; sql_edit_ok = "";
		}
		try
		{
			pstmt15 = con.prepareStatement(sql_edit_pwd);
			pstmt15.setInt(1, idx);
			rs15 = pstmt15.executeQuery();
			if(rs15.next())
			{
				String pwd_db = rs15.getString(1);
				if(pwd_db != null) pwd_db = pwd_db.trim();
				String pwd = rbEditForm.getPwd();
				if(pwd != null) pwd = pwd.trim();
				if(pwd.equals(pwd_db))
				{
					pstmt16 = con.prepareStatement(sql_edit_ok);
					
					String content = rbEditForm.getContent();
				 	String subject = rbEditForm.getSubject();
				 	String writer = rbEditForm.getWriter();
				 	String email = rbEditForm.getEmail();
				 	String homepage = rbEditForm.getHomepage();
                    //String pwd = rbEditForm.getPwd();
				 	if(content != null) content = content.trim();
				 	if(subject != null) subject = subject.trim();
				 	if(writer != null) writer = writer.trim();
				 	if(email != null) email = email.trim();
				 	if(homepage != null) homepage = homepage.trim();
				 	
					pstmt16.setString(1, content);
					pstmt16.setString(2, subject);
					pstmt16.setString(3, writer);
					pstmt16.setString(4, email);
					pstmt16.setString(5, homepage);
					pstmt16.setInt(6, idx);
					int n = pstmt16.executeUpdate();
					if(n > 0)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else 
				{
					return false;
				}
			}
			else
			{
			    return false;
			}
		}
		catch(SQLException se)
		{
		     return false;
		}
		finally
		{
			try
			{
				if(pstmt16 != null) pstmt16.close();
				if(rs15 != null) rs15.close();
				if(pstmt15 != null) pstmt15.close();
				if(con != null) con.close();
 			}catch(SQLException se){}
		}
	}
    
    //5. del 관련 메소드 
    public boolean dbDAODelOk(int tableNumber, int idx, String pwd)
    {
    	String sql_del_pwd = null;
    	String sql_del_ok = null;
    	String sql_reply_del_idx = null;
		
		switch(tableNumber)
		{
		    case 0 : 
		    	sql_del_pwd = RBSQL.RB_DEL_PWD_TN_0;
		    	sql_del_ok = RBSQL.RB_DELOK_TN_0; 
		    	sql_reply_del_idx = RBSQL.RB_REPLY_DEL_IDX_TN_0;
		    	break;
		    case 1 : 
		    	sql_del_pwd = RBSQL.RB_DEL_PWD_TN_1;
		    	sql_del_ok = RBSQL.RB_DELOK_TN_1; 
		    	sql_reply_del_idx = RBSQL.RB_REPLY_DEL_IDX_TN_1;
		    	break;
		    case 2 : 
		    	sql_del_pwd = RBSQL.RB_DEL_PWD_TN_2;
		    	sql_del_ok = RBSQL.RB_DELOK_TN_2; 
		    	sql_reply_del_idx = RBSQL.RB_REPLY_DEL_IDX_TN_2;
		    	break;
		    default : sql_del_pwd = ""; sql_del_ok = ""; sql_reply_del_idx="";
		}
		try
		{
			pstmt17 = con.prepareStatement(sql_del_pwd);
			pstmt17.setInt(1, idx);
			rs17 = pstmt17.executeQuery();
			if(rs17.next())
			{
				String pwd_db = rs17.getString(1);
				if(pwd_db != null) pwd_db = pwd_db.trim();
				
				if(pwd.equals(pwd_db))
				{
					con.setAutoCommit(false); 
					pstmt18 = con.prepareStatement(sql_reply_del_idx); //관련 reply글들 삭제 
					pstmt18.setInt(1, idx);
					pstmt18.executeUpdate();
					pstmt19 = con.prepareStatement(sql_del_ok); // 원래 글 삭제 
					pstmt19.setInt(1, idx);
					int n = pstmt19.executeUpdate();
					if(n > 0)
					{
						con.commit(); 
						return true;
					}
					else
					{
						con.rollback();
						return false;
					}
				}
				else 
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		catch(SQLException se)
		{
		    return false;
		}
		finally
		{
			try
			{
				con.setAutoCommit(true);
				if(pstmt19 != null) pstmt19.close();
				if(pstmt18 != null) pstmt18.close();
				if(rs17 != null) rs17.close();
				if(pstmt17 != null) pstmt17.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
    
    // 6. rewrite 관련 메소드
    public boolean dbDAOReWriteOk(MultipartRequest mr, int tableNumber, int idx)
    {
        //(1) client DATA를 받음 
		String subject = mr.getParameter("subject");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String email = mr.getParameter("email");
		String homepage = mr.getParameter("homepage");
		String pwd = mr.getParameter("pwd");
		  
		String filename = mr.getFilesystemName("filename");
		//String cType = mr.getContentType("filename");
	    //File f = mr.getFile("filename");
		long filesize = 0;
		//int readnum = 0;

		if(filename == null)
		{
		   filename = "";
		}
		else 
		{
           filename = filename.trim();
		   filesize = mr.getFile("filename").length();
		}
		
		// (2) sql문 실행 
		String sql_refer_lev_sunbun = null; // 부모글의 refer&lev&sunbun을 가져오는 SQL
		String sql_updateSunbun = null; // 부모글 이후의 sunbun을 +1 시키는 SQL 
    	String sql_rewrite = null; // 답변글을 insert하는 SQL 
		
		switch(tableNumber)
		{
		    case 0 : 
		    	sql_refer_lev_sunbun = RBSQL.RB_REWRITE_SEL_TN_0;
		    	sql_updateSunbun = RBSQL.RB_REWRITE_UP_TN_0;
		    	sql_rewrite = RBSQL.RB_REWRITE_IN_TN_0; 
		    	break;
		    case 1 : 
		    	sql_refer_lev_sunbun = RBSQL.RB_REWRITE_SEL_TN_1;
		    	sql_updateSunbun = RBSQL.RB_REWRITE_UP_TN_1;
		    	sql_rewrite = RBSQL.RB_REWRITE_IN_TN_1; 
		    	break;
		    case 2 : 
		    	sql_refer_lev_sunbun = RBSQL.RB_REWRITE_SEL_TN_2;
		    	sql_updateSunbun = RBSQL.RB_REWRITE_UP_TN_2;
		    	sql_rewrite = RBSQL.RB_REWRITE_IN_TN_2; 
		    	break;
		    default : sql_refer_lev_sunbun=sql_updateSunbun=sql_rewrite = "";
		}
		try
		{
			pstmt20 = con.prepareStatement(sql_refer_lev_sunbun);
			pstmt20.setInt(1, idx);
			rs20 = pstmt20.executeQuery();
			if(rs20.next())
			{
				int refer = rs20.getInt("refer");
				int lev = rs20.getInt("lev");
				int sunbun = rs20.getInt("sunbun");
				/*System.out.println(
						"refer : " + refer + ", lev : " + lev + ", sunbun : " + sunbun);*/
				con.setAutoCommit(false);
				pstmt21 = con.prepareStatement(sql_updateSunbun);
				pstmt21.setInt(1, sunbun);
				pstmt21.setInt(2, refer);
				pstmt21.executeUpdate(); //순번 Update 
				
				pstmt22 = con.prepareStatement(sql_rewrite);
				pstmt22.setString(1, writer);
				pstmt22.setString(2, email);
				pstmt22.setString(3, homepage);
				pstmt22.setString(4, pwd);
				pstmt22.setString(5, subject);
				pstmt22.setString(6, content);
				pstmt22.setInt(7, 0);
				pstmt22.setString(8, filename);
				pstmt22.setLong(9, filesize);
				pstmt22.setInt(10, refer);
				pstmt22.setInt(11, (lev+1));
				pstmt22.setInt(12, (sunbun+1));
				int n = pstmt22.executeUpdate(); // rewrite의 Insert 
				if(n > 0)
				{
					if(!filename.equals(""))
					{
						if(dbDAOFilenameUpdate(tableNumber,filename, filesize)) //2_2 호출 
						{
							con.commit();
							return true;
						}
						else
						{
							con.rollback();
							return false;
						}
					}
					else
					{
						con.commit();
						return true;
					}
				}
				else 
				{
					con.rollback();
					return false;
				}
			}
			else 
			{
				return false;
			}
		}
    	catch(SQLException se)
		{
    		try
			{
    		con.rollback();
			}catch(SQLException se2){}
    		return false;
		}
    	finally
		{
    		try
			{
    			con.setAutoCommit(true);
    			if(pstmt22 != null) pstmt22.close();
    			if(pstmt21 != null) pstmt21.close();
    			if(rs20 != null) rs20.close();
    			if(pstmt20 != null) pstmt20.close();
    			if(con != null) con.close();
			}catch(SQLException se){}
		}
    }
}

