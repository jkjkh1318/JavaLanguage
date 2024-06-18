class Solution {
    public String restoreString(String s, int[] indices) {
        // 배열 or list?
        // map??
        char[] arr = new char[s.length()];
        // List list = new ArrayList();

        for (int i = 0; i < indices.length; i++) {
            int num = indices[i];//4
            arr[num] = s.charAt(i);
            // list.set(num, s.charAt(i));
        }

        String answer = "";

        for(char c : arr){
            answer += c;
        }

        return answer;

        // return Arrays.toString(arr); //"[l, e, e, t, c, o, d, e]"...

        // return String.join(",",list);

    }
}