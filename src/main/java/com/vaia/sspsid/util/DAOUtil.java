package com.vaia.sspsid.util;

import com.vaia.sspsid.enumerated.LogLevel;
import static com.vaia.sspsid.enumerated.LogLevel.DEBUG;
import static com.vaia.sspsid.enumerated.LogLevel.ERROR;
import static com.vaia.sspsid.enumerated.LogLevel.INFO;
import static com.vaia.sspsid.enumerated.LogLevel.TRACE;
import static com.vaia.sspsid.enumerated.LogLevel.WARN;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DAOUtil {

    private static final Logger LOGGER = Logger.getLogger(DAOUtil.class.getName());

//============================================================Prepared Statement
    /**
     * Create Prepared Statement from plain SQL
     *
     * @param connection connection to create Prepared Statement
     * @param sql SQL to create prepared statement
     * @return Prepared statement Object
     */
    public static PreparedStatement prepareStatement(Connection connection, String sql) throws SQLException {
        return prepareStatement(connection, sql, false, new Object[0]);
    }

    /**
     * Bind Parameters to prepared statement
     *
     * @param preparedStatement prepared statement to be bind with parameters
     * @param values arrays of parameters to be bind to prepared statement
     */
    public static PreparedStatement addBatchParameter(PreparedStatement preparedStatement, Object[] values) throws SQLException {
        setValues(preparedStatement, values);
        log(preparedStatement.toString(), DEBUG);
        return preparedStatement;
    }

    /**
     * Bind Parameters to prepared statement but with custom log level
     *
     * @param preparedStatement prepared statement to be bind with parameters
     * @param values arrays of parameters to be bind to prepared statement
     * @param logLevel Log Level based on enums LogLevel
     */
    public static PreparedStatement addBatchParameter(PreparedStatement preparedStatement, Object[] values, LogLevel logLevel) throws SQLException {
        setValues(preparedStatement, values);
        log(preparedStatement.toString(), logLevel);
        return preparedStatement;
    }

    /**
     * @author Wirawan Adi Static method to create Prepared Statement
     *
     * @param connection Connection tobe created a Prepared Statement
     * @param sql String SQL To be created Prepared Statement
     * @param returnGeneratedKeys wether return generated key ?
     * @param values arrays of parameters to be bind to prepared statement
     */
    public static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys, Object[] values) throws SQLException {
        return prepareStatement(connection, sql, returnGeneratedKeys, values, DEBUG);
    }

    /**
     * @author Wirawan Adi Static method to create Prepared Statement
     *
     * @param connection Connection tobe created a Prepared Statement
     * @param sql String SQL To be created Prepared Statement
     * @param returnGeneratedKeys wether return generated key ?
     * @param values arrays of parameters to be bind to prepared statement
     * @param logLevel Customer Log Level
     */
    public static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys, Object[] values, LogLevel logLevel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql, returnGeneratedKeys ? 1 : 2);
        setValues(preparedStatement, values);
        log(preparedStatement.toString(), logLevel);
        return preparedStatement;
    }

    private static void setValues(PreparedStatement preparedStatement, Object[] values) throws SQLException {
        if (values.length != 0) {
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }
        }
    }

//============================================================Callable Statement
    /**
     * @author Wirawan Adi Static method to create Prepared Statement without
     * return generated keys and parameters
     *
     * @param connection Connection tobe created a Prepared Statement
     * @param sql String SQL To be created Prepared Statement
     */
    public static CallableStatement addBatchParameter(CallableStatement callableStatement, Object[] values) throws SQLException {
        return addBatchParameter(callableStatement, values, DEBUG);
    }

    public static CallableStatement addBatchParameter(CallableStatement callableStatement, Object[] values, LogLevel logLevel) throws SQLException {
        setValues(callableStatement, values);
        log(callableStatement.toString(), logLevel);
        return callableStatement;
    }

    public static CallableStatement callableStatement(Connection connection, String storeProc, Object[] parameterIn, LogLevel logLevel) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(storeProc);
        setValues(callableStatement, parameterIn);
        log(callableStatement.toString(), logLevel);
        return callableStatement;
    }

    public static CallableStatement callableStatement(Connection connection, String storeProc, Object[] parameterIn) throws SQLException {
        return callableStatement(connection, storeProc, parameterIn, DEBUG);
    }

    public static CallableStatement callableStatement(Connection connection, String storeProc) throws SQLException {
        return connection.prepareCall(storeProc);
    }

    public static void setValues(CallableStatement callableStatement, Object[] parametersIn) throws SQLException {
        if (parametersIn.length != 0) {
            for (int i = 0; i < parametersIn.length; i++) {
                callableStatement.setObject(i + 1, parametersIn[i]);
            }
        }
    }

    public static void log(String message, LogLevel logLevel) {
        log(LOGGER, logLevel, message);
    }

    public static void log(Logger logger, LogLevel logLevel, String logMessage) {
        switch (logLevel) {
            case ERROR:
                System.out.println("Error" + logMessage);
                break;
            case WARN:
                System.out.println("Warn" + logMessage);
                break;
            case INFO:
                System.out.println("Info" + logMessage);
                break;
            case DEBUG:
                System.out.println("Debug" + logMessage);
                break;
            case TRACE:
                System.out.println("Trace" + logMessage);
                break;
            default:
                break;
        }
    }

    public static java.sql.Date toSqlDate(java.util.Date date) {
        return date != null ? new java.sql.Date(date.getTime()) : null;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Closing Connection failed: " + e.getMessage());
                log(e.toString(), ERROR);
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("Closing Statement failed: " + e.getMessage());
                log(e.toString(), ERROR);
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.println("Closing ResultSet failed: " + e.getMessage());
                log(e.toString(), ERROR);
            }
        }
    }

    public static void close(Connection connection, Statement statement) {
        close(statement);
        close(connection);
    }

    public static void close(Statement statement, ResultSet resultSet) {
        close(statement);
        close(resultSet);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(resultSet);
        close(statement);
        close(connection);
    }

    public static Boolean checkBatchUpdate(int[] batchUpdateResult) {
        int result = 0;
        if (batchUpdateResult.length > 0) {
            for (int i = 0; i < batchUpdateResult.length; i++) {
                if (batchUpdateResult[i] >= 0) {
                    // Successfully executed; the number represents number of affected rows
                    log("OK: updateCount=" + batchUpdateResult[i], TRACE);
                    result += 1;
                } else if (batchUpdateResult[i] == Statement.SUCCESS_NO_INFO) {
                    // Successfully executed; number of affected rows not available
                    log("OK: updateCount=Statement.SUCCESS_NO_INFO", TRACE);
                    result += 1;
                } else if (batchUpdateResult[i] == Statement.EXECUTE_FAILED) {
                    log("updateCount=Statement.EXECUTE_FAILED", TRACE);
                    result -= 1;
                }
            }

            return batchUpdateResult.length == result;
        } else {
            return true;
        }
    }

}
