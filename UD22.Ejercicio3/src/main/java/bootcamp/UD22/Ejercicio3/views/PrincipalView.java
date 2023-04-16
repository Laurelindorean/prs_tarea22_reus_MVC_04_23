package bootcamp.UD22.Ejercicio3.views;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PrincipalView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnProyecto;
	public JButton btnCientificos;
	public JButton btnAsignado;

	public PrincipalView() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Escoge una opción");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 33, 202, 52);
		panel.add(lblNewLabel);

		btnCientificos = new JButton("Cientificos");
		btnCientificos.setBounds(34, 96, 119, 33);
		panel.add(btnCientificos);

		btnProyecto = new JButton("Proyecto");
		btnProyecto.setBounds(253, 96, 119, 33);
		panel.add(btnProyecto);
		
		btnAsignado = new JButton("Asignación");
		btnAsignado.setBounds(142, 150, 119, 33);
		panel.add(btnAsignado);
	}
}
