package com.bhatt.seakgeek.events;

import com.bhatt.seakgeek.model.Venue;
import com.bhatt.seakgeek.util.Urls;

public class VenueHandler extends BaseHandler{

	public Venue getVenue(){
		Venue venue;
		venue = getVenue(Urls.SEAK_GEEK_API_V2_ENDPOINT
				+ Urls.VENUE);
		
		return venue;
	}
	
	public Venue getVenueById(String id){
		Venue venue;
		venue = getVenue(Urls.SEAK_GEEK_API_V2_ENDPOINT
				+ Urls.VENUE + "/" + id);
		
		return venue;
	}
	
	public static void main(String args[]){
		VenueHandler handler = new VenueHandler();
		Venue ven = handler.getVenue();
		System.out.println(ven.getName());
		
	}
	
	
	
}
