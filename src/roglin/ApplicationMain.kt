package roglin

import asciiPanel.AsciiPanel
import roglin.screens.Screen
import roglin.screens.StartScreen
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

fun main(args: Array<String>){
    val app = ApplicationMain()
    app.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    app.isVisible = true
}

class ApplicationMain(): JFrame(), KeyListener {
    override fun keyTyped(e: KeyEvent?) {}

    override fun keyPressed(key: KeyEvent) {
        screen = screen.respondToUserInput(key)
        repaint()
    }

    override fun keyReleased(e: KeyEvent?) {}

    private val terminal = AsciiPanel()
    private var screen: Screen = StartScreen()

    init {
        add(terminal)
        pack()
        addKeyListener(this)
        repaint()
    }

    override fun repaint(){
        terminal.clear()
        screen.displayOutput(terminal)
        super.repaint()
    }
    
}
