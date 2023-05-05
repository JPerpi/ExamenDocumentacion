package pieces;

import java.util.ArrayList;

import chess.Cell;


/**
 * Clase Alfíl(Bishop)
 * 
 * @see Piece
 * @version 1.0
 * @since Se modifica en la versiń 1.0 
 * @author perpi
 */
public class Bishop extends Piece{
	

    /**
     * Contructor del alfíl
     * @param i El nombre corto del alfíl
     * @param p El nombre completo del alfíl
     * @param c Color del alfíl
     */
	public Bishop(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	/**
     * Función para obtener los movimientos
     * @param state Matriz con las casillas del tablero
     * @param x Coordenada X
     * @param y Coordenada Y 
     * @return Devuelve una ArrayList con los posbles movimientos
     */
	public ArrayList<Cell> move(Cell state[][],int x,int y)
	{
                // El alfíl se puede mover en diagonal en las 4 direcciones (NE, NO,SE,SO)
		possiblemoves.clear();
		int tempx=x+1,tempy=y-1;
		while(tempx<8&&tempy>=0)
		{
			if(state[tempx][tempy].getpiece()==null)
			{
				possiblemoves.add(state[tempx][tempy]);
			}
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx++;
			tempy--;
		}
		tempx=x-1;tempy=y+1;
		while(tempx>=0&&tempy<8)
		{
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx--;
			tempy++;
		}
		tempx=x-1;tempy=y-1;
		while(tempx>=0&&tempy>=0)
		{
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx--;
			tempy--;
		}
		tempx=x+1;tempy=y+1;
		while(tempx<8&&tempy<8)
		{
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx++;
			tempy++;
		}
		return possiblemoves;
	}
}