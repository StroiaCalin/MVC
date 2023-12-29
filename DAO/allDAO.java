package DAO;

import Connection.ConnectionFactory;

import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class allDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(allDAO.class.getName());
	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public allDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private String createDeleteQuery(String id) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("DELETE FROM ");
		stringBuilder.append(type.getSimpleName());
		stringBuilder.append(" WHERE ");
		switch (type.getSimpleName()) {
			case "Clienti":
				stringBuilder.append("idClienti=");
				break;
			case "Produse":
				stringBuilder.append("idproduse=");
				break;
			case "Comenzi":
				stringBuilder.append("idComenzi=");
				break;
			default:
				throw new IllegalArgumentException("Unknown entity type: " + type.getSimpleName());
		}
		stringBuilder.append(id);
		return stringBuilder.toString();
	}

	private String createSelectQuery(String field) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM ")
				.append(type.getSimpleName())
				.append(" WHERE ")
				.append(field)
				.append(" = ?;");
		return stringBuilder.toString();
	}


	private String createUpdateQuery(ArrayList<String> values, String id) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("UPDATE ")
				.append(type.getSimpleName())
				.append(" SET ");

		Field[] fields = type.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			stringBuilder.append(field.getName()).append("=");

			if (i == 0) {
				stringBuilder.append(escapeValue(values.get(i))).append(",");
			} else {
				stringBuilder.append(escapeValue(values.get(i))).append(",");
			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append(" WHERE ")
				.append(getIdColumnName())
				.append("=")
				.append(escapeValue(id));

		return stringBuilder.toString();
	}

	private String escapeValue(String value) {
		return '"' + value + '"';
	}

	private String getIdColumnName() {
		switch (type.getSimpleName()) {
			case "Clienti":
				return "idClienti";
			case "Produse":
				return "idproduse";
			case "Comenzi":
				return "idComenzi";
			default:
				throw new IllegalArgumentException("Unknown entity type: " + type.getSimpleName());
		}
	}


	private String createInsertQuery(String values) {
		StringBuilder stringBuilder = new StringBuilder();
		Field[] fields = type.getDeclaredFields();
		String fieldList = "";

		for (int i = 1; i < fields.length; i++) {
			fieldList += fields[i].getName() + ",";
		}
		fieldList = fieldList.substring(0, fieldList.length() - 1); // Remove the trailing comma

		stringBuilder.append("INSERT INTO ")
				.append(type.getSimpleName())
				.append(" (")
				.append(fieldList)
				.append(") VALUES (")
				.append(values)
				.append(");");

		return stringBuilder.toString();
	}



	public List<T> findAll() {
		String query = "SELECT * FROM " + type.getSimpleName();
		List<T> objects = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query);
			 ResultSet resultSet = statement.executeQuery()) {
			objects = createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
		}

		return objects;
	}

	public T findById(int id) {
		String query = createSelectQuery(getIdColumnName());
		T object = null;

		try (Connection connection = ConnectionFactory.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				List<T> objects = createObjects(resultSet);
				if (!objects.isEmpty()) {
					object = objects.get(0);
				}
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		}

		return object;
	}

	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<>();

		try {
			while (resultSet.next()) {
				T instance = type.getDeclaredConstructor().newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					setFieldValue(instance, field, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException | IllegalAccessException |
				 InvocationTargetException | NoSuchMethodException |
				 SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	private void setFieldValue(T instance, Field field, Object value) {
		try {
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
			Method method = propertyDescriptor.getWriteMethod();
			method.invoke(instance, value);
		} catch (IntrospectionException | IllegalAccessException |
				 InvocationTargetException e) {
			e.printStackTrace();
		}
	}


	public String insert(String valori) {
		String query = createInsertQuery(valori);

		try (Connection connection = ConnectionFactory.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query)) {
			System.out.println(statement.toString());
			int result = statement.executeUpdate();
			if (result > 0) {
				return "SUCCESS!";
			} else {
				return "ERROR";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "ERROR";
		}
	}


	public String update(ArrayList<String> valori, String id) {
		String query = createUpdateQuery(valori, id);

		try (Connection connection = ConnectionFactory.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query)) {
			System.out.println(statement.toString());
			int result = statement.executeUpdate();
			if (result > 0) {
				return "SUCCESS";
			} else {
				return "ERROR";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "ERROR";
		}
	}
	public String delete(String id) {
		String query = createDeleteQuery(id);
		try (Connection connection = ConnectionFactory.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query)) {
			System.out.println(statement.toString());
			int result = statement.executeUpdate();
			if (result > 0) {
				return "SUCCESS";
			} else {
				return "ERROR";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "ERROR";
		}
	}
	public DefaultTableModel createTabel(List<T> afisare) {
		Field[] fields = type.getDeclaredFields();
		String[] columnNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			columnNames[i] = fields[i].getName();
		}
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		if (afisare == null) {
			return tableModel;
		}
		for (T obj : afisare) {
			Object[] rowData = new Object[fields.length];
			int j = 0;
			for (Field field : fields) {
				field.setAccessible(true);
				try {
					rowData[j] = field.get(obj);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				j++;
			}
			tableModel.addRow(rowData);
		}
		return tableModel;
	}
}
