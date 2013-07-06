package org.ng.search.data;

import java.util.Date;

/**
 * FileSearchResults generated by hbm2java
 */
public class FileSearchResults implements java.io.Serializable {

	private Integer id;
	private String name;
	private String extension;
	private String desc;
	private String size;
	private String address;
	private Date added;
	private String related;
	private String searchkey;
	private String resulturl;
	private Date date;
	private int resultfrom;

	public FileSearchResults() {
	}

	public FileSearchResults(String name, String extension, String desc,
			String size, String address, Date added, String related,
			String searchkey, String resulturl, Date date, int resultfrom) {
		this.name = name;
		this.extension = extension;
		this.desc = desc;
		this.size = size;
		this.address = address;
		this.added = added;
		this.related = related;
		this.searchkey = searchkey;
		this.resulturl = resulturl;
		this.date = date;
		this.resultfrom = resultfrom;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getAdded() {
		return this.added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public String getRelated() {
		return this.related;
	}

	public void setRelated(String related) {
		this.related = related;
	}

	public String getSearchkey() {
		return this.searchkey;
	}

	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}

	public String getResulturl() {
		return this.resulturl;
	}

	public void setResulturl(String resulturl) {
		this.resulturl = resulturl;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getResultfrom() {
		return this.resultfrom;
	}

	public void setResultfrom(int resultfrom) {
		this.resultfrom = resultfrom;
	}

	public int hashCode() {
		return this.getId().hashCode();
	}
	
	public boolean  equals(Object other) {
		if (this == other) return true;
		
		if (!(other instanceof FileSearchResults)) 
			return false;
		
		FileSearchResults otherObj = (FileSearchResults)other;
		if (this.getId() == otherObj.getId()) {
			return true;
		} else {
			return false;
		}
	}
}
