/*
Search for a Range

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].
*/

public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int key) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    result.add(-1);
	    result.add(-1);
	    int n=a.size();
	    if(n<1)
	        return result;
        result.set(0,first(a,key));
        result.set(1,last(a,key));
        return result;
	}
	
	public int first(List<Integer> arr, int key)
    {
        int n = arr.size();
        int low=0,high=n-1,mid;
        while(low <= high){
            mid = (low+high)/2;
            if((mid==0 || arr.get(mid-1)<key) && arr.get(mid)==key)
                return mid;
            else if(arr.get(mid) < key)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    public int last(List<Integer> arr, int key)
    {
        int n = arr.size();
        int low=0,high=n-1,mid;
        while(low <= high){
            mid = (low+high)/2;
            if((mid==n-1 || arr.get(mid+1)>key) && arr.get(mid)==key)
                return mid;
            else if(arr.get(mid) <= key)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}
