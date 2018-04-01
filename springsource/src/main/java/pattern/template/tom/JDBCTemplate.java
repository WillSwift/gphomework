package pattern.template.tom;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {

    private DataSource dataSource;

    public JDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = getConnection();
            // 2.创建语句集
            pstmt = createPreparedStatement(connection, sql);
            // 3.执行语句集，获得结果集
            resultSet = executeQuery(pstmt, args);
            // 4.解析结果集
            List<T> result = parseResultSet(resultSet, rowMapper);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭结果集
            closeResultSet(resultSet);
            // 6.关闭语句集
            closePreparedStatement(pstmt);
            // 7.关闭数据库连接
            closeConnection(connection);
        }
        return null;
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private ResultSet executeQuery(PreparedStatement pstmt, Object[] args) throws SQLException {
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i, args[i]);
            }
        }
        return pstmt.executeQuery();
    }

    private <T> List<T> parseResultSet(ResultSet resultSet, RowMapper<T> rowMapper) throws Exception {
        List<T> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(rowMapper.mapRow(resultSet));
        }
        return resultList;
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePreparedStatement(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
