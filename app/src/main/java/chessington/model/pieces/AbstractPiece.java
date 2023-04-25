package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.PlayerColour;

import java.awt.*;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    public boolean squareExists(Coordinates cor){
        return !(cor.getRow()<0 || cor.getCol()<0 || cor.getRow()>7 || cor.getCol()>7);
    }

    public boolean squareIsEmpty(Coordinates cor, Board board){
        return board.get(cor)==null;
    }
    public boolean squareIsWithEnemy(Coordinates cor, Board board, PlayerColour colour){
       PlayerColour nextSquarePieceColour = board.get(cor).getColour();
        return board.get(cor)!=null && nextSquarePieceColour!=colour ;
    }
    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }
}
