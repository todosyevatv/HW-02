public class Queen extends ChessPiece{
    public Queen(String color) {
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
        int delta = (lineDelta == 0) ? columnDelta : lineDelta;
        if (lineDelta == 0 && columnDelta == 0) return false;
        if (!checkOnBoard(toLine, toColumn)) {return false;}
        if(!((lineDelta == 0 || columnDelta == 0) || (lineDelta == columnDelta))) {return false;}
        int lineDirection = getDirection(line,toLine);
        int columnDirection = getDirection(column,toColumn);

        for (int i = 1; i < delta; i++) {
            if (chessBoard.board[line + lineDirection * i][column + columnDirection * i] != null) {
                return false;
            }
        }
        return checkLast(chessBoard.board[toLine][toColumn]);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

}
