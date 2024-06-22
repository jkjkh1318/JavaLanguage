class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        //한 가지 숫자만 남으면 끝! ...가 아니었네!ㅠ
        ArrayDeque<Integer> stQueue = returnDeque(students);
        ArrayDeque<Integer> sdQueue = returnDeque(sandwiches);

        int answer = 0;

        while(true){
            //            if(stQueue.size() == 0){
            if(stQueue.isEmpty()){
                break;
            }

            //한 가지 숫자만 남았는지 판단하기 (X) ==> 문제 잘못 이해함!
//            if(hasOneNumbers(stQueue) + hasOneNumbers(sdQueue) == 1){
//                answer = sdQueue.size();
//                break;
//            }

            //top 샌드위치와 일치하는 요소가 하나도 없으면 중단
            if(!wantTopSandwich(stQueue, sdQueue.getFirst())){
                answer = sdQueue.size();
                break;
            }

            int student = stQueue.poll();
            int sandwich = sdQueue.poll();

            if(student != sandwich){
                stQueue.offer(student);//맨뒤에넣는다
                sdQueue.push(sandwich);//맨앞에넣는다(원복)
            }

        }

        return answer;
        
    }
    
   public static boolean wantTopSandwich(ArrayDeque<Integer> param, int topSandwich){
        ArrayDeque<Integer> deque = param.clone();

        for (Integer i : deque) {
            if(i == topSandwich) { //하나라도 일치하면 true 반환
                return true;
            }
        }

        return false; //일치하는 요소가 하나도 없으면 false 반환
    }

    public static ArrayDeque<Integer> returnDeque(int[] arr){
        ArrayDeque<Integer> deque = new ArrayDeque();
        for(int i:arr){
            deque.offer(i);
        }
        return deque;
    }
    
}