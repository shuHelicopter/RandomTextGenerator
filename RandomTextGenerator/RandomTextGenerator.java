package pa4;

/**
 ######################################################
 #################### by Shu Liu ######################
 ############ shutel at hotmail dot com ###############
 ################### 04/12/2016 #######################
 ########### GenText project @ USC CSCI455 ############
 ######################################################
 */

/**
 * This class is in charge of generating the next word from the successors list input
 */
import java.util.ArrayList;
import java.util.Random;

public class RandomTextGenerator {

	private ArrayList<String> successorList;
	private String wordGen;
	private boolean debug;
	
	/**
	 * Constructor
	 * @param successorList the successor list generated from current prefix
	 * @param debug check bugs with the debug model
	 */
	public RandomTextGenerator(ArrayList<String> successorList, boolean debug){
	this.successorList = successorList;
	this.debug = debug;
}
	/**
	 * Randomly generate the next word in the successor list
	 * @return the next word
	 */
	public String randGen(){
		int index = 0;
		Random generator;
		if(!debug){
			generator = new Random();
		}
		else{
			generator = new Random(1);
		}
		index = generator.nextInt(successorList.size());
		wordGen = successorList.get(index);
		return wordGen;
	}
		
}
