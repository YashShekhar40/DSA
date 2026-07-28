class Solution {
    public String smallestPalindrome(String s) 
    {
        if (s.length() == 1)
            return s;

        StringBuilder ret = new StringBuilder();
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); ++i)
        {
            int index = (int)((char)s.charAt(i) - 'a');
            freq[index]++;
        }


        for (int i = 0; i < 26; ++i)
        {
            if (freq[i]/2 == 0)
                continue;

            char c = (char)((int)'a' + i);

            for (int j = 0; j < freq[i] / 2; ++j)
            {
                ret.append(c);
            }
            
        }

        String half = ret.toString();

        // System.out.println( mid + "   ");

            for (int i = 0; i < 26; ++i)
            {
                if (i < 26 && freq[i] % 2 == 1)
                {
                    char c = (char)((int)'a' + i);
                    ret.append(c);
                    break;
                }
            }

        ret.append(new StringBuilder(half).reverse());

        return ret.toString();
    }
}