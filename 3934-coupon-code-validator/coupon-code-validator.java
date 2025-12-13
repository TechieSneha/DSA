class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        if(code.length != businessLine.length && businessLine.length != isActive.length){
            return new ArrayList<>();
        }
       Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        // Store valid coupons grouped by business line
        Map<String, List<String>> map = new HashMap<>();
        for (String b : order.keySet()) {
            map.put(b, new ArrayList<>());
        }

        // Regex for valid code (alphanumeric + underscore)
        String regex = "^[a-zA-Z0-9_]+$";

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] &&
                code[i] != null &&
                !code[i].isEmpty() &&
                code[i].matches(regex)) {

                 map.putIfAbsent(businessLine[i], new ArrayList<>());
                map.get(businessLine[i]).add(code[i]);
            }
        }

        // Result list
        List<String> result = new ArrayList<>();

        // Sort by business line order, then lexicographically by code
        List<String> businessOrder = Arrays.asList(
                "electronics", "grocery", "pharmacy", "restaurant"
        );

        for (String b : businessOrder) {
            List<String> list = map.get(b);
            Collections.sort(list);
            result.addAll(list);
        }

        return result;
    }
}