package devandroid.julian.appetanolgasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    /*
    criaçao de variaveis que vao ser utilizadas posteriormente
    private, pois elas so vao ser acessadas pela MainActivity
    lateinit var, pois quero que elas inicializem quando a tela for criada
    */
    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button

    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //criar o método inicializacaoDeComponentes
        inicializarComponentesInterface()
    }

    //crio a funçao do método
    private fun inicializarComponentesInterface() {


        //aqui eu LINKO as variaveis que criei como lateinit, com os ids dos componentes do layout.


        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_text_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_text_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)

        textResultado = findViewById(R.id.text_view_resultado)
    }
}