package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public class ProjectController {

    // M�todo que salva um projeto:
    public void save(Project project) throws SQLException {

        String sql = "INSERT INTO projects(name, "
                + "description, "
                + "createdAt, "
                + "updatedAt) "
                + "VALUES (?, ?, ?, ?)";

        // Estabelece a conex�o com o banco de dados e prepara a query:
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));

            statement.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao salvar o projeto: ",
                    ex.getMessage(), ex);
        }
    }

    public void update(Project project) {
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "createdAt = ?, "
                + "updatedAt = ?, "
                + "WHERE id = ? ";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualiazar o projeto: " + ex.getMessage());
        }
    }

    public void removeById(int idProject) {
        String sql = "DELETE FROM projects WHERE idProject = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idProject);
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar o projeto: " + ex.getMessage());
        }
    }

    public List<Project> getAll() {
        String sql = "SELECT * FROM projects";

        List<Project> projects = new ArrayList<>();

        ResultSet resultSet = null;

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));

                projects.add(project);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir o projeto: " + ex.getMessage());
        }

        return projects;
    }
}
