//将两个整数相除
//算法：通过模拟人类对除法的操作进行。
//注意事项：当输入参数特别大时，要特别注意溢出的情况，因此要注意将数据强制转换为long
//另外注意事项是：-val，在计算机内操作是：~val+1.所以对于Integer.MIN_VALUE而言，
//-Integer.MIN_VALUe == Integer.MIN_VALUE;
public class Solution {
    private int getBit(long dend,int index){
        if((dend & (1<<index))==0)
            return 0;
        return 1;
    }
    public int divide(int dividend, int divisor) {
        long dend = (long)dividend;
        long dsor = (long)divisor;
        
        boolean negative = false;
        if(dend<0){
            negative = !negative;
            dend = -dend;
        }
        if(dsor<0){
            negative = !negative;
            dsor = -dsor;
        }
        long prev = 0;
        long val = 0;
        int index = 31;
        long res = 0;
        
        while(index>=0){
            val = (prev<<1)+getBit(dend,index);
            if(val>=dsor){
                res = (res<<1)+1;
                val -= dsor;
            }else{
                res = res<<1;
            }
            prev = val;
            index--;
        }
        if(res>Integer.MAX_VALUE)
            return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        return negative?(int)-res:(int)res;
    }
}