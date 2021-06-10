public class emptyStackException extends Exception  {
    private String operator;
    private int position;
    public emptyStackException(Throwable cause, String op,int elementNum) {
        super(cause);
        this.operator = op;
        this.position = generatePosition(elementNum);
    }
    public String getOperator() {
        return this.operator;
    }
    public int getPosition(){
        return this.position;
    }
    private int generatePosition(int elementNum){
        return ((elementNum+1)*2)-1;
    }
}
