package com.bhatt.seakgeek.model;

import java.io.Serializable;
import java.util.List;

public class Events implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Stats stats;
	private String title;
	private String url;
	private String datetime_local;
	private List<Performers> performers;
	private Venue venue;
	private String short_title;
	private String datetime_utc;
	private float score;
	private String type;
	private long id;
	
	public Events() {
		super();
	}
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDatetime_local() {
		return datetime_local;
	}
	public void setDatetime_local(String datetime_local) {
		this.datetime_local = datetime_local;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public String getShort_title() {
		return short_title;
	}
	public void setShort_title(String short_title) {
		this.short_title = short_title;
	}
	public String getDatetime_utc() {
		return datetime_utc;
	}
	public void setDatetime_utc(String datetime_utc) {
		this.datetime_utc = datetime_utc;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Performers> getPerformers() {
		return performers;
	}
	public void setPerformers(List<Performers> performers) {
		this.performers = performers;
	}
	

}
