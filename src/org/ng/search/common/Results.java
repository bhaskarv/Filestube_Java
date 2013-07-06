package org.ng.search.common;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Results {
	private int hitsTotal;
	private int pageNumber;
	private int hitsForThisPage;
	
	@XmlElement(required=false)
	private List<Hits> hits;

	public int getHitsTotal() {
		return hitsTotal;
	}

	public void setHitsTotal(int hitsTotal) {
		this.hitsTotal = hitsTotal;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getHitsForThisPage() {
		return hitsForThisPage;
	}

	public void setHitsForThisPage(int hitsForThisPage) {
		this.hitsForThisPage = hitsForThisPage;
	}

	public List<Hits> getHits() {
		return hits;
	}

	public void setHits(List<Hits> hits) {
		this.hits = hits;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer("hitsTotal = "+hitsTotal+" page = "+pageNumber+" HITS  = ");
		for (Hits hit : hits) {
			buffer.append(hit.toString());
		}
		return buffer.toString();
	}
}
