package com.bhatt.seakgeek.events;

import java.util.HashMap;
import java.util.Map;

import com.bhatt.seakgeek.model.EventsWrapper;
import com.bhatt.seakgeek.util.Urls;

public class EventsHandler extends BaseHandler {

	public EventsWrapper getEventsByVenue(String city) {
		EventsWrapper events = getBaseEvents(Urls.SEAK_GEEK_API_V2_ENDPOINT
				+ Urls.EVENT + "?city=" + city);

		return events;
	}

	public EventsWrapper getEventsById(String id) {
		EventsWrapper events = getBaseEvents(Urls.SEAK_GEEK_API_V2_ENDPOINT
				+ Urls.EVENT + "/" + id);

		return events;
	}

	public EventsWrapper getEventsByLatLong(String lat, String lon) {
		EventsWrapper events = getBaseEvents(Urls.SEAK_GEEK_API_V2_ENDPOINT
				+ Urls.EVENT + "?lat=" + lat + "&lon=" + lon);
		return events;
	}

	public EventsWrapper getEvents(String query) {
		return getEvents(query, null, null, null, null, null, null);
	}

	public EventsWrapper getEvents(String lat, String lon) {
		return getEvents(null, lat, lon, null, null, null, null);
	}

	public EventsWrapper getEvents(String lat, String lon, String startDate,
			String endDate) {
		return getEvents(null, lat, lon, startDate, endDate, null, null);
	}

	public EventsWrapper getEvents(String query, String lat, String lon,
			String startDate, String endDate) {
		return getEvents(query, lat, lon, startDate, endDate, null, null);
	}

	public EventsWrapper getEvents(String query, String lat, String lon,
			String performer, String datetime_local_gte,
			String datetime_local_lte, String items_per_page) {
		Map<String, String> args = new HashMap<String, String>();

		if (query != null && !query.isEmpty()) {
			args.put(Urls.QUERY, query);
		}

		if (lat != null && !lat.isEmpty() && lon != null && !lon.isEmpty()) {
			args.put(Urls.LAT, lat);
			args.put(Urls.LON, lon);
		}

		if (performer != null && !performer.isEmpty()) {
			args.put(Urls.PERFORMER_ARG, performer);
		}

		if (datetime_local_gte != null && !datetime_local_gte.isEmpty()) {
			// fixme: also parse the format
			args.put(Urls.DATETIME_GTE_ARG, datetime_local_gte);
		}

		if (datetime_local_lte != null && !datetime_local_lte.isEmpty()) {
			// fixme: also parse the format
			args.put(Urls.DATETIME_LTE_ARG, datetime_local_lte);
		}

		if (items_per_page != null && !items_per_page.isEmpty()) {
			args.put(Urls.ITEMS_PER_PAGE, items_per_page);
		}

		// create a url based on map
		StringBuffer url = new StringBuffer(Urls.SEAK_GEEK_API_V2_ENDPOINT
				+ Urls.EVENT);
		int i = 0;
		for (Map.Entry<String, String> entry : args.entrySet()) {
			url.append(i++ == 0 ? "?" : "&");
			url.append(entry.getKey() + "=" + entry.getValue());
		}

		EventsWrapper events = getBaseEvents(url.toString());
		return events;

	}

	public static void main(String args[]) {
		EventsHandler handler = new EventsHandler();
		EventsWrapper result = handler.getEventsByVenue("san%20francisco");
		System.out.println("size:" + result.getEvents().size());

		result = handler.getEventsByLatLong("40.8292", "-73.9266");
		System.out.println("size:" + result.getEvents().size());

		result = handler.getEventsByVenue("san%20francisco");
		System.out.println("size:" + result.getEvents().size());

		// 37.38605168662028, -122.0838511

		result = handler.getEvents(null, "37.38605168662028", "-122.0838511",
				null, null, null, null);
		System.out.println("generic events:" + result.getEvents().size());
		
		result = handler.getEvents("music", "37.38605168662028", "-122.0838511",
				null, null, null, null);
		System.out.println("music events:" + result.getEvents().size());

	}

}
