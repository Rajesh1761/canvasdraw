package com.canvas.service;

import com.canvas.utils.Constants;

public class Rectangle implements Element, Constants {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public Rectangle(int _x1, int _y1, int _x2, int _y2) {
		if ((x1 == x2 && y1 > y2) || (y1 == y2 && x1 > x2)) {
			this.x1 = _x2;
			this.y1 = _y2;
			this.x2 = _x1;
			this.y2 = _y1;
		} else {
			this.x1 = _x1;
			this.y1 = _y1;
			this.x2 = _x2;
			this.y2 = _y2;
		}
	}

	public int getX1() {
		return x1;
	}

	public Rectangle setX1(int x1) {
		this.x1 = x1;
		return this;
	}

	public int getY1() {
		return y1;
	}

	public Rectangle setY1(int y1) {
		this.y1 = y1;
		return this;
	}

	public int getX2() {
		return x2;
	}

	public Rectangle setX2(int x2) {
		this.x2 = x2;
		return this;
	}

	public int getY2() {
		return y2;
	}

	public Rectangle setY2(int y2) {
		this.y2 = y2;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x1;
		result = prime * result + x2;
		result = prime * result + y1;
		result = prime * result + y2;
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
		Rectangle other = (Rectangle) obj;
		if (x1 != other.x1)
			return false;
		if (x2 != other.x2)
			return false;
		if (y1 != other.y1)
			return false;
		if (y2 != other.y2)
			return false;
		return true;
	}

}
