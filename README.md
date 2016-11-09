# RandomTextGenerator
@Copyright ShuHelicopter  
Random Text Generator Project with Java (Markov process text generation)

For generating text, you should initially choose prefixLength consecutive words at random from the sample text and use them as the initial prefix (we'll call this a random prefix) in the random writing process outlined earlier. (The program does not generate the words in this initial prefix.) Your program should then write numWords words to outFile. Each of these words should be chosen based on the current prefix. (Each time a word w is written to outFile, the prefix is updated by removing its first word and appending w to the end.)

For example, suppose that prefixLength = 2 and the sample file contains

I like the big blue dog better than the big elephant with the big blue hat on his tusk.
Here is how the first three words might be chosen:
A two-word sequence is chosen at random to become the initial prefix. Let's suppose that "the big" is chosen.
The first word must be chosen based on the probability that it follows the prefix (currently "the big") in the source. The source contains three occurrences of "the big". Two times it is followed by "blue", and once it is followed by "elephant". Thus, the next word must be chosen so that there is a 2/3 chance that "blue" will be chosen, and a 1/3 chance that "elephant" will be chosen. Let's suppose that we choose "blue" this time.
The next word must be chosen based on the probability that it follows the prefix (currently "big blue") in the source. The source contains two occurrences of "big blue". Once it is followed by "dog", and the other time it is followed by "hat". Thus, the next word must be chosen so that there is a 50-50 probability of choosing "dog" vs. "hat". Let's suppose that we choose "hat" this time.
The next word must be chosen based on the probability that it follows the prefix (currently "blue hat") in the source. The source contains only one occurrence of "blue hat", and it is followed by "on". Thus, the next word must be "on" (100% probability).
Thus, the first three words in the output text would be "blue hat on".

*  
This is one the course projects in CSCI 455.





