class Solution {
    private int getValue(char ch){
        switch(ch){
            case 'I':
            return 1;
            case 'V':
            return 5;
            case 'X':
            return 10;
            case 'L':
            return 50;
            case 'C':
            return 100;
            case 'D':
            return 500;
            case 'M':
            return 1000;
            default :
            return 0;
        }
    }
    public int romanToInt(String s) {
        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++){
            
            if(i + 1 < n && getValue(s.charAt(i)) < getValue(s.charAt(i+1))){
                count -= getValue(s.charAt(i));
            }else{
                count += getValue(s.charAt(i));
            }
        }

        return count;
    }
}