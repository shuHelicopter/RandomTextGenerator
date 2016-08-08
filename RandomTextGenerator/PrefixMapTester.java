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
import java.util.Map;
import java.util.HashMap;

public class PrefixMapTester {
	public void printMap(Map<String, ArrayList<String>> codes){
	//then you just access the reversedMap however you like...
	for (Map.Entry entry : codes.entrySet()) {
	    System.out.println(entry.getKey() + ", " + entry.getValue());
	}
	}
}
