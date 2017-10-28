/*
Allocate Books

N number of books are given. 
The ith book has Pi number of pages. 
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

NOTE: Return -1 if a valid assignment is not possible

Input:
 List of Books M number of students 

Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.
*/

public class Solution {
	public int books(ArrayList<Integer> list, int m) {
	    if(list.size() < m){
	        return -1;}
        if(list.size() == m)
            return (int)getMax(list);
	    long ans = partition(list , list.size() , m);
	    return (int)ans;
	}
	
	public static long getSum(ArrayList<Integer> list){
	    long sum = 0L;
	    for(int i:list)
	        sum += (long)i;
        return sum;
	}
	public static long getMax(ArrayList<Integer> list){
	    long max = 0L;
	    for(int i:list)
	        max = Math.max(max,(long)i);
        return max;
	}
	
	public static long partition(ArrayList<Integer> list , int n , int m){
	    long lo = getMax(list);
	    long hi = getSum(list);
	    long mid;
	    while(lo < hi){
	        mid = lo + (hi-lo)/2;
	        long readers = getReaders(list , mid);
	        if(readers <= m)
	            hi = mid;
            else
                lo = mid + 1;
	    }
	    return lo;
	}
	
	public static int getReaders(ArrayList<Integer> list , long mid){
	    long total = 0L;
	    int ans=1;
	    for(int i:list){
	        total += (long)i;
	        if(total > mid){
	            total = (long)i;
	            ans++;
	        }
	    }
	    return ans;
	}
}
