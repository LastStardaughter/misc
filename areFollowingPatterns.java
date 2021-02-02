boolean areFollowingPatterns(String[] strings, String[] patterns) {
    if(strings.length != patterns.length){return false;}
    HashMap<String, String> map=new HashMap();
    for(int i=0;i<strings.length;i++){
        String curstr=strings[i], curpat=patterns[i];
        if(map.containsKey(curpat)){
            if(!map.get(curpat).equals(curstr)){return false;}
            continue;            
        }
        if(map.containsValue(curstr)){return false;}
        map.put(curpat, curstr);
    }
    return true;
}