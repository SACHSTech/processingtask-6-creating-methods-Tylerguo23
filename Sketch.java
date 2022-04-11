import processing.core.PApplet;

/**
 * 
 * This program draws a simple house using methods
 * @author: T. Guo
 *
 **/


public class Sketch extends PApplet {

  public void settings() {
    // set screen size
    size(800, 600);
  }

  public void setup() {
    // set background to light blue
    background(102, 217, 255);
  }

  public void draw() {
    // house base
    fill(255,255,204);
    rect(getCornerX(width / 2, width / 2), height / 2, width / 2, height / 2);
    triangle(width / 4, height / 2, width / 2, height / 3, (float) (width * 0.75), height / 2);
    
    // grass
    fill(51, 204, 51);
    rect(0, (float) (height * (double) 29 / 30), width, height / 30);
    
    // door
    fill(255, 204, 102);
    rect(getCornerX(width / 10, width / 2), (float) (height * 0.75), width / 10, (float) (height * (double) 13 / 60));

    // windows
    fill (51, 204, 255);
    drawWindow((float) (width * 0.3125), (float) (height * (double) 7 / 12));
    drawWindow((float) (width * 0.625), (float) (height * (double) 7 / 12));
    
    // yellow (sun and doorknob)
    fill(255, 255, 0);
    ellipse(width / 8, height / 6, width / 8, height / 6);
    ellipse((float) (width * 0.525), (float) (height * (double) 13 / 15), width / 80, height / 60);

    // flowers
    drawFlower((float) (width * 0.3125), (float) (height * (double) 13 / 15), width / 16, color(255, 153, 0), color(255, 255, 0));
    drawFlower((float) (width * 0.40625), (float) (height * (double) 12 / 15), width / 16, color(137, 153, 255), color(255, 255, 0));
    drawFlower((float) (width * 0.59375), (float) (height * (double) 12.5 / 15), width / 16, color(160, 210, 0), color(255, 255, 0));
    drawFlower((float) (width * 0.6875), (float) (height * (double) 13.5 / 15), width / 16, color(255, 150, 150), color(255, 255, 0));
  }


  /**
  * Draws a small square window
  *
  * @param x x-coordinate of the window's top left corner
  * @param y y-coodinate of the window's top left corner
  *
  */
  private void drawWindow(float x, float y){
    rect(x, y, width / 16, height / 12);
    line(x + width / 32, y, x + width / 32, y + height / 12);
    line(x, y + height / 24, x + width / 16, y + height / 24);
  }


  /**
  * Draws a 4 petaled flower
  *
  * @param centerX the x-coordinate of the center of the actual flower
  * @param centerY the y-coordiante of the center of the actual flower
  * @param petalSize the length of the petals in pixels
  * @param petalColor the color of the petals as an RGB int value
  * @param centerColor the color of the center of the flower as an RGB int value
  *
  */
  private void drawFlower(float centerX, float centerY, float petalSize, int petalColor, int centerColor){
    // stem
    stroke(51, 153, 51);
    strokeWeight(width / 200);
    line(centerX, centerY, centerX, (float) (height * (double) 29 / 30));
    
    // petals
    stroke(0);
    strokeWeight(0);
    fill(petalColor);
    ellipse(centerX, centerY, width / 40, petalSize);
    ellipse(centerX, centerY, petalSize, height / 30);
    
    // center
    strokeWeight(1);
    fill(centerColor);
    ellipse(centerX, centerY, width / 40, height / 30);
  }


  /**
  * Returns the x-coordinate that an object must be drawn at in order for it to be
  * centered on the given coordinates
  *
  * @param width the width of the object
  * @param x the x-coordinate that the object should be centered upon
  * @return the x-coordinate that the object should be drawn at
  *
  */
  private float getCornerX(float width, float x){
    float newX = x - width / 2;
    return newX;
  }
}