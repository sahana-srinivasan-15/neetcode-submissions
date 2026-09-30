class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0)return " ";
        StringBuilder st = new StringBuilder();
        st.append('^');
        for(char c:s.toCharArray()){
            st.append("#").append(c);
        }
        st.append("#$");
        char[] arr = st.toString().toCharArray();
        int n = st.length();
        int[] p = new int[n];
        int c = 0,r=0;
        for(int i=1;i<n-1;i++){
             int mirror = 2*c-i;
            if(i<r){
                p[i]=Math.min(p[mirror],r-i);
            }
            while(arr[i+p[i]+1]==arr[i-1-p[i]]){
                p[i]++;
            }
            if(i+p[i]>r){
                c=i;
                r=i+p[i];
            }
        }
        int maxlen = 0, center=0;
        for(int i = 1;i<n-1;i++){
            if(p[i]>maxlen){
                maxlen = p[i];
                center = i;
            }
        }
        int start = (center - maxlen)/2;
        return s.substring(start,start+maxlen);

    }
}
