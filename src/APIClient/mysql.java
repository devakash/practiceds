package APIClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class mysql {

	public mysql() {

	}

	public Connection connectmysql() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.57.172:3306/tlinkprod?" + "user=read_testlink&password=yodlee@123");
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return conn;

	}

	public void getTestPlan(Connection con) {
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from testplans";
			ResultSet set = stmt.executeQuery(statement);
			while (set.next()) {
				System.out.println(set.getString("notes"));
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}

	}

	public int getProjectId(Connection con, String projectName) {
		int projectId = (Integer) 0;
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from nodes_hierarchy where name='" + projectName + "'";
			ResultSet set = stmt.executeQuery(statement);
			set.last();

			projectId = set.getInt("id");
			// System.out.println(projectId);
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return projectId;
	}

	public String getProjectPrefix(Connection con, int projectId) {
		String projectPrefix = "";
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from testprojects where id=" + projectId;
			ResultSet set = stmt.executeQuery(statement);
			set.last();
			projectPrefix = set.getString("prefix");
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return projectPrefix;
	}

	/*
	 * Get NodeId using automation Id
	 */
	public List<Integer> getNodeIdsFromcfielddesignValues(Connection con, String automationId) {
		List<Integer> nodeIdlist = new ArrayList<Integer>();
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from cfield_design_values where value='" + automationId + "'";
			ResultSet set = stmt.executeQuery(statement);
			while (set.next()) {
				nodeIdlist.add(set.getInt("node_id"));
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return nodeIdlist;
	}

	public List<Integer> getTestCaseExternalId(Connection con, List<Integer> nodeIdlist) {
		List<Integer> testlinkidlist = new ArrayList<Integer>();
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String nodeidlistcomaseparted = nodeIdlist.toString().replace("[", "").replace("]", "").replace(", ", ",");
			// System.out.println(nodeidlistcomaseparted);
			String statement = "select * from tcversions where id in (" + nodeidlistcomaseparted + ")";
			ResultSet set = stmt.executeQuery(statement);
			while (set.next()) {
				testlinkidlist.add(set.getInt("tc_external_id"));
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return testlinkidlist;

	}

	public List<Integer> getTestCaseExternalId(Connection con, List<Integer> tcversionlist, List<Integer> nodeIdlist) {
		List<Integer> testlinkidlist = new ArrayList<Integer>();

		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String tcidlistcomaseparted = tcversionlist.toString().replace("[", "").replace("]", "").replace(", ", ",");
			String nodeidlistcomaseparted = nodeIdlist.toString().replace("[", "").replace("]", "").replace(", ", ",");
			System.out.println(nodeidlistcomaseparted);
			// System.out.println(tcidlistcomaseparted);
			String statement = "select * from tcversions where id in (" + tcidlistcomaseparted + ") and id in ("
					+ nodeidlistcomaseparted + ")";
			ResultSet set = stmt.executeQuery(statement);
			while (set.next()) {
				testlinkidlist.add(set.getInt("tc_external_id"));
				// testlinkidlist.add(set.getInt("id"));
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return testlinkidlist;
	}

	public int getTestPlanId(Connection con, String testplan) {
		int testplanId = 0;
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from nodes_hierarchy where node_type_id=5 and name='" + testplan + "'";
			ResultSet set1 = stmt.executeQuery(statement);
			set1.last();
			testplanId = set1.getInt("id");
			set1.close();
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return testplanId;
	}

	public List<Integer> gettcversionId(Connection con, String testplan) {
		List<Integer> tcversionlist = new ArrayList<Integer>();
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from nodes_hierarchy where node_type_id=5 and name='" + testplan + "'";
			ResultSet set1 = stmt.executeQuery(statement);
			set1.last();
			int testplanId = set1.getInt("id");
			set1.close();
			ResultSet set2 = stmt.executeQuery("select * from testplan_tcversions where testplan_id=" + testplanId);
			while (set2.next()) {
				tcversionlist.add(set2.getInt("tcversion_id"));
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return tcversionlist;

	}

	public List<String> getTestCaseName(Connection con, String automationId, String projectName) {
		List<String> teslinkTestcaselist = new ArrayList<String>();
		int projectId = getProjectId(con, projectName);
		// System.out.println(projectId);
		String projectPrefix = getProjectPrefix(con, projectId);
		// System.out.println(projectPrefix);
		List<Integer> nodeIdlist = getNodeIdsFromcfielddesignValues(con, automationId);
		List<Integer> testCaseIdlist = getTestCaseExternalId(con, nodeIdlist);
		// System.out.println(testCaseIdlist.toString());
		for (int i = 0; i < testCaseIdlist.size(); i++) {
			String temp = projectPrefix + "-" + testCaseIdlist.get(i);
			teslinkTestcaselist.add(temp);
		}
		return teslinkTestcaselist;
	}

	public List<String> getTestCaseName(Connection con, String automationId, String projectName, String testplan) {
		List<String> teslinkTestcaselist = new ArrayList<String>();
		int projectId = getProjectId(con, projectName);
		String projectPrefix = getProjectPrefix(con, projectId);
		List<Integer> nodeIdlist = getNodeIdsFromcfielddesignValues(con, automationId);
		List<Integer> tcIdlist = gettcversionId(con, testplan);
		List<Integer> testCaseIdlist = getTestCaseExternalId(con, nodeIdlist, tcIdlist);
		for (int i = 0; i < testCaseIdlist.size(); i++) {
			String temp = projectPrefix + "-" + testCaseIdlist.get(i);
			System.out.println(temp);
			teslinkTestcaselist.add(temp);
			// teslinkTestcaselist.add(testCaseIdlist.get(i).toString());
		}
		return teslinkTestcaselist;
	}

	public List<Integer> getTestCaseversionId(Connection con, String automationId, List<Integer> tcIdlist) {
		List<Integer> testCaseIdlist = new ArrayList<Integer>();
		List<Integer> nodeIdlist = getNodeIdsFromcfielddesignValues(con, automationId);
		for (int i = 0; i < nodeIdlist.size(); i++) {
			if (tcIdlist.contains(nodeIdlist.get(i))) {
				testCaseIdlist.add(nodeIdlist.get(i));
			}
		}
		return testCaseIdlist;
	}

	public List<Integer> getTestCaseId(Connection con, List<Integer> tcversionIdlist) {
		List<Integer> testCaseIdlist = new ArrayList<Integer>();
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String tcversionIdlistcomaseparted = testCaseIdlist.toString().replace("[", "").replace("]", "")
					.replace(", ", ",");
			String statement = "select *  where tc in (" + tcversionIdlistcomaseparted + ")";
			System.out.println(statement);
			ResultSet set1 = stmt.executeQuery(statement);
			while (set1.next()) {
				testCaseIdlist.add(set1.getInt("id"));
			}
		} catch (Exception ex) {

		}
		return testCaseIdlist;

	}

	public int getBuildId(Connection con, String BuildName, int testPlanId) {
		int build_id = 0;
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from builds where testplan_id=" + testPlanId + " and name ='" + BuildName
					+ "'";
			System.out.println(statement);
			ResultSet set1 = stmt.executeQuery(statement);
			set1.last();
			build_id = set1.getInt("id");

		} catch (SQLException ex) {
			ex.getMessage();
		}
		return build_id;

	}
	// ***********************************************NEW
	// Code**********************

	private List<Integer> getNodeId(Connection con, String automationId) {
		List<Integer> nodeIdlist = new ArrayList<Integer>();
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from cfield_design_values where value='" + automationId + "'";
			// System.out.println(statement);
			ResultSet set1 = stmt.executeQuery(statement);
			while (set1.next()) {
				nodeIdlist.add(set1.getInt("node_id"));
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return nodeIdlist;
	}

	private List<Integer> getTcversionid(Connection con, List<Integer> nodeidlist) {
		List<Integer> tcvIdlist = new ArrayList<Integer>();
		String nodelistcomaseparted = nodeidlist.toString().replace("[", "").replace("]", "").replace(", ", ",");
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select * from tcversions where id in (" + nodelistcomaseparted + ")";
			// System.out.println(statement);
			ResultSet set1 = stmt.executeQuery(statement);
			while (set1.next()) {
				tcvIdlist.add(set1.getInt("id"));
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return tcvIdlist;

	}

	private List<Integer> gettestcaseid(Connection con, List<Integer> tcvIdlist) {
		List<Integer> tcidlist = new ArrayList<Integer>();
		String tcidlistcommaseparted = tcvIdlist.toString().replace("[", "").replace("]", "").replace(", ", ",");
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String statement = "select parent_id from nodes_hierarchy where id in (" + tcidlistcommaseparted + ")";
			// System.out.println(statement);
			ResultSet set1 = stmt.executeQuery(statement);
			while (set1.next()) {
				tcidlist.add(set1.getInt(1));
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return tcidlist;

	}

	public List<Integer> getTestCaseId2(Connection con, String automationId) {
		List<Integer> nodeidlist = getNodeId(con, automationId);
		List<Integer> tcvidlist = getTcversionid(con, nodeidlist);
		List<Integer> tcidlist = gettestcaseid(con, tcvidlist);
		return tcidlist;
	}

	public static void main(String[] args) throws Exception

	{
		mysql db = new mysql();
		Connection con = db.connectmysql();
		List<Integer> nodeIdlist = db.getNodeIdsFromcfielddesignValues(con, "ExpenseAnalysisFinapp_TC0015");
		for (Integer i : nodeIdlist) {
			System.out.print(i + " ");
		}
		List<Integer> testCaseExternalId = db.getTestCaseExternalId(con, nodeIdlist);
		System.out.println();
		for (Integer i : testCaseExternalId) {
			System.out.print(i + " ");
		}
		List<Integer> parent_id = db.gettestcaseid(con, nodeIdlist);
		System.out.println();
		for (Integer i : parent_id) {
			System.out.print(i + " ");
		}
		con.close();
	}
}
