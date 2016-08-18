package roglin

import java.awt.Color

/**
 * Created by parks on 7/8/16.
 */


class World(private val tiles: Array<Tile?>, val width: Int, val height: Int){


    fun tile(x: Int, y: Int): Tile? {
        if ( x < 0 || x >= width || y < 0 || y >= height) return Tile.BOUNDS else return tiles[x*height+y]
    }


    fun glyph(x: Int, y: Int): Char = tile(x,y)!!.glyph

    fun color(x: Int, y: Int): Color = tile(x,y)!!.color

}