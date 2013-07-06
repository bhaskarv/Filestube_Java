package org.ng.search.common;

import org.ng.search.service.FilestubeService;

public class EnumTester {

	public static void main(String[] args) throws Exception {
		SortType type = SortType.SIZE_ASCENDING;
		
		System.out.println(type.getSortMethod());
		
		FilestubeService service = new FilestubeService();
		System.out.println(service.searchAndPersist(new FilestubeRequest() {
			public String getPhrase() {
				return "EJB";
			}
		}));
		
	}
}
