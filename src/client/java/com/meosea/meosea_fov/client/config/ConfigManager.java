package com.meosea.meosea_fov.client.config;

import net.fabricmc.loader.api.FabricLoader;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public final class ConfigManager {
	private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("meoseas-fov.yml");
	private static ConfigManager instance;

	public int minFov = 30;
	public int maxFov = 110;

	public static ConfigManager get() {
		if (instance == null) {
			instance = load();
		}
		return instance;
	}

	private static ConfigManager load() {
		ConfigManager config = new ConfigManager();

		if (Files.exists(PATH)) {
			try (Reader reader = Files.newBufferedReader(PATH)) {
				Yaml yaml = new Yaml(new SafeConstructor(new LoaderOptions()));
				Object data = yaml.load(reader);
				if (data instanceof Map<?, ?> map) {
					config.minFov = readInt(map, "minFov", config.minFov);
					config.maxFov = readInt(map, "maxFov", config.maxFov);
				}
			} catch (Exception e) {
				System.err.println("[MeoSea's Fov] Không đọc được config, dùng giá trị mặc định: " + e);
			}
		}

		config.minFov = Math.max(1, Math.min(config.minFov, 70));
		config.maxFov = Math.max(70, Math.min(config.maxFov, 179));

		save(config);
		return config;
	}

	private static int readInt(Map<?, ?> map, String key, int fallback) {
		return map.get(key) instanceof Number n ? n.intValue() : fallback;
	}

	private static void save(ConfigManager config) {
		String text = """
			# MeoSea's Fov
			# Cần khởi động lại game sau khi sửa.

			# FOV nhỏ nhất của slider (1 - 70)
			minFov: %d

			# FOV lớn nhất của slider (70 - 179)
			maxFov: %d
			""".formatted(config.minFov, config.maxFov);

		try {
			Files.writeString(PATH, text);
		} catch (IOException e) {
			System.err.println("[MeoSea's Fov] Không ghi được config: " + e);
		}
	}
}