package com.canvas.command;

import java.util.function.Predicate;

import com.canvas.exception.InvalidParameters;
import com.canvas.service.DrawElementType;
import com.canvas.utils.Constants;

public class DrawLineCommand implements DrawElementType,Constants {

	private static final String helpMessage = "L x1 y1 x2 y2";

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public DrawLineCommand(String[] params) {
		Predicate<String[]> predicate = p1 -> Integer.parseInt(params[0]) <= 0
				|| Integer.parseInt(params[1]) <= 0
				|| Integer.parseInt(params[2]) <= 0
				|| Integer.parseInt(params[3]) <= 0;
		if (params.length < 4)
			throw new InvalidParameters(PARAMS_EXPECTED_4,
					helpMessage);
		if (x1 != x2 && y1 != y2) {
			throw new InvalidParameters(
					DIAGONAL_NOT_SUPPORT,
					helpMessage);
		}
		if (predicate.test(params)) {
			throw new InvalidParameters(GREATER_THAN_ZERO1, helpMessage);
		}else{
			x1 = Integer.parseInt(params[0]);
			y1 = Integer.parseInt(params[1]);
			x2 = Integer.parseInt(params[2]);
			y2 = Integer.parseInt(params[3]);
		}
	}
	public int getX1() {
		return x1;
	}

	public DrawLineCommand setX1(int x1) {
		this.x1 = x1;
		return this;
	}

	public int getY1() {
		return y1;
	}

	public DrawLineCommand setY1(int y1) {
		this.y1 = y1;
		return this;
	}

	public int getX2() {
		return x2;
	}

	public DrawLineCommand setX2(int x2) {
		this.x2 = x2;
		return this;
	}

	public int getY2() {
		return y2;
	}

	public DrawLineCommand setY2(int y2) {
		this.y2 = y2;
		return this;
	}
}
