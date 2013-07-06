package org.ng.search.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="answer")
public class Answer {

	@XmlElement
	private int hasResults;
	
	@XmlElement(required=false)
	private Results results;

	public int getHasResults() {
		return hasResults;
	}

	public void setHasResults(int hasResults) {
		this.hasResults = hasResults;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}
	
	public String toString() {
		return "hasResutls = "+hasResults+" results = "+results;
				
	}
}
