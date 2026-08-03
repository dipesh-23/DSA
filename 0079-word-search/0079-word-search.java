class Solution {

    public boolean f(int i, int j , String word,int index,char[][] board ){
        
        if(i <0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }

        if(index == word.length()-1){
            return true;
        }
        board[i][j] = '#';

        boolean ans = false;
        ans = ans || f(i+1,j,word,index+1,board);
        ans = ans || f(i-1,j,word,index+1,board);
        ans = ans || f(i,j+1,word,index+1,board);
        ans = ans || f(i,j-1,word,index+1,board);

        board[i][j] = word.charAt(index);

        return ans;

    }
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(f(i,j,word,0,board)==true){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}