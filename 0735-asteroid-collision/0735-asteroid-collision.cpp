class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int>st;
        int n = asteroids.size();
        for(int i = 0; i < n; i++){
            if(st.empty()) st.push(asteroids[i]);
            else if(st.top() > 0 && asteroids[i] < 0){ // top is +ve, but element is -ve
                if(st.top() < abs(asteroids[i])){ // top is smaller than abs(i)
                    st.pop(); // remove the top element
                    i--;
                    continue;
                } else if(st.top() == abs(asteroids[i])){ // equal popout
                    st.pop();
                }
            }else{
                st.push(asteroids[i]); // common condition to add into stack
            }
        }
        n = st.size();
        vector<int>ans(n);
        for(int i = n-1; i >= 0; i--){ // we have to return in orderwise
            ans[i] = st.top(); // add the top element of stack into vector
            st.pop(); // after adding, pop out from the stack
        }
        return ans;
    }
};