public class PostFixIf {
    static String postFix = " ";
    static char nextChr = 0;
    static Stack stack = new Stack();
    static String prec[];
static String converToPostfix(String infix){

    stack.clear();
    for(int i=0; i<infix.length(); i++){
        char nextChr = infix.charAt(i);

        System.err.println(nextChr);

        if(Character.isLetterOrDigit(i)){
            postFix += i;
        }
        else if(nextChr == '('){
            stack.push(nextChr);
        }
        else if (nextChr == ')'){
            while (!stack.isEmpty() && (!stack.peek().equals('('))){
                postFix += stack.pop();
            }
            if(!stack.isEmpty() && (!stack.peek().equals('('))){
                return "Invalid Expression";
            }
            else{
                stack.pop();
            }
        }
        else{
            while (!stack.isEmpty() && pre(nextChr) <= pre((char) stack.peek())) {
                postFix += stack.pop();
            }
            stack.push(nextChr);
            }

        }
        while(!stack.isEmpty()){
            postFix += stack.pop();
        }
        return postFix;
    }


    static int pre(char ch){
        switch (ch) {
            case '-': case '+':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }

}


