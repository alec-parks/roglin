package roglin.screens

import asciiPanel.AsciiPanel
import roglin.World
import roglin.WorldBuilder
import java.awt.event.KeyEvent


class PlayScreen(private val screenWidth: Int, private val screenHeight: Int) : Screen {

    private var world: World
    private var centerX : Int = 0
    private var centerY : Int = 0

    init {
        world = createWorld()
    }

    private fun createWorld() = WorldBuilder(90,80).makeCaves().build()

    override fun displayOutput(terminal: AsciiPanel) {
        val left = getScrollX()
        val top = getScrollY()
        displayTiles(terminal,left,top)
        terminal.write('X', centerX - left, centerY - top)
    }

    override fun respondToUserInput(key: KeyEvent): Screen {
        when (key.keyCode) {
            KeyEvent.VK_ESCAPE -> return LoseScreen()
            KeyEvent.VK_ENTER -> return WinScreen()
            KeyEvent.VK_LEFT, KeyEvent.VK_H -> scrollBy(-1,0)
            KeyEvent.VK_RIGHT, KeyEvent.VK_L -> scrollBy(1,0)
            KeyEvent.VK_UP, KeyEvent.VK_K -> scrollBy(0,-1)
            KeyEvent.VK_DOWN, KeyEvent.VK_J -> scrollBy(0,1)
            KeyEvent.VK_Y -> scrollBy(-1,-1)
            KeyEvent.VK_U -> scrollBy(1,-1)
            KeyEvent.VK_B -> scrollBy(-1,1)
            KeyEvent.VK_N -> scrollBy(1,1)
        }
        return this
    }

    fun getScrollX() = Math.max(0, Math.min(centerX - screenWidth / 2, world.width - screenWidth))

    fun getScrollY() = Math.max(0, Math.min(centerY - screenHeight/2 , world.height - screenHeight))

    private fun displayTiles(terminal: AsciiPanel, left : Int, top: Int){
        for(x in 0..screenWidth-1){
            for (y in 0..screenHeight-1){
                val wx = x + left
                val wy = y + top

                terminal.write(world.glyph(wx,wy),x,y,world.color(wx,wy))
            }
        }
    }

    private fun scrollBy(mx : Int, my : Int){
        centerX = Math.max(0, Math.min(centerX + mx, world.width-1))
        centerY = Math.max(0, Math.min(centerY + my, world.height-1))
    }

}