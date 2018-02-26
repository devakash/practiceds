package reportsql;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TestSql {

	// LinkedHashMap<String, ArrayList<String>>
	public static void main(String[] args) {
		try {
			int i[] = getExecutionPlanIdToCompare("L1", "PFM 3.0", "3");
			String query = SQL.getQuery(i);

			System.out.println(query);
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	private static LinkedHashMap<String, ArrayList<String>> getResults(int i[], String query) throws SQLException {

		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/report_dashboard", "root", "root");
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet resultSet = pstmt.executeQuery();
		while (resultSet.next()) {

			String tCaseName = resultSet.getString(1);
			ArrayList<String> al=new ArrayList<String>();
			for (int j = 2; j < i.length+2; j++) {
				al.add(resultSet.getString(j));
			}
			
			map.put(tCaseName, al);

		}
		
		return map;

	}

	public static int[] getExecutionPlanIdToCompare(String envName, String suiteName, String compareInput)
			throws SQLException {
		int compareLimit = 2;
		if (compareInput.contains("5")) {
			compareLimit = 5;
		} else if (compareInput.contains("3")) {
			compareLimit = 3;
		}

		int executionPlanId[] = new int[compareLimit];
		String query = "select execution_plan_id from execution_plan_table where env_id in(select env_id from env_info where env_name='"
				+ envName + "') and test_suite_id in (select test_suite_id from test_suite where test_suite_name='"
				+ suiteName + "') order by execution_plan_id desc limit " + compareLimit;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/report_dashboard", "root", "root");
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet resultSet = pstmt.executeQuery();

		int i = 0;
		while (resultSet.next()) {
			executionPlanId[i] = resultSet.getInt("execution_plan_id");
			i = i + 1;
		}

		con.close();
		return executionPlanId;

	}
}
