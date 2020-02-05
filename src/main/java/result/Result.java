package result;

import document.Document;

public class Result {

    public Result(Double score, Document document) {
        this.score = score;
        this.document = document;
    }

    Double score;
    Document document;
}
