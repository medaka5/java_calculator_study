public class Calculator {
    private String display = "0";

    private double saved_num;
    private boolean operatorPushedNow = false;


    private enum OperationState  {
        NONE,
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLEX,
    }
    private OperationState operationState = OperationState.NONE;

    private void execCalc() {
        double result ;
        switch (operationState) {
            case PLUS:
                result = saved_num + Double.parseDouble(display);
                break;
            case MINUS:
                result = saved_num - Double.parseDouble(display);
                break;
            case MULTIPLEX:
                result = saved_num * Double.parseDouble(display);
                break;
            case DIVIDE:
                result = saved_num / Double.parseDouble(display);
                break;
            case NONE:
            default:
                result = Double.parseDouble(display);
                break;
        }
        double result_int = Math.floor(result);

        if( result_int == result) {
            display = Integer.toString((int)result_int);
        } else {
            display = Double.toString(result);
        }
    }

    public String GetDisplayText() {

        return display;
    }

    // key of 0 to 9
    public void keyNumber(int num) {
        if(num < 0 || num > 9) {
            throw new IllegalArgumentException();
        }

        if(display.equals("0") || operatorPushedNow) {
            display = Integer.toString(num);
        } else {
            display = display + Integer.toString(num);
        }
        operatorPushedNow = false;
    }

    // key of +
    public void keyPlus() {
        operatorPushedNow = true;
        execCalc();
        operationState = OperationState.PLUS;
        saved_num = Double.parseDouble(display);
    }

    // key of -
    public void keyMinus() {
        operatorPushedNow = true;
        execCalc();
        operationState = OperationState.MINUS;
        saved_num = Double.parseDouble(display);
    }
    // key of x
    public void keyMultiply() {
        operatorPushedNow = true;
        execCalc();
        operationState = OperationState.MULTIPLEX;
        saved_num = Double.parseDouble(display);
    }
    // key of /
    public void keyDivide() {
        operatorPushedNow = true;
        execCalc();
        operationState = OperationState.DIVIDE;
        saved_num = Double.parseDouble(display);
    }
    // key of =
    public void keyEqual() {
        double result = 0;

        operatorPushedNow = true;
        execCalc();
    }
}
