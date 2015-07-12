package com.himamis.retex.renderer.web;

public class ConsoleLogger {
	
	public static native void log(String message) /*-{
		$wnd.console.log(message);
	}-*/;

}
