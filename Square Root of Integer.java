/*
Square Root of Integer
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
*/

public class Solution {
	public int sqrt(int key) {
	    if(key < 1)
	        return 0;
        long cur = 1;
        long lkey = (long)key;
        while(lkey > cur*cur){
            cur = cur * 2;
        }
        if(lkey == cur*cur)
            return (int)cur;
        return binarySearch(lkey , cur/2L , cur);
	}
	public int binarySearch(long key, long l, long h){
	    long low = l, high = h , mid;
	    while(low <= high){
	        mid = (low+high)/2L;
	        if(mid*mid == key || (mid*mid<key && (mid+1)*(mid+1)>key))
	            return (int)mid;
            if(mid*mid < key)
                low = mid+1;
            else
                high = mid-1;
	    }
	    return (int)low;
	}
}
