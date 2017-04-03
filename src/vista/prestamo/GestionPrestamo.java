package vista.prestamo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrestamo;
import vista.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GestionPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControladorPrestamo controladorPrestamo;
	private FormularioPrestamo formulacionPrestamo;

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	/**
	 * Create the dialog.
	 */
	public GestionPrestamo(JFrame principal, boolean modal) {
		super(principal, true);
		setBounds(100, 100, 260, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(145, 186, 89, 23);
		contentPanel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(35, 186, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nuevo prestamo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 224, 65);
		contentPanel.add(panel);
		
				JButton btnNewButton = new JButton("Realizar Prestamo");
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
							.addContainerGap())
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addContainerGap())
				);
				panel.setLayout(gl_panel);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Borrar prestamos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(10, 89, 224, 65);
				contentPanel.add(panel_1);
				
				JButton button = new JButton("Realizar Prestamo");
				
				JButton button_1 = new JButton("Realizar Prestamo");
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_1))
							.addContainerGap())
				);
				panel_1.setLayout(gl_panel_1);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						controladorPrestamo.abrirFormularioPrestamo();

					}
				});
	}
}
