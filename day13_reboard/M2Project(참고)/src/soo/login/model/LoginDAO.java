package soo.login.model;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

import soo.mb.model.MbDTO;
import soo.sql.LoginSQL;

public class LoginDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
    public LoginDAO()
    {
      Context initContext;
  	  try 
	  {
  		  initContext = new InitialContext();
  		  Context envContext  = (Context)initContext.lookup("java:/comp/env");
          DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
          con = ds.getConnection();
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
    public int memberDAOCheck(String id, String pwd)
    {
       try
	   {
       	   pstmt = con.prepareStatement(LoginSQL.LOGIN_SELECT_ID);
       	   pstmt.setString(1, id);
       	   rs = pstmt.executeQuery();
       	   if(rs.next()) // id를  가진 회원이 존재 
       	   {
       	        String pwd_db = rs.getString("pwd");
       	        if(pwd_db != null) pwd_db = pwd_db.trim();
       	        if(pwd != null) pwd = pwd.trim();
       	        if(pwd.equals(pwd_db)) // pwd도 일치 
       	        {
       	        	setDAOMbDTO();
       	        	return 1;
       	        }
       	        else // pwd가 불일치 
       	        {
       	        	return 3;
       	        }
       	   }
       	   else // id를 가진 회원이 존재하지 않음 
       	   {
       	   	    return 2;
       	   }
	   }
       catch(SQLException se)
	   {
       	   return 4;
	   }
       finally
	   {
       	   try
		   {
       	   	  if(rs != null) rs.close();
       	   	  if(pstmt != null) pstmt.close();
       	   	  if(con != null) con.close();
		   }
       	   catch(SQLException se){}
	   }
    }
    
    MbDTO dto; // 사용자의 정보를 담을 수 있는 객체 
    public void setDAOMbDTO() // login성공한 회원객체를 셋팅 
    {
    	try
		{
    	    int no =  rs.getInt(1);
    	    String name = rs.getString(2);
    	    String ssn = rs.getString(3);
    	    String id = rs.getString(4);
    	    String pwd = rs.getString(5);
    	    String email = rs.getString(6);
    	    String phone = rs.getString(7);
    	    Date date = rs.getDate(8);
    	    String date_str = date.toString();
    	    
    	    dto =new MbDTO(no, name, ssn, id, pwd, email, phone, date_str);
		}
    	catch(SQLException se)
		{
    		System.out.println(se);
		}
    }
    public MbDTO getMbDTO()
    {
        return dto;
    }
}
