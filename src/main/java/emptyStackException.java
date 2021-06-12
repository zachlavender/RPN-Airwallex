public class emptyStackException extends Exception  {
    private String operator;
    private int position;
    public emptyStackException(Throwable cause, String op,int position) {
        super(cause);
        this.operator = op;
        this.position = position;
    }
    public String getOperator() {
        return this.operator;
    }
    public int getPosition(){
        return this.position;
    }
}
