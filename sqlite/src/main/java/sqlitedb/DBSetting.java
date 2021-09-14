package sqlitedb;

public abstract class DBSetting {
	protected static final String dbFilePath = "/Users/12818/workspace/java/mydb.db";
	protected static DBHelper db = null;
	static {
		if(db==null) {
			db = new DBHelper(dbFilePath);
		}
	}
}
