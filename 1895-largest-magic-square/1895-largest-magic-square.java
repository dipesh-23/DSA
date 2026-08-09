class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] rowsum = new int[n][m];

        for(int i=0; i<n; i++){
            rowsum[i][0] =grid[i][0];
        }

        for(int i=0; i<n; i++){
            for(int j=1; j<m; j++){
                rowsum[i][j] = rowsum[i][j-1]+grid[i][j];
            }
        }

        int[][] colsum = new int[n][m];

        for(int i=0; i<m; i++){
            colsum[0][i] =grid[0][i];
        }

        for(int j=0; j<m; j++){
            for(int i=1; i<n; i++){
                colsum[i][j] = colsum[i-1][j]+grid[i][j];
            }
        }

        int ans = 1;

        for(int side = Math.min(m,n); side>=2; side--){

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){

                    if(i+side-1 >= n){
                        continue;
                    }

                    if(j+side-1 >=m){
                        continue;
                    }

                    boolean allsafe = true;

                    int target = rowsum[i][j+side-1] - (j>0 ? rowsum[i][j-1] : 0);

                    //row check
                    for(int row =i; row<i+side; row++){
                        int p = rowsum[row][j+side-1]-(j>0 ? rowsum[row][j-1]: 0);
                        if(p != target){
                            allsafe= false;
                            break;
                        }
                    }

                    if(!allsafe) continue;

                    //column check
                    for(int col = j; col<j+side; col++){
                        int p = colsum[i+side-1][col] -(i>0 ? colsum[i-1][col] :0);
                        if(p!= target){
                            allsafe = false;
                            break;
                        }
                    }

                    if(!allsafe) continue;

                    //diagonal check
                    int diagsum1 = 0;
                    int diagsum2 = 0;
                    for(int k=0; k<side; k++){
                        diagsum1 += grid[i+k][j+k];
                        diagsum2 += grid[i+k][j+side-1-k];
                    }

                    if(diagsum1 != target){
                        continue;
                    }

                    if(diagsum2 != target){
                        continue;
                    }

                    return side;
                }
            }
        }

        return ans;

    }
}