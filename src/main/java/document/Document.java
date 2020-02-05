package document;

import java.util.Set;
import java.util.StringTokenizer;
import java.util.HashMap;


public class Document {

    public Integer id;
    public String docText;
    private Integer docLength;
    public HashMap<String, Integer> docTermFrequency;

    public Document(String text){
        docText = text;
        setTermFrequenciesAndLength();
    }

    public String toString(){
        return docText;
    }

    public Set<String> getTokens(){
        return this.docTermFrequency.keySet();
    }

    private String clean(String s){
        return s.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();
    }

    public Integer getDocLength(){
        return docLength;
    }

    public void setId(Integer id){
        this.id = id;
    }

    private void  setTermFrequenciesAndLength() {
        StringTokenizer st = new StringTokenizer(clean(docText));

        Integer length = 0;
        HashMap<String, Integer> tf = new HashMap<>();

        while (st.hasMoreElements()) {
            length += 1;
            String token = (String) st.nextElement();
            if (tf.containsKey(token)) {
                Integer newCount = tf.get(token) + 1;
                tf.put(token, newCount);
            } else {
                tf.put(token, 1);
            }
        }

        docLength = length;
        docTermFrequency = tf;
    }
}
