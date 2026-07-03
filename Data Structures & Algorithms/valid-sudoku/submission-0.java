class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean res = isvalid(board, "row", i, 0);
            if(res==false) return false;
        }
        for(int i=0;i<9;i++){
            boolean res = isvalid(board, "col", i, 0);
            if(res==false) return false;
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                boolean res = isvalid(board, "box", i, j);
                if(res==false) return false;
            }
        }

        return true;
    }

    public boolean isvalid(char[][] board, String entityType, int entityId, int entityId2){
        int[] bucket = new int[10];
        
        if(entityType == "row"){
            for(int i=0;i<9;i++){
                if(board[entityId][i]!='.'){
                    int num = board[entityId][i] - '0';
                    bucket[num]++;
                }
            }
        }else if(entityType == "col"){
            for(int i=0;i<9;i++){
                if(board[i][entityId]!='.'){
                    int num = board[i][entityId] - '0';
                    bucket[num]++;
                }
            }
        }else{
            for(int i=entityId;i<entityId+3;i++){
                for(int j=entityId2;j<entityId2+3;j++){
                    if(board[i][j]!='.'){
                        int num = board[i][j] - '0';
                        bucket[num]++;
                    }
                }
            }
        }
        for(int i=0;i<10;i++){
            if(bucket[i]>1){
                return false;
            }
        }
        return true;
    }
}
