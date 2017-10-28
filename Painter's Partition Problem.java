/*
Painter's Partition Problem

You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003
Example

Input : 
  K : 2
  T : 5
  L : [1, 10]
Output : 50

*/

public class Solution {
	public int paint(int k, int t, ArrayList<Integer> list) {
        long ans = partition(list, list.size(), k);
        ans = ans*(long)t;
        ans = ans % 10000003;
        return (int)ans;
	}
	
	public static long getSum(ArrayList<Integer> list){
	    long sum=0;
	    for(int i:list){
	        sum += (long)i;}
        return sum;
	}
	
	public static long getMax(ArrayList<Integer> list){
	    long max=0;
	    for(int i:list)
	        max = Math.max((long)i,max);
        return max;
	}
	
	public static long partition(ArrayList<Integer> list, int n, int k){
        //Returns maximum length of board one painter paints
        long lo = getMax(list);
        long hi = getSum(list);
        long mid;
        while(lo < hi){
            mid = lo + (hi-lo)/2;
            int requiredPainters = getRequiredPainters(list, n, mid);
            if(requiredPainters <= k)
                hi = mid;
            else         
                lo = mid + 1;
        }
        return lo;
    }
    
    public static int getRequiredPainters(ArrayList<Integer> list, int n, long maxLengthPerPainter){
        long total = 0;
        int numPainters = 1;
        for(int i =0 ; i < n ; i++){
            total += (long)list.get(i);            
            if(total > maxLengthPerPainter){
                total = (long)list.get(i);
                numPainters++;
            }
            
        }
        return numPainters;
    }
}
