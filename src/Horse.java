public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int lineDelta = toLine - line;
        int columnDelta = toColumn - column;

        if (!((Math.abs(lineDelta) == 2 && Math.abs(columnDelta) == 1) ||
                (Math.abs(lineDelta) == 1 && Math.abs(columnDelta) == 2))) {
            return false;
        }
        if (!checkOnBoard(toLine, toColumn)) {
            return false;
        }
        int lineDirection = getDirection(line, toLine);
        int columnDirection = getDirection(column, toColumn);
        if (lineDelta == 2) {
            if (chessBoard.board[line + lineDirection][column] != null || chessBoard.board[line + 2 * lineDirection][column] != null) {
                return false;
            }
        } else {
            if (chessBoard.board[line][column + columnDirection] != null || chessBoard.board[line][column + 2 * columnDirection] != null) {
                return false;
            }
        }
        return checkLast(chessBoard.board[toLine][toColumn]);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
