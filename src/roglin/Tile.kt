package roglin

import asciiPanel.AsciiPanel
import java.awt.Color

/**
 * Created by parks on 7/8/16.
 */
enum class Tile constructor(val glyph: Char, val color: Color) {
    FLOOR(250.toChar(), AsciiPanel.yellow),
    WALL(177.toChar(), AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack);
}
