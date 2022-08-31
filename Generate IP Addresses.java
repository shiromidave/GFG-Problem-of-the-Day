//Generate IP Addresses
// Expected Time Complexity: O(N * N * N * N)
// Expected Auxiliary Space: O(N * N * N * N)
class Solution {
    public ArrayList<String> genIp(String s) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        int n = s.length();
        if(n>12) {
            result.add("-1");
            return result;
        }
        for(int i=1;i<=n-2;i++){
            for(int j=i+1;j<=n-1;j++){
                for(int k=j+1;k<=n;k++){
                    String a = s.substring(0,i);
                    String b = s.substring(i,j);
                    String c = s.substring(j,k);
                    String d = s.substring(k,n);
                    if(valid(a) && valid(b) && valid(c) && valid(d)){
                        result.add(a+"."+b+"."+c+"."+d);
                    }
                }
            }
        }
        return result;
    }
    
    boolean valid(String s){
        int n = s.length();
        if(n==0 || n>3 || Integer.parseInt(s)>255 || (s.charAt(0)=='0' && n>1))
            return false;
        return true;    
    }
}
