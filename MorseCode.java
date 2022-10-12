import java.util.Scanner;
/* This program takes a user inputed string and outputs a conversion of 
 * select characters of the string as Morse code.
*/

/* Author: Willie Patterson
 * Date:   June 19, 2022
*/
public class MorseCode {

	public static void conversionDirections() { // User directions 
		System.out.print("""
				DIRECTIONS:
				1. Input a statement to be converted to Morse Code.
						
						input: "My name is John Doe"
						output: ---.-- -..---. ..... .-------....-. --.----.
				
				2. Each character of statement will be converted valid inputs include:
						- all letters, a-z regardless of case
						- positive digits, 0-9
						- select specail characters (? , .)
				
				3. If invalid input is detected the morse conversion will convert up to the invalid input
				   and will output that character for future reference. 
				
				""");
	}
	
	/* Method checks string element to convert letters a-z of the 
	 * alphabet and returns theMorse equivalent character.
    */
	public static String alphabetMorse(String alphChar) { 
		
		/* .equalsIgnoreCase() is used in conditional   
		 * statements to reduce errors if user enters capital 
		 * and lower letters. 
		*/
		
		if ("a".equalsIgnoreCase(alphChar)){
			return ".-";
		}
		else if ("b".equalsIgnoreCase(alphChar)) {
			return "-...";
		}
		else if ("c".equalsIgnoreCase(alphChar)) {
			return "-.-.";
		}
		else if ("d".equalsIgnoreCase(alphChar)) {
			return "--.";
		}
		else if ("e".equalsIgnoreCase(alphChar)) {
			return ".";
		}
		else if ("f".equalsIgnoreCase(alphChar)) {
			return "..-.";
		}
		else if ("g".equalsIgnoreCase(alphChar)) {
			return "--.";
		}
		else if ("h".equalsIgnoreCase(alphChar)) {
			return "....";
		}
		else if ("i".equalsIgnoreCase(alphChar)) {
			return "..";
		}
		else if ("j".equalsIgnoreCase(alphChar)) {
			return ".---";
		}
		else if ("k".equalsIgnoreCase(alphChar)) {
			return "-.-";
		}
		else if ("l".equalsIgnoreCase(alphChar)) {
			return ".-..";
		}
		else if ("m".equalsIgnoreCase(alphChar)) {
			return "--";
		}
		else if ("n".equalsIgnoreCase(alphChar)) {
			return "-.";
		}
		else if ("o".equalsIgnoreCase(alphChar)) {
			return "----";
		}
		else if ("p".equalsIgnoreCase(alphChar)) {
			return ".--.";
		}
		else if ("q".equalsIgnoreCase(alphChar)) {
			return "--.-";
		}
		else if ("r".equalsIgnoreCase(alphChar)) {
			return "-.-";
		}
		else if ("s".equalsIgnoreCase(alphChar)) {
			return "...";
		}
		else if ("t".equalsIgnoreCase(alphChar)) {
			return "-";
		}
		else if ("u".equalsIgnoreCase(alphChar)) {
			return "..-";
		}
		else if ("v".equalsIgnoreCase(alphChar)) {
			return "...-";
		}
		else if ("w".equalsIgnoreCase(alphChar)) {
			return ".---";
		}
		else if ("x".equalsIgnoreCase(alphChar)) {
			return "-...";
		}
		else if ("y".equalsIgnoreCase(alphChar)) {
			return "-.--";
		}
		else if ("z".equalsIgnoreCase(alphChar)) {
			return  "--..";
		}
		else {
			alphChar  = intMorse(alphChar); // returns intMorse() method to continue and better organize string elements for morse conversion.
		}
		
		return alphChar;
	}
	
	/* Method checks string element to convert digits 0-9
	 * and return the Morse equivalent character.
	*/
	public static String intMorse(String intChar) {
			
		if ("0".equals(intChar)) {
			return "----";
		}
		else if ("1".equals(intChar)) {
			return ".----";
		}
		else if ("2".equals(intChar)) {
			return "..---";
		}
		else if ("3".equals(intChar)) {
			return  "...--";
		}
		else if ("4".equals(intChar)) {
			return "....-";
		}
		else if ("5".equals(intChar)) {
			return ".....";
		}
		else if ("6".equals(intChar)) {
			return "-....";
		}
		else if ("7".equals(intChar)) {
			return "--...";
		}
		else if ("8".equals(intChar)) {
			return "---..";
		}
		else if ("9".equals(intChar)) {
			return "----.";
		}
		else {
			intChar = specialCaseMorse(intChar); // returns method specialCaseMorse() to continue and better organize string elements for morse conversion.
		}
		
		return intChar;
	}
	
	/* Method checks string element if it is a select 
	 * acceptable special characeter (.,?) and return 
	 * the Morse equivalent character.
	*/	
	public static String specialCaseMorse(String spcChar) {
		
		if (" ".equals(spcChar)) {
			return " ";
		}
		else if (",".equals(spcChar)) {
			return "--..--";
		}
		else if (".".equals(spcChar)) {
			return ".-.-.-";
		}
		else if ("?".equals(spcChar)) {
			return "..--..";
		}
			
		return  ": " + spcChar;	// catch characters that have not been assigned a Morse equivalent character and also for easier output  when that character is called.
	}
	
	/* Method takes a user inputed string, which is split
	 * and stored into a String Array to output the acceptable 
	 * charcters as a new string converted to Morse.
	*/
	public static void userInput(Scanner scnr) {
		System.out.print("Enter a statement for Morse conversion: ");
		
		String s1 = scnr.nextLine(); // User inputed String 
		String[] s2 = s1.split(""); // String s1 is split and stored into an array s2
		String tempval;
		int i;
		
		while (!"stop".equalsIgnoreCase(s1)) {
			
			System.out.print("Morse conversion: ");
			
			for (i = 0; i < s2.length; ++i) {
				 tempval = alphabetMorse(s2[i]); // assigned alpabetMorse() method as it starts to check the character if can be converted to Morse.
				 
				 if (tempval.startsWith(":")) { // Used to catch invalid inputs as they start with a (:) when returned by specialCase() method.
					 System.out.println();
					 System.out.println();
					 System.out.println("ERROR: Invalid Character Inputed" + tempval);
					 break; // code stops and outputs when first invalid input is detected
				 }
				 else {
					 System.out.print(tempval);		
				 }
			}
			System.out.println();
			System.out.println();
			System.out.print("Enter a statement for Morse conversion: ");
			s1 = scnr.nextLine();
			s2 = s1.split("");	
		}	
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		conversionDirections(); // Method call for conversionDirections()
		
		System.out.println("USER-INPUT:");
		userInput(scnr); // Method call for userInput()
	}

}
