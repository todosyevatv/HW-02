abstract class ChessPiece {

    public String color;
    public boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();

    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract public String getSymbol();

    public static boolean checkOnBoard(int toLine, int toColumn) {
        return (toLine <= 7 && toLine >= 0) && (toColumn <= 7 && toColumn >= 0);
    }

    public static int getDirection(int from, int to) {
        if (to == from) {
            return 0;
        }
        return ((to - from) > 0) ? 1 : -1;
    }

    public boolean checkLast(ChessPiece chessPiece) {
        return chessPiece == null || !chessPiece.getColor().equals(color);
    }

}
