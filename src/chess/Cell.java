package chess;

import chess.Pieces.Piece;

public class Cell {
   private int row;
   private int col;

   private Piece piece;

   public int getRow(){
       return this.row;
   }
   public int getCol(){
       return this.col;
   }

   public Piece getPiece(){
       return this.piece;
   }

   public void setPiece(Piece piece){
       this.piece = piece;
   }

   public boolean isEmpty(){
       return piece == null;
   }
}
