class Solution {
    public String decodeMessage(String key, String message) {
        String keyString = key.replaceAll(" ", "");
        String[] arr = keyString.split("");

        String finalKey = "";

        for(int i=0; i<arr.length; i++){
            String s = arr[i];
            if(keyString.indexOf(s) == i) finalKey+=s;
        }

        String engKey = Arrays.stream(finalKey.split("")).sorted().collect(Collectors.joining());

        String answer = "";

        for(int i=0; i<message.length(); i++){
            for(int j=0; j<finalKey.length(); j++){
                if(message.substring(i, i+1).equals(" ")) {
                    answer += " ";
                    break;
                }else if(message.substring(i, i+1).equals(finalKey.substring(j, j+1))){
                    answer += engKey.substring(j, j+1);
                    
                }
            }
        }

        return answer;
    }
}