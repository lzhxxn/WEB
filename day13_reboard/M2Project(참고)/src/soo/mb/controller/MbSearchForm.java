package soo.mb.controller;

import org.apache.struts.action.ActionForm;

public class MbSearchForm extends ActionForm{
    private String select;
    private String searchString;
    
    
	/**
	 * @return searchString�� �����մϴ�.
	 */
	public String getSearchString() {
		return searchString;
	}
	/**
	 * @param searchString �����Ϸ��� searchString.
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return select�� �����մϴ�.
	 */
	public String getSelect() {
		return select;
	}
	/**
	 * @param select �����Ϸ��� select.
	 */
	public void setSelect(String select) {
		this.select = select;
	}
}
