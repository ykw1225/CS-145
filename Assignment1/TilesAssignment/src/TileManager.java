
import java.awt.*;
import java.util.*;

/**
 * This class represents how does the drawing panel act
 * when users use mouse or keyboard by clicking or pressing some specific key.
 * @author Kit Wong
 */
public class TileManager {
    ArrayList <Tile> tileList;

    /**
     * This method is the constructor for the TileManager object.
     */
    public TileManager() {
        tileList = new ArrayList <Tile>();
    }

    /**
     * This method is adding a new Tile object into the Tile ArrayList.
     * @param rect is a Tile object which contain x, y, width, height, and color variables.
     */
    public void addTile(Tile rect) {
        tileList.add (rect);
    }

    /**
     * This method is checking if the point is inside the tile object.
     * @param rect is a Tile object
     * @param x is the x value of the point
     * @param y is the y value of the point
     */
    public boolean checkIfInside(Tile rect, int x, int y){
		if(x >= rect.getX() && x <= (rect.getX() + rect.getWidth())){
			if(y >= rect.getY() && y <= (rect.getY() + rect.getHeight())){
				return true;
			}
		}
		return false;
	}


    /**
     * This method is making the drawing panel to draw out all of the tile objects in the tile array list.
     * @param g is a graphics object which can draw things in drawing panel.
     */
    public void drawAll(Graphics g) {
        for (int i=0; i<tileList.size(); i++){
            tileList.get(i).draw(g);
        }
    }

    /**
     * This method is raising the most top of the tile object
     * when the mouse left click on it to the most front in panel.
     * @param x is the x value where the mouse clicking.
     * @param y is the y value where the mouse clicking.
     */
    public void raise(int x, int y) {
        for (int i=tileList.size()-1; i >= 0; i--){
            if(checkIfInside(tileList.get(i),x,y)){
				if(i != tileList.size()-1){
					tileList.add(tileList.get(i));
                	tileList.remove(i);
                	i=0;
				}
            }
            else{
                i=0;
            }
		}
	}

    /**
     * This method is lowering the most top of the tile object
     * when the mouse shift left click on it to the most back in panel.
     * @param x is the x value where the mouse clicking.
     * @param y is the y value where the mouse clicking.
     */
    public void lower(int x, int y) {
        for (int i=tileList.size()-1; i >= 0; i--){
            if (checkIfInside(tileList.get(i), x, y)) {
				tileList.add(0, tileList.get(i));
				tileList.remove(i+1);
				break;
			}
            else{
				break;
            }
		}
	}

    /**
     * This method is deleting the most top of the tile object
     * when the mouse right click on it.
     * @param x is the x value where the mouse clicking.
     * @param y is the y value where the mouse clicking.
     */
    public void delete(int x, int y) {
        for (int i=tileList.size()-1; i >= 0; i--){
            if (checkIfInside(tileList.get(i), x, y)){
				tileList.remove(i);
                i = 0;
            }
        }
    }

    /**
     * This method is deleting the all tile objects which are under the point
     * when the mouse shift right click on that point.
     * @param x is the x value where the mouse clicking.
     * @param y is the y value where the mouse clicking.
     */
    public void deleteAll(int x, int y) {
        for (int i=tileList.size()-1; i >= 0; i--){
            if (checkIfInside(tileList.get(i), x, y)) {
				tileList.remove(i);
            }
        }
    }

    /**
     * This method is reordering and relocating the tile objects.
     * @param width is the width of panel.
     * @param height is the height of panel.
     */
    public void shuffle(int width, int height) {
        Collections.shuffle(tileList);
        Random rand = new Random();
        for (int i=0; i<tileList.size(); i++){
            tileList.get(i).setX(rand.nextInt(width-tileList.get(i).getWidth()));
            tileList.get(i).setY(rand.nextInt(height-tileList.get(i).getHeight()));
        }
    }
}
