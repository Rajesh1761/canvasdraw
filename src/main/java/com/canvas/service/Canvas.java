package com.canvas.service;

import com.canvas.exception.InvalidElementException;

public interface Canvas {
	
	void addCanvasElement(Element element) throws InvalidElementException;

    String drawCanvas();

}
