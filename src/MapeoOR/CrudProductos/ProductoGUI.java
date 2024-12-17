package MapeoOR.CrudProductos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoGUI extends JFrame {

    private Crud crud = new Crud();
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtIdBuscar;
    private JTextField txtIdEliminar;
    private JTextField txtIdActualizar;
    private JTextField txtNombreActualizar;
    private JTextField txtPrecioActualizar;
    private JTable table;
    private DefaultTableModel model;

    public ProductoGUI() {
        setTitle("CRUD Productos");
        setLayout(new BorderLayout());
        setSize(600, 500);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelAgregar = new JPanel();
        panelAgregar.setLayout(new GridLayout(3, 2));

        panelAgregar.add(new JLabel("Nombre Producto: "));
        txtNombre = new JTextField();
        panelAgregar.add(txtNombre);

        panelAgregar.add(new JLabel("Precio Producto: "));
        txtPrecio = new JTextField();
        panelAgregar.add(txtPrecio);

        JButton btnInsertar = new JButton("Insertar Producto");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarProducto();
            }
        });
        panelAgregar.add(btnInsertar);

        add(panelAgregar, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Precio");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelAcciones = new JPanel();
        panelAcciones.setLayout(new GridLayout(4, 2));

        panelAcciones.add(new JLabel("ID para Buscar: "));
        txtIdBuscar = new JTextField();
        panelAcciones.add(txtIdBuscar);

        JButton btnBuscar = new JButton("Buscar Producto");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });
        panelAcciones.add(btnBuscar);

        panelAcciones.add(new JLabel("ID para Eliminar: "));
        txtIdEliminar = new JTextField();
        panelAcciones.add(txtIdEliminar);

        JButton btnEliminar = new JButton("Eliminar Producto");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
        panelAcciones.add(btnEliminar);

        panelAcciones.add(new JLabel("ID para Actualizar: "));
        txtIdActualizar = new JTextField();
        panelAcciones.add(txtIdActualizar);

        panelAcciones.add(new JLabel("Nuevo Nombre: "));
        txtNombreActualizar = new JTextField();
        panelAcciones.add(txtNombreActualizar);

        panelAcciones.add(new JLabel("Nuevo Precio: "));
        txtPrecioActualizar = new JTextField();
        panelAcciones.add(txtPrecioActualizar);

        JButton btnActualizar = new JButton("Actualizar Producto");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });
        panelAcciones.add(btnActualizar);

        add(panelAcciones, BorderLayout.SOUTH);
    }

    private void insertarProducto() {
        String nombre = txtNombre.getText();
        double precio = 0;
        try {
            precio = Double.parseDouble(txtPrecio.getText());
            Producto producto = new Producto(0, nombre, precio);
            crud.crearProducto(producto);
            JOptionPane.showMessageDialog(this, "Producto Insertado");
            limpiarCampos();
            listarProductos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un precio válido.");
        }
    }

    private void buscarProducto() {
        int id = 0;
        try {
            id = Integer.parseInt(txtIdBuscar.getText());
            Producto producto = crud.obtenerProducto(id);
            if (producto != null) {
                JOptionPane.showMessageDialog(this, "Producto encontrado: " + producto);
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ID válido.");
        }
    }

    private void actualizarProducto() {
        int id = 0;
        String nombre = txtNombreActualizar.getText();
        double precio = 0;
        try {
            id = Integer.parseInt(txtIdActualizar.getText());
            precio = Double.parseDouble(txtPrecioActualizar.getText());
            Producto producto = new Producto(id, nombre, precio);
            crud.actualizarProducto(producto);
            JOptionPane.showMessageDialog(this, "Producto actualizado");
            limpiarCampos();
            listarProductos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese datos válidos.");
        }
    }

    private void eliminarProducto() {
        int id = 0;
        try {
            id = Integer.parseInt(txtIdEliminar.getText());
            crud.eliminarProducto(id);
            JOptionPane.showMessageDialog(this, "Producto eliminado");
            limpiarCampos();
            listarProductos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ID válido.");
        }
    }

    private void listarProductos() {
        List<Producto> productos = crud.listarProductos();
        model.setRowCount(0);
        for (Producto producto : productos) {
            model.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getPrecio()});
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtIdBuscar.setText("");
        txtIdEliminar.setText("");
        txtIdActualizar.setText("");
        txtNombreActualizar.setText("");
        txtPrecioActualizar.setText("");
    }

    public static void main(String[] args) {
        // Crea la GUI y hazla visible
        ProductoGUI gui = new ProductoGUI();
        gui.setVisible(true);
    }
}
