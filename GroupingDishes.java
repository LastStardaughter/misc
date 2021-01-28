String[][] groupingDishes(String[][] menu) {
    HashMap<String, ArrayList<String>> map = new HashMap();
    
    for(int i=0; i<menu.length;i++){
        String dish=menu[i][0];
        for (int j=1; j<menu[i].length;j++){
            String ingredient=menu[i][j];
            if(map.containsKey(ingredient)){
                map.get(ingredient).add(dish);
            } else {
                ArrayList<String> temp = new ArrayList();
                temp.add(dish);
                map.put(ingredient, temp);
            }
        }
    }
    
    Object[] ingredientList = map.keySet().toArray();
    
    for(int i=0; i<ingredientList.length;i++){
        if(map.get(ingredientList[i]).size()<2){
            map.remove(ingredientList[i]);
        }
    }
    
    ingredientList = map.keySet().toArray();    
    String[][] result=new String[ingredientList.length][];
    Arrays.sort(ingredientList);
    for(int i=0; i<ingredientList.length;i++){
        ArrayList<String> dishes=map.get(ingredientList[i]);
        dishes.sort(null);
        result[i] = new String[dishes.size()+1];
        result[i][0] = ingredientList[i].toString();
        for (int j=0;j<dishes.size();j++){
            result[i][j+1]=dishes.get(j);
        }
    }
    
    return result;
}
