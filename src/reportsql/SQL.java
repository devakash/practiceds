package reportsql;

public class SQL {

	public static String getQuery(int i[]) {

		String part1 = "select testcase_name,";
		String part2 = part2generator(i);
		String part3 = part3generator(i);

		return part1 + part2 + part3;

	}

	static String part2generator(int i[]) {
		String template = "";
		for (int k = 0; k < i.length; k++) {
			if (k == 0) {
				template = template + "max(case when execution_plan_id =" + i[k] + " then results end) result_" + i[k]
						+ ",";
			} else {
				template = template + "max(case when execution_plan_id =" + i[k] + " then results end) result_" + i[k]
						+ ",";
			}

		}
		template = template.substring(0, template.length() - 1);
		return template;
	}

	static String part3generator(int i[]) {
		String var = "";
		for (int k : i) {
			var = var + k + ",";
		}
		var = var.substring(0, var.length() - 1);
		String part3 = " from execution_result where execution_plan_id in(" + var + ") group by testcase_name;";
		return part3;
	}

}
