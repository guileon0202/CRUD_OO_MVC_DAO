/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Vendas;
import util.Conexao;

public class VendasDAO {
    
    public void cadastrar(Vendas v) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into vendas (data_venda, valor_venda, cliente, produto, quantidade, forma_pagamento, status_venda, vendedor, canal_vendas) values (?,?,?,?,?,?,?,?,?)");
        comando.setString(1, v.getData_venda());
        comando.setDouble(2, v.getValor_venda());
        comando.setString(3, v.getCliente());
        comando.setString(4, v.getProduto());
        comando.setInt(5, v.getQuantidade());
        comando.setString(6, v.getForma_pagamento());
        comando.setString(7, v.getStatus_venda());
        comando.setString(8, v.getVendedor());
        comando.setString(9, v.getCanal_vendas());
        comando.execute();
        con.close();
    }
    
    public void deletar(Vendas v) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from vendas where id = ?");
        comando.setInt(1, v.getId());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Vendas v) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update vendas set data_venda = ?, valor_venda = ?, cliente = ?, produto = ?, quantidade = ?, forma_pagamento = ?, status_venda = ?, vendedor = ?, canal_vendas = ? where id = ?");
        comando.setString(1, v.getData_venda());
        comando.setDouble(2, v.getValor_venda());
        comando.setString(3, v.getCliente());
        comando.setString(4, v.getProduto());
        comando.setInt(5, v.getQuantidade());
        comando.setString(6, v.getForma_pagamento());
        comando.setString(7, v.getStatus_venda());
        comando.setString(8, v.getVendedor());
        comando.setString(9, v.getCanal_vendas());
        comando.setInt(10, v.getId());
        comando.execute();
        con.close();
    }
    
    public Vendas consultarById(Vendas v) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from vendas where id = ?");
        comando.setInt(1, v.getId());
        ResultSet rs = comando.executeQuery();
        Vendas vend = new Vendas();
        if (rs.next()){
            vend.setId(rs.getInt("id"));
            vend.setData_venda(rs.getString("data_venda"));
            vend.setValor_venda(rs.getDouble("valor_venda"));
            vend.setCliente(rs.getString("cliente"));
            vend.setProduto(rs.getString("produto"));
            vend.setQuantidade(rs.getInt("quantidade"));
            vend.setForma_pagamento(rs.getString("forma_pagamento"));
            vend.setStatus_venda(rs.getString("status_venda"));
            vend.setVendedor(rs.getString("vendedor"));
            vend.setCanal_vendas(rs.getString("canal_vendas")); 
        }        
        return vend;
    }
    
    public List<Vendas> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from vendas");
        ResultSet rs = comando.executeQuery();
        
        List<Vendas> lvend = new ArrayList<Vendas>();
        while(rs.next()){
            Vendas vend = new Vendas();
            vend.setId(rs.getInt("id"));
            vend.setData_venda(rs.getString("data_venda"));
            vend.setValor_venda(rs.getDouble("valor_venda"));
            vend.setCliente(rs.getString("cliente"));
            vend.setProduto(rs.getString("produto"));
            vend.setQuantidade(rs.getInt("quantidade"));
            vend.setForma_pagamento(rs.getString("forma_pagamento"));
            vend.setStatus_venda(rs.getString("status_venda"));
            vend.setVendedor(rs.getString("vendedor"));
            vend.setCanal_vendas(rs.getString("canal_vendas"));
            lvend.add(vend);
        }        
        return lvend;
    }
    
}
