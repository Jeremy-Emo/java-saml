package com.onelogin.saml2.http;

import java.io.IOException;

import play.mvc.Http.Response;
import play.mvc.results.Redirect;

public class PlayResponse extends HttpResponse {
	
private final Response response;
	
	public PlayResponse(Response response) {
		this.response = response;
	}

	@Override
	public void sendRedirect(String target) throws IOException {
		new Redirect(target).apply(null, response);
	}

	@Override
	public void invalidateSession() {
		this.response.removeCookie("session");
	}

	

}
