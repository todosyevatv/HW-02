public class Bishop extends ChessPiece {

    public Bishop(String color) {
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
        if (lineDelta == 0 || lineDelta != columnDelta) {
            return false;
        }
        if (!checkOnBoard(toLine, toColumn)) {return false;}
        int lineDirection = getDirection(line, toLine);
        int columnDirection = getDirection(column, toColumn);
        int checkColumn = column;
        int checkLine = line;
        for (int i = 1; i < lineDelta ; i++) {
            checkColumn += columnDirection;
            checkLine += lineDirection;
            if (chessBoard.board[checkLine][checkColumn] != null) {return false;}
        }
        return checkLast(chessBoard.board[toLine][toColumn]);
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
