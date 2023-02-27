/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Commands;
import util.ConnectionFactory;

/**
 *
 * @author diogo
 */
public class CommandsController {
    
    public void save(Commands command){
        String sql = "INSERT INTO commands (name,description,function) VALUES (?,?,?)";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, command.getName());
            statement.setString(2, command.getDescription());
            statement.setString(3, command.getFuncion());
            statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar comando" + e.getMessage(),e);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
        
    }
    
    public void update(Commands command){
        
    }
    
    //testar deletar sem o id direto
    public void removeById(Commands command) throws SQLException{
        
        String sql = "DELETE FROM commands WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, command.getId());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar comando" + e.getMessage(), e);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
        
    }
    
    public List<Commands> getall(){
        String sql = "SELECT * FROM commands";
        
        List<Commands> listCommands= new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            resultset = statement.executeQuery();
            
            while(resultset.next()){
                //criando objetos commandos e preenchendo a lista com esses objetos
                Commands command = new Commands();
                command.setId(resultset.getInt("id"));
                command.setName(resultset.getString("name"));
                command.setFuncion(resultset.getString("function"));
                command.setDescription(resultset.getString("description"));
                listCommands.add(command);
            }
        
        }catch (Exception e) {
            throw new RuntimeException("Erro ao buscar comandos" + e.getMessage(), e);
        
        }finally{
            ConnectionFactory.closeConnection(conn, statement,resultset);
        }
        return listCommands;
    }    
}
