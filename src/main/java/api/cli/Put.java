package api.cli;

import api.Request;
import api.Response;
import api.StatusCode;
import index.Index;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static api.StatusCode.*;

public class Put implements Request {
    Index index;
    public static String COMMAND_IDENTIFIER = "put";

    public Put(Index index){
        this.index = index;
    }

    public Response request(String userInput) {

        String[] splits = parseRegexInput(userInput);
        Integer count = 0;

        for (String s: splits) {
            index.put(s);
            count += 1;
        }

        return new Response("indexed " + count + " documents", StatusCode.SUCCESS);

    }

    public static Matcher parseInput(String userInput){
        userInput = userInput.replace(COMMAND_IDENTIFIER, "");
        //Pattern pattern = Pattern.compile("\"[^\"]*\"|[^,]+");

        Pattern pattern = Pattern.compile("\\\"(.*?)\\\"");
        return pattern.matcher(userInput);

    }

    public static String[] parseRegexInput(String userInput) {
        userInput = userInput.replace(COMMAND_IDENTIFIER, "");
        //Pattern pattern = Pattern.compile("\"[^\"]*\"|[^,]+");

        Pattern pattern = Pattern.compile("\\\"(.*?)\\\"");
        String[] s = userInput.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        return s;//pattern.matcher(userInput);
    }

}
