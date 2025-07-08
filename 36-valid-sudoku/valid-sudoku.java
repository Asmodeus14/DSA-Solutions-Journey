class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowSeen = new boolean[9][9];
        boolean[][] colSeen = new boolean[9][9];
        boolean[][] boxSeen = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if (rowSeen[i][num] || colSeen[j][num] || boxSeen[boxIndex][num]) {
                        return false;
                    }
                    rowSeen[i][num] = true;
                    colSeen[j][num] = true;
                    boxSeen[boxIndex][num] = true;
                }
            }
        }
        return true;
    }
}