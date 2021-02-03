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
  		 System.out.println("jndi�� ��ã�� : "  + e);
  	  }		
  	  catch(SQLException se)
  	  {
  		 System.out.println("con�� ������ : " + se);
  	  }
    }
    public int memberDAOCheck(String id, String pwd)
    {
       try
	   {
       	   pstmt = con.prepareStatement(LoginSQL.LOGIN_SELECT_ID);
       	   pstmt.setString(1, id);
       	   rs = pstmt.executeQuery();
       	   if(rs.next()) // id��  ���� ȸ���� ���� 
       	   {
       	        String pwd_db = rs.getString("pwd");
       	        if(pwd_db != null) pwd_db = pwd_db.trim();
       	        if(pwd != null) pwd = pwd.trim();
       	        if(pwd.equals(pwd_db)) // pwd�� ��ġ 
       	        {
       	        	setDAOMbDTO();
       	        	return 1;
       	        }
       	        else // pwd�� ����ġ 
       	        {
       	        	return 3;
       	        }
       	   }
       	   else // id�� ���� ȸ���� �������� ���� 
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
    
    MbDTO dto; // ������� ������ ���� �� �ִ� ��ü 
    public void setDAOMbDTO() // login������ ȸ����ü�� ���� 
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
