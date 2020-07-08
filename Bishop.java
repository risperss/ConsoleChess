import java.util.*;

public class Bishop extends Piece
{
    public Bishop(Color color)
    {
        super(color);
        setIcon('B');
    }

    @Override
    public void setPossibleMoves(Square currSquare, Board board, Player currPlayer) 
    {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        
        possibleMoves.addAll(oneDirection(1, 1, currSquare, board, currPlayer));
        possibleMoves.addAll(oneDirection(-1, 1, currSquare, board, currPlayer));
        possibleMoves.addAll(oneDirection(1, -1, currSquare, board, currPlayer));
        possibleMoves.addAll(oneDirection(-1, -1, currSquare, board, currPlayer));

        setPossibleMoves(possibleMoves);
    }

    //not the band
    public ArrayList<Move> oneDirection(int rowDir, int colDir, Square currSquare, Board board, Player currPlayer)
    {
        ArrayList<Move> oneDirection = new ArrayList<Move>();
        int row = currSquare.getROW();
        int col = currSquare.getCOL();

        int i = 1;
        while (i < 8)
        {
            int dRow = row + (i * rowDir);
            int dCol = col + (i * colDir);
            
            if (dRow >= 0 && dRow < 8 && dCol < 8 && dCol >= 0)            
            { 
                Square destSquare = board.getSquare(row + (i * rowDir), col + (i * colDir));
                Piece destPiece = destSquare.getPiece();
            
                if (destPiece == null)
                {
                    oneDirection.add(new Move(currPlayer, currSquare, destSquare, board, MoveType.NORMAL));
                }
                else if (destPiece.getColor() != getColor())
                {
                    oneDirection.add(new Move(currPlayer, currSquare, destSquare, board, MoveType.NORMAL));
                    break;
                    //break because you cannot go through a piece of diff colour,
                    //but you can still land on it
                }
                else 
                {
                    break;
                    //cannot go to a Move with a piece the same colour
                }
            }
            else 
            {
                break;
            }
            i++;
        }

        return oneDirection;
    }
}