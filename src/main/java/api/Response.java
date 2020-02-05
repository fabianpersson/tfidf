package api;

public class Response {
    public Object msg;
    public StatusCode status;


    public Response(Object msg, StatusCode status){
        this.msg = msg;
        this.status = status;
    }
}
