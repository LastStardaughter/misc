boolean containsCloseNums(int[] nums, int k) {
    HashMap<Integer, Integer> map=new HashMap();
    
    for(int i=0; i<nums.length-1;i++){
        if(map.containsKey(nums[i])){
            map.put(nums[i],map.get(nums[i])+1);
        } else {map.put(nums[i],1);}
        if(i>=k){
            map.put(nums[i-k],map.get(nums[i-k])-1);
        }
        if (map.containsKey(nums[i+1]) && map.get(nums[i+1])>0){
            return true;
        }
    }
    return false;
}