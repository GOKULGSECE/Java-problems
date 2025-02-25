package Graphs;

class surroundregions {
    private int count = 0;

    public void dfs(char[][] board,int i,int j)
    {
        if(i>=0 && j>=0 && i<board.length && j<board[0].length && board[i][j] == 'X')
        {
            if(i-1<0 || board[i-1][j]=='.' && board[i][j-1]!='X'){
                count++;
            }
            else if(j-1<0 || board[i][j-1]=='.' && board[i-1][j]!='X'){
                count++;
            }
        }
    }

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        surroundregions sr = new surroundregions();
        int result = sr.countBattleships(board);
        System.out.println("Number of battleships: " + result);
    }
}
