import java.util.ArrayList;
import java.util.Stack;

//Note: No Static methods. Otherwise, no credits.

/**
 *A class contains methods that turning an infix expression to a postfix expression, evaluating a postfix expression and etc.
 *@author Genjie Liu
 *@version 1.0
 *Lab section:Fri 10:25-11:20 Tuan Tran
 */
public class Expression {

    /**
     * The content of this expression
     */
    private String infix;


    /**
     * A constructor for an empty string.
     */
    public Expression(){
        this.infix="";
    }

    /**
     * A constructor for the Expression class.
     * @param infix A string that contains numeric expression.
     */
    public Expression(String infix){
        this.infix=infix;

    }

    /**
     * Convert the infix expression into a postfix expression
     * @return A arraylist of String represents the postfix expression.
     */
    public ArrayList<String> infixToPostfix()
    {
        GenericStack<String> stack= new GenericStack<>();//Initialize a String stack.
        ArrayList<String> postFixString= new ArrayList<String>();//Initialize a String arrayList as the postfix.
        String[]splited=infix.split("(?<=[-+*/])|(?=[-+*/])|(?<=[()])|(?=[()])");//Separate infix by "+-*/" and "()".

        /*
        Loop through the whole infix string.
         */
        for(int i=0;i<splited.length;i++) {
            String c=splited[i];//token in every location of infix.

            /*
            If the token is a number, add it to the postfix.
             */
            if (c.matches("[0-9]+")) {
                postFixString.add(c);
            }
            /*
            If it is a (, push to the stack.
             */
            else if (c.equals("(")) {
                stack.push(c);
            }
            /*
            If it is a ).
             */
            else if (c.equals(")")) {

                while (!stack.isEmpty()) { //check the top of stack is a ( before the stack gets empty.
                    if(stack.peek().equals("("))
                    {
                        stack.pop();
                        break;
                    }
                    else {
                        postFixString.add(stack.pop());//If the top is not a (, keep poping elements off the stack.
                    }
                }

            }
            /*
            Pop operator with higher precedence than the token.
             */
            else {
                while (!stack.isEmpty() && !stack.peek().equals("(") && OperatorOrder(c) <= OperatorOrder(stack.peek()))

                {
                    postFixString.add(stack.pop());
                }
                stack.push(c);
            }
        }

        /*
        As it reaches to the end, pop everything off stack.
         */
        while (!stack.isEmpty())
        {
            postFixString.add(stack.pop());
        }

        return postFixString;
    }


    /**
     * Evaluate the postfix expression.
     * @return the result of expression.
     */
    public int evaluate() {
        GenericStack<Integer> stack = new GenericStack<>();
        Expression expression = new Expression(infix);
        ArrayList<String> postfix = expression.infixToPostfix();//Turn infix to postfix.

        /*
        Loop through the postfix.
         */
        for (int i=0;i<postfix.size();i++){
            String c=postfix.get(i);//every token in the postfix expression.

            /*
            Push the token to the stack if it is a number.
             */
            if(c.matches("[0-9]+"))
            {
                stack.push(Integer.parseInt(c));
            }

            /*
            If it is a operator
             */
            else if (isOperator(c)){
                int operand1=stack.pop();//An number off from the stack.
                int operand2=stack.pop();//Another number off from the stack.
                switch (c) {
                    case "+":
                        stack.push(operand2 + operand1);//Add them together if the operator is +.
                        break;

                    case "-":
                        stack.push(operand2 -operand1);//Subtract one from the other if the operator is -.
                        break;

                    case "/":
                        stack.push(operand2 / operand1);//Divide one from the other if the operator is /.
                        break;

                    case "*":
                        stack.push(operand2 * operand1);//Times them together if the operator is *
                        break;
                }
            }
        }
        return stack.pop();//pop everything off the stack and it is the final result.
    }


    //Helper methods

    /**
     * Determine if the precedence of an operator.
     * @param a an operator
     * @return a number represents the precedence level.
     */
    public int OperatorOrder (String a)
    {
        if(a.equals("+") || a.equals("-"))
        {
            return 1;
        }
        else if (a.equals("*") || a.equals("/"))
        {
            return 2;
        }
        return 0;
    }

    /**
     * Determine if a string is an operator.
     * @param c a string needed to be determined
     * @return true if the string is an operator, otherwise false.
     */
    public boolean isOperator(String c)
    {
        if( c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

