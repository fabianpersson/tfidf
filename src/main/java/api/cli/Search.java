package api.cli;
import api.Request;
import api.StatusCode;
import document.Document;
import index.Index;
import api.Response;

import java.util.ArrayList;
import java.util.TreeMap;

public class Search implements Request {

    Index index;
    public static String COMMAND_IDENTIFIER = "search";

    public Search(Index index){
        this.index = index;

    }

    public Response request(String userInput) {
        userInput = userInput.replace(COMMAND_IDENTIFIER, "");
        TreeMap<Double, ArrayList<Document>> res = index.search(userInput);
        return new Response(res, StatusCode.SUCCESS);
    }
}
