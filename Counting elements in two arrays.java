//Counting elements in two arrays
// Expected Time Complexity: O((m + n) * log n).
// Expected Auxiliary Space: O(1).
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       // add your code here
       Arrays.sort(arr2);
       ArrayList<Integer> result = new ArrayList<>();
       for(int i=0;i<arr1.length;i++){
           result.add(BinarySearch(arr2,arr1[i],0,arr2.length));
       }
       return result;
    }
     static int BinarySearch(int[]arr,int target,int i,int j){
        
        if(i<j){
            int mid=(i+j)/2;
            if(arr[mid]<=target){
                return  BinarySearch(arr,target,mid+1,j);
            }else{
                return  BinarySearch(arr,target,i,mid);
            }
        }
        return i;
    }
}







class Solution
{
     public static int binary_Search(int arr[], int l, int h, int x)
    {
       while (l <= h)
       {
        int mid = (l+h) / 2;
 
        
        if (arr[mid] <= x)
            l = mid + 1;
 
        
        else
            h = mid - 1;    
       }
     
    
      return h;
   } 
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        ArrayList<Integer> res = new ArrayList<Integer> (0);
        Arrays.sort(arr2);
        
        for(int i = 0; i < m; i++)
        {
            int index = binary_Search(arr2, 0, n-1, arr1[i]);
            
            res.add (index + 1);
        }
        return res;
    }
}


//TLE

class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       // add your code here
       Arrays.sort(arr2);
       ArrayList<Integer> result = new ArrayList<>();
       for(int i=0;i<arr1.length;i++){
           result.add(BinarySearch(arr1[i],arr2,result));
       }
       return result;
    }
     static int BinarySearch(int target,int[] arr2,ArrayList<Integer>result){
        
        int low=0;
        int count=0;
        int high=arr2.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr2[mid]<=target){
                count++;
                low+=1;
               // high-=1;
            }
            else if(arr2[mid]>target)
                high-=1;
        }
        return count;
    }
}

