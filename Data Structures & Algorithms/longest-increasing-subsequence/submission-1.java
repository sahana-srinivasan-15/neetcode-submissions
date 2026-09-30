class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> ll = new ArrayList<>();

        for (int num : nums) {

            int left = 0;
            int right = ll.size();

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (ll.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == ll.size()) {
                ll.add(num);
            } else {
                ll.set(left, num);
            }
        }

        return ll.size();
    }
}