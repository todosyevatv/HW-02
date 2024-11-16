public class Pawn extends ChessPiece {


    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column != toColumn) {
            return false;
        }
        int direction = (color.equals("White")) ? 1 : -1;
        boolean firstStep = ((direction == 1 && line == 1) || (direction == -1 && line == 6));
        int lineDelta = (toLine - line) * direction;
        if (!(lineDelta == 1 || (lineDelta == 2 && (firstStep)))) {
            return false;
        }
        if (!checkOnBoard(toLine, toColumn)) {return false;}
        if (lineDelta == 2 && chessBoard.board[line + direction][column] != null) { return false;

        }
        return checkLast(chessBoard.board[toLine][toColumn]);
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
