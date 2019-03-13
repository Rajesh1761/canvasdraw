package com.canvas.service;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.canvas.exception.InvalidElementException;
import com.canvas.utils.Constants;
public class CanvasImpl implements Canvas, Constants {

	private final char[][] canvasArrays;
	private final int width;
	private final int height;
	private final String horizontalEdge;

	public CanvasImpl(int width, int height) {
		this.width = width;
		this.height = height;
		canvasArrays = new char[this.height][this.width];
		Arrays.stream(canvasArrays).forEach(chars -> Arrays.fill(chars, ' '));
		horizontalEdge = Stream.generate(() -> String.valueOf(HORIZONTAL_EDGE))
				.limit(width + 2).collect(Collectors.joining());
	}

	@Override
	public void addCanvasElement(Element element)
			throws InvalidElementException {
		if (element instanceof Line) {
			addLine((Line) element);
		} else if (element instanceof Rectangle) {
			addRectangle((Rectangle) element);
		}else if (element instanceof BucketFill) {
			addBucketFill((BucketFill) element);
		}

	}
	private void addBucketFill(BucketFill bucketFill) {
		if (isWithInCanvas(bucketFill.getX(), bucketFill.getY())) {
			throw new InvalidElementException(
					"Bucket fill point"+OUTSIDE_CANVAS);
		}
		fillBucket(bucketFill.getX(), bucketFill.getY(),
				bucketFill.getCharacter());
	}
	private void fillBucket(int x, int y, char mchar) {
		char oldCharacter = canvasArrays[y - 1][x - 1];
		Stack<Location> stack = new Stack<>();
		stack.add(new Location(y - 1, x - 1));
		// BFS traversal
		while (!stack.isEmpty()) {
			Location pop = stack.pop();
			if (canvasArrays[pop.getX()][pop.getY()] == oldCharacter) {
				canvasArrays[pop.getX()][pop.getY()] = mchar;
			}
			if (pop.getX() - 1 >= 0
					&& canvasArrays[pop.getX() - 1][pop.getY()] == oldCharacter) {
				stack.add(new Location(pop.getX() - 1, pop.getY()));
			}
			if (pop.getX() + 1 < height
					&& canvasArrays[pop.getX() + 1][pop.getY()] == oldCharacter) {
				stack.add(new Location(pop.getX() + 1, pop.getY()));
			}
			if (pop.getY() - 1 >= 0
					&& canvasArrays[pop.getX()][pop.getY() - 1] == oldCharacter) {
				stack.add(new Location(pop.getX(), pop.getY() - 1));
			}
			if (pop.getY() + 1 < width
					&& canvasArrays[pop.getX()][pop.getY() + 1] == oldCharacter) {
				stack.add(new Location(pop.getX(), pop.getY() + 1));
			}
		}
	}
	private void addRectangle(Rectangle rec) {
		if (isWithInCanvas(rec.getX1(), rec.getY1())) {
			throw new InvalidElementException("Rectangle"+OUTSIDE_CANVAS);
		}
		drawRectangle(rec.getX1(), rec.getY1(), rec.getX2(), rec.getY2());
	}
	private void drawRectangle(int x1, int y1, int x2, int y2) {
		drawLine(x1, y1, x2, y1);//top line
		drawLine(x2, y1, x2, y2);//bottom line
		drawLine(x1, y1, x1, y2);//right line
		drawLine(x1, y2, x2, y2);//right line
	}
	private void addLine(Line line) {
		if (isWithInCanvas(line.getX1(), line.getY1())) {
			throw new InvalidElementException("Line"+OUTSIDE_CANVAS);
		}
		if (line.getX2() >= width) {
			line.setX2(width);
		}
		if (line.getY2() >= height) {
			line.setY2(height);
		}
		drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
	}

	private void drawLine(int x1, int y1, int x2, int y2) {
		for (int row = y1 - 1; row <= y2 - 1 && row < height; row++) {
			for (int col = x1 - 1; col <= x2 - 1 && col < width; col++) {
				canvasArrays[row][col] = CanvasImpl.LINE_CHAR;
			}
		}

	}

	public boolean isWithInCanvas(int x1, int y1) {
		return x1 < 1 || x1 >= width || y1 < 1 || y1 >= height;
	}

	@Override
	public String drawCanvas() {
		StringBuilder builder = new StringBuilder();
		builder.append(horizontalEdge).append("\n");
		for (int i = 0; i < this.height; i++) {
			builder.append(VERTICAL_EDGE);
			for (int j = 0; j < this.width; j++) {
				builder.append(canvasArrays[i][j]);
			}
			builder.append(VERTICAL_EDGE);
			builder.append("\n");
		}
		builder.append(horizontalEdge);
		return builder.toString();
	}

}
