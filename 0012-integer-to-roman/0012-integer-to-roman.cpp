class Solution {
public:
    string intToRoman(int num) { 
        // Evaluate the possible values with respect to their roman values..
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        string roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};

        string str = "";
        // Run the loop through the values..
        for(int i = 0; i < 13; i++){
            while(num >= values[i]){ // if the current num is >= value
                num -= values[i];    // 58 => 50 -> "L", 8-> "VIII"
                str += roman[i];     // Add that respective roman into the string
            }
        }
        return str;
    }
};