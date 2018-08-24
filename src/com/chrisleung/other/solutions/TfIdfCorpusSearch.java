package com.chrisleung.other.solutions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/*

Given the following definitions:
- term: a word like "puppies"
- document: a long string of terms, like "puppies are cuter than kittens because..."
- corpus: a collection of all documents to consider, like["puppies are cuter than kittens because...", "I like flowers and puppies and the color green and...", ...]
- query: a short string of terms, like "puppies and kittens"


Then relevance refers to the problem of determining how closely related a 
particular document is to a given query. One basic (but very useful) approach, 
called tf-idf, relies on computing two quantities:

- Term frequency: 
tf(term, document) = number of occurrences of term in document
- Inverse document frequency: 
idf(term, corpus) = log(number of documents in corpus / number of documents in corpus that contain term)

Then the relevance of a document to a query is the sum of the 
quantity (tf multiplied by idf for each term in the query).


Implement search(query, K) that returns the top K highest-ranking documents in the corpus for the given query.

// # times word occurs in a given document
// # of documents the word occurs in


*/

public class TfIdfCorpusSearch {

    Map<String,Set<Integer>> wordDocIdMap = new HashMap<>(); // Word : Doc ID set for documents that contain the word
    Map<Integer,Map<String,Integer>> docIdWordFreqMap = new HashMap<>(); // Doc ID to Word:Frequency Map
    Map<Integer,String> corpus = new HashMap<>(); // Doc ID to Document map
    
    TfIdfCorpusSearch(Map<Integer,String> c) {
        corpus = new HashMap<Integer,String>(c);
        for(Entry<Integer,String> e : corpus.entrySet()) {
            String doc = e.getValue();
            int docId = e.getKey();
            for(String w : doc.split("\\s")) {
                wordDocIdMap.computeIfAbsent(w,k->new HashSet<Integer>()).add(docId);
                Map<String,Integer> wordFreqMap = docIdWordFreqMap.computeIfAbsent(docId,k->new HashMap<String,Integer>());
                wordFreqMap.put(w,wordFreqMap.getOrDefault(w,0)+1);
            }
        }
    }
    
    List<Integer> search(String searchPhrase, int k) {
        // TODO: Input validation
        Map<Integer,Double> docScore = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{ 
            double result = docScore.getOrDefault(b,0.0)-docScore.getOrDefault(a,0.0);
            if(result == 0.0) return 0;
            return result > 0 ? 1 : - 1;
        }); // PQ of Doc IDs

        String[] searchTerms = searchPhrase.split("\\s+");
        for(String word : searchTerms) {
            Set<Integer> docsWithWord = wordDocIdMap.get(word);
            if(docsWithWord == null) continue;
            double idf = Math.log((double)corpus.size()/docsWithWord.size());
            for(Integer docId : docsWithWord) {
                int wordFreq = docIdWordFreqMap.get(docId).get(word);
                docScore.put(docId,docScore.getOrDefault(docId,0.0)+wordFreq*idf); // Update score
            }
        }
        for(Integer docId : docScore.keySet()) {
            pq.offer(docId);
        }
        List<Integer> output = new ArrayList<>();
        for(int i=0; i<k && !pq.isEmpty(); i++) {
            output.add(pq.remove()); 
        }
        return output;
    }
    
    public static void main(String args[] ) throws Exception {
        Map<Integer,String> corpus = new HashMap<>();
        corpus.put(1,"hello chris");
        corpus.put(2,"you are cool");
        corpus.put(3,"today is cool");
        TfIdfCorpusSearch app = new TfIdfCorpusSearch(corpus);
        List<Integer> result = app.search("you are cool",3);
        System.out.println(result);
    }

}
