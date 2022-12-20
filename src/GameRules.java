import java.util.Random;

public class GameRules {

    public boolean isValidMove(int X, int Y, PlayerMarker[][] board) {
        return board[X][Y] != PlayerMarker.X && board[X][Y] != PlayerMarker.O;
    }

    public char isGameEnd(PlayerMarker[][] board, PlayerMarker playerMark) {
        if (checkWinner(board)) {
            if (playerMark == PlayerMarker.X) {
                return 'X';
            } else return 'O';
        } else if (isBoardFull(board)) {
            return 'D';
        } else return 'C';
    }

    private boolean isBoardFull(PlayerMarker[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean checkWinner(PlayerMarker[][] board) {
        return (board[0][0] != null && board[0][0] == board[0][1] && board[0][0] == board[0][2])
                || (board[1][0] != null && board[1][0] == board[1][1] && board[1][0] == board[1][2])
                || (board[2][0] != null && board[2][0] == board[2][1] && board[2][0] == board[2][2])
                || (board[0][0] != null && board[0][0] == board[1][0] && board[0][0] == board[2][0])
                || (board[0][1] != null && board[0][1] == board[1][1] && board[0][1] == board[2][1])
                || (board[0][2] != null && board[0][2] == board[1][2] && board[0][2] == board[2][2])
                || (board[0][0] != null && board[0][0] == board[1][1] && board[0][0] == board[2][2])
                || (board[0][2] != null && board[0][2] == board[1][1] && board[0][2] == board[2][0]);
    }

    public PlayerMarker[][] placeRandom(PlayerMarker[][] gameBoard, Player currentPlayer) {
        boolean done = false;
        int r1;
        int r2;
        while(!done){
            r1 = randomNum();
            r2 = randomNum();
            if(gameBoard[r1][r2] == null){
                gameBoard[r1][r2] = currentPlayer.getPlayerMark();
                done = true;
            }
        }
        return gameBoard;
    }
    private int randomNum(){
        Random random = new Random();
        return random.nextInt(3);
    }
}