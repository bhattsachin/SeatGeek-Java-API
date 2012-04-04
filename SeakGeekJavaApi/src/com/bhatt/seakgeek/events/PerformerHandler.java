package com.bhatt.seakgeek.events;

import com.bhatt.seakgeek.model.Performers;
import com.bhatt.seakgeek.util.Urls;

public class PerformerHandler extends BaseHandler{
	
	public Performers getPerformerById(String id){
		Performers performer;
		performer = getPerformer(Urls.SEAK_GEEK_API_V2_ENDPOINT
				+ Urls.PERFORMERS + "/" + id);
		
		return performer;
	}

}
