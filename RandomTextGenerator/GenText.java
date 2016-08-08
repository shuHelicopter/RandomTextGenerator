package pa4;

/**
 ######################################################
 #################### by Shu Liu ######################
 ############ shutel at hotmail dot com ###############
 ################### 04/12/2016 #######################
 ########### GenText project @ USC CSCI455 ############
 ######################################################
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the main class
 * It is in charge of reading input file, executing the program, and output the data
 */
public class GenText {
	private static int prefixLength = 0; 
	private static int numWords = 0;
	private static boolean debug = false;
	private static String inFileName = "";
	private static String outFileName = "";
	private static String wordGen = "";
	private static ArrayList<String> origWord = new ArrayList<String>();
	private static ArrayList<String> successors = new ArrayList<String>();
	private static Prefix prefix;

	/**
	 * Main method that inputs data, executes the text generating program and outputs results
	 * @param args command arguments
	 * @throws IOException deal with exceptions
	 */
	public static void main(String[] args) throws IOException{
		input(args);
		if(prefixLength < 1){
			System.out.println("The prefixLength should be no less than 1");
		}
		else if(numWords < 0){
			System.out.println("The numWords should be no less than 0");
		}
		else if(prefixLength >= origWord.size()){
			if(origWord.size() <= 1){
				System.out.println("This file should have more than one word");
			}
			else{
				System.out.println("The prefixLength should be less than the number of words in sourceFile");

			}
		}

		else{
			excute();
		}
	}

	/**
	 * Read the file with the given file name
	 * @param fileName the given file name
	 * @return words in the input file
	 * @throws IOException deal with exceptions
	 */
	private static ArrayList<String> readFile(String fileName) throws IOException {
		File inFile = new File(fileName);
		Scanner in = new Scanner(inFile);
		try {
			return readWords(in);
		}
		finally
		{
			in.close();
		}
	}
	/**
	 * Read all the words and put them in the array list
	 * @param in the content scanned from the file
	 * @return the data in the input file
	 */

	private static ArrayList<String> readWords(Scanner in){
		ArrayList<String> origWordData = new ArrayList<String>();
		String words;
		while(in.hasNext()){
			words = in.next();
			origWordData.add(words);
		}
		return origWordData;
	}

	/**
	 * Input the data from the given file
	 * @param args command arguments from users
	 */

	private static void input(String[] args){
		try {
			if (args.length < 1) {
				System.out.println("ERROR: missing file name command line argument");
			}
			else {
				if (args.length !=4 && args.length !=5){
					System.out.println("The number of command-line arguments should be four or five. ");
					System.out.println("The input format is: [-d] prefixLength numWords sourceFile outFile. ");
				}
				else if (args.length == 5){
					inFileName = args[3]; 
					outFileName = args[4];
					prefixLength = Integer.parseInt(args[1]);
					numWords = Integer.parseInt(args[2]);
					debug = true;
				}
				else{
					inFileName = args[2]; 
					outFileName = args[3];
					prefixLength = Integer.parseInt(args[0]);
					numWords = Integer.parseInt(args[1]);
					debug = false;
				}
			}
			origWord = readFile(inFileName);
		}
		catch (FileNotFoundException exc) {
			System.out.println("File not found: " + inFileName);
		}
		catch (NumberFormatException exc) {
			System.out.println("The prefixLength or numWords should be an integer");
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * Execute the text generating program
	 * @throws IOException deal with exceptions
	 */

	private static void excute() throws IOException{
		Output outFile = new Output();
		prefix = new Prefix(prefixLength, origWord, true);
		prefix.prefixMapGen();
		prefix.initialPre();
		if(debug){
			System.out.println("DEBUG: chose a new initial prefix: " + prefix.toString());   
		}

		for(int i=1; i<=numWords; i++ ){ 
			successors = prefix.getSuccessorList();
			if(debug){
				System.out.println("DEBUG: prefix: " + prefix.toString()); 
				System.out.println("DEBUG: successors: " + successors); 
			}
			if(successors == null){
				prefix.initialPre();
				if(debug){
					System.out.println("DEBUG: successors: <END OF FILE>");   
					System.out.println("DEBUG: chose a new initial prefix: " + prefix.toString());
				}
				successors = prefix.getSuccessorList();
			}
			wordGen = new RandomTextGenerator(successors, debug).randGen();
			if(debug){
				System.out.println("DEBUG: word generated: " + wordGen);
			}
			outFile.fileWrite(wordGen, outFileName);
			prefix.shiftPrefix(wordGen);
		}

	}
}
