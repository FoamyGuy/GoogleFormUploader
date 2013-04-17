package com.makemyandroidapp.googleformuploader;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import android.util.Log;

public class GoogleFormUploader {
	private ArrayList<Entry> mEntries;
	private String formId;
	
	/**************************
	 * Constructor
	 * @param formId - the id for your form. 
	 * Look at the source of the live form to find it.
	 **************************/
	public GoogleFormUploader(String formId){
		this.formId = formId;
		mEntries = new ArrayList<Entry>();
	}
	/*****************************************
	 * Add an entry to the list to get uploaded
	 * @param id - entry id. Look at the source
	 * of the 'live form' to find your entry id's. 
	 * @param data - data for this column
	 *****************************************/
	public void addEntry(String id, String data){
		mEntries.add(new Entry(id, data));
	}
	
	/***************************************
	 * Upload entries to the form. This method
	 * is Asynchronous, it will return immediately.
	 * It will call onUploadComplete() and pass
	 * the response that it got back from google
	 * server.
	 ***************************************/
	public void upload(){
		//Log.i("Uploader", getFormUrl());
		//Log.i("Uploader", getData());
		Thread t = new Thread(new Runnable(){
			public void run(){
				HttpRequest mReq = new HttpRequest();
				String response = mReq.sendPost(getFormUrl(), getData());
				onUploadComplete(response);
			}
		});
			
		t.start();
	}
	
	private String getFormUrl(){
		StringBuilder url = new StringBuilder("https://docs.google.com/forms/d/");
		url.append(formId);
		url.append("/formResponse");
		return url.toString();
	}
	private String getData(){
		StringBuilder data = new StringBuilder();
		for(Entry cur: mEntries){
			data.append("entry.");
			data.append(cur.getEntryId());
			data.append("=");
			try {
				data.append(URLEncoder.encode(cur.getData(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				data.append(URLEncoder.encode(cur.getData()));
			}
			data.append("&");
		}
		data.deleteCharAt(data.length() - 1);
		return data.toString();
	}
	
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	
	/********************************************
	 * Default behavior is do nothing. Override this
	 * if you want to get a callback when the upload
	 * is complete. Check the response to termine
	 * success of failure.
	 * @param response - the response that was sent back
	 * by the google docs server.
	 *********************************************/
	public void onUploadComplete(String response){
		
	}
}
