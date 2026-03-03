package stack;

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
 */
public class EvaluationOfPostfixExpression {

    public int evalRPN(String[] tokens) {
        int statckSize = tokens.length;
        int[] numStack=new int[statckSize];
        int top =-1;

        for(String i : tokens){
            System.out.println("TOP: "+top);
            switch(i){
                case "+":
                    System.out.println(numStack[top]);
                    numStack[top-1] = numStack[top]+numStack[top-1];
                    top--;
                    break;
                case "-":
                    numStack[top-1] = numStack[top-1]-numStack[top];
                    top--;
                    break;
                case "*":
                    System.out.println(numStack[top]);
                    numStack[top-1] = numStack[top-1]*numStack[top];
                    top--;
                    break;
                case "/":
                    numStack[top-1] = numStack[top-1]/numStack[top];
                    top--;
                    break;
                default:

                    numStack[++top] = Integer.valueOf(i);
                    System.out.println(numStack[top]);
            }
        }
        System.out.println("*************************");
        for(int num: numStack){

            System.out.println(num);
        }

        return numStack[0];


    }
}
