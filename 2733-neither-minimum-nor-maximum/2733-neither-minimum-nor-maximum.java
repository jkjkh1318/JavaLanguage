class Solution {
    public int findNonMinOrMax(int[] nums) {
        //길이가 1,2인 경우에는 바로 반환
        if(nums.length <= 2){
            return -1;
        }

        Arrays.sort(nums);

        return nums[1];
    }
}