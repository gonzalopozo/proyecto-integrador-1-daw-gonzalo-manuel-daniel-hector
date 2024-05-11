package control;

public class DetallesPersonajesListener implements ActionListener{
    
    private Views vDetalles;
    private int cont = 3;

    public DetallesPersonajesListener(Views vDetalles) {
        this.vDetalles = vDetalles;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String password = vDetalles.getTxtPassword().getText();
        String usuario = vDetalles.getTxtNombre().getText();

        String contraBD = "";


        AccesoBD acceso = new AccesoBD();
        Connection c = acceso.getConexion();

        try{
            contraBD = acceso.comprobarLogin(c, usuario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        acceso.cerrarConexion();


        


    }
}
