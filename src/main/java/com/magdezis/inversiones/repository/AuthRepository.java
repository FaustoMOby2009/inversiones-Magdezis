package main.java.com.magdezis.inversiones.repository;

import main.java.com.magdezis.inversiones.config.DataBaseConection;
import main.java.com.magdezis.inversiones.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthRepository {

    private boolean estado = false;

    public boolean create(Usuario usuario) {
        String sql = "insert into usuarios values (?,?,?,?,?)";

        try (PreparedStatement pstm = DataBaseConection.getConnectionDataBase().prepareStatement(sql)) {

            pstm.setString(1, usuario.getIdUsuario());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getPassword());
            pstm.setString(5, usuario.getIdRol());

            int filas = pstm.executeUpdate();
            if (filas > 0) {
                estado = true;
            };

        } catch (SQLException e) {
            System.out.println("Error al registrar en BD: " + e.getMessage());
            return estado;
        }return estado;
    }
}
