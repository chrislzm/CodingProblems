package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlagiarismDetector {
    
    // intputs: n-gram size (int), single document (String)
    // List<String>: n-grams in the document
    // unit: word   "to be or not to be" n-gram 1, ["to","be","or"..]
    // 2-gram ["to be", "be or", "or not"...]
    // [["to","be"],["be","or"]..]
    
    // Upper/lower case
    // Punctuation
    // Numbers
    // English alphabet
    // Whitespace
    
    // n-gram : document id 
    Map<String,List<Long>> index = new HashMap<String,List<Long>>();

    // O(nm) = n number of words, m nGramSize
    List<String> getNgrams(int nGramSize, String document) {
      // TODO: Input validation (nGramSize > 0, String not null, length>0)
      List<String> output = new ArrayList<>();
      String[] tokens = cleanAndTokenizeString(document);
      if(tokens.length > nGramSize) return output;
      for(int i=0; i<=tokens.length-nGramSize; i++) {
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<nGramSize; j++) {
          sb.append(tokens[i+j]).append(' ');
        }
        output.add(sb.toString());
      }
      return output;
    }
    
    // Generate n-grams - O(mn + nk), n = number of words in our document
    // Returns list of doc ids with any of the n-grams in our document
    List<Long> findSimilarDocuments(int nGramSize, String doc) {
      Set<Long> matchedDocuments = new HashSet<>();
      List<String> nGrams = getNgrams(nGramSize, doc);
      // "to be or not to be"
      for(String nGram : nGrams) { // O(nk)  (k = average # documents per ngram, in our index)
        matchedDocuments.addAll(index.get(nGram));
      }
      return new ArrayList<Long>(matchedDocuments);
    }
    
    // "Magic" method that cleans string up, removes punctuation, etc
    String[] cleanAndTokenizeString(String doc) {
      // does that here with doc
      return doc.split("\\s+");
    }
    
    
    public static void main(String[] args) {
    }
}
