package com.repeater.util

enum class KeyCode(var code: Int) {
    None(0),
    Backspace(8),
    Delete(0x7F),
    Tab(9),
    Clear(12),
    Return(13),
    Pause(19),
    Escape(27),
    Space(0x20),
    Keypad0(0x100),
}
