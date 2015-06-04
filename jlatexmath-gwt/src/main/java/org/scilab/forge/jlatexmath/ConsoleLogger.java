package org.scilab.forge.jlatexmath;

public class ConsoleLogger {
	
	public static native void log(String message) /*-{
		$wnd.console.log(message);
	}-*/;

}
