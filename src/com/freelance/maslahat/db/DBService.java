package com.freelance.maslahat.db;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

public class DBService extends DBSupport {

	private static final Logger LOG = Logger.getLogger(DBService.class);

	private String status;
	private String message;

	public DBService() {
		dbEngine = new DBEngine();
	}

	public DBService(DBEngine dbEngine) {
		this.dbEngine = dbEngine;
	}

	public void openConnection() {
		connection = dbEngine.getConnection();
	}

	public void closeConnetion() {
		DBUtils.close(rs, cs, ps, st, connection);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void prepareCall(String spName) {
		prepareCall(spName, null);
	}

	public void prepareCall(String spName, Map<String, String> parameters) {
		try {
			cs = connection.prepareCall(DBUtils.spQuery(spName, parameters));
			LOG.info(cs);
			if (parameters != null && parameters.size() > 0) {
				for (Map.Entry<String, String> entry : parameters.entrySet()) {
					cs.setString(entry.getKey(), entry.getValue());
				}
				LOG.info(parameters);
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
	}

	public void addBatch(Map<String, String> parameters) {
		if (parameters != null && parameters.size() > 0) {
			try {
				for (Map.Entry<String, String> entry : parameters.entrySet()) {
					cs.setString(entry.getKey(), entry.getValue());
				}
				cs.addBatch();
			} catch (SQLException e) {
				LOG.error(e);
			}
			LOG.info(parameters);
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
