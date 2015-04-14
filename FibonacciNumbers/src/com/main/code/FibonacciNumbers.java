/**
* FibonacciNumbers --- program to print "Fibonacci Numbers".
* @author Jananjoy 
* 
*/
package com.main.code;
import java.util.Scanner;

public class FibonacciNumbers {
	
	private int firstNumber;  // First Number of the Fibonacci number
	private int secondNumber; // Second Number of the Fibonacci number
	private int nextElement;  //  Next Element of the Fibonacci number
	private int []fiboSeriesNumber; // Array to store Fibonacci Numbers 
	static int indexCounter; // index Counter variable 
	
	/**
	   * Initialization of the variables related with FibonacciNumbers class 
	   * @param firstNumber- the number of the Fibonacci Series. 
	   * @param secondNumber- the number of the Fibonacci Series. 
	   * @param arraySize-the array Size. 
	   */
	FibonacciNumbers( int firstNumber, int secondNumber, int arraySize ){
		
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		nextElement = 0;
		fiboSeriesNumber = new int[arraySize];

	} // End of the Constructor FibonacciNumbers(int.int.int)
	
	/**
	   * Generation of the FibonacciSeries based on the user input
	   * @param totalNumber-the total number of element in the Series. 
	   * @return No return value.
	   */
	void FibonacciSeries( int totalNumber ){
		
		fiboSeriesNumber[indexCounter++] = firstNumber;
		fiboSeriesNumber[indexCounter++] = secondNumber;
		
		while( indexCounter < totalNumber ){
			
			nextElement = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = nextElement;
			
			fiboSeriesNumber[indexCounter++] = nextElement;
			
		} //End of the while() loop
		
	}// End of the  FibonacciSeries() methods
	
	/**
	   * Display the element of the Fibonacci Series
	   * @param totalNumber-the total number of element in the Series. 
	   * @return No return value.
	   */
	void displayFibonacciElement(){
		
		System.out.println(" The elements in the List are:");
		for(int index = 0; index < indexCounter; index++){
			
			System.out.println( fiboSeriesNumber[index] );
			
		}// End of the for loop

	} // End of the displayFibonacciElement() methods
	
	/**
	   * Display the element of the Fibonacci Series
	   * @param elementCount -the total number of element in the Series. 
	   * @return No return value.
	   */
	public static long recursiveFiboSeriesNumber( int elementCount ) {
		
		if( elementCount == 0 ) return elementCount;
		else if( elementCount == 1 ) return elementCount;
		else return recursiveFiboSeriesNumber( elementCount - 1 )+recursiveFiboSeriesNumber( elementCount - 2 );
		
	} // End of the recursiveFiboSeriesNumber( int ) methods
	
	/**
	* Description: The Prints out series of the Fibonacci Numbers based on the user inputs
	* @param arg A string array containing
	* @exception Any exception
	* @return No return value.
	*/
	public static void main(String[] args) {
    
		ReadInputFromXML getInputValue = new ReadInputFromXML();
		getInputValue.readData();
		int myNumber = getInputValue.getTotalElement();
		System.out.println("================================");
		System.out.println("1.Fibonacci Series Using recursion");
		System.out.println("2.Fibonacci Series Without recursion");
		System.out.println("Enter your Choice=>");
		
		Scanner inputChoice = new Scanner(System.in);
		int myChoice = inputChoice.nextInt();
		switch( myChoice ){
		
			case 1:
				for(int index = 0; index < myNumber; index++){
				
					System.out.println( index + ":" + recursiveFiboSeriesNumber(index));
				
				}	
				break;	
			
			case 2:
				
				FibonacciNumbers myFibonacciNumbers = new  FibonacciNumbers(getInputValue.getFirstElement(),getInputValue.getSecondElement(),getInputValue.getTotalElement());
				myFibonacciNumbers.FibonacciSeries(myNumber);
				myFibonacciNumbers.displayFibonacciElement();
				
				break;	
				
			default:
				
				System.out.println( "User do not choose the right options" );
				
			    break;
		
		} // End of the Switch()
	    
	} //End of the main() methods

}
