package org.silvasoft.tools.resizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NameNotFoundException;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

public class MainWindow {

	private JFrame frmResizeTool;
	private JTextField xTextField;
	private JTextField wTextField;
	private JTextField yTextField;
	private JTextField hTextFiled;
	private JTextField windowTitleField;
	private JCheckBox chckbxNewCheckBox;
	private JList<ResizeData> list;

	/**
	 * Launch the application.
	 * 
	 * @throws ClassNotFoundException
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args)
			throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		setSystemLookAndFeel();

		EventQueue.invokeLater(() -> {
			try {
				MainWindow window = new MainWindow();
				window.frmResizeTool.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws UnsupportedLookAndFeelException
	 */
	private static void setSystemLookAndFeel()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Class lnfClass = Class.forName(UIManager.getSystemLookAndFeelClassName(), true,
				Thread.currentThread().getContextClassLoader());

		LookAndFeel newInstance = (LookAndFeel) lnfClass.newInstance();

		UIManager.setLookAndFeel(newInstance);
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResizeTool = new JFrame();
		frmResizeTool.setTitle("Resize Tool");
		frmResizeTool.setBounds(100, 100, 500, 250);
		frmResizeTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		JPanel configurationPanel = initConfigPanel();
		list = initList();

		frmResizeTool.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.add(configurationPanel);
		mainPanel.add(list);

		SpringLayout layout = new SpringLayout();

		layout.putConstraint(SpringLayout.NORTH, configurationPanel, 0, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.WEST, configurationPanel, 5, SpringLayout.WEST, mainPanel);
		layout.putConstraint(SpringLayout.SOUTH, configurationPanel, 0, SpringLayout.SOUTH, mainPanel);

		layout.putConstraint(SpringLayout.WEST, list, 5, SpringLayout.EAST, configurationPanel);
		layout.putConstraint(SpringLayout.NORTH, list, 5, SpringLayout.NORTH, mainPanel);
		layout.putConstraint(SpringLayout.SOUTH, list, 5, SpringLayout.SOUTH, mainPanel);
		layout.putConstraint(SpringLayout.EAST, list, 5, SpringLayout.EAST, mainPanel);
		mainPanel.setLayout(layout);
	}

	/**
	 * @return
	 */
	private JPanel initConfigPanel() {

		JPanel configurationPanel = new JPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 90, 90, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 20, 20, 20, 20, 20, 20, 0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		configurationPanel.setLayout(gridBagLayout);

		JLabel xLabel = new JLabel("X");
		xLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_xLabel = new GridBagConstraints();
		gbc_xLabel.anchor = GridBagConstraints.NORTH;
		gbc_xLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_xLabel.insets = new Insets(10, 0, 5, 5);
		gbc_xLabel.gridx = 0;
		gbc_xLabel.gridy = 0;
		configurationPanel.add(xLabel, gbc_xLabel);

		JLabel lblY = new JLabel("Y");
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.anchor = GridBagConstraints.NORTH;
		gbc_lblY.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblY.insets = new Insets(10, 0, 5, 0);
		gbc_lblY.gridx = 1;
		gbc_lblY.gridy = 0;
		configurationPanel.add(lblY, gbc_lblY);

		xTextField = new JTextField();
		xTextField.setText("0");
		xTextField.setColumns(10);
		GridBagConstraints gbc_xTextField = new GridBagConstraints();
		gbc_xTextField.insets = new Insets(0, 0, 5, 5);
		gbc_xTextField.gridx = 0;
		gbc_xTextField.gridy = 1;
		configurationPanel.add(xTextField, gbc_xTextField);

		yTextField = new JTextField();
		yTextField.setText("0");
		yTextField.setColumns(10);
		GridBagConstraints gbc_yTextField = new GridBagConstraints();
		gbc_yTextField.insets = new Insets(0, 0, 5, 0);
		gbc_yTextField.gridx = 1;
		gbc_yTextField.gridy = 1;
		configurationPanel.add(yTextField, gbc_yTextField);

		JLabel lblNewLabel_1 = new JLabel("Width");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		configurationPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHeight.insets = new Insets(0, 0, 5, 0);
		gbc_lblHeight.gridx = 1;
		gbc_lblHeight.gridy = 2;
		configurationPanel.add(lblHeight, gbc_lblHeight);

		wTextField = new JTextField();
		wTextField.setText("1024");
		wTextField.setColumns(10);
		GridBagConstraints gbc_wTextField = new GridBagConstraints();
		gbc_wTextField.insets = new Insets(0, 0, 5, 5);
		gbc_wTextField.gridx = 0;
		gbc_wTextField.gridy = 3;
		configurationPanel.add(wTextField, gbc_wTextField);

		hTextFiled = new JTextField();
		hTextFiled.setText("800");
		hTextFiled.setColumns(10);
		GridBagConstraints gbc_hTextFiled = new GridBagConstraints();
		gbc_hTextFiled.insets = new Insets(0, 0, 5, 0);
		gbc_hTextFiled.gridx = 1;
		gbc_hTextFiled.gridy = 3;
		configurationPanel.add(hTextFiled, gbc_hTextFiled);

		JLabel lblTitle = new JLabel("Window Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 2;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 4;
		configurationPanel.add(lblTitle, gbc_lblTitle);

		windowTitleField = new JTextField();
		windowTitleField.setText("....");
		windowTitleField.setColumns(10);
		GridBagConstraints gbc_windowTitleField = new GridBagConstraints();
		gbc_windowTitleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_windowTitleField.insets = new Insets(0, 0, 5, 0);
		gbc_windowTitleField.gridwidth = 2;
		gbc_windowTitleField.gridx = 0;
		gbc_windowTitleField.gridy = 5;
		configurationPanel.add(windowTitleField, gbc_windowTitleField);

		chckbxNewCheckBox = new JCheckBox("Show");
		chckbxNewCheckBox.setSelected(true);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 6;
		configurationPanel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		JButton btnResize = new JButton("Resize");
		btnResize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ResizeData data = collectData();
				if (data != null)
					try {

						resize(data);
						addToList(data);
					} catch (NameNotFoundException e1) {
						JOptionPane.showMessageDialog(frmResizeTool, "Window \"" + data.getWindowName() + "\" not found ");
						e1.printStackTrace();
					}

			}

		});
		GridBagConstraints gbc_btnResize = new GridBagConstraints();
		gbc_btnResize.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnResize.gridx = 1;
		gbc_btnResize.gridy = 6;
		configurationPanel.add(btnResize, gbc_btnResize);

		return configurationPanel;

	}

	/**
	 * @return
	 * 
	 */
	private JList<ResizeData> initList() {

		DefaultListModel<ResizeData> dataModel = new DefaultListModel<ResizeData>();
		fillWithDefaultData(dataModel);
		JList<ResizeData> list = new JList<ResizeData>(dataModel);
		list.setBorder(new TitledBorder(null, "Previous values", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		new ListAction(list, new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JList<ResizeData> list = (JList<ResizeData>) e.getSource();
				ResizeData selectedValue = list.getSelectedValue();
				if (selectedValue != null) {
					try {
						resize(selectedValue);
						fillData(selectedValue);
					} catch (NameNotFoundException e1) {
						JOptionPane.showMessageDialog(frmResizeTool,
								"Window \"" + selectedValue.getWindowName() + "\" not found ");

						e1.printStackTrace();
					}
				}
			}
		});
		return list;
	}

	private void fillWithDefaultData(DefaultListModel<ResizeData> dataModel) {
		dataModel.addElement(new ResizeData("Kalkulator", 0, 0, 800, 600, true));
		dataModel.addElement(new ResizeData("Kalkulator", 0, 0, 1024, 768, true));
		dataModel.addElement(new ResizeData("Kalkulator", 0, 0, 1024, 1028, true));

	}

	protected ResizeData collectData() {

		try {
			String windowName = windowTitleField.getText();
			int x = Integer.parseInt(xTextField.getText());
			int y = Integer.parseInt(yTextField.getText());
			int h = Integer.parseInt(hTextFiled.getText());
			int w = Integer.parseInt(wTextField.getText());
			boolean show = chckbxNewCheckBox.isSelected();
			return new ResizeData(windowName, x, y, h, w, show);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void fillData(ResizeData data) {
		xTextField.setText("" + data.getX());
		yTextField.setText("" + data.getY());
		wTextField.setText("" + data.getW());
		hTextFiled.setText("" + data.getH());

		windowTitleField.setText(data.getWindowName());
		chckbxNewCheckBox.setSelected(data.isShow());
	}

	private void resize(ResizeData data) throws NameNotFoundException {
		ResizeUtils.resizeWindow(data.getWindowName(), data.getX(), data.getY(), data.getW(), data.getH(), data.isShow());
	}

	private void addToList(ResizeData data) {

		DefaultListModel<ResizeData> defaultListModel = (DefaultListModel<ResizeData>) list.getModel();
		if (!defaultListModel.contains(data)) {
			defaultListModel.addElement(data);
		}
	}
}
