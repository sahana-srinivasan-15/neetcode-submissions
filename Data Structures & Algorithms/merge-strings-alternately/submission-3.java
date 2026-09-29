class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        sb.append(word1);
        sb.append(word2);
        String str = sb.toString();
        StringBuilder st = new StringBuilder();
        int i=0;
        for(int j=word1.length();j<sb.length();j++){
           if(i<word1.length()){
            st.append(str.charAt(i));
            i++;
           }
           st.append(str.charAt(j));
        }
        if(i<word1.length()){
            st.append(word1.substring(i));
        }
        return st.toString();
    }
}