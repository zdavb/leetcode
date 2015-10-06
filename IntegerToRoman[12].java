//my idea
public class Solution {
    char[] chars = {'I','V','X','L','C','D','M'};
    private int findIndex(int base){
        int index = 0;
        switch(base){
            case 1000:
                index = 6;
                break;
            case 100:
                index = 4;
                break;
            case 10:
                index = 2;
                break;
            case 1:
                index = 0;
                break;
        }
        return index;
    }
    public String intToRoman(int num) {
        StringBuffer buffer =  new StringBuffer();

        int base = 1000;
        while(base >= 1){
            int val = num/base;
            int index = findIndex(base);
            num = num%base;
            base /= 10;
            
            if(val == 0)
                continue;
            
            if(val%5 == 4){//val == 4 or val == 9
                if(val == 4){
                    buffer.append(chars[index]);
                    buffer.append(chars[index+1]);
                }else{
                    buffer.append(chars[index]);
                    buffer.append(chars[index+2]);
                }
            }else{
                if(val>=5){
                    buffer.append(chars[index+1]);
                    val -= 5;
                }
                int tmpVal = 0;
                while(tmpVal<val){
                    buffer.append(chars[index]);
                    tmpVal++;
                }
            }
        }
        return buffer.toString();
    }
}
//better idea
public class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i<values.length;i++){
            while(num>=values[i]){
                num -= values[i];
                buffer.append(strs[i]);
            }
        }
        return buffer.toString();
    }
}