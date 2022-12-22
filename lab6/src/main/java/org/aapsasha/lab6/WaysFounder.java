package org.aapsasha.lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class SityPriority{
    public int priority;
    int townInd;
    public SityPriority(int townInd,int priority){
        this.priority = priority;
        this.townInd = townInd;
    }
}

public class WaysFounder {
    ArrayList<String> names;
    ArrayList<Integer> waysLenght;
    public WaysFounder(int[][] adjacencyMatrix, ArrayList<String> names, String startTown){
        this.names = names;
        boolean[] alreadyUsed = new boolean[names.size()];
        for(int i =0; i < names.size();++i){
            alreadyUsed[i] = false;
        }
        waysLenght = new ArrayList<>(names.size());
        for(int i = 0;i < names.size();++i){
            waysLenght.add(Integer.MAX_VALUE);
        }
        waysLenght.set(names.indexOf(startTown),0);
        PriorityQueue<Integer> sityPriorities = new PriorityQueue<>(names.size(), Comparator.comparingInt((Integer fTown) -> waysLenght.get(fTown)));

        sityPriorities.add(names.indexOf(startTown));
        alreadyUsed[names.indexOf(startTown)] = true;
        while(true){
            if(sityPriorities.peek() == null){
                break;
            }
            int town = sityPriorities.poll();
            for(int i =0; i < names.size();++i){
                if(adjacencyMatrix[town][i] != -1){
                    if(waysLenght.get(town) + adjacencyMatrix[town][i] < waysLenght.get(i)){
                        waysLenght.set(i,waysLenght.get(town) + adjacencyMatrix[town][i]);
                        if(!alreadyUsed[i]){
                            sityPriorities.add(i);
                            alreadyUsed[i] = true;
                        }
                    }
                }
            }
        }
    }
    public ArrayList<Integer> showAll(){
        return waysLenght;
    }

}
