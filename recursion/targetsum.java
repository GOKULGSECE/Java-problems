package recursion;

import java.util.Arrays;

import static recursion.targetsum.Solution.findTargetSumWays;

class targetsum {
    class Solution {
        private static int result = 0;
        public static void recur(int i,int r,int nums[],int target)
        {
            if(i==nums.length)
            {
                if(target==r){
                    result++;
                }
            }
            else{
                recur(i+1,r+nums[i],nums,target);
                recur(i+1,r-nums[i],nums,target);
            }


        }
        public static int findTargetSumWays(int[] nums, int target) {
            // int i = nums.length;
            // int result = 0;
            recur(0,0,nums,target);
            return result;

        }
    }

        public static void main(String[] args) {
            int nums[] = {1};
            int target = 1;
            System.out.println(findTargetSumWays(nums,target));
        }
}
