class Solution {
public:
    int calPoints(vector<string>& operations) {
        stack<int>st;

        for(string op : operations){
            if(op == "D"){
                st.push(st.top()*2);
            }else if(op == "C"){
                st.pop();
            }else if(op == "+"){
                int a = st.top();
                st.pop();
                int b = st.top();

                st.push(a);
                st.push(a + b);
            }else{
                st.push(stoi(op));
            }
        }

        int score = 0;
        while(!st.empty()){
            score += st.top();
            st.pop();
        }

        return score;
    }
};