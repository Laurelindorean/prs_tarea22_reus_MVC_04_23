package bootcamp.UD22.Ejercicio2.views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;

public class ClienteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textId;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textAdress;
	public JTextField textDni;
	public JTextField textDate;
	public String[] nombresColumnas = {"ID", "Nombre", "Apellido", "Dirección", "DNI", "Fecha"};
	public Object[][] datosFila= {};
	public JButton btnAdd;
	public JButton btnList;
	public JButton btnEdit;
	public JButton btnDelete;
	private JPanel panelDetalle;
	public JTable tabla;
	public JButton btnOk;
	public JButton btnVolver;



	/**
	 * Create the frame.
	 */
	public ClienteView() {
		setTitle("Gestión de Clientes");
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
		lblId.setBounds(10, 12, 57, 20);
		panel.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 41, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 72, 46, 14);
		panel.add(lblApellido);
		
		JLabel lblAdress = new JLabel("Dirección:");
		lblAdress.setBounds(10, 100, 57, 14);
		panel.add(lblAdress);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 130, 46, 14);
		panel.add(lblDni);
		
		JLabel lblDate = new JLabel("Fecha:");
		lblDate.setBounds(10, 159, 46, 14);
		panel.add(lblDate);
		
		textId = new JTextField();
		textId.setBounds(94, 12, 223, 20);
		panel.add(textId);
		textId.setColumns(10);
		textId.setEditable(false);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(94, 38, 223, 20);
		panel.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(94, 68, 223, 20);
		panel.add(textApellido);
		
		textAdress = new JTextField();
		textAdress.setColumns(10);
		textAdress.setBounds(94, 97, 223, 20);
		panel.add(textAdress);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(94, 127, 223, 20);
		panel.add(textDni);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(94, 156, 223, 20);
		panel.add(textDate);
		
		btnAdd = new JButton("Agregar");
		btnAdd.setBounds(350, 11, 121, 29);
		panel.add(btnAdd);
		
		btnDelete = new JButton("Borrar");
		btnDelete.setBounds(350, 112, 121, 29);
		panel.add(btnDelete);
		
		btnEdit = new JButton("Editar");
		btnEdit.setBounds(342, 78, 68, 29);
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
		
		panelDetalle = new JPanel();
		panelDetalle.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDetalle.setBounds(10, 204, 504, 266);
		
		panelDetalle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Apellido", "Direcci\u00F3n", "DNI", "Fecha"
			}
		));
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(452, 230));
		panelDetalle.add(scroll);
		getContentPane().add(panelDetalle);
	

	}
}
