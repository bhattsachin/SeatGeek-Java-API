package com.bhatt.seakgeek.events;

import com.bhatt.seakgeek.model.EventsWrapper;
import com.bhatt.seakgeek.model.Performers;
import com.bhatt.seakgeek.model.Venue;
import com.bhatt.seakgeek.util.Client;
import com.google.gson.Gson;

public class BaseHandler {
	private static Client client = new Client();
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public String getObject(String url){
		String body = null;
		try {
			 body = client.fetchUrl(url);
		} catch (Exception ex) {
			ex.printStackTrace();
			// 404 or some error occured.
		}
		return body;
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	protected EventsWrapper getBaseEvents(String url) {
		EventsWrapper events = null;
		Gson gson = new Gson();
		events = (EventsWrapper) gson.fromJson(getObject(url), EventsWrapper.class);

		return events;
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	protected Performers getPerformer(String url) {
		Performers performer = null;
		Gson gson = new Gson();
		performer = (Performers) gson.fromJson(getObject(url), Performers.class);

		return performer;
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	protected Venue getVenue(String url) {
		Venue venue = null;
		Gson gson = new Gson();
		venue = (Venue) gson.fromJson(getObject(url), Venue.class);

		return venue;
	}

}
