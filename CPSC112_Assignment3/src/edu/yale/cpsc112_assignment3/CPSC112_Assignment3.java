package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = true;
  public static Random r = new Random();

  public static void main(String[] args) {
    makeMySecret();
    isGameOver("1234");
    isGameOver("4321");
    isGameOver("2567");
    isGameOver("1432");
  }

  public static void makeMySecret() {
	  int firstDigit = r.nextInt(7) + 1;
	  int secondDigit = r.nextInt(7) + 1;
	  while (firstDigit == secondDigit)
	  {
		  secondDigit = r.nextInt(7) + 1;
	  }
	  int thirdDigit = r.nextInt(7) + 1;
	  while (thirdDigit == firstDigit || thirdDigit == secondDigit)
	  {
		  thirdDigit = r.nextInt(7) + 1;
	  }
	  int fourthDigit = r.nextInt(7) + 1;
	  while (fourthDigit == firstDigit || fourthDigit == secondDigit || fourthDigit == thirdDigit)
	  {
		  fourthDigit = r.nextInt(7) + 1;
	  }
	  mySecret = "" + firstDigit + secondDigit + thirdDigit + fourthDigit;
	  
	  if (DEBUG)
		  {
	       System.out.println(mySecret);
		  }
  }

  public static boolean isGuessValid(String input) {
	  int digitOne = Integer.parseInt(input.substring(0,1));
	  int digitTwo = Integer.parseInt(input.substring(1,2));
	  int digitThree = Integer.parseInt(input.substring(2,3));
	  int digitFour = Integer.parseInt(input.substring(3,4));
	  if (input.length() != 4 || digitOne == digitTwo || digitOne == digitThree || digitOne == digitFour || digitTwo == digitThree || digitTwo == digitFour || digitThree == digitFour || digitOne < 1 || digitOne > 7 || digitTwo < 1 || digitTwo > 7 || digitThree < 1 || digitThree > 7 || digitFour < 1 || digitFour > 7)
	  {
		  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
		  return false;
	  }
	  else
	  {
		  return true;
	  }
  }

  public static boolean isGameOver(String input) {
	  int correctDigits = 0;
	  int correctSpots = 0;
	  
	  if (isGuessValid(input) == false)
	  {
		  return false;
	  }
	  if (isGuessValid(input))
	  {
		  for (int i = 0; i < 4; i++)
		  {
			  for (int j = 0; j < 4; j++)
			  {
				  if (Integer.parseInt(input.substring(i, i+1)) == Integer.parseInt(mySecret.substring(j, j+1)))
				  {
					  correctDigits++;
				  }
			  }
		  }
		  for (int i = 0; i < 4; i++) {
			  if (input.charAt(i) == mySecret.charAt(i))
			  {
				  correctSpots++; 
			  }
		  }
		  
		  System.out.println("Guess: " + input);
		  System.out.println("Result: " + correctDigits + "," + correctSpots);
		  System.out.println(); 
	  }
	  if (correctDigits == 4 && correctSpots == 4) {
		  System.out.println("You won!");
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
}
