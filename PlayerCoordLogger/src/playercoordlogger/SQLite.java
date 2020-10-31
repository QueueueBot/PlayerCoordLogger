package playercoordlogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.SQLiteConfig;

public class SQLite implements Logger {
	
	static {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String PluginDir;
	private static String DatabaseDir;
	private static Connection conn;
	private static boolean isOpened = false;
	
	private static final String FILENAME = "database.db";
	private static final String TABLENAME = "Record";
	private static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLENAME +
			" (" + 
			"    `UUID`       VARCHAR(64)    NOT NULL,\n" + 
			"    `Nickname`       VARCHAR(64)    NOT NULL,\n" + 
			"    `PosX`       INT            NOT NULL,\n" + 
			"    `PosY`       INT            NOT NULL,\n" + 
			"    `PosZ`       INT            NOT NULL,\n" + 
			"    `Dim`        VARCHAR(45)    NOT NULL,\n" + 
			"    `Timestamp`  TIMESTAMP      NOT NULL,\n" + 
			"    `Pitch`      DOUBLE         NOT NULL,\n" + 
			"    `Yaw`        DOUBLE         NOT NULL\n" + 
			");";
	private static final String INSERT_SQL = "INSERT INTO " + TABLENAME + "(UUID, Nickname, PosX, PosY, PosZ, Dim, Timestamp, Pitch, Yaw) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	
	public static boolean Init() {
		PluginDir = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("%20", "");
		DatabaseDir = PluginDir + FILENAME;
		// Need Handler for Exception
		return true;
	}

	
	public static int getLog(String s) {
		return 0;
	}

	
	public static int writeLog(OBJ_Record r) {

		if(!isOpened) {
			return -1;
		}
		
		int numRowsInserted = 0;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setString(1,  r.getUUID());
			ps.setString(2,  r.getNickname());
			ps.setInt(3, r.getX());
			ps.setInt(4, r.getY());
			ps.setInt(5, r.getZ());
			ps.setString(6, r.getDim());
			ps.setTimestamp(7, r.getTimestamp());
			ps.setDouble(8, r.getPitch());
			ps.setDouble(9, r.getPitch());
			
			numRowsInserted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return numRowsInserted;
		
	}

	
	public int writeLog(ArrayList<OBJ_Record> list) {
		for(OBJ_Record r : list) {
			writeLog(r);
		}
		// Need Handler for Exception
		return 0;
	}
	
	private int createTable() {
		if(!isOpened) {
			return -1;
		}
		
		int numRowsInserted = 0;
		PreparedStatement ps = null;
		
		try {
			ps = this.conn.prepareStatement(CREATE_SQL);
			
			numRowsInserted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return 1;
	}
	
	
	private ArrayList<OBJ_Record> SelectAll() {
		if(!isOpened) {
			return null;
		}
		String CAT_SQL = "SELECT * FROM " + TABLENAME + ";";
		ArrayList<OBJ_Record> list = new ArrayList<OBJ_Record>();
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(CAT_SQL);
			
			while(rs.next()) {
				OBJ_Record r = new OBJ_Record(
						rs.getString("UUID"),
						rs.getString("Nickname"),
						rs.getInt("PosX"), 
						rs.getInt("PosY"), 
						rs.getInt("PosZ"), 
						rs.getString("Dim"), 
						rs.getTimestamp("Timestamp"), 
						rs.getDouble("Pitch"),
						rs.getDouble("Yaw")
						);
				list.add(r);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		
		} finally {
			
			
		}
		return list;
	}
	
	public void open() {
		try {
			SQLiteConfig cfg = new SQLiteConfig();
			cfg.setReadOnly(false);
			this.conn = DriverManager.getConnection("jdbc:sqlite:/" + DatabaseDir);
			
		} catch(SQLException e) {
			e.printStackTrace();
			isOpened = false;
		}
		isOpened = true;
	}
	
	
	
	private static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private static boolean close() {
		
		if(isOpened == false) {
			return true;
		}
		try {
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
