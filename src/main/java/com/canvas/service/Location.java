package com.canvas.service;

public class Location {
	public Location(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}

	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public Location setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public Location setY(int y) {
		this.y = y;
		return this;
	}
}
