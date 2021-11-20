package com.thiago.listadeprodutos.ui.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thiago.listadeprodutos.R
import com.thiago.listadeprodutos.models.Produto

class ListaProdutosAdapter(
    private val produtos: List<Produto>,
    private val context: Context
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincular(produtos: Produto) {
            itemView.findViewById<TextView>(R.id.item).text = produtos.nome

            itemView.findViewById<TextView>(R.id.item_preco).text = produtos.preco

            itemView.findViewById<TextView>(R.id.item_descricao).text = produtos.descricao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_produto, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincular(produtos[position])
    }

    override fun getItemCount(): Int = produtos.size
}