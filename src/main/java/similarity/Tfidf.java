package similarity;

import document.Document;
import index.Index;
import result.ResultSet;

import java.lang.Math;
import java.util.Collections;

public class Tfidf {
    private Index index;
    private double idf;

    public Tfidf(Index index){
        this.index = index;
    }

    private double calculateSingleDocScore(String token, Document d) {
        return this.idf * ((double)d.docTermFrequency.get(token)/(double)d.getDocLength());
    }

    public ResultSet getTokenScore (String token){
        ResultSet rs = new ResultSet();
        this.idf = index.containsKey(token) ? 1 + Math.log((double)index.docCount/(1 + index.get(token).size())): 1 + Math.log(index.docCount); //maybe this abstraction into one class
        for (Object d: index.containsKey(token) ? index.get(token): Collections.emptyList()) {
            Document document = (Document) d;
            Double score = calculateSingleDocScore(token, document);
            rs.updateOneDocumentScore(document, score);
        }
        return rs;

    }

}

