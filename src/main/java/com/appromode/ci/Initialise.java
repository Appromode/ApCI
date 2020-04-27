package com.appromode.ci;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.appromode.listener.AdminMenuListener;
import com.appromode.listener.CrateInventoryListener;
import com.appromode.listener.DSchemListener;
import com.appromode.listener.FlightOrbListener;
import com.appromode.listener.InstaSwordListener;
import com.appromode.listener.KitShardListener;
import com.appromode.listener.KitUnlockListener;
import com.appromode.listener.LeaveListener;
import com.appromode.listener.PJoinListener;
import com.appromode.listener.RankOrbListener;
import com.appromode.listener.SchematicListener;
import com.appromode.utils.FileMan;
import com.appromode.utils.FoRunnable;
import com.appromode.utils.RankOrbConfirm;
import com.appromode.versions.NMS;
import com.appromode.versions.NMS_1_10_R1;
import com.appromode.versions.NMS_1_11_R1;
import com.appromode.versions.NMS_1_12_R1;
import com.appromode.versions.NMS_1_13_R1;
import com.appromode.versions.NMS_1_13_R2;
import com.appromode.versions.NMS_1_14_R1;
import com.appromode.versions.NMS_1_15_R1;
import com.appromode.versions.NMS_1_8_R1;
import com.appromode.versions.NMS_1_8_R2;
import com.appromode.versions.NMS_1_8_R3;
import com.appromode.versions.NMS_1_9_R1;
import com.appromode.versions.NMS_1_9_R2;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Initialise extends JavaPlugin{
	
	public String prefix = this.getConfig().getString("prefix");
	public String servern = this.getConfig().getString("servername");
	public String syntax = this.getConfig().getString("syntaxerror");
	public String noperm = this.getConfig().getString("nopermission");
	public String pnotfound = this.getConfig().getString("playernotfound");
	public String error = this.getConfig().getString("error");
	public String warzone = this.getConfig().getString("warzoneworldname");
	public String version;
	
	public HashMap<UUID, Integer> foCooldownTime = new HashMap<UUID, Integer>();
	public HashMap<UUID, BukkitRunnable> foCooldownTask = new HashMap<UUID, BukkitRunnable>();
	public HashMap<UUID, Integer> foTimes = new HashMap<UUID, Integer>();
	public HashMap<UUID, Boolean> fopause = new HashMap<UUID, Boolean>();
	public HashMap<UUID, Integer> ikCooldownTime = new HashMap<UUID, Integer>();
	public HashMap<UUID, BukkitRunnable> ikCooldownTask = new HashMap<UUID, BukkitRunnable>();
	public HashMap<UUID, Integer> ikTimes = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> confirmTime = new HashMap<UUID, Integer>();
	public HashMap<UUID, BukkitRunnable> confirmTask = new HashMap<UUID, BukkitRunnable>();
	public HashMap<UUID, Integer> ciConfirmed = new HashMap<UUID, Integer>();
	
	public NMS nms;
	
	@Inject
	private FileMan fm;
	
	@Inject
	private FoRunnable fr;
	
	@Inject
	private RankOrbConfirm roc;
	
	@Inject
	private Commands command;
	
	@Inject
	private AdminMenuListener aml;
	
	@Inject
	private PJoinListener jl;
	
	@Inject
	private FlightOrbListener fol;
	
	@Inject
	private DSchemListener dsl;
	
	@Inject
	private InstaSwordListener isl;
	
	@Inject
	private KitShardListener ksl;
	
	@Inject
	private KitUnlockListener kul;
	
	@Inject
	private RankOrbListener rol;
	
	@Inject
	private SchematicListener sl;
	
	@Inject
	private LeaveListener ll;
	
	@Inject
	private CrateInventoryListener cil;
	
	@Override
	public void onEnable() {
		if (setup()) {
			BinderModule module = new BinderModule(this);
		    Injector injector = module.createInjector();
		    injector.injectMembers(this);
			this.saveDefaultConfig();
			fm.createCustomConfigs();
			this.getCommand("apci").setExecutor(command);
			this.getServer().getPluginManager().registerEvents(aml, this);
			this.getServer().getPluginManager().registerEvents(jl, this);
			this.getServer().getPluginManager().registerEvents(fol, this);
			this.getServer().getPluginManager().registerEvents(dsl, this);
			this.getServer().getPluginManager().registerEvents(isl, this);
			this.getServer().getPluginManager().registerEvents(ksl, this);
			this.getServer().getPluginManager().registerEvents(kul, this);
			this.getServer().getPluginManager().registerEvents(rol, this);
			this.getServer().getPluginManager().registerEvents(sl, this);
			this.getServer().getPluginManager().registerEvents(ll, this);
			this.getServer().getPluginManager().registerEvents(cil, this);
			roc.runTaskTimer(this, 0, 20);
			fr.runTaskTimer(this, 0, 20);
			fm.fopauseLoad();
			fm.foikLoad();		
			getServer().getConsoleSender().sendMessage(prefix + " Ap CI has been enabled");
		} else {
			getServer().getConsoleSender().sendMessage(prefix + " Ap CI failed to initialise");
			getServer().getConsoleSender().sendMessage(prefix + " Your server version is not compatible with this plugin!");
		}
		
	}
	
	private boolean setup() {
		try {
			version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
		getServer().getConsoleSender().sendMessage(prefix + " Your server is running version" + version);
		if (version.equals("v1_8_R1")) {
			nms = new NMS_1_8_R1();
		} else if (version.equals("v1_8_R2")) {
			nms = new NMS_1_8_R2();
		} else if (version.equals("v1_8_R3")) {
			nms = new NMS_1_8_R3();
		} else if (version.equals("v1_9_R1")) {
			nms = new NMS_1_9_R1();
		} else if (version.equals("v1_9_R2")) {
			nms = new NMS_1_9_R2();
		} else if (version.equals("v1_10_R1")) {
			nms = new NMS_1_10_R1();
		} else if (version.equals("v1_11_R1")) {
			nms = new NMS_1_11_R1();
		} else if (version.equals("v1_12_R1")) {
			nms = new NMS_1_12_R1();
		} else if (version.equals("v1_13_R1")) {
			nms = new NMS_1_13_R1();
		} else if (version.equals("v1_13_R2")) {
			nms = new NMS_1_13_R2();
		} else if (version.equals("v1_14_R1")) {
			nms = new NMS_1_14_R1();
		} else if (version.equals("v1_15_R1")) {
			nms = new NMS_1_15_R1();
		}
		return nms != null;	    
	}
	
	@Override
	public void onDisable() {
		fm.fopauseDump();
		fm.foikConvert();
		fm.foikDump();
		getServer().getConsoleSender().sendMessage(prefix + " Ap CI has been disabled");
	}

}
