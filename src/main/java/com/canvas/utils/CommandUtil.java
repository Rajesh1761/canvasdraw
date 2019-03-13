package com.canvas.utils;

import com.canvas.command.CommandType;

public interface CommandUtil {

	public static boolean isNull(CommandType commandType) {
		return commandType != null ? false : true;
	}

	public static void exit() {
	        System.out.println("Exiting...");
	        System.exit(0);
		
	}

}
