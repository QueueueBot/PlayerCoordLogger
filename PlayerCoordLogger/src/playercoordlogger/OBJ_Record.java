package playercoordlogger;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.UUID;

class OBJ_Record {
	
	
	private UUID uuid;
	private int x;
	private int y;
	private int z;
	// Vertical Angle of Head Direction
	private int pit;
	// Horizontal Angle of Head Direction
	private int yaw;
	private String dim;
	private Timestamp ts;
	
	
	public OBJ_Record(Player p, Timestamp ts) {
		
		this.uuid = p.getUniqueId();
		Location L = p.getLocation();
		this.x = L.getBlockX();
		this.y = L.getBlockY();
		this.z = L.getBlockZ();
		this.pit = (int) L.getPitch();
		this.yaw = (int) L.getYaw();
		this.dim = L.getWorld().getName();
		
		
		if(ts == null) {
			this.ts = new Timestamp(new GregorianCalendar().getTimeInMillis());
		}
		else {
			this.ts = ts;
		}
	}
	
	public String getUUID() {
		return this.uuid.toString();
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getZ() {
		return this.z;
	}
	
	public int getPitch() {
		return this.pit;
	}
	
	public int getYaw() {
		return this.yaw;
	}
	
	public String getDim() {
		return this.dim;
	}
	
	public Timestamp getTimestamp() {
		return this.ts;
	}
	
	
	
	
	

}
