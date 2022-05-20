import processing.core.PApplet;

public class Sketch extends PApplet {

  // initializig variables for grid 
  int intCellWidth = 20;
  int intCellLength = 20;
  int intMargin = 5;
  int intRowCount = 10;
  int intColumnCount = 10;
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
    // setting all values of array to 1
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
    // drawing squares along the grid with color based on value of their spaces in the array 
    for (int y = 0; y < intColumnCount; y++){
      for(int x = 0; x < intRowCount; x++){
        if (intGrid[y][x] % 2 == 0){
          // produces green square if value of square is an even number 
          fill(0,255,51);
          rect(intMargin * (x+1) + (intCellWidth * x), intMargin + (intMargin + intCellLength) * y, intCellWidth, intCellLength);
        }else{
          // produces white square if value of square is an off number 
          fill(255);
          rect(intMargin * (x+1) + (intCellWidth * x), intMargin + (intMargin + intCellLength) * y, intCellWidth, intCellLength);
        }
        }
    }
	  
  }

  // mouseclicked method to run each time the mouse is clicked 
  public void mouseClicked(){
    // for loop to run every time mouse is clicked to check where the mouse was clicked, and add 1 to the values of the squares around the square clicked to change its color
    for (int y = 0; y < intColumnCount; y++){
      for(int x = 0; x < intRowCount; x++){
        if (mouseX > intMargin * (x+1) + (intCellWidth * x) && mouseX < ((intMargin * (x+1) + (intCellWidth * x)) + intCellWidth) && mouseY > (intMargin + (intMargin + intCellLength) * y) && mouseY < (intMargin + (intMargin + intCellLength) * y + intCellLength)){
          // print statement to print coordinates of mouse 
          System.out.println("Mouse Coordinates: (" + (mouseX) + "," + (mouseY) + "); grid coordinates: (row: " + y + " column: " + x + ")");
          System.out.println("");

          // increases values of array based on where on grid the mouse is 
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

    // for loop to count how many spaces are green in each row, and also how many continous blocks are green 
    for (int y = 0; y < intColumnCount; y++){
    for(int x = 0; x < intRowCount; x++){
    if (intGrid[y][x] % 2 == 0){
      counter++;
      RowCounter++;
      Continue++;
    }

    // if the continous value of the squares in a row is higher than the current maximum of the row it is replaced
    if (Continue > Max){
      Max = Continue;
    }

    // if the count finds an array vlaue that is odd, the continous value is reset to zero 
    if (intGrid[y][x] % 2 != 0){
      Continue= 0;
    }
  }

  // print statemetns based on how many green cells are present in each data type 
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

// for loop to find how many squares are green in each column 
for(int x = 0; x < intRowCount; x++){
for (int y = 0; y < intColumnCount; y++){
  if (intGrid[y][x] % 2 == 0){
    ColumnCounter++;
  }
}
// print statement based on how many spaces are green in the column 
System.out.println("Column " + x + " has " + ColumnCounter + " cells selected");
ColumnCounter = 0;
}


// prints how many cells are selected in total along the entire grid
    System.out.println("");
    System.out.println("Total of " + counter + " cells are selected");
    System.out.println("");
    counter = 0;

  }
}
