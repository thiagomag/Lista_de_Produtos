package com.thiago.listadeprodutos.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.thiago.listadeprodutos.R
import com.thiago.listadeprodutos.dao.ProdutoDao
import com.thiago.listadeprodutos.models.Produto

class FormularioProdutos : AppCompatActivity(R.layout.activity_formulario_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configSaveButton()
    }

    private fun configSaveButton() {

        findViewById<Button>(R.id.form_btn_salvar)
                .setOnClickListener {
            saveProduct()
        }
    }

    private fun saveProduct() {
        val nome = findViewById<EditText>(R.id.form_nome).text.toString()
        val descricao = findViewById<EditText>(R.id.form_descricao).text.toString()
        val preco = findViewById<EditText>(R.id.form_price).text.toString()

        val novoProduto = Produto(nome, descricao, preco)
        ProdutoDao().salvar(novoProduto)

        AlertDialog.Builder(this)
            .setTitle("Adicionado com sucesso")
            .setMessage("Produto $nome adicionada com sucesso")
            .setPositiveButton("Ok"){_,_ ->  finish() }
            .show()
    }
}