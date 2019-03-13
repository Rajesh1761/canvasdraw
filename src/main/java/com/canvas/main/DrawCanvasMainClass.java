package com.canvas.main;

import java.util.Scanner;

import com.canvas.command.CommandService;
import com.canvas.command.CommandType;
import com.canvas.command.CreateCommand;
import com.canvas.command.QuitCommand;
import com.canvas.exception.InvalidCommandException;
import com.canvas.exception.InvalidElementException;
import com.canvas.exception.InvalidParameters;
import com.canvas.service.Canvas;
import com.canvas.service.CanvasImpl;
import com.canvas.service.DrawElementType;
import com.canvas.service.Element;
import com.canvas.service.ElementService;
import com.canvas.utils.CommandUtil;
import com.canvas.utils.Constants;

public class DrawCanvasMainClass {
	private static Scanner scanner;
	private static CommandService commandService;
	private static Canvas canvas;
	private static ElementService  elementService;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		commandService = new CommandService();
		elementService = new ElementService();
		System.out.println(Constants.ENTER_COMMAND);
		while (true) {
			processCommand(scanner.nextLine());
			System.out.println(Constants.ENTER_COMMAND);
		}
	}

	private static void processCommand(String enteredCommand) {
		CommandType commandType = null;
		try {
			commandType = commandService.getCommandType(enteredCommand);
		} catch (InvalidCommandException exception) {
			System.err.println(Constants.VALID_COMMAND_ONLY);
		} catch (InvalidParameters invalidParamaters) {
			System.err.println(Constants.INVALID_SYNTAX
					+ invalidParamaters.getMessage());
			System.err.println(Constants.VALID_SYNTAX
					+ invalidParamaters.getCustomMessage());
		}catch (IllegalArgumentException e) {
			System.err.println(Constants.ILLEGAL_ARGUMENT);
		}
		if (!CommandUtil.isNull(commandType)) {
			if (commandType instanceof QuitCommand) {
				scanner.close();
				CommandUtil.exit();
			}
			if (commandType instanceof CreateCommand) {
				drawNewCanvas((CreateCommand) commandType);
				return;
			}
			if (commandType instanceof DrawElementType) {
				drawElement((DrawElementType) commandType);
			}
		}

	}

	private static void drawElement(DrawElementType commandType) {
		if (canvas == null) {
			System.out.println(Constants.CREATE_CANVAS);
			return;
		}
		try {
			Element elementType = elementService.getElementType(commandType);
            canvas.addCanvasElement(elementType);
            System.out.println(canvas.drawCanvas());
        } catch (InvalidElementException e) {
            System.err.println(Constants.CANNOT_ADD_ELEMENT + e.getMessage());
        }
	}

	private static void drawNewCanvas(CreateCommand commandType) {
		canvas = new CanvasImpl(commandType.getWidth(), commandType.getHeight());
		System.out.println(canvas.drawCanvas());

	}
}
