import android.widget.CheckBox
import android.widget.Switch
import androidx.appcompat.widget.SwitchCompat
import java.util.*

class PasswordControl () : Password() {
    private val numbers = "0123456789"
    private val letters = "abcdefghijklmnopqrstuvwxyz"
    private val symbols = """""!@#$&*_-+"',.?"""
    private var caracteres = ""
    fun control (switchNumbers : CheckBox, switchLetters : CheckBox, switchLettersUpper : CheckBox, switchSymbols : CheckBox)
    : String  {
        this.caracteres = ""
        if (switchNumbers.isChecked ) this.caracteres += numbers
        if (switchLettersUpper.isChecked ) this.caracteres += letters.toUpperCase(Locale.ROOT)
        if (switchSymbols.isChecked) this.caracteres += symbols
        if (switchLetters.isChecked) this.caracteres += letters
        return this.caracteres
    }

}