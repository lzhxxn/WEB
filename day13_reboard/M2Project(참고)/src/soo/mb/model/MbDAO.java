package soo.mb.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import soo.sql.MbSQL;

public class MbDAO {
   private Connection con;
   private PreparedStatement pstmt1;
   private ResultSet rs1;
   
   private PreparedStatement pstmt2;
   
   private PreparedStatement pstmt3; 
   private ResultSet rs3;
   
   public MbDAO() 
   {
   	  Context initContext;
	  try {
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
      //System.out.println("DbPool을 이용한 conn생성 성공 : " + con);
   }
   public boolean dbDAOSelect(String ssn)
   {
      try
	  {
      	  pstmt1 = con.prepareStatement(MbSQL.MB_SELECT_SSN);
      	  pstmt1.setString(1, ssn);
		  rs1 = pstmt1.executeQuery();
		  boolean result = rs1.next();
		  
		  return result;
	  }
      catch(SQLException se)
	  {
      	  return false;
	  }
      finally
	  {
	      try
		  {
	      	 if(rs1 != null) rs1.close();
	      	 if(pstmt1 != null) pstmt1.close();
	      	 if(con != null) con.close(); 
		  }catch(SQLException se){}
	  }
   }
   public boolean dbDAOInsert(String name, String ssn, 
    		String id, String pwd, String email, String phone)
   {
   	   try
	   {
   	   	   pstmt2 = con.prepareStatement(MbSQL.MB_INSERT);
   	   	   pstmt2.setString(1, name);
   	   	   pstmt2.setString(2, ssn);
   	   	   pstmt2.setString(3, id);
   	   	   pstmt2.setString(4, pwd);
   	   	   pstmt2.setString(5, email);
   	   	   pstmt2.setString(6, phone);
   	   	   int n = pstmt2.executeUpdate();
   	   	   if(n>0) 
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
   	   	  	if(pstmt2 != null) pstmt2.close();
   	   	  	if(con != null) con.close();
		  }catch(SQLException se){}
	   }
   }
   
   
   // memberFind관련 메소드 
   public ArrayList dbDAOSelect(String select, String searchString)
   {
   	   ArrayList list = new ArrayList();
       try
	   {
       	   if(select.equals("name"))
       	   {
       	       pstmt3 = con.prepareStatement(MbSQL.MB_SEARCH_NAME);
       	   }
       	   else if(select.equals("id"))
       	   {
       	       pstmt3 = con.prepareStatement(MbSQL.MB_SEARCH_ID);
       	   }
       	   else  //select.equals("ssn")
       	   {
       	       pstmt3 = con.prepareStatement(MbSQL.MB_SEARCH_SSN);
       	   }
       	   pstmt3.setString(1, searchString);
       	   rs3 = pstmt3.executeQuery();
           while(rs3.next())
           {
           	   int no = rs3.getInt(1);
           	   String name = rs3.getString(2);
           	   String ssn = rs3.getString(3);
           	   String id = rs3.getString(4);
           	   String pwd = rs3.getString(5);
           	   String email = rs3.getString(6);
           	   String phone = rs3.getString(7);
           	   Date date = rs3.getDate(8);
           	   String date_str = date.toString();
           	   
           	   MbDTO dto = new MbDTO(
           			no, name, ssn, id, pwd, email, phone, date_str);
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
       	   	  if(rs3 != null) rs3.close();
       	   	  if(pstmt3 != null) pstmt3.close();
       	   	  if(con != null) con.close();
		   }catch(SQLException se){}
	   }
   }
}










