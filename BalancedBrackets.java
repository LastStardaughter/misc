    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            switch(c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (!stackCheck(stack, '{')){return "NO";}
                    break;
                case ']':
                    if (!stackCheck(stack, '[')){return "NO";}
                    break;
                case ')':
                    if (!stackCheck(stack, '(')){return "NO";}
                    break;
                default:
                    return "NO";
            }
        }
        if (stack.empty()){return "YES";}
        return "NO";
    }
    
    static boolean stackCheck(Stack<Character> s, Character c){
        if(s.empty()){return false;}
        if(s.peek().equals(c)){
            s.pop();
            return true;
        } else {return false;}
    }