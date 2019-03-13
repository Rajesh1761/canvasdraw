package com.canvas.service;

import com.canvas.command.BucketFillCommand;
import com.canvas.command.DrawLineCommand;
import com.canvas.command.DrawRectangleCommand;

public class ElementService {

	public Element getElementType(DrawElementType commandType) {
		if (commandType instanceof DrawLineCommand) {
            DrawLineCommand cmd = (DrawLineCommand) commandType;
            return new Line(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
        }else if (commandType instanceof DrawRectangleCommand) {
            DrawRectangleCommand cmd = (DrawRectangleCommand) commandType;
            return new Rectangle(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
        }else if (commandType instanceof BucketFillCommand) {
            BucketFillCommand cmd = (BucketFillCommand) commandType;
            return new BucketFill(cmd.getX(), cmd.getY(), cmd.getCharacter());
        }
		return null;
	}
}
