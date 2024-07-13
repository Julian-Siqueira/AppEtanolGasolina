package devandroid.julian.appetanolgasolina

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isEmpty
import androidx.core.view.isInvisible
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

        //chamo o objeto btnCalcular e executo o metodo de "verificar se o botao foi clicado"
        btnCalcular.setOnClickListener {
            //crio o metodo calcularPreço
            calcularPreco()
        }
    }

    //crio a função do metodo calcular preço
    private fun calcularPreco() {

        //crio 2 variaveis para receber o editText do layout
        //faço um cast pra toString pois editAlcool.text é do tipo: Editable
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val CamposValidos = validarCampos(precoAlcool, precoGasolina)

        if(CamposValidos){
            //faco um cast pra toDouble, para calcular
            val Resultado =  precoAlcool.toDouble() / precoGasolina.toDouble()

            //esse calculo achei no google.
            if (Resultado >= 0.7){
                //seto a textResultado pra visible, para poder aparecer o text na View
                textResultado.visibility = View.VISIBLE
                textResultado.setText("Vale a pena abastecer com Gasolina")
            }else{
                textResultado.visibility = View.VISIBLE
                textResultado.setText("Vale a pena abastecer com Alcool")
            }
        }
    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        //inicio com o component input setando seu atributo para vazio.
        textInputAlcool.error = ""
        textInputGasolina.error = ""


        if(pAlcool.isEmpty()){
            //caso pAlcool não tenha nada, ele mostra o text abaixo
            textInputAlcool.error = "Digite o preço do alcool!"
            textResultado.visibility = View.INVISIBLE
            return false
        }else if (pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da Gasolina"
            textResultado.visibility = View.INVISIBLE
            return false
        }

        return true
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
        //setei a visibilidade da view pra invisivel, para nao aparecer nada.
        textResultado.visibility = View.INVISIBLE
    }
}