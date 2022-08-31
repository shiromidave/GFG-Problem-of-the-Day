/*
Longest Sub-Array with Sum K
Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 */
class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int length=0;
        
        for(int i=0;i<N;i++){
            sum+=A[i];
            if(sum==K){
                length = i+1;
            }
            else if(map.containsKey(sum-K)){
                length = Math.max(length,i-map.get(sum-K));
            }
             if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return length;
    }
    
}
//Brute force
//TLE
/*
class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=i;j<N;j++){
                sum+=A[j];
                if(!map.containsKey(sum)){
                    map.put(sum,j-i+1);
                }
                else{
                    int val = Math.max(j-i+1,map.get(sum));
                    map.put(sum,val);
                }
            }
        }
        return  map.get(K)!=null?map.get(K):0;
    }
    
    
}

*/
