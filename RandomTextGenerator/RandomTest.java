package pa4;

/**
 ######################################################
 #################### by Shu Liu ######################
 ############ shutel at hotmail dot com ###############
 ################### 04/12/2016 #######################
 ########### GenText project @ USC CSCI455 ############
 ######################################################
 */

import java.util.ArrayList;

public class RandomTest {
	public static void main(String[] args){
		boolean debug = true;
	ArrayList<String> test = new ArrayList<String>();
	String outcome;
	test.add("d");
	test.add("tom");
	test.add("mom");
	test.add("dad");
	RandomTextGenerator testGen = new RandomTextGenerator(test, debug);
	outcome = testGen.randGen();
	System.out.println(outcome);
	}
}
