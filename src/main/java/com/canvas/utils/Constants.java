package com.canvas.utils;

public interface Constants {
	final char HORIZONTAL_EDGE = '-';
	final char VERTICAL_EDGE = '|';
	final char LINE_CHAR = 'x';
	final String ENTER_COMMAND = "Enter command:";
	final String VALID_COMMAND_ONLY = "Enter valid command only";
	final String INVALID_SYNTAX = "Command syntax is not correct: ";
	final String VALID_SYNTAX = "Following correct syntax: \n";
	final String CREATE_CANVAS = "Please create canvas first";
	final String CANNOT_ADD_ELEMENT = "Can not add the model to canvas: ";
	final String ILLEGAL_ARGUMENT = "Illegal Arugment provided ";

	// Error Messages
	final String LINE_DRAW_DIAGONAL_ERROR = "Currently draw line does not support diagonal line";
	final String OUTSIDE_CANVAS = " is outside of canvas";

	// Bucket Error messages
	final String MINIMUM_3_PARAM = "Bucket fill expects 3 params";
	final String CHAR_NOT_MORE_THAN_1 = "Color character should not be more than 1";
	final String GREATER_THAN_SERO = "x or y should be > 0";

	// Line Error messages
	final String PARAMS_EXPECTED_4 = "Draw line command expects 4 params: ";
	final String DIAGONAL_NOT_SUPPORT = "Draw line does not support diagonal line at the moment";
	final String GREATER_THAN_ZERO1 = "Number should be > 0";

	// Rectangle Error messages
	final String MINIMUM_4_PARAMS = "Draw Rectangle command expects 4 params";
}
