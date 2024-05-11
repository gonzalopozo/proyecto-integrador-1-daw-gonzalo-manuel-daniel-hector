package control;

public class DetallesPersonajesListener implements ActionListener{
    
    private Views vDetalles;
    private int cont = 3;

    public DetallesPersonajesListener(Views vDetalles) {
        this.vDetalles = vDetalles;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        ArrayList datos = new ArrayList<String>();


        AccesoBD acceso = new AccesoBD();
        Connection c = acceso.getConexion();

        try{
            datos = acceso.obtenerDatos(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        acceso.cerrarConexion();


        

    }
}
