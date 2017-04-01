/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Valentina S
 */
class CamposVacios extends Exception {

    public CamposVacios(String debe_diligenciar_todos_los_campos) {
    }

    CamposVacios() {
        super("debe ingresar todos los campos");//To change body of generated methods, choose Tools | Templates.
    }
    
}
