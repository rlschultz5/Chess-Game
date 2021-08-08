package org.schultz.piece;

import org.schultz.ChessBoard;
import org.schultz.ChessPoint;
import org.schultz.PlayerColor;

import java.awt.*;

public abstract class ChessPiece {
    protected final PlayerColor playerColor;

    public ChessPiece(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    public PlayerColor getPlayerColor() {
        return this.playerColor;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName().toUpperCase() + " (" + playerColor + ")";
    }

    public abstract boolean validMove(ChessPoint start, ChessPoint end, ChessBoard chessBoard);

}