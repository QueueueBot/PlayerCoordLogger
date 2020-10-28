package playercoordlogger;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.UUID;

class OBJ_Record {
	
	
	private UUID uuid;
	private int PosX;
	private int PosY;
	private int PosZ;
	// Vertical Angle of Head Direction
	private double Pitch;
	// Horizontal Angle of Head Direction
	private double Yaw;
	private String dim;
	private Timestamp ts;
	
	
	public OBJ_Record(Player p, Timestamp ts) {
		
		this.uuid = p.getUniqueId();
		Location L = p.getLocation();
		this.PosX = L.getBlockX();
		this.PosY = L.getBlockY();
		this.PosZ = L.getBlockZ();
		this.Pitch = L.getPitch();
		this.Yaw = L.getYaw();
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
	
	public double getX() {
		return this.PosX;
	}
	
	public double getY() {
		return this.PosY;
	}
	
	public double getZ() {
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
	
	
	
	
	

}
