package cn.edu.tsinghua.thss.datamining.knn.core.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class KnnFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JFileChooser trainfc;
	private JFileChooser testfc;
	private JTextField kinput;
	private JComboBox weightchooser;

	private String train_file;
	private String test_file;
	private int k;
	private int weight_type;

	public KnnFrame() {
		this.setTitle("KNN Classifier");
		this.setSize(new Dimension(600, 600));
		this.setLocation(200, 50);
		this.setLayout(new BorderLayout());
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		JPanel inputPanel = new JPanel();

		JButton trainfcbutton = new JButton("Select training file");
		JButton testfcbutton = new JButton("Select testing file");
		trainfc = new JFileChooser();
		testfc = new JFileChooser();
		FileFilter arfffilter = new FileNameExtensionFilter("arff files",
				"arff");
		trainfc.addChoosableFileFilter(arfffilter);
		testfc.addChoosableFileFilter(arfffilter);
		trainfcbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ret = trainfc.showDialog(null, "Open file");
				if (ret == JFileChooser.APPROVE_OPTION) {
					train_file = trainfc.getSelectedFile().getAbsolutePath();
					System.out.println("Training file:" + train_file);
				}
			}
		});
		testfcbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ret = testfc.showDialog(null, "Open file");

				if (ret == JFileChooser.APPROVE_OPTION) {
					test_file = testfc.getSelectedFile().getAbsolutePath();
					System.out.println("Testing file:" + test_file);
				}
			}
		});

		inputPanel.add(trainfcbutton, new Dimension(10, 20));
		inputPanel.add(testfcbutton, new Dimension(60, 20));

		this.add(inputPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		KnnFrame mainframe = new KnnFrame();
	}
}
