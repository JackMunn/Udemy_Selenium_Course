import java.util.ArrayList;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {

		// int
		int myNumber = 5; 
		// System.out.println(myNumber + " is the number stored in the variable");
		// decimal points
		float myLongNumber = 50234234;
		double myDecimal = 4.99; 
		
		
		// Strings
		String myWebsite = "Jack's website"; 
		char myLetter = 'J';
		
		//Boolean
		boolean myOption = true;
		
		// Arrays - the [] denotes an array. First you assign memory, then you define what's in it.
		int[] myArray = new int[5];
		myArray[0] = 1;
		myArray[1] = 2;
		myArray[2] = 3;
		myArray[3] = 4;
		myArray[4] = 5;
		
		// second way of assigning values to an array
		
		int[] myArray2 = {1,2,3,4,5};
		// System.out.println(myArray2[0]);
		
		//for loops
		for(int i = 0; i < myArray2.length; i++) {
		//	System.out.println(myArray2[i]);
			
		// array of strings
		String[] myNames = {"Jack", "Nicola", "Pete", "Manish"};
		
		for(i = 0; i < myNames.length; i++) {
			// System.out.println(myNames[i]);
		}

		// an alternative way of iterating through an array
		for(String s: myNames) {
			// System.out.println(s);
		}
				}
		int[] longArray = {1,2,4,5,6,7,8,9,10,122};
			
			for(int i = 0 ; i < longArray.length; i++) {
				if(longArray[i] % 2 == 0) {
					//System.out.println(longArray[i] + " is even");
					break;
				}
				else 
				{
					//System.out.println(longArray[i] + " is odd");
				}
			} 
			
		// Array list, unlike normal arrays, allow new values to be added
		
		ArrayList<String> myArrayList = new ArrayList();
		
		myArrayList.add("Jack");
		myArrayList.add("Katie");
		myArrayList.remove(0);

		
		System.out.println(myArrayList);
		
		
		// Strings- which is an object in Java
		// Creates a String object using string literal
		String firstString = "Jack";
		//if a second string contains the same data as the first, it will simply 'point' to the first, rather than allocate new memory for the same data
		String secondString = "Jack";
		
		//a second way to set a string, using new object - this will always allocate additional memory, even if its duplicate data
		String thirdString = new String("Test");
		
		// breaking up strings
		String threeWords = "Jack Katie Laura";
		String[] splitStrings = threeWords.split(" ");
		for(int i = 0; i < splitStrings.length; i++) {
			System.out.println(splitStrings[i]);
		}
		
		String wordWithWhiteSpace = " Katie";
		String trimmedWord = wordWithWhiteSpace.trim();
		System.out.println(trimmedWord);
		
		// prints each character in a string
		for(int i = 0; i < threeWords.length(); i++) {
			System.out.println(threeWords.charAt(i));
		}
		
		//print in reverse order
		for(int i = threeWords.length() - 1; i >= 0; i--) {
			System.out.println(threeWords.charAt(i));
		}
		
		// calls a method on an object
		CoreJavaBrushUp1 demoMethod = new CoreJavaBrushUp1();
		int methodNumber = demoMethod.getData();
		System.out.println(methodNumber);
		
		// note this is calling a static method below, without creating an obkect
		System.out.println(returnsMyName());
		
	
	}
	
	// Methods
	// Why methods? re-use blocks of code. Must be created outside of main block, as you don't want to excecute the method immediately when main is ran
	
	public int getData() {
		// public means it can be used by other classes (files)
		// the 'void' can be replaced based on the output of the method: string, int, etc. Void means it is returning nothing.
		System.out.println("Hello from the method");
		return 5;
	}
	
	public static String returnsMyName() {
		// use of 'static' moves the method from object level to class level.
		return "Jack";
	}
	

}
