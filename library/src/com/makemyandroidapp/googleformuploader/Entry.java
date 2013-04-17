package com.makemyandroidapp.googleformuploader;

public class Entry {

	public Entry(String entryId, String data){
		this.entryId = entryId;
		this.data = data;
	}
	public String getEntryId() {
		return entryId;
	}
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	private String entryId;
	private String data;
	
}
