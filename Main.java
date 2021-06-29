package cmpe150_1;


public class Main {
	public static void main(String [] args) {
		
		int stickmanHeight = Integer.parseInt(args[0]);
		int stairHeight = Integer.parseInt(args[1]);
		
		//this for loop achieves certain number of frames depending on the height of the stairs. The variable "numberOfFrames" indicates the number of images of the ascending stickman in the output
		for(int numberOfFrames=0; numberOfFrames<=stairHeight; numberOfFrames++) {
			//this for loop is used for printing different number of empty lines in each frame which depends on the height of the stairs. The "emptyLines" variable indicates the number of empty lines printed in each frame
			for( int emptyLines=stairHeight; emptyLines>numberOfFrames; emptyLines--) {
					System.out.println();
				}
			//printing number of spaces before the head(can possibly be 0) by implementing the "repeatingCharacters" method, (numberOfFrames*3) number of times because the number of white-spaces increases by 3 with every frame
			repeatingCharacters(' ',numberOfFrames*3);
			
			// printing the head
			System.out.println(" O ");
			
			//printing number of white-spaces before the hands(can possibly be 0) implementing "repeatingCharacters" method , (numberOfFrames*3) number of times because the number of white-spaces increases by 3 with every frame
			repeatingCharacters(' ',numberOfFrames*3);
			
			//printing the hands of the stickman
			System.out.print("/|\\\n");
			
			//printing middle part using the  middlePart method
			middlePart(numberOfFrames, stickmanHeight, stairHeight);
			
			//printing sticks with stairs using the numberOfFrames method 
			sticksWithStairs(numberOfFrames, stairHeight);
			
			//printing legs with the corresponding stairs, using the legsOfStickman method
			legsOfStickman(numberOfFrames, stairHeight);
			
			//printing the part after the legs, using the stairsAfterLegs method
			stairsAfterLegs(numberOfFrames, stairHeight);
			
			//printing 3 lines at the end of each image
			System.out.println("\n\n");
			}
	}
	/*This method can print a certain character given number of times, using two parameters. 
	One of the parameters is "character", which is the type of character(could be whitespace, star) needs to be printed and the other parameter is "times", 
	which indicates how many times it should be printed*/
	 public static void repeatingCharacters(char character, int times) {
		 //for loop used to print a given character, using the variable "repeat", which increments by one with every iteration, while it is less than the given number of "times"
    	 for (int repeat = 0; repeat < times; repeat++) {	
    	 System.out.print(character);
    	 }
    	 } 	
	
	//This method(middlePart) prints white-spaces with vertical sticks in a new line before the stairs, using three parameters(numberOfFrames, stickmanHeight, stairHeight)
	public static void middlePart(int numberOfFrames, int stickmanHeight, int stairHeight) {
		
		//printing sticks of the body above the stairs. The initial number of sticks is given by a relationship((stickmanHeight-2)-(stairHeight+1), which could be zero in some cases.The number of lines with the white-spaces and the stick increases by 1 with every frame as the stickman ascends the stairs.
		//the for loop with a "body" variable is used to print the white-spaces and the stick on every new line while the "body" variable is less than ((stickmanHeight-2)-(stairHeight+1)+numberOfFrames).
		for(int body=0; body<(stickmanHeight-2)-(stairHeight+1)+numberOfFrames; body++) {
			//implementing the "repeatingCharacters" method in order to print white-spaces before the stick (numberOfFrames*3) number of times because the number of white-spaces increase by 3 with every frame
			repeatingCharacters(' ',numberOfFrames*3);
			//printing the vertical stick of the body of the stickman
			System.out.println(" | ");
		}
	}
	//This method(sticksWithStairs)is implemented in order to print the sticks of the body and the corresponding stair, using two parameters(numberOfFrames, stairHeight)
	public static void sticksWithStairs(int numberOfFrames, int stairHeight) {
		//this for loop with a "line" variable is used for printing the vertical stick with a corresponding stair. "Line" variable used indicates how many lines of stick with a stair will be printed in each frame. The number of such lines decrease with every frame as the stickman ascends.
		for(int line=0;line<stairHeight-numberOfFrames; line++) {
			//implementing the "repeatingCharacters" method in order to print white-spaces before the stick (numberOfFrames*3) number of times because the number of white-spaces increase by 3 with every frame
			repeatingCharacters(' ',numberOfFrames*3);
			//printing the vertical stick of the body of the stickman
			System.out.print(" | ");
			//implementing the "repeatingCharacters" method in order to print white-spaces before the step of the stair, which decrease by 3 with every line and by 3 with each new frame.
			repeatingCharacters(' ',3*stairHeight-3*line-3*numberOfFrames);
			//printing the step of each stair 
			System.out.print("___|");
			//implementing the "repeatingCharacters" method in order to print stars inside each stair (line*3) number of times because the number of stars increase in each line by 3
			repeatingCharacters('*',line*3);
			//printing the end part of the stair
			System.out.println("|");
			
		}
	}
	//This method(legsOfStickman) is implemented in order to print the legs part of the stickman with the corresponding stair using two parameters(numberOfFrames, stairHeight)
	public static void legsOfStickman(int numberOfFrames, int stairHeight) {
		//implementing the "repeatingCharacters" method in order to print white-spaces before the legs (numberOfFrames*3) number of times because the number of white-spaces increase by 3 with every frame
		repeatingCharacters(' ',numberOfFrames*3);
		//printing legs
		System.out.print("/ \\___|");
		//implementing the "repeatingCharacters" method in order to print stars inside each stair (3*stairHeight-3*numberOfFrames) number of times because as the stickman ascends the stairs in every frame it gets on a stair with the number of stars decreased by 3.
		repeatingCharacters('*',3*stairHeight-3*numberOfFrames);
		//printing the end part of the stair
		System.out.println("|");
	}
	//This method(stairsAfterLegs) is used in order to print the part which the stickman has already passed(is not displayed on the first frame), using two parameters(numberOfFrames,stairHeight)
	public static void stairsAfterLegs(int numberOfFrames, int stairHeight) {
		//This for loop is used for increasing number of printed lines of stairs passed by stickman in each frame. The "lines" variable indicates the number of stairs passed by stickman. with every frame one more line is printed, as the stickman ascends the stairs
		for(int lines=0; lines < numberOfFrames; lines++) {
			//implementing the "repeatingCharacters" method in order to print white-spaces (3*numberOfFrames-3*lines) number of times because the number of white-spaces changes in each frame and line 
			repeatingCharacters(' ', 3*numberOfFrames-3*lines);
			//printing the the step of the stair
			System.out.print("___|");
			//implementing the "repeatingCharacters" method in order to print stars inside each stair (stairHeight*3-3*(numberOfFrames-1)+lines*3) number of times because the number of stars is changing with the frame and line
			repeatingCharacters('*', stairHeight*3-3*(numberOfFrames-1)+lines*3);
			//printing the end part of the stair
			System.out.println("|");
		}
	}

}
