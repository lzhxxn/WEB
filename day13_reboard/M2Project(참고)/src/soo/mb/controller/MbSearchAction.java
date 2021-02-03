package soo.mb.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import soo.mb.model.MbManager;

public class MbSearchAction extends Action{
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		 // 1. Ŭ����Ʈ�� ���� �����͸� �޴´�. 
		MbSearchForm msf = (MbSearchForm)form;
		String select = msf.getSelect();
		String searchString = msf.getSearchString();
		System.out.println("MbSearchAction�� select : " + select 
				                    + ", searchString : " + searchString);
		
		 // 2. DB table�� ���� �˻��� �´�.(MbDTO �̿�) 
		MbManager manager = MbManager.getInstance();
		ArrayList list = manager.dbSelect(select, searchString);
		
	    Boolean result_ref = Boolean.TRUE;
		if(list == null) result_ref= Boolean.FALSE;
		
		request.setAttribute("list", list);
		request.setAttribute("result_ref", result_ref);
		
		 // 3. forward ������ ���� 
	      return mapping.findForward("fw-mb-search-result");
	 }
}
