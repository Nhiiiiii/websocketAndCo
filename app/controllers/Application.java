package controllers;

import play.*;
import play.mvc.*;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import java.util.Date;
import play.libs.Comet;
import play.mvc.Results.Chunks;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("@TODO menu"));
  }
 

	public static Result sseClient(){
		return ok(sse.render());	
	}
  
	public static Result sseFeed(){
		Chunks<String> chunks = new StringChunks() {

	    		// Called when the stream is ready
	    		public void onReady(Chunks.Out<String> out) {
	      			out.write("data : hello\n");
	      			out.write("world");
	      			out.close();
	    		}

  		};

  		return ok(chunks).as("text/event-stream");
	}



}
