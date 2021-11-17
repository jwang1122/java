package org.huaxia.sqlitedb;

public abstract class DBSetting {
	protected static final String dbFilepath = "/Users/12818/workspace/mydb.db";
	protected static DBHelper db = null;
	static {
		if(db==null) {
			db = new DBHelper(dbFilepath);
		}
	}
}
