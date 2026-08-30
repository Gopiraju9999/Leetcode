class Solution {
    public String decodeString(String s) {
        Stack<Integer>num_st = new Stack<>();
        Stack<String>str_st = new Stack<>();

        int num = 0;
        String current = "";

        for(char ch : s.toCharArray()){

            // Here we got digits..
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            // push elements till we got the closed bracket..
            else if(ch == '['){
                num_st.push(num);
                str_st.push(current);
                num = 0;
                current = "";
            }
            // The moment we got closed, start poping from "str_st" & pop number 
            // Because, we need to repeat "repeat" times and append into string as well..
            else if(ch == ']'){
                int repeat = num_st.pop();  // popped number
                String prev = str_st.pop();    // pop character 
                StringBuilder temp = new StringBuilder(prev); // store into temp str 

                // Start appending till repeat times
                for(int i = 0; i < repeat; i++){
                    temp.append(current);
                }
                current = temp.toString();  // Making into string format..
            }
            // Especially, this step for appending for alphabets..
            else{
                current += ch;  // last step for appending for characters..
            }
        }
        return current;
    }
}