/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.VendasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vendas;

/**
 *
 * @author leong
 */

@WebServlet(name = "Proj_vendas", urlPatterns = {"/controle_vendas"})
public class controle_vendas extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your pageh ere. You may use following sample code. */

            String op = request.getParameter("op");
            VendasDAO vdao = new VendasDAO();
            Vendas v = new Vendas();

            if (op.equals("CADASTRAR")) {
                String data_venda = request.getParameter("txtdata_venda");
                double valor_venda = Double.parseDouble(request.getParameter("txtvalor_venda"));
                String cliente = request.getParameter("txtcliente");
                String produto = request.getParameter("txtproduto");
                int quantidade = Integer.parseInt(request.getParameter("txtquantidade"));
                String forma_pagamento = request.getParameter("txtforma_pagamento");
                String status_venda = request.getParameter("txtstatus_venda");
                String vendedor = request.getParameter("txtvendedor");
                String canal_vendas = request.getParameter("txtcanal_vendas");
                v.setData_venda(data_venda);
                v.setValor_venda(valor_venda);
                v.setCliente(cliente);
                v.setProduto(produto);
                v.setQuantidade(quantidade);
                v.setForma_pagamento(forma_pagamento);
                v.setStatus_venda(status_venda);
                v.setVendedor(vendedor);
                v.setCanal_vendas(canal_vendas);
                
                String msg = "Cadastrar";
                try {
                    vdao.cadastrar(v);
                    System.out.println("Cadastrado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);

                }
                } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                v.setId(id);
                String msg = "Deletar";
                try {
                    vdao.deletar(v);
                    List<Vendas> lvend = vdao.consultarTodos();
                    request.setAttribute("lvend", lvend);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
                } else if (op.equals("CONSULTAR BY ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                v.setId(id);
                try {
                    v = vdao.consultarById(v);
                    request.setAttribute("v", v);
                    request.getRequestDispatcher("resultadoconsultarbyid.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
                } else if (op.equals("CONSULTAR TODOS")) {
                try {
                    List<Vendas> lvend = vdao.consultarTodos();
                    request.setAttribute("lvend", lvend);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
                 } else if (op.equals("ATUALIZAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                v.setId(id);
                try {
                    v = vdao.consultarById(v);
                    request.setAttribute("v", v);
                    request.getRequestDispatcher("resultadoconsultaratualizar.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
                } else if (op.equals("EFETIVAR ATUALIZAÇÃO")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                String data_venda = request.getParameter("txtdata_venda");
                double valor_venda = Double.parseDouble(request.getParameter("txtvalor_venda"));
                String cliente = request.getParameter("txtcliente");
                String produto = request.getParameter("txtproduto");
                int quantidade = Integer.parseInt(request.getParameter("txtquantidade"));
                String forma_pagamento = request.getParameter("txtforma_pagamento");
                String status_venda = request.getParameter("txtstatus_venda");
                String vendedor = request.getParameter("txtvendedor");
                String canal_vendas = request.getParameter("txtcanal_vendas");
                v.setId(id);
                v.setData_venda(data_venda);
                v.setValor_venda(valor_venda);
                v.setCliente(cliente);
                v.setProduto(produto);
                v.setQuantidade(quantidade);
                v.setForma_pagamento(forma_pagamento);
                v.setStatus_venda(status_venda);
                v.setVendedor(vendedor);
                v.setCanal_vendas(canal_vendas);
                String msg = "Atualizar";
                try {
                    vdao.atualizar(v);
                    System.out.println("Atuaizado com sucesso!!");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            }

        }
    }
        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
