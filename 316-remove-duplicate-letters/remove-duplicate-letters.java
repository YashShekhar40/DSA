class Solution {
    public String removeDuplicateLetters(String s) 
    {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); ++i)
        {
            freq[(int)((char)s.charAt(i) - 'a')]++;
        }

        boolean[] included = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            --freq[(int)(c - 'a')];
            
            if (included[(int)(c - 'a')])
                continue;

            while (!stack.isEmpty())
            {
                char temp = stack.peek();
                if (c <= temp && freq[(int)(temp - 'a')] > 0)
                {
                    stack.pop();
                    
                    included[(int)(temp - 'a')] = false;
                }

                else
                {
                    break;
                }
                
            }

            if (!included[(int)(c - 'a')]){
                stack.add(c);
                included[(int)(c - 'a')] = true;
            }
        }

        StringBuilder ret = new StringBuilder();

        while (!stack.isEmpty())
        {
            ret.append(stack.pop());
        }

        ret.reverse();

        return ret.toString();
    }
}