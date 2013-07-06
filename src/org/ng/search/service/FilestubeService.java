package org.ng.search.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.ng.search.common.Answer;
import org.ng.search.common.FilestubeRequest;
import org.ng.search.common.Hits;
import org.ng.search.data.FileSearchResults;
import org.ng.search.data.FileSearchResultsDao;
import org.ng.search.data.Keywordlist;
import org.ng.search.data.KeyworldsListDao;

public class FilestubeService {
	
	FileSearchResultsDao searchResultsDao = new FileSearchResultsDao();
	KeyworldsListDao keywordsListDao = new KeyworldsListDao();
	
	public Answer searchResults(FilestubeRequest request) throws Exception {
	
		URL url = new URL(getURL(request));
		URLConnection urlConnection = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		JAXBContext context = JAXBContext.newInstance(Answer.class);
		Unmarshaller unMarsheller = context.createUnmarshaller();
		
		Answer answer = (Answer)unMarsheller.unmarshal(reader);
		
		return answer;
	}
	
	private String getURL(FilestubeRequest request) {
		
		StringBuffer url  = new StringBuffer(request.getUrl());
		url.append("?key=").append(request.getKey());
		if (request.getPhrase() != null) {;
			url.append("&phrase=").append(request.getPhrase());
		}
		return url.toString();
	};
	
	public boolean searchAndPersist(FilestubeRequest request) throws Exception {
		Answer answer = searchResults(request);
		
		
		for(Hits hit : answer.getResults().getHits()) {
			FileSearchResults searchResults = new FileSearchResults();
			searchResults.setAddress(hit.getLink());
			searchResults.setDesc(hit.getDescription());
			searchResults.setSearchkey(request.getPhrase());
			searchResults.setExtension(hit.getExtension());
			searchResults.setResulturl(hit.getLink());
			searchResults.setSize(hit.getSize());
			searchResults.setRelated(hit.getRelated());
			searchResults.setName(hit.getName());
			searchResults.setAdded(new Date(System.currentTimeMillis()));
			searchResults.setDate(new Date(System.currentTimeMillis()));
			
			searchResultsDao.persist(searchResults);
		}
		
		Keywordlist keywordlist = new Keywordlist();;
		keywordlist.setKeyCount(answer.getResults().getHitsTotal());
		keywordlist.setSearchKey(request.getPhrase());
		keywordlist.setSearchDate(new Date(System.currentTimeMillis()));
		keywordlist.setCrawlDate(new Date(System.currentTimeMillis()));
		
		keywordsListDao.persist(keywordlist);
		
		
		return true;
		
	}
}
