class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.length();
        int MOD = 1000000007;
        vector<long long int> dp(3);
        dp[n%3] = 1;
        
        // intitialse answer for last element
        if(s[n-1] == '0')
            dp[(n-1)%3] = 0;
        else if( s[n-1] == '*')
            dp[(n-1)%3] = 9;
        else 
            dp[(n-1)%3] = 1;
        
        
        // fill dp
        for (int i = n-2; i>=0 ; i--){
           
            dp[i%3] = 0;
            dp[(i+1)%3] = dp[(i+1)%3] % MOD;
            dp[(i+2)%3] = dp[(i+2)%3] % MOD;
            
            
            // considering  only 1 character 
            if(s[i] != '0'){
                if(s[i] == '*')
                    dp[i%3] += 9*dp[(i+1)%3];
                else
                    dp[i%3] += dp[(i+1)%3];
            }
            
            
            
            // considering 2 characters
            if (s[i] == '1'){
                if (s[i+1] == '*')
                    dp[i%3] += 9*dp[(i+2)%3];
                else
                    dp[i%3] += dp[(i+2)%3];
                dp[i%3] = dp[i%3] % MOD;
            }
            
            else if(s[i] == '2'){
                if (s[i+1] == '*')
                    dp[i%3] += 6 * dp[(i+2)%3];
                else if (s[i+1] <= '6')
                    dp[i%3] += dp[(i+2)%3];
                else
                    dp[i%3] += 0;
                dp[i%3] = dp[i%3] % MOD;
            }
            
            else if (s[i] == '*'){
                if (s[i+1] == '*')
                    dp[i%3] += 15*dp[(i+2)%3];
                else if(s[i+1] <= '6')
                    dp[i%3] += 2*dp[(i+2)%3];
                else
                    dp[i%3]+= dp[(i+2)%3];
                dp[i%3] = dp[i%3] % MOD;
            }
            dp[i%3] = dp[i%3] % MOD;
                
        }
        return dp[0%3] % MOD;

        
    }
};