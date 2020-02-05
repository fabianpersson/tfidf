package index;
import document.Document;
import result.Result;
import similarity.Tfidf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import result.ResultSet;

public class Index extends HashMap<String, ArrayList<Document>>{

    public int currentId;
    public int docCount;
    private Tfidf tfidf; //maybe change this to a similarity module

    public Index() {
        tfidf = new Tfidf(this);
    }

    public void put(String text) {
        Document d = new Document(text);

        currentId += 1;
        docCount += 1;
        d.id = currentId;

        for (String token : d.docTermFrequency.keySet()){
            ArrayList<Document> documentList = this.getOrDefault(token, new ArrayList<>());
            documentList.add(d);
            this.put(token, documentList);

        }
    }

    public  TreeMap<Double, ArrayList<Document>> search(String queryText){
        Document queryDoc = new Document(queryText);
        ResultSet rs = new ResultSet();

        for (String token : queryDoc.getTokens() ){
            ResultSet tokenScores = tfidf.getTokenScore(token);
            rs.update(tokenScores);
        }

        return rs.getSorted();
    }
}
