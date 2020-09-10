     //return highest sum keyboards[n]+drive[m]<=b or -1 if non-extant
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
         int maxValue = -1;
         for(int i=0;i<keyboards.length;i++){
             for (int j=0;j<drives.length;j++){
                 if (keyboards[i]+drives[j]>b){continue;}
                 if (keyboards[i]+drives[j]>maxValue){
                     maxValue=keyboards[i]+drives[j];
                     if (maxValue==b){return b;}
                     }
                
             }
         }
         return maxValue;

    }