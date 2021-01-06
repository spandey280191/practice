package leetCode.TopInterviewQuestion.WordLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class WordNode{
    String word;
    int numSteps;

    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}

public class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord,1));
       // queue.add(new WordNode(beginWord, 1));

        wordDict.add(endWord);

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(endWord)){
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        int min = s.ladderLength("hit","cog",list);
        System.out.println(min);
    }
}
