package control;

public class LoginListener implements ActionListener{
    
    private Views v1;
    private int cont = 3;

    public LoginListener(Views v1) {
        this.v1 = v1;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String password = v1.getTxtPassword().getText();
        String usuario = v1.getTxtNombre().getText();

        String contraBD = "";


        AccesoBD acceso = new AccesoBD();
        Connection c = acceso.getConexion();

        try{
            contraBD = acceso.comprobarLogin(c, usuario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        acceso.cerrarConexion();


        if (contraBD == "") {
            v1.getMensaje().setText("ERROR Introduza usuario y contraseña.");
        } else if (contraBD == "" && password == "") {
            v1.getMensaje().setText("Este Usuario no existe");
        } else if (contraBD.equals(password)){
            SeleccionRol vRol = new SeleccionRol();

            v1.dispose();
            vRol.setVisible(true);

        } else {

            v1.getMensaje().setText("Esta contraseña es incorrecta");
            cont--;
            if (cont == 0) {
                v1.dispose();
            }

        }


    }
}
