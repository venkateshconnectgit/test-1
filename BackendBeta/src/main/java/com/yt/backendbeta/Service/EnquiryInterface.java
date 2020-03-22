package com.yt.backendbeta.Service;

import java.util.List;

import com.yt.backendbeta.Entity.Enquiry;

public interface EnquiryInterface {
    
	public void addEnquiry(Enquiry enquiry);	
    public Enquiry getEnquiryId(String id);
    public List<Enquiry> getEnquiryName(String name);
}
