package com.canvas.command;

import java.util.Arrays;

import com.canvas.exception.InvalidCommandException;
import com.canvas.exception.InvalidParameters;

public class CommandService implements CommandType {

	public CommandType getCommandType(String command)
			throws InvalidCommandException, InvalidParameters,IllegalArgumentException {
		command = command.trim().replaceAll(" {2}", " ");
		String[] stringSplit = command.split(" ");
		String[] params = Arrays
				.copyOfRange(stringSplit, 1, stringSplit.length);
		switch (stringSplit[0].toUpperCase()) {
		case "Q":
			return new QuitCommand();
		case "C":
			return new CreateCommand(params);
		case "L":
			return new DrawLineCommand(params);
		case "R":
			return new DrawRectangleCommand(params);
		case "B":
			return new BucketFillCommand(params);
		default:
			throw new InvalidCommandException();
		}

	}

}
