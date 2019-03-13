package com.canvas.command;

import java.util.function.Predicate;

public class CreateCommand implements CommandType {

	private int width;
	private int height;

	public CreateCommand(String[] params) {
		Predicate<String[]> predicate = p1 -> Integer.parseInt(params[0]) <= 0
				|| Integer.parseInt(params[1]) <= 0;
		if (predicate.test(params)) {
			throw new IllegalArgumentException();
		} else {
			this.width = Integer.parseInt(params[0]);
			this.height = Integer.parseInt(params[1]);
		}

	}

	public int getWidth() {
		return width;
	}

	public CreateCommand setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public CreateCommand setHeight(int height) {
		this.height = height;
		return this;
	}

}
