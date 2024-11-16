public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int lineDelta = Math.abs(toLine - line);
        int columnDelta = Math.abs(toColumn - column);
        if (lineDelta == 0 && columnDelta == 0) {
            return false;
        }
        if (lineDelta > 1 || columnDelta > 1) {
            return false;
        }
        if (!checkOnBoard(toLine, toColumn)) {return false;}
        return checkLast(chessBoard.board[toLine][toColumn]);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {

        for (int i = 0; i < 8; i++) {
            for (int b = 0; b < 8; b++) {
                if (board.board[i][b] == null) {
                    continue;
                }
                if (board.board[i][b].getColor().equals(color)) {
                    continue;
                }
                if (board.board[i][b].canMoveToPosition(board, i, b, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }
}
