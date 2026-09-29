class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while(i<nums1.length&&j<nums2.length){
          if(nums1[i]==0){
            nums1[i]=nums2[j++];
          }
          i++;
        }
        Arrays.sort(nums1);
    }
}