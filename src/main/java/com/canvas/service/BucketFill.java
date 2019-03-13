package com.canvas.service;

import com.canvas.utils.Constants;

public class BucketFill implements Element, Constants{
	private int x;
	private int y;
	private char character;

	public BucketFill(int x1, int y1, char character) {
		this.x = x1;
		this.y = y1;
		this.character = character;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + character;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BucketFill other = (BucketFill) obj;
		if (character != other.character)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public BucketFill setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public BucketFill setY(int y) {
		this.y = y;
		return this;
	}

	public char getCharacter() {
		return character;
	}

	public BucketFill setCharacter(char character) {
		this.character = character;
		return this;
	}
}
