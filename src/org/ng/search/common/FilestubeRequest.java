package org.ng.search.common;

public class FilestubeRequest {
	
	private String url = "http://api.filestube.com";
	private String key="2c17a6258659780e0bc6d2ca41ab731e";
	private String phrase;
	private String related;
	private SortType sort;
	private int page;
	private String extension;
	
	public String getUrl() {
		return url;
	}
//	public void setUrl(String url) {
//		this.url = url;
//	}
	public String getKey() {
		return key;
	}
//	public void setKey(String key) {
//		this.key = key;
//	}
	public String getPhrase() {
		return phrase;
	}
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	public String getRelated() {
		return related;
	}
	public void setRelated(String related) {
		this.related = related;
	}
	public SortType getSort() {
		return sort;
	}
	public void setSort(SortType sort) {
		this.sort = sort;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
}
