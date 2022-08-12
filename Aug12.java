/*
Given a string S consisting of uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

Example 1:

Input:
N = 12
S = defRTSersUXI
Output: deeIRSfrsTUX
Explanation: Sorted form of given string
with the same case of character as that
in original string is deeIRSfrsTUX
*/
//Approach 1
class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str) 
    {
        char[] mixChArr = str.toCharArray();
        
        int lIdx = 0;
        int uIdx = 0;
        
        //counting number of lowercase and uppercase characters.
        for (char ch: mixChArr) 
        {
            if (Character.isUpperCase(ch))
                uIdx++;
            else
                lIdx++;
        }
        
        int upperSize = uIdx;
        int lowerSize = lIdx;
        
        char[] lowerChArr = new char[lowerSize];
        char[] upperChArr = new char[upperSize];
        
        lIdx = 0;
        uIdx = 0;
        
        //storing uppercase and lowercase characters in two separate lists.
        for (char ch: mixChArr) 
        {
            if (Character.isUpperCase(ch))
                upperChArr[uIdx++] = ch;
            else
                lowerChArr[lIdx++] = ch;
        };

        //sorting both the lists.
        Arrays.sort(upperChArr);
        Arrays.sort(lowerChArr);
        
        lIdx = 0;
        uIdx = 0;
        
        //iterating over the given string.
        for (int mIdx = 0; mIdx < mixChArr.length; mIdx++) 
        {
            //if current character is in uppercase then we pick character from  
		    //the list containing uppercase characters and add it to result.
            if (Character.isUpperCase(mixChArr[mIdx])) 
            {
                mixChArr[mIdx] = upperChArr[uIdx++];
            }
            
            //else we pick the character from the sorted list  
		    //containing lowercase characters and add it to result.
            else
            {
                mixChArr[mIdx] = lowerChArr[lIdx++];
            }
        }
        String rtnStr = new String(mixChArr);
        //returning the result.
        return rtnStr;
    }
    
}
//Approach 2
class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        
        int lower = -1;
        int upper = -1;
        
        if(arr[0]<=97){
            upper = 0;
        }
        for(int i=0;i<arr.length;i++){
            char ch = arr[i];
            if(ch>=97){
                lower = i;
                break;
            }
        }
        if(upper==-1 || lower==-1) return new String(arr);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>=97){
                sb.append(arr[lower]);
                lower++;
            }
            else{
                sb.append(arr[upper]);
                upper++;
            }
        }
        return sb.toString();
        /*
        //Runtime error
        String result = "";
        ArrayList<Character> lowerCase = new ArrayList<>();
        ArrayList<Character> upperCase = new ArrayList<>();
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                lowerCase.add(str.charAt(i));
            }
            else{
                upperCase.add(str.charAt(i));
            }
        }
        Collections.sort(lowerCase);
        Collections.sort(upperCase);
        
        int j=0,k=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                result += lowerCase.get(j++);
            }
            else{
                result += upperCase.get(k++);
            }
        }
        return result;
        */
    }
}
