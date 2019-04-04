package com.onelogin.saml2.http;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import play.Logger;
import play.mvc.Http.Request;

public class PlayRequest extends HttpRequest {
	
	private final Request request;
	
	public PlayRequest(Request request) {
		this.request = request;
	}

	@Override
    public boolean isSecure() {
        return request.secure;
    }

    @Override
    public String getScheme() {
        Integer port = request.port;
        if(port == 80) {
        	return "http";
        } else if(port == 443) {
        	return "https";
        } else if(port == 21) {
        	return "ftp";
        } else {
        	return "http";
        }
    }

    @Override
    public String getServerName() {
        return request.host;
    }

    @Override
    public int getServerPort() {
        //return request.port;
    	return 80;
    }

    @Override
    public String getQueryString() {
        return request.querystring;
    }

    @Override
    public String getRequestURI() {
        return request.path;
    }

    @Override
    public String getRequestURL() {
        return this.getScheme() + "://" + request.path;
    }

    @Override
    public String getParameter(String name) {
        return request.params.get(name);
    }

}
