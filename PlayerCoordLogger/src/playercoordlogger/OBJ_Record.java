package playercoordlogger;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.UUID;

class OBJ_Record {
	
	
	private String uuid;
	private int PosX;
	private int PosY;
	private int PosZ;
	private String dim;
	private Timestamp ts;
	// Vertical Angle of Head Direction
	private double Pitch;
	// Horizontal Angle of Head Direction
	private double Yaw;
	
	
	public OBJ_Record(Player p, Timestamp ts) {
		this(
				p.getUniqueId().toString()
				, p.getLocation().getBlockX()
				, p.getLocation().getBlockY()
				, p.getLocation().getBlockZ()
				, p.getLocation().getWorld().getName()
				, getGeoTimestamp()
				, (double)p.getLocation().getPitch()
				, (double)p.getLocation().getYaw()
				);
	}
	
	public OBJ_Record() {
		this(
				new UUID(123123, 1234123).toString()
				, (int) (Math.random()*100)
				, (int) (Math.random()*256)
				, (int) (Math.random()*100)
				, "test_world"
				, getGeoTimestamp()
				, (Math.random()*365)
				, (Math.random()*365)
				);
	}
	
	public OBJ_Record(String uuid, int x, int y, int z, String dim, Timestamp ts, double pitch, double yaw) {
		
		this.uuid = uuid;
		this.PosX = x;
		this.PosY = y;
		this.PosZ = z;
		this.dim = dim;
		this.ts = ts;
		this.Pitch = pitch;
		this.Yaw = yaw;
		
		
	}
	
	
	
	public String getUUID() {
		return this.uuid.toString();
	}
	
	public int getX() {
		return this.PosX;
	}
	
	public int getY() {
		return this.PosY;
	}
	
	public int getZ() {
		return this.PosZ;
	}
	
	public double getPitch() {
		return this.Pitch;
	}
	
	public double getYaw() {
		return this.Yaw;
	}
	
	public String getDim() {
		return this.dim;
	}
	
	public Timestamp getTimestamp() {
		return this.ts;
	}
	
	public static Timestamp getGeoTimestamp() {
		return new Timestamp(new GregorianCalendar().getTimeInMillis());
	}
	
	
	
	

}
