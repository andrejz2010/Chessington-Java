package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;



import java.util.ArrayList;
import java.util.List;

import static chessington.model.PlayerColour.BLACK;
import static chessington.model.PlayerColour.WHITE;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves= new ArrayList<>();
        Coordinates PieceInFrontOfWhite=new Coordinates(from.getRow()-1, from.getCol());
        Coordinates PieceInFrontOfTwoSquareWhite=new Coordinates(from.getRow()-2, from.getCol());
        Coordinates PieceInFrontOfBlack=new Coordinates(from.getRow()+1, from.getCol());
        Coordinates PieceInFrontOfTwoSquareBlack=new Coordinates(from.getRow()+2, from.getCol());


        if (this.colour==WHITE) {
            Piece pieceInFront = board.get(PieceInFrontOfWhite);
            Piece pieceInFrontTwoSquare = board.get(PieceInFrontOfTwoSquareWhite);

                if (from.getRow() == 6) {

                    Coordinates to1 = new Coordinates(from.getRow() - 2, from.getCol());
                    if (pieceInFrontTwoSquare == null) {
                        Move allowedMove1 = new Move(from, to1);
                        allowedMoves.add(allowedMove1);
                    }
                }
            if (pieceInFront == null) {
                Coordinates to1 = new Coordinates(from.getRow() - 1, from.getCol());
                Move allowedMove1 = new Move(from, to1);
                allowedMoves.add(allowedMove1);
            }
            } else if (this.colour == BLACK) {
            Piece pieceInFront = board.get(PieceInFrontOfBlack);
            Piece pieceInFrontTwoSquare = board.get(PieceInFrontOfTwoSquareBlack);



                if (from.getRow() == 1) {
                    Coordinates to1 = new Coordinates(from.getRow() + 2, from.getCol());
                    if (pieceInFrontTwoSquare == null){
                    Move allowedMove1 = new Move(from, to1);
                    allowedMoves.add(allowedMove1);}
                }
                if(pieceInFront==null) {
                    Coordinates to2 = new Coordinates(from.getRow() + 1, from.getCol());
                    Move allowedMove2 = new Move(from, to2);
                    allowedMoves.add(allowedMove2);
                }

        }

       return allowedMoves;
    }
}
