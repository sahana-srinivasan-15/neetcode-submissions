class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j]==0){
                    int k =0;
                    while(k<m){
                        if(matrix[i][k]!=0){
                        matrix[i][k]=-100000;}
                        k++;
                    }
                    int k1 = 0;
                    while(k1<n){
                        if(matrix[k1][j]!=0){
                            matrix[k1][j]=-100000;
                        }
                        k1++;
                    }


                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(matrix[i][j]==-100000){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
