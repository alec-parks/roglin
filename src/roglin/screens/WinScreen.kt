package roglin.screens

import asciiPanel.AsciiPanel
import java.awt.event.KeyEvent


class WinScreen(): Screen{
    override fun displayOutput(terminal: AsciiPanel) {
        terminal.write("You win!",1,1)
        terminal.writeCenter("-- press [enter] to play again --",22)
    }

    override fun respondToUserInput(key: KeyEvent) = if(key.keyCode == KeyEvent.VK_ENTER) PlayScreen(80,21) else this

}