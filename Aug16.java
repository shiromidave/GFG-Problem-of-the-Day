/*
Fact Digit Sum
A(X) for positive integer X is the sum of factorials of its digits. For example, A(154) = 1! + 5! + 4!= 145.
Given a number N, find the minimum number X such that A(X) = N. You have to return a list of digits which represent the number X.

Example 1:

Input: N = 40321
Output: 18
Explanation: A(18)=1!+ 8! =40321 
Note that A(80) and A(81) are also 
40321, But 18 is the smallest 
number.
*/
class Solution
{
    int fact[]=new int[10];
    ArrayList<Integer> arr=new ArrayList<>();
    ArrayList<Integer> FactDigit(int N)
    {
        // code here
        fact[0]=1;
        for(int i=1;i<10;i++){
            fact[i]=fact[i-1]*i;
        }
        fun(N);
        Collections.sort(arr);
        return arr;
    }
    public int fun(int n)
    {
        if(n<0)return -1;
        if(n==0)return 1;
        for(int i=9;i>=1;i--){
            int p=fun(n-fact[i]);
            if(p==1){
                arr.add(i);
                return 1;
            }
        }
        return -1;
    }
}
class Solution
{
    ArrayList<Integer> FactDigit(int N)
    { 
        ArrayList<Integer> result = new ArrayList<>();
        int[] fact = new int[10];
        fact[0] = 1;
        for(int i=1;i<=9;i++){
            fact[i] = i*fact[i-1];
        }
        for(int i=9;i>=1;i--){
            while(N>=fact[i]){
                N-=fact[i];
                result.add(i);
            }
        }
        Collections.reverse(result);
        return result;
        // code here
    }
}
