//coded together by Scott and jmsaylor
    static void checkMagazine(String[] magazine, String[] note) {
        boolean result = true;
        Map<String, Integer> magazineMap = new HashMap();
        Map<String, Integer> noteMap = new HashMap();
        for (String word : magazine) {
            if (magazineMap.putIfAbsent(word, 1) != null){
                int temp = magazineMap.get(word);
                temp++;
                magazineMap.put(word, temp);
            }
        }
        for (String word : note) {
            if (noteMap.putIfAbsent(word, 1) != null){
                int temp = noteMap.get(word);
                temp++;
                noteMap.put(word, temp);
            }
        }
        for (String word : noteMap.keySet()) {
            // System.out.println(magazineMap.get(word) + " : " + noteMap.get(word));
            if (magazineMap.get(word) == null || noteMap.get(word) > magazineMap.get(word)){
                result = false;
            }
        }
        System.out.println( result ? "Yes" : "No");
//        System.out.println(magazineMap);
//        System.out.println(noteMap);
    }