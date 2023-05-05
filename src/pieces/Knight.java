package pieces;

import java.util.ArrayList;

import chess.Cell;

/**
 * Clase Caballo(Knight)
 * 
 * @see Piece
 * @version 1.0
 * @since Se modifica en la versiń 1.0 
 * @author perpi
 */
public class Knight extends Piece{
	
	//Constructor
    /**
     * Contructor de la clase Knight(Caballo)
     * @param i NOmbre corto de la pieza
     * @param p Nombre completo de la pieza
     * @param c Color de la pieza (1: negro//0: blanco)
     */
	public Knight(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//Move Function overridden
	//There are at max 8 possible moves for a knight at any point of time.
	//Knight moves only 2(1/2) steps

    /**
     * Función para obtener los movimientos
     * @param state Matriz con las casillas del tablero
     * @param x Coordenada X
     * @param y Coordenada Y 
     * @return Devuelve una ArrayList con los posbles movimientos
     */
	public ArrayList<Cell> move(Cell state[][],int x,int y)
	{
		possiblemoves.clear();
		int posx[]={x+1,x+1,x+2,x+2,x-1,x-1,x-2,x-2};
		int posy[]={y-2,y+2,y-1,y+1,y-2,y+2,y-1,y+1};
		for(int i=0;i<8;i++)
			if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
				if((state[posx[i]][posy[i]].getpiece()==null||state[posx[i]][posy[i]].getpiece().getcolor()!=this.getcolor()))
				{
					possiblemoves.add(state[posx[i]][posy[i]]);
				}
		return possiblemoves;
	}
}