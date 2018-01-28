package database;

import java.awt.Point;

public class Grid {
private Pixel[][] grid;

public Grid(int h, int w) {
	grid = new Pixel[h][w];
	for(int x=0; x<h; x++) {
		for(int y=0; y<w; y++) {
			grid[x][y] = new Pixel("",new Point(x,y));
		}
	}
}

public void changePixel(String c, int x, int y) {
	grid[x][y].changeColor(c);
}

public String getPixel(int x, int y) {
	return grid[x][y].getColor();
}
	
	private class Pixel{
		private String color;
		@SuppressWarnings("unused")
		private final Point position;
		
		protected Pixel(String c, Point p) {
			color = c;
			position = p;
		}
		
		public void changeColor(String c) {
			color = c;
		}
		
		public String getColor() {
			return color;
		}
	}
}
