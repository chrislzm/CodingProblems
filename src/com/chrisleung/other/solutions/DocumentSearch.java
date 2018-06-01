package com.chrisleung.other.solutions;

public class DocumentSearch {
    import java.io.*;
    import java.util.*;

    /*

     Small search engine
     Keyword-based search
     Assume documents are available as files
        Can assume in string arrays
     Return: Regular text document (not binary), offset from beginning of document

     Full word match
     Number of characters

     Goal: Highlight the word in the document


     */


    class Document {
        long docId;
        String document;
    }

    class Result {
        long docId;
        List<Integer> locations; // char location from beginning of file
        Result(long d, List<Integer> l) {
            docId = d;
            locations = l;
        }
    }


    static final String PUNCTUATION_AND_WHITESPACE = "[\.!\n\t ]";

    static final Set<Character> TOKENIZE_CHARS;

    static {
        TOKENIZE_CHARS = new HashSet<Character>();
        for(char c : PUNCTUATION_AND_WHITESPACE) {
            TOKENIZE_CHARS.add(c);
        }
    }

    Map<String,List<Result>> searchResultsMap = new HashMap<>();

    public void preprocess(List<Document> documents) {
        for(Document doc : documents) {
            StringBuilder word = new StringBuilder();
            for(int index=0; index<=doc.document.length(); index++) {
                if(TOKENIZE_CHARS.contains(doc.document.charAt(index)) || index == doc.document.length()) {
                    // Add the word to our results
                    if(word.length() > 0) {            
                        List<Result> results = searchResultsMap.computeIfAbsent(word.toString(),k->new ArrayList<Result>());
                        results.add(new Result(doc.docId,index-word.length()));
                        word.setLength(0);                      
                    }
                } else if(index < doc.document.length()){
                    char c = doc.document.charAt(index);
                    if(c >= 'A' && c <= 'Z') {
                        c = c - 'A' + 'a'; // Make lowercase
                    }
                    word.append(c);
                }
            }
        }
    }

    public List<Result> search(String searchString) {
        if(searchResultsMap.containsKey(searchString.toLowerCase())) {
            return searchResultsMap.get(searchString);
        }
        return new ArrayList<>();    
    }

    // n = number documents
    // m = average length of the documents
    // O(nm)
    public List<Result> search1(List<Document> documents, String searchString) {
        List<Result> output = new ArrayList<>();
        for(Document doc : documents) { // O(n)
            if(doc.document == null || doc.document.isEmpty()) continue;
            // "cat" don't return "category"
            List<Integer> results = new ArrayList<>();
            // Handle upper/lowercase
            String document = doc.document.toLowerCase();
            searchString = searchString.toLowerCase();
            // Regex matching
            Pattern pattern = Pattern.compile(String.format("%s%s%s",PUNCTUATION_AND_WHITESPACE,searchString,PUNCTUATION_AND_WHITESPACE));
            Matcher matcher = pattern.matcher(doc.document);
            // Find all matches in the document
            while(matcher.find()) { // O(m)
                results.add(matcher.start()); // start() = char index of match
            }
            // Add to output
            output.add(new Result(doc.docId,results));
        }
        return output;
    }

    public static void main(String[] args) {
    }
}
