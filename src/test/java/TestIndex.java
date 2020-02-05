import api.cli.Put;
import document.Document;
import org.junit.Test;

import index.Index;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestIndex {

    @Test
    public void testPut() {
        String s1 = "this is a test string, and this is one doc only";
        Index index = new Index();
        index.put(s1);
        assertEquals(1, index.docCount);

    }

    @Test
    public void testSearch() {
        String s1 = "this is a test string, and this is one doc only";
        String s2 = "no match here, and this is one doc only";
        Index index = new Index();
        index.put(s1);
        index.put(s2);
        //System.out.println(index.search("string"));
        assertEquals(1, index.search("string").size());
    }

    @Test
    public void testOrder() {

        Index index = new Index();
        String doc1 ="The brown fox jumped over the brown dog.";
        String doc2 = "The lazy brown dog, sat in the other corner";
        String doc3 = "The Red Fox bit the lazy dog!";

        index.put(doc1);
        index.put(doc2);
        index.put(doc3);
        String query = "Dog";
        TreeMap<Double, ArrayList<Document>> result = index.search(query);

        Integer[] order = {3, 1, 2};

        System.out.println(result);

        Integer idx = 0;
        for (ArrayList<Document> docs : result.values()){
            for (Document d : docs){
                assertEquals(order[idx], d.id);
                idx += 1;
            }

        }


    }


}