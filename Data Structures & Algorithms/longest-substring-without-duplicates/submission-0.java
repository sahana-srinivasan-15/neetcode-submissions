class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>hs = new HashSet<>();
        int l =0;
        int res =0;
        for(int r=0;r<s.length();r++){
            while(hs.contains(s.charAt(r))){
               hs.remove(s.charAt(l));
               l++;
            }
            hs.add(s.charAt(r));
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
