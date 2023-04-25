package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;


import java.util.ArrayList;
import java.util.List;




public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        boolean pieceIsWhite = (this.colour == PlayerColour.WHITE);
        ArrayList<Move> allowedMoves = new ArrayList<>();
        Coordinates PieceInFrontOfWhite = from.plus(-1,0);
        Coordinates PieceInFrontOfTwoSquareWhite = from.plus(-2,0);
        Coordinates PieceInFrontOfBlack = from.plus(+1,0);
        Coordinates PieceInFrontOfTwoSquareBlack = from.plus(+2,0);
        Coordinates PieceInDiagonalLeftWhite = from.plus(-1,-1);
        Coordinates PieceInDiagonalRightWhite =from.plus(-1,+1);
        Coordinates PieceInDiagonalLeftBlack = from.plus(+1,-1);
        Coordinates PieceInDiagonalRightBlack = from.plus(+1,+1);
        boolean pieceIsAtTheBotom = from.getRow() == 7;
        boolean pieceIsAtTheTop = from.getRow() == 0;
        boolean pieceIsOnTheLeft = from.getRow() == 0;
        boolean pieceIsOnTheRight = from.getRow() == 7;




        boolean blackAtTheBottom = from.getRow() == 7;
        boolean whiteAtTheTop = from.getRow() == 0;
        boolean pieceOnRightOfBoard = from.getCol() == 7;
        boolean pieceOnLeftOfBoard = from.getCol() == 0;


        if (pieceIsWhite) {
            if (!whiteAtTheTop) {

                Piece pieceInDiagonalLeft=null;
                Piece pieceInDiagonalRight=null;

                if(squareExists(PieceInDiagonalLeftWhite)){
                    pieceInDiagonalLeft= board.get(PieceInDiagonalLeftWhite);
                }
                if(squareExists(PieceInDiagonalRightWhite)){
                    pieceInDiagonalRight=board.get(PieceInDiagonalRightWhite);


                }

                Piece pieceInFront=null;
               if(squareExists(PieceInFrontOfWhite)) {
                   pieceInFront = board.get(PieceInFrontOfWhite);
                }



                Piece pieceInFrontTwoSquare=null;
                if(squareExists(PieceInFrontOfTwoSquareWhite)){
                 pieceInFrontTwoSquare = board.get(PieceInFrontOfTwoSquareWhite);
                }


                boolean madeFistMove = from.getRow() == 6;
                if (pieceInDiagonalLeft!=null && pieceInDiagonalLeft.getColour()==PlayerColour.BLACK && !pieceOnLeftOfBoard){
                    Move allowedMove = new Move(from, PieceInDiagonalLeftWhite);
                    allowedMoves.add(allowedMove);
                }

                if (pieceInDiagonalRight!=null  && pieceInDiagonalRight.getColour()==PlayerColour.BLACK && !pieceOnRightOfBoard){
                    Move allowedMove = new Move(from, PieceInDiagonalRightWhite);
                    allowedMoves.add(allowedMove);
                }

                if (madeFistMove) {

                    Coordinates to = new Coordinates(from.getRow() - 2, from.getCol());
                    if (pieceInFrontTwoSquare == null) {
                        Move allowedMove = new Move(from, to);
                        allowedMoves.add(allowedMove);
                    }
                }
                if (pieceInFront == null) {
                    Coordinates to = new Coordinates(from.getRow() - 1, from.getCol());
                    Move allowedMove = new Move(from, to);
                    allowedMoves.add(allowedMove);

                }
            }
        } else  {
            if (!blackAtTheBottom) {
                boolean madeFistMove = from.getRow() == 1;
                Piece pieceInFront=null;
                if(squareExists(PieceInFrontOfBlack)) {
                    pieceInFront = board.get(PieceInFrontOfBlack);
                }



                Piece pieceInFrontTwoSquare=null;
                if(squareExists(PieceInFrontOfTwoSquareBlack)){
                    pieceInFrontTwoSquare = board.get(PieceInFrontOfTwoSquareBlack);
                }



                Piece pieceInDiagonalLeft=null;
                Piece pieceInDiagonalRight=null;


                    if(squareExists(PieceInDiagonalLeftBlack)){
                        pieceInDiagonalLeft= board.get(PieceInDiagonalLeftBlack);
                    }
                    if(squareExists(PieceInDiagonalRightBlack)){
                         pieceInDiagonalRight=board.get(PieceInDiagonalRightBlack);


                    }


                if (pieceInDiagonalLeft!=null && pieceInDiagonalLeft.getColour()==PlayerColour.WHITE && !pieceOnLeftOfBoard){
                    Move allowedMove = new Move(from, PieceInDiagonalLeftBlack);
                    allowedMoves.add(allowedMove);
                }

                if (pieceInDiagonalRight!=null && pieceInDiagonalRight.getColour()==PlayerColour.WHITE && !pieceOnRightOfBoard){
                    Move allowedMove = new Move(from, PieceInDiagonalRightBlack);
                    allowedMoves.add(allowedMove);
                }



                if (madeFistMove) {
                    Coordinates to = new Coordinates(from.getRow() + 2, from.getCol());
                    if (pieceInFrontTwoSquare == null) {
                        Move allowedMove = new Move(from, to);
                        allowedMoves.add(allowedMove);
                    }
                }
                if (pieceInFront == null) {
                    Coordinates to = new Coordinates(from.getRow() + 1, from.getCol());
                    Move allowedMove = new Move(from, to);
                    allowedMoves.add(allowedMove);
                }
            }

        }

        return allowedMoves;
    }
}
