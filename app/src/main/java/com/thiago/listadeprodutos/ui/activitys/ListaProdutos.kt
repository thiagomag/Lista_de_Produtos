package com.thiago.listadeprodutos.ui.activitys

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thiago.listadeprodutos.R
import com.thiago.listadeprodutos.dao.ProdutoDao
import com.thiago.listadeprodutos.ui.components.ListaProdutosAdapter

class ListaProdutos : AppCompatActivity(R.layout.activity_lista_produtos) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onResume() {
        super.onResume()
        configRecycleView()
        configBotaoSalvar()
    }

    private fun configBotaoSalvar() {
        findViewById<RecyclerView>(R.id.lista_produtos)
            .adapter = ListaProdutosAdapter(ProdutoDao().buscarProdutos(), this)
    }

    private fun configRecycleView() {
        findViewById<FloatingActionButton>(R.id.btn_add_tarefa)
            .setOnClickListener {
                val intent = Intent(this, FormularioProdutos::class.java)
                startActivity(intent)
            }
    }
}