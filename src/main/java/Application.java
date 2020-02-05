import index.Index;
import api.CliApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Application {
    public static void main(String[] args) throws IOException {
        Index index = new Index();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CliApi cli = new CliApi(index);
        cli.start(reader);
    }
}
