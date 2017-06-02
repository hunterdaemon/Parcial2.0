/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.ColmenaDao;
import edu.co.sergio.mundo.dao.Conexion;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author David
 */
@WebServlet(name = "graficoTorta", urlPatterns = {"/graficoTorta"})
public class graficoTorta extends HttpServlet {

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
        
        response.setContentType("image/PNG");
        OutputStream out = response.getOutputStream();
        
        try {
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ResultSet rs = null;
            PreparedStatement ps = null;
            
            int inf = 0;
            
            try{
                
                ps = connection.prepareStatement("SELECT * from Colmenas");
                rs = ps.executeQuery();
                
                DefaultPieDataset data = new DefaultPieDataset();
                while(rs.next()){
                   data.setValue(rs.getInt(10)+": "+rs.getInt(1), rs.getInt(1));
                }
 
                    JFreeChart cha = ChartFactory.createPieChart3D("Etapas de la Vida",data, true, true, true);
                    
                    int ancho = 750;
                    int alto = 600;
                    
                    final PiePlot3D plot = (PiePlot3D)cha.getPlot();
                    plot.setStartAngle(270);
                    plot.setForegroundAlpha(0.80f);
                    plot.setInteriorGap(0.03);
                    
                    ChartUtilities.writeChartAsPNG(out, cha, ancho, alto);
                    
                    ps.close();
                    rs.close();
                    Conexion.closeConnection();
                
            }catch(Exception ex){
            }
            
        } finally {
            out.close();
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
