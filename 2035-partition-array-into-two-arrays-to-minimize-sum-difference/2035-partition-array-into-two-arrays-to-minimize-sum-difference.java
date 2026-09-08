import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int N = nums.length;

        int s = 0;
        for (int i = 0; i < N; i++) {
            s += nums[i];
        }

        int n = N / 2;
        int n1 = n;
        int n2 = n;

        List<List<Integer>> listA = new ArrayList<>();
        for (int i = 0; i < n1 + 1; i++) {
            listA.add(new ArrayList<>());
        }

        for (int mask = 0; mask < (1 << n1); mask++) {
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n1; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                    cnt++;
                }
            }
            listA.get(cnt).add(sum);
        }

        List<List<Integer>> listB = new ArrayList<>();
        for (int i = 0; i < n2 + 1; i++) {
            listB.add(new ArrayList<>());
        }

        for (int mask = 0; mask < (1 << n2); mask++) {
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n2; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[n1 + i];
                    cnt++;
                }
            }
            listB.get(cnt).add(sum);
        }

        for (int i = 0; i < n2 + 1; i++) {
            Collections.sort(listB.get(i));
        }

        int ans = Integer.MAX_VALUE;

        // Optimized matching phase using Collections.binarySearch
        for (int i = 0; i < n1 + 1; i++) {
            int rightsize = n - i;
            List<Integer> bList = listB.get(rightsize);

            for (int j = 0; j < listA.get(i).size(); j++) {
                int leftsum = listA.get(i).get(j);
                

                int target = (s-2*leftsum)/2;

                int pos = Collections.binarySearch(bList, target);
                if (pos < 0) {
                    pos = -pos - 1; // Index of first element >= target
                }

                // Check closest element >= target
                if (pos < bList.size()) {
                    int rightsum = bList.get(pos);
                    ans = Math.min(ans, Math.abs(2 * (leftsum + rightsum) - s));
                }

                // Check closest element < target
                if (pos > 0) {
                    int rightsum = bList.get(pos - 1);
                    ans = Math.min(ans, Math.abs(2 * (leftsum + rightsum) - s));
                }
            }
        }

        return ans;
    }
}