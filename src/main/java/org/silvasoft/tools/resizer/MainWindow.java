package org.silvasoft.tools.resizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NameNotFoundException;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
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
	private JPanel panel_1;

	/**
	 * Launch the application.
	 * 
	 * @throws ClassNotFoundException
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException,
			IllegalAccessException {

		Class lnfClass = Class.forName(UIManager.getSystemLookAndFeelClassName(), true, Thread.currentThread().getContextClassLoader());

		LookAndFeel newInstance = (LookAndFeel) lnfClass.newInstance();

		UIManager.setLookAndFeel(newInstance);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmResizeTool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmResizeTool.setBounds(100, 100, 516, 239);
		frmResizeTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultListModel<ResizeData> dataModel = new DefaultListModel<ResizeData>();
		fillWithDefaultData(dataModel);

		panel_1 = new JPanel();
		frmResizeTool.getContentPane().add(panel_1, BorderLayout.CENTER);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		JPanel panel = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel, 196, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel, 210, SpringLayout.WEST, panel_1);
		panel_1.add(panel);

		xTextField = new JTextField();
		xTextField.setText("0");
		xTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		wTextField = new JTextField();
		wTextField.setText("1024");
		wTextField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Width");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

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

		yTextField = new JTextField();
		yTextField.setText("0");
		yTextField.setColumns(10);

		JLabel lblY = new JLabel("Y");
		lblY.setHorizontalAlignment(SwingConstants.CENTER);

		hTextFiled = new JTextField();
		hTextFiled.setText("800");
		hTextFiled.setColumns(10);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);

		chckbxNewCheckBox = new JCheckBox("Show");
		chckbxNewCheckBox.setSelected(true);

		windowTitleField = new JTextField();
		windowTitleField.setText("....");
		windowTitleField.setColumns(10);

		JLabel lblTitle = new JLabel("Window Title");

		JList list_1 = new JList();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(Alignment.TRAILING)
												.addGroup(
														gl_panel.createSequentialGroup().addComponent(lblTitle)
																.addContainerGap(514, Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(Alignment.LEADING)
																				.addComponent(windowTitleField, GroupLayout.DEFAULT_SIZE,
																						337, Short.MAX_VALUE)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(chckbxNewCheckBox)
																								.addPreferredGap(
																										ComponentPlacement.RELATED, 223,
																										Short.MAX_VALUE)
																								.addComponent(btnResize))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addGroup(
																										gl_panel.createParallelGroup(
																												Alignment.LEADING)
																												.addGroup(
																														gl_panel.createParallelGroup(
																																Alignment.LEADING,
																																false)
																																.addComponent(
																																		xTextField)
																																.addComponent(
																																		lblNewLabel,
																																		Alignment.TRAILING,
																																		GroupLayout.DEFAULT_SIZE,
																																		GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE))
																												.addComponent(
																														lblNewLabel_1,
																														GroupLayout.DEFAULT_SIZE,
																														245,
																														Short.MAX_VALUE)
																												.addComponent(
																														wTextField,
																														GroupLayout.PREFERRED_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(ComponentPlacement.RELATED)
																								.addGroup(
																										gl_panel.createParallelGroup(
																												Alignment.TRAILING)
																												.addGroup(
																														gl_panel.createParallelGroup(
																																Alignment.LEADING)
																																.addComponent(
																																		yTextField,
																																		GroupLayout.PREFERRED_SIZE,
																																		GroupLayout.DEFAULT_SIZE,
																																		GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		lblY,
																																		Alignment.TRAILING,
																																		GroupLayout.PREFERRED_SIZE,
																																		86,
																																		GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		lblHeight,
																																		Alignment.TRAILING,
																																		GroupLayout.PREFERRED_SIZE,
																																		86,
																																		GroupLayout.PREFERRED_SIZE))
																												.addComponent(
																														hTextFiled,
																														GroupLayout.PREFERRED_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.PREFERRED_SIZE))))
																.addGap(41)
																.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1,
																		GroupLayout.PREFERRED_SIZE).addGap(196)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_panel.createSequentialGroup()
														.addGap(13)
														.addGroup(
																gl_panel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblY)
																		.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1,
																				GroupLayout.PREFERRED_SIZE))
														.addGap(2)
														.addGroup(
																gl_panel.createParallelGroup(Alignment.TRAILING)
																		.addComponent(yTextField, GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addComponent(xTextField, GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGap(4)
														.addGroup(
																gl_panel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblHeight)
																		.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18,
																				GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(
																gl_panel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(wTextField, GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addComponent(hTextFiled, GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblTitle).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(windowTitleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(chckbxNewCheckBox).addComponent(btnResize))
						.addGap(18)));
		panel.setLayout(gl_panel);
		list = new JList<ResizeData>(dataModel);
		sl_panel_1.putConstraint(SpringLayout.NORTH, list, 5, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, list, 5, SpringLayout.EAST, panel);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, list, 5, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, list, 5, SpringLayout.EAST, panel_1);
		list.setBorder(new TitledBorder(null, "Previous values", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		new ListAction(list, new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResizeData selectedValue = list.getSelectedValue();
				if (selectedValue != null) {
					try {
						resize(selectedValue);
						fillData(selectedValue);
					} catch (NameNotFoundException e1) {
						JOptionPane.showMessageDialog(frmResizeTool, "Window \"" + selectedValue.getWindowName() + "\" not found ");

						e1.printStackTrace();
					}
				}
			}
		});

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
