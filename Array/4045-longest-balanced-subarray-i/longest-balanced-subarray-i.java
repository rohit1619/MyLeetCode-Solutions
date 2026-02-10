class Solution {
    public int longestBalanced(int[] nums) {
        int maxLength = 0;
        for(int i=0;i<nums.length;i++){
        Set<Integer> evenSet = new HashSet<>();
        Set<Integer> oddSet = new HashSet<>();
        for(int j=i;j<nums.length;j++){
            if(nums[j] % 2 == 0){
                evenSet.add(nums[j]);
            }
            else{
                oddSet.add(nums[j]);
            }
            if(evenSet.size() == oddSet.size()){
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        }
        return maxLength;
    }
}