
public class PostFix {
    /**
     * Take in a regular infix algebraic expression and convert to Postfix form.
     * @param infix
     * @return  String value representing Postfix form.
     */

    public String convertToPostfix (String infix){
        String postFix = " ";
        char nextChr = 0;
        //char topOp = 0;
        Stack stack = new Stack();

        for(int i = 0;i < infix.length(); i++){
                nextChr = infix.charAt(i);          //char at "i" in string
                switch (nextChr) {

                    //Check presidents and pop out of stack depending on
                    /*case '+': case '-':
                        if ((stack.peek() == null)  ||
                                stack.peek().equals('(')) {
                            //System.out.println(stack.peek());
                            stack.push(nextChr);
                        }
                        else if ((stack.peek().equals('*')) ||
                                ( stack.peek().equals('/'))) {
                            while (!stack.isEmpty() &&
                                    !stack.peek().equals("(")) {
                                postFix += stack.pop();
                            }
                            stack.push(nextChr);
                        } else if (stack.peek().equals("(")) {
                            System.err.println(stack.peek());
                        }
                        break;
                    case '*': case '/':
                        if ((stack.peek() == null) || (stack.peek().equals
                        ("+")) || stack.peek().equals("-")) {
                            while(!stack.isEmpty() &&
                                    !stack.peek().equals("(")) {
                                postFix += stack.pop();
                            }
                        }
                        stack.push(nextChr);
                        break;
                    case '^':
                        //postFix += stack.pop();
                        if ((stack.peek() != null) &&
                                (stack.peek().equals('^'))){
                            while(!stack.isEmpty() &&
                                    !stack.peek().equals("(")) {
                                postFix += stack.pop();
                            }
                        }
                        stack.push(nextChr);
                        break;*/
                    case '^':
                        postFix += nextChr;
                        break;
                    case '+': case '-':case '*': case '/':
                    while (!stack.isEmpty() && pre(nextChr) <=
                                pre((char) stack.peek())) {
                            postFix += stack.pop();
                        }
                    case '(':
                          // Pushed above so already in the stack
                         stack.push(nextChr);
                         break;
                    case ')':
                        while(!stack.isEmpty() && !stack.peek().equals('(')) {
                            postFix += stack.pop();
                        }
                        if((stack.peek() != null) &&
                                (stack.peek().equals('('))) {
                            stack.pop();
                        }
                        //postFix += stack.pop();
                        break;
                    // Immediately print the char if letter or number.
                    default:
                        if (Character.isLetter(nextChr)) {
                            //System.out.println(nextChr);
                            postFix += nextChr;
                        }
                        break;
                } //End switch Statement
        } // End for loop

        while(!stack.isEmpty()){
            postFix += stack.pop();
        }
        return postFix;
    } // End Main

    //***********************************************************************

    /**
     * Gives finite value to use for precedence.
     * @param ch
     * @return  int
     */
    public int pre(char ch){
        switch (ch) {
            case '-': case '+':
                return 1;
            case '*': case '/':
                return 2;
            /*case '^':
                return 3;*/
        }
        return 0;
    }
} // End class
