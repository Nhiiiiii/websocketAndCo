package controllers;

import play.*;
import play.mvc.*;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import java.util.Date;

import views.html.*;

public class Websockets extends Controller {

	public static Result websocketClient() {
		return ok(websockets.render());
	}

	public static WebSocket<String> websocketHandle() {
		return new WebSocket<String>() {
			// Appel à la création du websocket
			public void onReady(WebSocket.In<String> in, final WebSocket.Out<String> out) {
              
				Logger.info("Connected");

				 // Message d'accueil du serveur
				out.write("Serveur : websocket ok");

				// Gestion des messages du client
				in.onMessage(new Callback<String>() {
 					public void invoke(String event) {
						out.write( "("+ new Date()+") " + "Server : Pong !");
						Logger.info(event);
					} 
				});
              
				// When the socket is closed.
				in.onClose(new Callback0() {
					public void invoke() {
						Logger.info("Disconnected");
					}
				});
			}
		};
	}
}
