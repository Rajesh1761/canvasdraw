package com.canvas.command;

import java.util.function.Predicate;

import com.canvas.exception.InvalidParameters;
import com.canvas.service.DrawElementType;
import com.canvas.utils.Constants;
public class BucketFillCommand implements DrawElementType,Constants {
	private static final String helpMessage = "B x y c ";
	private int x;
	private int y;
	private char character;

	public BucketFillCommand(String... params) {
		Predicate<String[]> predicate = p1 -> Integer.parseInt(params[0]) <= 0
				|| Integer.parseInt(params[1]) <= 0;
		if (params.length < 3)
			throw new InvalidParameters(MINIMUM_3_PARAM,
					helpMessage);
		if (params[2].length() != 1)
			throw new InvalidParameters(
					CHAR_NOT_MORE_THAN_1, helpMessage);
		if (predicate.test(params)) {
			throw new InvalidParameters(GREATER_THAN_SERO, helpMessage);
		} else {
			x = Integer.parseInt(params[0]);
			y = Integer.parseInt(params[1]);
			character = params[2].charAt(0);
		}
	}

	public int getX() {
		return x;
	}

	public BucketFillCommand setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public BucketFillCommand setY(int y) {
		this.y = y;
		return this;
	}

	public char getCharacter() {
		return character;
	}

	public BucketFillCommand setCharacter(char character) {
		this.character = character;
		return this;
	}

}
