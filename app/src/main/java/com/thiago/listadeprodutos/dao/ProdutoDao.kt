package com.thiago.listadeprodutos.dao

import com.thiago.listadeprodutos.models.Produto

class ProdutoDao {

    fun salvar(produto: Produto) {
        produtos.add(produto)
    }

    fun buscarProdutos() : List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}