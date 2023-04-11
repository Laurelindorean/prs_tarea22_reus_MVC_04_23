package bootcamp.UD22.ejercicio1.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 
 * @author Palmira
 *
 */

public class ClienteView extends JFrame {

	private JPanel contentPane;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textAdress;
	public JTextField textDni;
	public JLabel lblDni;
	public JLabel lblDireccin;
	public JLabel lblApellido;
	public JLabel lblNombre;
	public JButton btnBuscar;
	public JButton btnAdd;
	public JButton btnUpdate;
	public JButton btnDelete;
	public JButton btnClean;

	/**
	 * Create the frame.
	 */
	public ClienteView() {
		setTitle("Gestión Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(38, 51, 70, 21);
		contentPane.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(38, 93, 70, 21);
		contentPane.add(lblApellido);
		
		lblDireccin = new JLabel("Dirección");
		lblDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccin.setBounds(38, 136, 70, 21);
		contentPane.add(lblDireccin);
		
		lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDni.setBounds(38, 178, 70, 21);
		contentPane.add(lblDni);
		
		textNombre = new JTextField();
		textNombre.setBounds(154, 52, 192, 21);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(154, 94, 192, 21);
		contentPane.add(textApellido);
		
		textAdress = new JTextField();
		textAdress.setColumns(10);
		textAdress.setBounds(154, 137, 192, 21);
		contentPane.add(textAdress);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(154, 179, 192, 21);
		contentPane.add(textDni);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(24, 251, 89, 23);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("Modificar");
		btnUpdate.setBounds(144, 251, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(263, 251, 89, 23);
		contentPane.add(btnDelete);
		
		btnClean = new JButton("Limpiar");
		btnClean.setBounds(390, 251, 89, 23);
		contentPane.add(btnClean);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(390, 51, 89, 23);
		contentPane.add(btnBuscar);
	}
}
