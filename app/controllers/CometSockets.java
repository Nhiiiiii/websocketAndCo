package controllers;

import play.*;
import play.mvc.*;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import java.util.Date;
import play.libs.Comet;

import views.html.*;

public class CometSockets extends Controller {


	public static Result cometClient(){
		return ok(cometSockets.render());	
	}	

	public static Result comet() {
		Comet comet = new Comet("parent.cometMessage") {
			public void onConnected() {
				sendMessage("Server say : Hello");
				try{
				Thread.currentThread().sleep(5000);
				} catch(Exception ie){}
				sendMessage(" world");
				close();
			}
		};
		return ok(comet);
	}

}
