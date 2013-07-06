package org.ng.search.common;

public enum SortType {

	SIZE_ASCENDING("sa"),
	SIZE_DESCENDING("sd"),
	DATE_ASCENDING("da"),
	DATE_DESCENDING("dd");
	
	private String sortBy;
	
	private SortType(String s) {
		sortBy = s;
	}
	
	public String getSortMethod(){
		return sortBy;
	}
	
}
