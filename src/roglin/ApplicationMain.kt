package roglin

import javax.swing.JFrame
import asciiPanel.AsciiPanel

fun main(args: Array<String>){
    val app = ApplicationMain()
    app.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    app.isVisible = true
}

class ApplicationMain(): JFrame() {
    private val terminal: AsciiPanel

    init {
        terminal = AsciiPanel()
        terminal.write("roglin tutorial", 1, 1)
        add(terminal)
        pack()
    }
    
}
