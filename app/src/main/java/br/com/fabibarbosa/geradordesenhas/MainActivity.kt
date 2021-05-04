package br.com.fabibarbosa.geradordesenhas

import PasswordControl
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGenerate = findViewById<Button>(R.id.btn_generate)
        val password = PasswordControl()
        val txtOutput = findViewById<TextView>(R.id.output_password)
        val seekbarValue = findViewById<SeekBar>(R.id.seekbar_password_size)
        val txtSeekbarResult = findViewById<TextView>(R.id.seekbar_result)


        val checkboxNumber = findViewById<CheckBox>(R.id.checkbox_numbers)
        val checkboxLetter = findViewById<CheckBox>(R.id.checkbox_letter)
        val checkboxSymbols = findViewById<CheckBox>(R.id.checkbox_symbols)
        val checkboxLetterUpper = findViewById<CheckBox>(R.id.checkbox_letter_upper)

        seekbarValue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               txtSeekbarResult.text  = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        btnGenerate.setOnClickListener { it ->
            var caracteres = password.control(checkboxNumber,checkboxLetter,checkboxLetterUpper,checkboxSymbols)

            if (caracteres != "" && caracteres != null) {
                if (txtSeekbarResult.text.toString().toInt() <= 5) {
                    Snackbar.make(it,"Sua senha deve ter mais de 5 caracteres", Snackbar.LENGTH_SHORT).show()
                }else {
                    password.generatePassword(txtSeekbarResult.text.toString().toInt(),caracteres, txtOutput)
                    txtOutput.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_content_copy_black_36dp, 0, 0, 0,)
                    txtOutput.setOnClickListener {
                        password.generatePassword(txtSeekbarResult.text.toString().toInt(),caracteres, txtOutput)
                        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        var clip: ClipData = ClipData.newPlainText("copyed",txtOutput.text.toString())
                        clipboard.setPrimaryClip(clip)
                        Snackbar.make(it,"Senha copiada com sucesso", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }else {
                Snackbar.make(it,"Você deve ativar ao menos uma opção", Snackbar.LENGTH_SHORT).show()
            }
        }
    }






}