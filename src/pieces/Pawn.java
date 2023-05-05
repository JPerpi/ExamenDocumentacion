package pieces;

import java.util.ArrayList;

import chess.Cell;


/**
 * Clase Peón(Pawn)
 * 
 * @see Piece
 * @version 1.0
 * @since Se modifica en la versiń 1.0 
 * @author perpi
 */
public class Pawn extends Piece{
	
	//COnstructors

    /**
     * Constructor de la calse Pawn (Peón)
     * @param i Nombre corto de la pieza
     * @param p Nombre completo de la pieza
     * @param c Color de la pieza
     */
	public Pawn(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//Move Function Overridden

    /**
     * Función para obtener los posibles movimientos
     * @param state Matriz con las casillas del tablero
     * @param x Coordenada X
     * @param y Coordenada Y
     * @return Devuelve un ArrayList con los posibles movimientos
     */
	public ArrayList<Cell> move(Cell state[][],int x,int y)
	{

            
            //El peón solo se puede mover una casilla hacia adelante, en su primer movimiento se puede mover dos casillas hacia delante
            //Solo se puede mover ne diagonal cuando ataca a una pieza del color contrario
		
		possiblemoves.clear();
		if(getcolor()==0)
		{
			if(x==0)
				return possiblemoves;
			if(state[x-1][y].getpiece()==null)
			{
				possiblemoves.add(state[x-1][y]);
				if(x==6)
				{
					if(state[4][y].getpiece()==null)
						possiblemoves.add(state[4][y]);
				}
			}
			if((y>0)&&(state[x-1][y-1].getpiece()!=null)&&(state[x-1][y-1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x-1][y-1]);
			if((y<7)&&(state[x-1][y+1].getpiece()!=null)&&(state[x-1][y+1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x-1][y+1]);
		}
		else
		{
			if(x==8)
				return possiblemoves;
			if(state[x+1][y].getpiece()==null)
			{
				possiblemoves.add(state[x+1][y]);
				if(x==1)
				{
					if(state[3][y].getpiece()==null)
						possiblemoves.add(state[3][y]);
				}
			}
			if((y>0)&&(state[x+1][y-1].getpiece()!=null)&&(state[x+1][y-1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x+1][y-1]);
			if((y<7)&&(state[x+1][y+1].getpiece()!=null)&&(state[x+1][y+1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x+1][y+1]);
		}
		return possiblemoves;
	}
}
