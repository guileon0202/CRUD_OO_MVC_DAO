/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author leong
 */
public class Vendas {
    
    private int id;
    private String data_venda;
    private double valor_venda;
    private String cliente;
    private String produto;
    private int quantidade;
    private  String forma_pagamento;
    private  String status_venda ;
    private String vendedor; 
    private String canal_vendas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public String getStatus_venda() {
        return status_venda;
    }

    public void setStatus_venda(String status_venda) {
        this.status_venda = status_venda;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCanal_vendas() {
        return canal_vendas;
    }

    public void setCanal_vendas(String canal_vendas) {
        this.canal_vendas = canal_vendas;
    }   
       
}
