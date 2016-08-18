package roglin

/**
 * Created by parks on 7/8/16.
 */

class WorldBuilder(val width: Int, val height: Int){

    private var tiles:Array<Tile?>

    init {
        val T = Array( width, {IntArray(width)})
        tiles = arrayOfNulls(width*height)
    }

    fun build() = World(tiles, width, height)

    private fun randomizeTiles(): WorldBuilder {
        for (x in 0..width-1) {
            for (y in 0..height-1){
                tiles[x*height+y] = if (Math.random() < 0.5) Tile.FLOOR else Tile.WALL
            }
        }
        return this
    }

    private fun smooth(times: Int): WorldBuilder{
        val t2:Array<Tile?> = arrayOfNulls(width*height)
        for (t in 0..times){
            for(x in 0..width-1){
                for (y in 0..height-1){
                    var floors = 0
                    var rocks = 0

                    for (ox in -1..1){
                       inner@ for( oy in -1..1){
                            if ( x + ox < 0 || x+ ox >= width || y + oy < 0 || y + oy >= height)
                                break@inner
                            if(tiles[(x+ox)*height+(y+oy)] == Tile.FLOOR)
                                floors++
                            else
                                rocks++
                        }
                    }
                    t2[x*height+y] = if(floors >= rocks) Tile.FLOOR else Tile.WALL
                }
            }
            tiles = t2
        }
        return this
    }

    fun makeCaves() : WorldBuilder = randomizeTiles().smooth(8)


}