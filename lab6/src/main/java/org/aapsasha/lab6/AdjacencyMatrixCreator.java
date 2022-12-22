package org.aapsasha.lab6;
import org.aapsasha.lab6.ReadandWrite.TownData;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixCreator {
    public ArrayList<String> names;
    public List<TownData> townList;
    public int[][] adjacencyMatrix;
    AdjacencyMatrixCreator(List<TownData> townList){
        this.townList = townList;
        adjacencyMatrix = new int[100][100];
        for(int i =0;i < 100;++i){
            for(int j =0; j < 100; ++j){
                adjacencyMatrix[i][j] = -1;
            }
        }
        names = new ArrayList<>();
        for(int i =0; i < townList.size(); ++i){
            String firstTown = townList.get(i).getFirstTown();
            int fInd = names.indexOf(firstTown);
            if(fInd == -1){
                names.add(firstTown);
                fInd = names.size() - 1;
            }

            String secondTown = townList.get(i).getSecondTown();
            int sInd = names.indexOf(secondTown);
            if(sInd == -1){
                names.add(secondTown);
                sInd = names.size() - 1;
            }

            int distance = townList.get(i).getDistance();

            adjacencyMatrix[fInd][sInd] = distance;
            adjacencyMatrix[sInd][fInd] = distance;
        }
        int[][] resized = new int[names.size()][names.size()];
        for(int i =0; i < names.size();++i){
            for(int j =0; j < names.size(); ++j){
                resized[i][j] = adjacencyMatrix[i][j];
            }
        }
        adjacencyMatrix =resized;
    }
}
