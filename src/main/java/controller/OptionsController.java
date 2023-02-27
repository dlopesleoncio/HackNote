/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Options;
import util.ConnectionFactory;

/**
 *
 * @author diogo
 */
public class OptionsController {
    public void saveOption(Options options){
        String sql = "INSERT INTO options (option_command, description, command_id ) VALUES (?,?, ?)";
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, options.getOptionCommand());
            statement.setString(2, options.getDescription());
            //statement.setString(3, options.getExample());
            statement.setInt(3, options.getId_command());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar opção" + e.getMessage(),e);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void removeById(Options options){
        String sql = "DELETE FROM options WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, options.getOptionCommand());
            statement.setString(2, options.getDescription());
            statement.setString(3, options.getExample());
            statement.setInt(4, options.getId_command());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar opção" + e.getMessage(),e);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Options> getAll(int id){
        String sql = "SELECT * FROM options WHERE command_id = ?";
        List<Options> optionsList = new ArrayList<>();
        
        //criando conexão com database
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            resultset = statement.executeQuery();
            while(resultset.next()){
                //criando objetos options e preenchendo a lista com esses objetos
                Options options = new Options();
                options.setOptionCommand(resultset.getString("option_command"));
                options.setDescription(resultset.getString("description"));
                optionsList.add(options);
            }
        } catch (Exception e) {
                throw new RuntimeException("Erro ao buscar opções" + e.getMessage(), e);
        } finally{
                ConnectionFactory.closeConnection(conn, statement);
        }
        return optionsList;
    }
}
