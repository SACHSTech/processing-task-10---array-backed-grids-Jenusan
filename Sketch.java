import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import processing.core.PApplet;

public class Sketch extends PApplet {

  int intCellWidth = 20;
  int intCellLength = 20;
  int intMargin = 5;
  int intRowCount = 20;
  int intColumnCount = 20;
  int intScreenWidth = (intRowCount*intCellWidth) + ((intRowCount + 1) * intMargin);
  int intScreenLength = (intColumnCount*intCellLength) + ((intColumnCount + 1) * intMargin);
  int counter;
  int RowCounter;
  int ColumnCounter;
  int Continue;

  int[][] intGrid = new int[intColumnCount][intRowCount];
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(intScreenWidth, intScreenLength);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
    for (int y = 0; y < intColumnCount; y++){
      for(int x = 0; x < intRowCount; x++){
        intGrid[y][x] = 1;
      }
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    for (int y = 0; y < intColumnCount; y++){
      for(int x = 0; x < intRowCount; x++){
        if (intGrid[y][x] % 2 == 0){
          fill(0,255,51);
          rect(intMargin * (x+1) + (intCellWidth * x), intMargin + (intMargin + intCellLength) * y, intCellWidth, intCellLength);
        }else{
          fill(255);
          rect(intMargin * (x+1) + (intCellWidth * x), intMargin + (intMargin + intCellLength) * y, intCellWidth, intCellLength);
        }
        }
    }
	  
  }

  public void mouseClicked(){
    for (int y = 0; y < intColumnCount; y++){
      for(int x = 0; x < intRowCount; x++){
        if (mouseX > intMargin * (x+1) + (intCellWidth * x) && mouseX < ((intMargin * (x+1) + (intCellWidth * x)) + intCellWidth) && mouseY > (intMargin + (intMargin + intCellLength) * y) && mouseY < (intMargin + (intMargin + intCellLength) * y + intCellLength)){
          System.out.println("Mouse Coordinates: (" + (mouseX) + "," + (mouseY) + "); grid coordinates: (row: " + y + " column: " + x + ")");
          System.out.println("");
          if (y == 0 && x == 0){
            intGrid[y][x]++;
            intGrid[y+1][x]++;
            intGrid[y][x+1]++;
          }else if (y==0 && x== intColumnCount - 1){
            intGrid[y][x]++;
            intGrid[y+1][x]++;
            intGrid[y][x-1]++;
          }else if(y==intColumnCount -1 && x== 0){
            intGrid[y][x]++;
            intGrid[y-1][x]++;
            intGrid[y][x+1]++;
          }else if (y==intColumnCount - 1 && x == intRowCount - 1){
            intGrid[y][x]++;
            intGrid[y-1][x]++;
            intGrid[y][x-1]++;
          }else if (y==0){
            intGrid[y][x]++;
            intGrid[y+1][x]++;
            intGrid[y][x-1]++;
            intGrid[y][x+1]++;
          } else if(y == intRowCount -1){
            intGrid[y][x]++;
            intGrid[y-1][x]++;
            intGrid[y][x-1]++;
            intGrid[y][x+1]++;
          }else if(x == 0){
            intGrid[y][x]++;
            intGrid[y-1][x]++;
            intGrid[y+1][x]++;
            intGrid[y][x+1]++;
          } else if(x == intColumnCount -1){
            intGrid[y][x]++;
            intGrid[y-1][x]++;
            intGrid[y+1][x]++;
            intGrid[y][x-1]++;
          } else {
            intGrid[y][x]++;
            intGrid[y-1][x]++;
            intGrid[y+1][x]++;
            intGrid[y][x-1]++;
            intGrid[y][x+1]++;
          }
        }
      }
    }

    int Max = 0; 

    for (int y = 0; y < intColumnCount; y++){
    for(int x = 0; x < intRowCount; x++){
    if (intGrid[y][x] % 2 == 0){
      counter++;
      RowCounter++;
      Continue++;
    }
    if (Continue > Max){
      Max = Continue;
    }
    if (intGrid[y][x] % 2 != 0){
      Continue= 0;
    }
  }

  if (Max <= 2){
    System.out.println("Row " + y + " has " + RowCounter + " cells selected");
    RowCounter = 0;
    Continue = 0;
    Max = 0;
  }else{
  System.out.println("Row " + y + " has " + RowCounter + " cells selected");
  RowCounter = 0;
  System.out.println("There are " + Max + " continuous blocks selcted in row " + y);
  Continue = 0;
  Max = 0;
  }
}

for(int x = 0; x < intRowCount; x++){
for (int y = 0; y < intColumnCount; y++){
  if (intGrid[y][x] % 2 == 0){
    ColumnCounter++;
  }
}
System.out.println("Column " + x + " has " + ColumnCounter + " cells selected");
ColumnCounter = 0;
}


    System.out.println("");
    System.out.println("Total of " + counter + " cells are selected");
    System.out.println("");
    counter = 0;

  }
}
