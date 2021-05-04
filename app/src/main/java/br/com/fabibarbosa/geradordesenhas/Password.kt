import android.widget.TextView

abstract class Password () {
    var password = ""
    fun generatePassword (passwordSize : Int, caracteres : String, output : TextView) {
        this.password = ""
        while (this.password.length < passwordSize ) {
            this.password += caracteres[(caracteres.indices).random()]
        }
        output.text = this.password
    }
}
