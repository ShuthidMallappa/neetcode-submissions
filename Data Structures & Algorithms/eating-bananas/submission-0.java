class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int num : piles){
            high = Math.max(high,num);
        }

        int answer = high;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canEatAll(piles, h, mid)){
                answer = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return answer;
    }

    public boolean canEatAll(int[] piles, int h, int speed){
        int hours = 0;

        for (int pile : piles){
            hours += (pile + speed - 1)/ speed;
        }

        return hours <= h;
    }
}
