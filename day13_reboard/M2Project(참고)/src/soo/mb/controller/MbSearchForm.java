package soo.mb.controller;

import org.apache.struts.action.ActionForm;

public class MbSearchForm extends ActionForm{
    private String select;
    private String searchString;
    
    
	/**
	 * @return searchString을 리턴합니다.
	 */
	public String getSearchString() {
		return searchString;
	}
	/**
	 * @param searchString 설정하려는 searchString.
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return select을 리턴합니다.
	 */
	public String getSelect() {
		return select;
	}
	/**
	 * @param select 설정하려는 select.
	 */
	public void setSelect(String select) {
		this.select = select;
	}
}
