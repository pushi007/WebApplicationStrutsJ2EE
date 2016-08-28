package com.tvm.ilp.t154.cao.controllers;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.CountryReport;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.services.AccountServices;

/**
 * Servlet implementation class ChartController
 */
public class ChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountServices accService = new AccountServices();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/*
	 * public ChartController() { super(); // TODO Auto-generated constructor
	 * stub }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		String bname = null;
		HttpSession session = null;
		if ("viewPie".equals(action)) {
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			JDBCPieDataset dataset = null;
			dataset = accService.viewPie(month, year);
			request.setAttribute("dataset", dataset);
			final DefaultPieDataset data = (DefaultPieDataset) request
					.getAttribute("dataset");

			JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart ",
					data, true, true, false);
			chart.setTitle("Location wise percentage of customers");
			PiePlot plot = (PiePlot) chart.getPlot();
			PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
					"{0} = {2}", new DecimalFormat("0"), new DecimalFormat(
							"0.00%"));
			plot.setLabelGenerator(generator);

			try {
				final ChartRenderingInfo info = new ChartRenderingInfo(
						new StandardEntityCollection());

				response.setContentType("image/png");
				OutputStream out1 = response.getOutputStream();
				ChartUtilities.writeChartAsPNG(out1, chart, 650, 350, info);
				// ChartUtilities.saveChartAsPNG(file1, chart, 800, 350, info);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if ("viewBar".equals(action)) {
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			JDBCCategoryDataset dataset = null;
			dataset = accService.viewBar(month, year);
			request.setAttribute("dataset", dataset);
			final DefaultCategoryDataset data = (DefaultCategoryDataset) request
					.getAttribute("dataset");
			if (dataset.getRowCount() != 0) {

				JFreeChart chart = ChartFactory.createBarChart3D(
						"Location wise percentage of customers", "Country",
						"No of Customers", data, PlotOrientation.HORIZONTAL,
						true, true, false);
				chart.setBackgroundPaint(Color.white);

				// Set the background colour of the chart

				chart.getTitle().setPaint(Color.black);

				// Adjust the colour of the title

				CategoryPlot plot = chart.getCategoryPlot();

				// Get the Plot object for a bar graph

				plot.setBackgroundPaint(Color.white);
				plot.setRangeGridlinePaint(Color.blue);

				CategoryItemRenderer renderer = plot.getRenderer();

				renderer.setSeriesPaint(0, Color.blue);

				renderer.setSeriesPaint(1, Color.green);
				final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
				rangeAxis.setStandardTickUnits(NumberAxis
						.createIntegerTickUnits());
				// CategoryAxis domainAxis = plot.getDomainAxis();
				// domainAxis.setCategoryLabelPositions(
				// CategoryLabelPositions.createUpRotationLabelPositions(Math.PI
				// /
				// 2));

				try {
					final ChartRenderingInfo info = new ChartRenderingInfo(
							new StandardEntityCollection());
					/*
					 * final File file1 = new File(
					 * "C:/Documents and Settings/589768/Desktop/barchart.png");
					 */
					response.setContentType("image/png");
					OutputStream out1 = response.getOutputStream();
					ChartUtilities.writeChartAsPNG(out1, chart, 650, 350, info);
					// ChartUtilities.saveChartAsPNG(file1, chart, 800, 500,
					// info);
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		} else if ("viewPieCAO".equalsIgnoreCase(action)) {

			JDBCPieDataset dataset = null;
			JFreeChart chart = null;
			session = request.getSession();

			String chart1 = (String) session.getAttribute("chart1");

			if ("first".equalsIgnoreCase(chart1)) {
				bname = (String) session.getAttribute("bname");
				int npId = Integer.parseInt(bname);
				dataset = accService.viewPieCAO(npId);
				if (dataset.getItemCount() != 0) {
					request.setAttribute("dataset", dataset);

					final DefaultPieDataset data = (DefaultPieDataset) request
							.getAttribute("dataset");

					chart = ChartFactory.createPieChart3D("Pie Chart ", data,
							true, true, false);
					chart.setTitle("Customer wise percentage of Account type");
					PiePlot plot = (PiePlot) chart.getPlot();
					PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
							"{0} = {2}", new DecimalFormat("0"),
							new DecimalFormat("0.00%"));
					plot.setLabelGenerator(generator);
				}
			}

			else if ("second".equalsIgnoreCase(chart1)) {

				String month = (String) session.getAttribute("month");
				dataset = accService.viewPieCAOMonth(month);

				if (dataset.getItemCount() != 0) {
					request.setAttribute("dataset", dataset);

					final DefaultPieDataset data = (DefaultPieDataset) request
							.getAttribute("dataset");

					chart = ChartFactory.createPieChart3D("Pie Chart ", data,
							true, true, false);
					chart.setTitle("Year wise percentage of Account type");
					PiePlot plot = (PiePlot) chart.getPlot();
					PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
							"{0} = {2}", new DecimalFormat("0"),
							new DecimalFormat("0.00%"));
					plot.setLabelGenerator(generator);

				}

			}

			else if ("third".equalsIgnoreCase(chart1)) {
				String month = (String) session.getAttribute("month");
				String year = (String) session.getAttribute("year");
				dataset = accService.viewPieCAOYear(month, year);

				if (dataset.getItemCount() != 0) {
					request.setAttribute("dataset", dataset);

					final DefaultPieDataset data = (DefaultPieDataset) request
							.getAttribute("dataset");

					chart = ChartFactory.createPieChart3D("Pie Chart ", data,
							true, true, false);
					chart
							.setTitle("Month and year wise percentage of Account type");
					PiePlot plot = (PiePlot) chart.getPlot();
					PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
							"{0} = {2}", new DecimalFormat("0"),
							new DecimalFormat("0.00%"));
					plot.setLabelGenerator(generator);
				}
			}

			try {
				final ChartRenderingInfo info = new ChartRenderingInfo(
						new StandardEntityCollection());

				response.setContentType("image/png");
				OutputStream out1 = response.getOutputStream();
				ChartUtilities.writeChartAsPNG(out1, chart, 800, 350, info);
				// ChartUtilities.saveChartAsPNG(file1, chart, 800, 350, info);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		else if ("viewBarCAO".equalsIgnoreCase(action)) {

			JDBCCategoryDataset dataset = null;
			JFreeChart chart = null;
			session = request.getSession();
			bname = (String) session.getAttribute("bname");
			int npId = Integer.parseInt(bname);
			String chart1 = (String) session.getAttribute("chart1");

			if ("first".equalsIgnoreCase(chart1)) {

				dataset = accService.viewBarCAO(npId);
				if (dataset.getRowCount() != 0) {
					request.setAttribute("dataset", dataset);

					final DefaultCategoryDataset data = (DefaultCategoryDataset) request
							.getAttribute("dataset");

					chart = ChartFactory.createBarChart3D(
							"Customer wise number of Account type",
							"Account Name", "No of Accounts", data,
							PlotOrientation.VERTICAL, true, true, false);
					chart.setBackgroundPaint(Color.white);

					// Set the background colour of the chart

					chart.getTitle().setPaint(Color.black);

					// Adjust the colour of the title

					CategoryPlot plot = chart.getCategoryPlot();

					// Get the Plot object for a bar graph

					plot.setBackgroundPaint(Color.white);
					plot.setRangeGridlinePaint(Color.blue);

					CategoryItemRenderer renderer = plot.getRenderer();

					renderer.setSeriesPaint(0, Color.blue);

					renderer.setSeriesPaint(1, Color.green);
					final NumberAxis rangeAxis = (NumberAxis) plot
							.getRangeAxis();
					rangeAxis.setStandardTickUnits(NumberAxis
							.createIntegerTickUnits());

				}
			}

			else if ("second".equalsIgnoreCase(chart1)) {

				String month = (String) session.getAttribute("month");
				dataset = accService.viewBarCAOMonth(month);
				if (dataset.getRowCount() != 0) {
					request.setAttribute("dataset", dataset);

					final DefaultCategoryDataset data = (DefaultCategoryDataset) request
							.getAttribute("dataset");

					chart = ChartFactory.createBarChart3D(
							"Year wise number of Account type",
							"Account Name", "No of Accounts", data,
							PlotOrientation.VERTICAL, true, true, false);
					chart.setBackgroundPaint(Color.white);

					// Set the background colour of the chart

					chart.getTitle().setPaint(Color.black);

					// Adjust the colour of the title

					CategoryPlot plot = chart.getCategoryPlot();

					// Get the Plot object for a bar graph

					plot.setBackgroundPaint(Color.white);
					plot.setRangeGridlinePaint(Color.blue);

					CategoryItemRenderer renderer = plot.getRenderer();

					renderer.setSeriesPaint(0, Color.blue);

					renderer.setSeriesPaint(1, Color.green);
					final NumberAxis rangeAxis = (NumberAxis) plot
							.getRangeAxis();
					rangeAxis.setStandardTickUnits(NumberAxis
							.createIntegerTickUnits());

				}
			}

			else if ("third".equalsIgnoreCase(chart1)) {
				String month = (String) session.getAttribute("month");
				String year = (String) session.getAttribute("year");
				dataset = accService.viewBarCAOYear(month, year);

				if (dataset.getRowCount() != 0) {
					request.setAttribute("dataset", dataset);

					final DefaultCategoryDataset data = (DefaultCategoryDataset) request
							.getAttribute("dataset");

					chart = ChartFactory.createBarChart3D(
							"Month and Year wise number of Account type",
							"Account Name", "No of Accounts", data,
							PlotOrientation.VERTICAL, true, true, false);
					chart.setBackgroundPaint(Color.white);

					// Set the background colour of the chart

					chart.getTitle().setPaint(Color.black);

					// Adjust the colour of the title

					CategoryPlot plot = chart.getCategoryPlot();

					// Get the Plot object for a bar graph

					plot.setBackgroundPaint(Color.white);
					plot.setRangeGridlinePaint(Color.blue);

					CategoryItemRenderer renderer = plot.getRenderer();

					renderer.setSeriesPaint(0, Color.blue);

					renderer.setSeriesPaint(1, Color.green);
					final NumberAxis rangeAxis = (NumberAxis) plot
							.getRangeAxis();
					rangeAxis.setStandardTickUnits(NumberAxis
							.createIntegerTickUnits());
				}

			}

			try {
				final ChartRenderingInfo info = new ChartRenderingInfo(
						new StandardEntityCollection());
				/*
				 * final File file1 = new File(
				 * "C:/Documents and Settings/589768/Desktop/barchart.png");
				 */
				response.setContentType("image/png");
				OutputStream out1 = response.getOutputStream();
				ChartUtilities.writeChartAsPNG(out1, chart, 800, 250, info);
				// ChartUtilities.saveChartAsPNG(file1, chart, 800, 500, info);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else if ("viewChart".equalsIgnoreCase(action)) {
			List<String> businessNames = new ArrayList<String>();
			try {
				businessNames = accService.getBNames();
			} catch (CommercialCustRegException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bnames", businessNames);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/viewChart.jsp");
			rd.forward(request, response);
		}

		else if ("viewChartEmp".equalsIgnoreCase(action)) {
			List<NonPersonalCustomer> businessNames = new ArrayList<NonPersonalCustomer>();
			try {
				businessNames = accService.getBusinessNameAndId();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// request.setAttribute("bnames", businessNames);

			String type = request.getParameter("type");
			session = request.getSession();
			session.setAttribute("bnames", businessNames);
			session.setAttribute("type", type);
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/viewChartEmp.jsp");
			rd.forward(request, response);
		}

		else if (action.equals("generatePie")) {
			response.sendRedirect(request.getContextPath()
					+ "/jsp/PieChart.jsp");
		} else if (action.equals("generateBar")) {
			response.sendRedirect(request.getContextPath()
					+ "/jsp/BarChart.jsp");
		}

		else if (action.equals("generateBarCAO")) {
			session = request.getSession();
			String bname1 = (String)session.getAttribute("bname");
			AccountServices acServices = new AccountServices();
			String chart = (String) session.getAttribute("chart1");
			session = request.getSession();
			int npId = Integer.parseInt(bname1);

			List<NonPersonalCustomer> npList = acServices
					.getBusinessNameAndId();
			String name = null;

			for (NonPersonalCustomer npCust : npList) {
				if (npCust.getBusinessId() == npId) {
					name = npCust.getBusinessName();
				}
			}
			session.setAttribute("name",name);
			session.setAttribute("chart", chart);
			response.sendRedirect(request.getContextPath()
					+ "/jsp/BarChartForCAO.jsp");

		}

		else if (action.equals("generatePieCAO")) {
			String chart = request.getParameter("chart");
			AccountServices acServices = new AccountServices();
			if ("first".equalsIgnoreCase(chart)) {
				bname = request.getParameter("bname");
				session = request.getSession();
				int npId = Integer.parseInt(bname);

				List<NonPersonalCustomer> npList = acServices
						.getBusinessNameAndId();
				String name = null;

				for (NonPersonalCustomer npCust : npList) {
					if (npCust.getBusinessId() == npId) {
						name = npCust.getBusinessName();
					}
				}
				session.setAttribute("name",name);
				session.setAttribute("bname", bname);
				session.setAttribute("chart1", "first");
				response.sendRedirect(request.getContextPath()
						+ "/jsp/PieChartCAO.jsp");
			} else if ("second".equalsIgnoreCase(chart)) {
				// bname = request.getParameter("bname2");
				String month = request.getParameter("month");

				session = request.getSession();
				// session.setAttribute("bname", bname);
				session.setAttribute("chart1", "second");
				session.setAttribute("month", month);

				response.sendRedirect(request.getContextPath()
						+ "/jsp/PieChartCAO.jsp");
			} else if ("third".equalsIgnoreCase(chart)) {
				// bname = request.getParameter("bname3");
				String month = request.getParameter("monthY");
				String year = request.getParameter("year");
				session = request.getSession();
				// session.setAttribute("bname", bname);
				session.setAttribute("chart1", "third");
				session.setAttribute("month", month);
				session.setAttribute("year", year);
				response.sendRedirect(request.getContextPath()
						+ "/jsp/PieChartCAO.jsp");
			}

		} else if (action.equals("generatePieCAONew")) {

			session = request.getSession();
			String bname1 = (String) session.getAttribute("bname");
			session = request.getSession();
			session.setAttribute("bname", bname1);

			response.sendRedirect(request.getContextPath()
					+ "/jsp/PieChartCAO.jsp");
		} else if (action.equals("chart")) {
			String month = request.getParameter("month");
			String year = request.getParameter("year");

			if (request.getParameter("choice").equals("bar")) {
				request.setAttribute("month", month);
				request.setAttribute("year", year);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/BarChart.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("choice").equals("pie")) {
				request.setAttribute("month", month);
				request.setAttribute("year", year);

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/PieChart.jsp");
				rd.forward(request, response);
			} else if (request.getParameter("choice").equals("pdf")) {

				List<CountryReport> countryList = new ArrayList<CountryReport>();
				PdfPTable table = new PdfPTable(2);

				countryList = accService.getCountryDetails(month, year);
				String heading = "Location wise report of Business Customers";
				if (countryList.size() != 0) {
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"attachment; filename=\"report.pdf\"");
					Document document = new Document();

					try {
						PdfWriter.getInstance(document, response
								.getOutputStream());

						// step 3
						document.open();
						// step 4

						Font fontbold = FontFactory.getFont("Arial", 35,
								Font.BOLD);

						Paragraph paragraph = new Paragraph(
								"Nexus Banking Group ", fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);

						paragraph.setFont(fontbold);

						document.add(paragraph);
						document.add(new Paragraph(""));
						fontbold = FontFactory
								.getFont("Arial", 20, Font.NORMAL);
						paragraph = new Paragraph("\n\nGeneral Report",
								fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);
						document.add(paragraph);
						paragraph = new Paragraph("on", fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);
						document.add(paragraph);

						paragraph = new Paragraph(heading, fontbold);

						paragraph.setAlignment(Element.ALIGN_CENTER);

						document.add(paragraph);

						String ticketMonth = null;
						if (month.equals("1"))
							ticketMonth = "January";
						else if (month.equals("2"))
							ticketMonth = "February";
						else if (month.equals("3"))
							ticketMonth = "March";
						else if (month.equals("4"))
							ticketMonth = "April";
						else if (month.equals("5"))
							ticketMonth = "May";
						else if (month.equals("6"))
							ticketMonth = "June";
						else if (month.equals("7"))
							ticketMonth = "July";
						else if (month.equals("8"))
							ticketMonth = "August";
						else if (month.equals("9"))
							ticketMonth = "September";
						else if (month.equals("10"))
							ticketMonth = "October";
						else if (month.equals("11"))
							ticketMonth = "November";
						else if (month.equals("12"))
							ticketMonth = "December";

						paragraph = new Paragraph("in " + ticketMonth + " "
								+ year, fontbold);
						paragraph.setAlignment(Element.ALIGN_CENTER);
						document.add(paragraph);
						int total = 0;
						float percentage = 0;
						for (CountryReport c : countryList) {
							total = c.getCount() + total;
						}

						document.add(new Paragraph("\n\n"));

						table.setWidthPercentage(95);
						table.setWidths(new int[] { 1, 1 });
						PdfPCell cell;

						/*
						 * cell = new PdfPCell(new
						 * Phrase("Total no of accounts")); cell.setColspan(1);
						 * table.addCell(cell);
						 * 
						 * cell = new PdfPCell(new Phrase("" +total)); //
						 * cell.setColspan(3); table.addCell(cell);
						 */
						cell = new PdfPCell(new Phrase(
								"Country Of Registration"));

						table.addCell(cell);
						cell = new PdfPCell(new Phrase("Count of Customers"));

						table.addCell(cell);
						for (CountryReport c : countryList) {
							cell.setRowspan(2);
							percentage = ((c.getCount() * 100) / (float) total);
							cell = new PdfPCell(new Phrase(c.getCountry()));

							table.addCell(cell);
							cell = new PdfPCell(new Phrase("" + c.getCount()
									+ " " + "(" + percentage + "%)"));

							table.addCell(cell);

						}

						document.add(table);
						document.close();

					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		}
	}

}
