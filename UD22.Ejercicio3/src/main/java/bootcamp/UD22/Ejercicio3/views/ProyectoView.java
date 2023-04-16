package bootcamp.UD22.Ejercicio3.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ProyectoView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textId;
	public JTextField textNombre;
	public JButton btnAdd;
	public JButton btnList;
	public JButton btnEdit;
	public JButton btnDelete;
	private JPanel panelDetalle;
	public JTable tabla;
	public JButton btnOk;
	public JButton btnVolver;
	private JLabel lblHoras;
	public JTextField textHoras;


	public ProyectoView() {
		setTitle("Proyecto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 504, 184);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 38, 57, 20);
		panel.add(lblId);

		JLabel lblNom = new JLabel("Nombre:");
		lblNom.setBounds(10, 85, 68, 14);
		panel.add(lblNom);

		textId = new JTextField();
		textId.setBounds(94, 38, 223, 20);
		panel.add(textId);
		textId.setColumns(10);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(94, 82, 223, 20);
		panel.add(textNombre);

		btnAdd = new JButton("Agregar");
		btnAdd.setBounds(350, 11, 121, 29);
		panel.add(btnAdd);

		btnDelete = new JButton("Borrar");
		btnDelete.setBounds(350, 112, 121, 29);
		panel.add(btnDelete);

		btnEdit = new JButton("Editar");
		btnEdit.setBounds(345, 78, 68, 29);
		panel.add(btnEdit);

		btnList = new JButton("Buscar");
		btnList.setBounds(350, 43, 121, 29);
		panel.add(btnList);

		btnOk = new JButton("OK");
		btnOk.setBounds(420, 78, 55, 29);
		panel.add(btnOk);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 145, 121, 29);
		panel.add(btnVolver);
		
		lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(10, 127, 68, 14);
		panel.add(lblHoras);
		
		textHoras = new JTextField();
		textHoras.setColumns(10);
		textHoras.setBounds(94, 124, 223, 20);
		panel.add(textHoras);

		panelDetalle = new JPanel();
		panelDetalle.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDetalle.setBounds(10, 204, 504, 266);

		panelDetalle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Horas"
			}
		));
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(452, 230));
		panelDetalle.add(scroll);
		getContentPane().add(panelDetalle);

	}
}
