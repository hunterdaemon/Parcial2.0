/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.ColmenaDao;
import edu.co.sergio.mundo.vo.Visitas_Tecnicas;
import edu.co.sergio.mundo.vo.Colmena;
import edu.co.sergio.mundo.vo.Recoleccion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

public class ChartServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            response.setContentType("image/png");
            OutputStream outputStream = response.getOutputStream();
            JFreeChart chart = getChart();
            chart = getChart();
            int width = 500;
            int height = 350;
            ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
            
		

	}
        
	public JFreeChart getChart() {
		
                DefaultPieDataset dataset = new DefaultPieDataset();
	        //Crear la capa de servicios que se enlace con el DAO
                List <Colmena>c=new LinkedList<Colmena>();
                ColmenaDao dep=new ColmenaDao();
                c= dep.findAll();
               
            
                dataset.setValue("Panal con alimento",c.get(1).getPanal_Alimento());
                
            
		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("Informacion Panal Colmena", dataset, legend, tooltips, urls);

		chart.setBorderPaint(Color.GREEN);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);

		return chart;
	}

}
