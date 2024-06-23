class RecentCounter {

    ArrayDeque<Integer> pingTime = new ArrayDeque();

    //생성자
    public RecentCounter() {

    }


    public int ping(int t) {
        pingTime.offer(t);

        for(int i:pingTime){
            if(i < t - 3000){
                pingTime.poll();
            }
        }

        return pingTime.size();

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */