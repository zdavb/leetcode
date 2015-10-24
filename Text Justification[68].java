public class Solution {
    private void appendBuilderNSpace(StringBuilder builder,int n){
        for(int i = 0;i<n;i++){
            builder.append(' ');
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        List<List<String>> wordsInGroup = new LinkedList<>();
        List<Integer> countOfEachGroup = new LinkedList<>();
        
        int sumOfOneGroup = 0;
        List<String> newGroup = new LinkedList<>();
        
        //init wordsInGroup and countOfEachGroup
        for(int i = 0;i<words.length;i++){
            int sum = sumOfOneGroup + words[i].length();
            if(sum > maxWidth){
                wordsInGroup.add(newGroup);
                countOfEachGroup.add(sumOfOneGroup);
                newGroup = new LinkedList<>();
                sumOfOneGroup = 0;
            }
            sumOfOneGroup += words[i].length()+1;//add one space
            newGroup.add(words[i]);
        }
        wordsInGroup.add(newGroup);
        countOfEachGroup.add(sumOfOneGroup);
        
        //reconstruct wordsInGroup
        int countOfGroup = wordsInGroup.size();
        for(int i = 0;i<countOfGroup - 1;i++){
            List<String> wordsInOneGroup = wordsInGroup.get(i);
            int needSpaceNum = maxWidth - (countOfEachGroup.get(i)-1);//last word do not need space
            int evenSpaceNum = 0;
            int extraSpaceNum = needSpaceNum;
            
            int wordCountInOneGroup = wordsInOneGroup.size();
            if(wordCountInOneGroup == 0)
                continue;
            
            if(wordCountInOneGroup > 1){
                evenSpaceNum = needSpaceNum / (wordCountInOneGroup - 1);
                extraSpaceNum = needSpaceNum % (wordCountInOneGroup - 1);
            }
            
            StringBuilder builder = new StringBuilder();
            builder.append(wordsInOneGroup.get(0));
            for(int j = 1;j<wordCountInOneGroup;j++){
                builder.append(' ');
                if(extraSpaceNum > 0){
                    appendBuilderNSpace(builder,evenSpaceNum+1);
                    extraSpaceNum--;
                }else{
                    appendBuilderNSpace(builder,evenSpaceNum);
                }
                builder.append(wordsInOneGroup.get(j));
            }
            
            if(builder.length() < maxWidth)
                appendBuilderNSpace(builder,maxWidth - builder.length());
                
            res.add(builder.toString());
        }
        //deal with last group
        List<String> wordsInLastline = wordsInGroup.get(countOfGroup - 1);
        int needSpaceNum = maxWidth - (countOfEachGroup.get(countOfGroup-1) - 1);
        int wordCountInLastline = wordsInLastline.size();
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0;i<wordCountInLastline;i++){
            builder.append(wordsInLastline.get(i));
            builder.append(' ');
        }
        int curSize = builder.length();
        if(curSize > maxWidth){
            builder.deleteCharAt(curSize-1);
        }else{
            appendBuilderNSpace(builder,maxWidth - curSize);
        }
        res.add(builder.toString());
        return res;
    }
}