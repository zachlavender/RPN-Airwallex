public class emptyStackException extends Exception  {
    private String operator;
    public emptyStackException(Throwable cause, String op) {
        super(cause);
        this.operator = op;
    }
    public String getOperator() {
        return this.operator;
    }

}
