package com.hibernate.util;

import java.util.Set;

public class mosques {
	
	String place_id, place_name, jumma_time, eid_time, sect, pic;
	int lat,lng,capacity;
	prayer_time times;
	Set<users> subscribers;
	users admin;
	
	public users getAdmin() {
		return admin;
	}
	public void setAdmin(users admin) {
		this.admin = admin;
	}
	public Set<users> getSubscribers() {
		return subscribers;
	}
	public void setSubscribers(Set<users> subscribers) {
		this.subscribers = subscribers;
	}
	public prayer_time getTimes() {
		return times;
	}
	public void setTimes(prayer_time times) {
		this.times = times;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getJumma_time() {
		return jumma_time;
	}
	public void setJumma_time(String jumma_time) {
		this.jumma_time = jumma_time;
	}
	public String getEid_time() {
		return eid_time;
	}
	public void setEid_time(String eid_time) {
		this.eid_time = eid_time;
	}
	public String getSect() {
		return sect;
	}
	public void setSect(String sect) {
		this.sect = sect;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getLng() {
		return lng;
	}
	public void setLng(int lng) {
		this.lng = lng;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
}
