package pattern.template.tom;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T mapRow(ResultSet resultSet) throws Exception;
}
