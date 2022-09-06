package chart;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StudentScoreChart extends ApplicationFrame{

	private static final long serialVersionUID = 1L;
	public StudentScoreChart(String title, String chartTitle) {
		super(title);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "Student ID", "Scores", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		FileTest test = new FileTest();
		try {
		ArrayList<String[]> rows = test.readCSVFile();
		for(int i=1; i<rows.size(); i++) {
			dataset.addValue(Integer.parseInt(rows.get(i)[3]),"Scores",rows.get(i)[1]);
		}
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return dataset;
	}
	public static void main(String[] args) {
		StudentScoreChart chart = new StudentScoreChart("Huaxia Student Score", "Student ID vs Scores");

		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);

	}

}
