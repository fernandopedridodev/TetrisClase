/*
 * Copyright (C) 2019 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package teistris;

import java.awt.Color;

/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Profe de Programación
 */
public class Piece {

    /**
     * Referenza ao obxecto xogo
     */
    private Game game;

    /**
     * Referenzas aos catro cadrados que forman a peza
     */
    private Square a, b, c, d;

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     * @param game
     */
    public Piece(Game game) {
        this.game = game;

        a = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game);
        b = new Square(Game.MAX_X / 2, 0, Color.BLUE, game);
        c = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, 
                Color.BLUE, game);
        d = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game);
    }

    /**
     * Move a ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {
        if (canMove(1, 0)) {
            a.moveBy(Game.SQUARE_SIDE, 0);
            b.moveBy(Game.SQUARE_SIDE, 0);
            c.moveBy(Game.SQUARE_SIDE, 0);
            d.moveBy(Game.SQUARE_SIDE, 0);
            return true;
        } 

        return false;
        
    }

    /**
     * Move a ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {
        if (canMove(-1,0)) {
            a.moveBy(-Game.SQUARE_SIDE, 0);
            b.moveBy(-Game.SQUARE_SIDE, 0);
            c.moveBy(-Game.SQUARE_SIDE, 0);
            d.moveBy(-Game.SQUARE_SIDE, 0);
            return true;
        }

        return false;
    }

    /**
     * Move a ficha a abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {
        if (canMove(0,1)) {
            a.moveBy(0, Game.SQUARE_SIDE);
            b.moveBy(0, Game.SQUARE_SIDE);
            c.moveBy(0, Game.SQUARE_SIDE);
            d.moveBy(0, Game.SQUARE_SIDE);
            return true;
        }

        return false;
    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }
    
    private boolean canMove(int dx, int dy) {
        return game.isValidPosition(a.getX() + dx, a.getY() + dy) &&
               game.isValidPosition(b.getX() + dx, b.getY() + dy) &&
               game.isValidPosition(c.getX() + dx, c.getY() + dy) &&
               game.isValidPosition(d.getX() + dx, d.getY() + dy);
    }
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Square getA() {
        return a;
    }

    public void setA(Square a) {
        this.a = a;
    }

    public Square getB() {
        return b;
    }

    public void setB(Square b) {
        this.b = b;
    }

    public Square getC() {
        return c;
    }

    public void setC(Square c) {
        this.c = c;
    }

    public Square getD() {
        return d;
    }

    public void setD(Square d) {
        this.d = d;
    }

    void addPieceToGround() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}