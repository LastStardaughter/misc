static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int cur, prev = arr[0], min = Integer.MAX_VALUE;
        for (int i=1; i<arr.length;i++){
            cur=arr[i];
            if(cur-prev<min){min=cur-prev;}
            if(min==0){return 0;}
            prev=cur;
        }
        return min;
    }