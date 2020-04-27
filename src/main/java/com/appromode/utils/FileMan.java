package com.appromode.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import com.appromode.ci.Initialise;
import com.google.inject.Inject;

public class FileMan {

	private File foFile;
	private FileConfiguration foFileConfig;
	private File fopFile;
	private FileConfiguration fopFileConfig;
	private File ikFile;
	private FileConfiguration ikFileConfig;
	private File schemFolder;

	@Inject
	private Initialise plugin;

	public int stringToInt(String amount) {
		try {
			int value = Integer.parseInt(amount);
			return value;
		} catch (NumberFormatException e) {
			return 1;
		}
	}

	public void createCustomConfigs() {
		foFile = new File(plugin.getDataFolder(), "fotime.yml");
		fopFile = new File(plugin.getDataFolder(), "fopause.yml");
		ikFile = new File(plugin.getDataFolder(), "iktime.yml");
		schemFolder = new File(plugin.getDataFolder(), "schematics");
		if (!foFile.exists()) {
			foFile.getParentFile().mkdirs();
			plugin.saveResource("fotime.yml", false);
		}
		if (!fopFile.exists()) {
			fopFile.getParentFile().mkdirs();
			plugin.saveResource("fopause.yml", false);
		}
		if (!ikFile.exists()) {
			ikFile.getParentFile().mkdirs();
			plugin.saveResource("iktime.yml", false);
		}
		if (!schemFolder.exists()) {
			schemFolder.getParentFile().mkdirs();
		}
		foFileConfig = new YamlConfiguration();
		fopFileConfig = new YamlConfiguration();
		ikFileConfig = new YamlConfiguration();
		try {
			foFileConfig.load(foFile);
			fopFileConfig.load(fopFile);
			ikFileConfig.load(ikFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " Config files generated / checked");
		return;		
	}

	public FileConfiguration foFileConfiguration() {
		return this.foFileConfig;
	}

	public FileConfiguration fopFileConfiguration() {
		return this.fopFileConfig;
	}

	public FileConfiguration ikFileConfiguration() {
		return this.ikFileConfig;
	}

	public void foikConvert() {
		plugin.foCooldownTask.clear();
		plugin.ikCooldownTask.clear();

		if (!plugin.foCooldownTime.isEmpty()) {
			for (UUID entry : plugin.foCooldownTime.keySet()) {
				final UUID uuid = entry;
				int fotime = plugin.foCooldownTime.get(uuid);
				plugin.foTimes.put(uuid, fotime);
			}
			plugin.foCooldownTime.clear();
		}
		if (!plugin.ikCooldownTime.isEmpty()) {
			for (UUID entry : plugin.ikCooldownTime.keySet()) {
				final UUID uuid = entry;
				int iktime = plugin.ikCooldownTime.get(uuid);
				plugin.ikTimes.put(uuid, iktime);
			}
			plugin.ikCooldownTime.clear();
		}
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " flight orb times have been converted");
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " insta-kill sword times have been converted");
		return;
	}

	public void fopauseDump() {
		int emptysfop = fopFileConfiguration().getKeys(false).size();
		if (!plugin.fopause.isEmpty()) {
			if (emptysfop != 0) {
				for (UUID entry : plugin.fopause.keySet()) {
					String suuid = entry.toString();
					fopFileConfiguration().set(suuid, true);
				}
				for (String key : fopFileConfiguration().getKeys(false)) {
					if (!plugin.fopause.containsKey(UUID.fromString(key))) {
						fopFileConfiguration().set(key, false);
					}
				}
				plugin.fopause.clear();
			} else {
				for (UUID entry : plugin.fopause.keySet()) {
					String suuid = entry.toString();
					fopFileConfiguration().set(suuid, true);
				}
				plugin.fopause.clear();
			}
		} else {
			if (emptysfop != 0) {
				for (String key : fopFileConfiguration().getKeys(false)) {
					fopFileConfiguration().set(key, false);
				}
			}
		}
		try {
			fopFileConfiguration().save(fopFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " flight orb pause values have been saved!");
		return;
	}

	public void foikDump() {
		int emptysfo = foFileConfiguration().getKeys(false).size();
		int emptysik = ikFileConfiguration().getKeys(false).size();

		if (!plugin.foTimes.isEmpty()) {
			if (emptysfo != 0) {
				for (UUID entry : plugin.foTimes.keySet()) {
					String suuid = entry.toString();
					foFileConfiguration().set(suuid, plugin.foTimes.get(entry));
				}
				for (String key : foFileConfiguration().getKeys(false)) {
					if (!plugin.foTimes.containsKey(UUID.fromString(key))) {
						foFileConfiguration().set(key, 0);
					}
				}
				plugin.foTimes.clear();
			} else {
				for (UUID entry : plugin.foTimes.keySet()) {
					String suuid = entry.toString();
					foFileConfiguration().set(suuid, plugin.foTimes.get(entry));
				}
				plugin.foTimes.clear();
			}
		} else {
			if (emptysfo != 0) {
				for (String key : foFileConfiguration().getKeys(false)) {
					foFileConfiguration().set(key, 0);
				}
			}
		}

		if (!plugin.ikTimes.isEmpty()) {
			if (emptysik != 0) {
				for (UUID entry : plugin.ikTimes.keySet()) {
					String suuid = entry.toString();
					ikFileConfiguration().set(suuid, plugin.ikTimes.get(entry));
				}
				for (String key : ikFileConfiguration().getKeys(false)) {
					if (!plugin.ikTimes.containsKey(UUID.fromString(key))) {
						ikFileConfiguration().set(key, 0);
					}
				}
				plugin.ikTimes.clear();
			} else {
				for (UUID entry : plugin.ikTimes.keySet()) {
					String suuid = entry.toString();
					ikFileConfiguration().set(suuid, plugin.foTimes.get(entry));
				}
				plugin.ikTimes.clear();
			}
		} else {
			if (emptysik != 0) {
				for (String key : ikFileConfiguration().getKeys(false)) {
					ikFileConfiguration().set(key, 0);
				}
			}
		}

		try {
			foFileConfiguration().save(foFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ikFileConfiguration().save(ikFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " flight orb times have been saved!");
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " insta-kill sword times have been saved!");
		return;
	}

	public void fopauseLoad() {
		int emptyfop = fopFileConfiguration().getKeys(false).size();

		if (emptyfop != 0) {
			for (String key : fopFileConfiguration().getKeys(false)) {
				if (fopFileConfiguration().getBoolean(key) != false) {
					boolean pause = fopFileConfiguration().getBoolean(key);
					final UUID uuid = UUID.fromString(key);
					plugin.fopause.put(uuid, pause);
				}
			}
		}
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " flight orb pause times have been loaded");
		return;
	}

	public void foikLoad() {
		int emptyfo = foFileConfiguration().getKeys(false).size();
		int emptyik = ikFileConfiguration().getKeys(false).size();
		if (emptyfo != 0) {
			for (String key : foFileConfiguration().getKeys(false)) {
				if (foFileConfiguration().getInt(key) != 0) {
					int times = stringToInt(foFileConfiguration().getString(key));
					final UUID uuid = UUID.fromString(key);
					plugin.foTimes.put(uuid, times);
				}
			}
		}

		if (emptyik != 0) {
			for (String key : ikFileConfiguration().getKeys(false)) {
				if (ikFileConfiguration().getInt(key) != 0) {
					int times = stringToInt(ikFileConfiguration().getString(key));
					final UUID uuid = UUID.fromString(key);
					plugin.ikCooldownTime.put(uuid, times);
					plugin.ikCooldownTask.put(uuid, new BukkitRunnable() {
						@Override
						public void run() {
							if (plugin.ikCooldownTime.containsKey(uuid)) {
								plugin.ikCooldownTime.put(uuid, plugin.ikCooldownTime.get(uuid) - 1);
								if (plugin.ikCooldownTime.get(uuid).equals(0)) {
									plugin.ikCooldownTime.remove(uuid);
									plugin.ikCooldownTask.remove(uuid);
								}
							} else {
								cancel();
							}
						}

					});
					plugin.ikCooldownTask.get(uuid).runTaskTimer(plugin, 20, 20);
				}
			}
		}

		try {
			foFileConfiguration().save(foFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ikFileConfiguration().save(ikFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " flight orb times have been loaded");
		plugin.getServer().getConsoleSender().sendMessage(plugin.prefix + " insta-kill sword times have been loaded");
		return;
	}
}
