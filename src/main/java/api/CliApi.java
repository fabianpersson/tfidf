package api;

import java.io.BufferedReader;
import java.io.IOException;

import api.Response;
import api.StatusCode;
import api.cli.Put;
import api.cli.Search;
import index.Index;

public class CliApi {

    Index index;

    public CliApi(Index index){
        this.index = index;
    }

    String helpMessage = "please specify \"search <query>\" or \"put \'<document>\', \'<document>\'\"";

    public void start(BufferedReader reader) throws IOException {
        System.out.println(helpMessage + " to get started");

        while (true) {
            String userInput = reader.readLine();
            Response res;

            if (userInput.startsWith(Search.COMMAND_IDENTIFIER)) {
                Search search = new Search(index);
                res = search.request(userInput);
            } else if (userInput.startsWith(Put.COMMAND_IDENTIFIER)) {
                Put put = new Put(index);
                res = put.request(userInput);
            } else {
                res = new Response(helpMessage, StatusCode.FAILURE);
            }
            System.out.println(res.status);
            System.out.println(res.msg);
        }

    }
}
