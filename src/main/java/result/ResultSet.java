package result;

import document.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class ResultSet extends HashMap <Document, Double>{

    public void update(ResultSet otherRs) {
        for(HashMap.Entry<Document, Double> entry : otherRs.entrySet()) {
            Document d = entry.getKey();
            Double score = entry.getValue();
            updateOneDocumentScore(d, score);
        }
    }

    public void updateOneDocumentScore(Document d, Double score) {
        Double oldScore = this.getOrDefault(d, 0.0);
        this.put(d, oldScore + score);

    }

    public  TreeMap<Double, ArrayList<Document>>getSorted() {
        TreeMap<Double, ArrayList<Document>> scores = new TreeMap<>(Collections.reverseOrder());

        for(HashMap.Entry<Document, Double> entry : this.entrySet()) {
            Document d = entry.getKey();
            Double score = entry.getValue();

            ArrayList<Document> docList = scores.getOrDefault(score, new ArrayList<>());
            docList.add(d);
            scores.put(score, docList);

        }

        return scores;
    }

}

