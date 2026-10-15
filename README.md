# MeoSea's FOV

A tiny, client-side Fabric mod that lets you change the limits of Minecraft's FOV slider.

By default Minecraft only allows an FOV between 30 and 110. This mod lets you set your own minimum and maximum in a config file, and the slider in the video settings follows it.

## Features

- Raise the maximum FOV beyond 110 (default: 130)
- Lower the minimum FOV below 30 if you want
- The "Quake Pro" label moves to your new maximum
- Lightweight: one config file, no extra screens, no gameplay changes

## Requirements

- Minecraft 26.3
- [Fabric Loader](https://fabricmc.net/use/) 0.19.5 or newer
- Java 25 or newer

Fabric API is **not** required. The mod is client-side only, so you do not need to install it on servers.

## Installation

1. Install Fabric Loader for Minecraft 26.3.
2. Download the latest `.jar` from [Modrinth](https://modrinth.com/project/meosea-fov) or the [releases page](https://github.com/MeoSea/MeoSea-Fov).
3. Put the file into your `mods` folder.
4. Launch the game once. The config file will be created automatically.

## Configuration

The config file is created at `config/meoseas-fov.yml`:

```yaml
# FOV minimum of the slider (1 - 70)
minFov: 30

# FOV maximum of the slider (70 - 179)
maxFov: 130
```

Notes:

- **Restart the game** after editing the file. The slider range is created once at startup.
- Values are clamped so that `minFov <= 70 <= maxFov`. 70 is Minecraft's default FOV, so the default always stays on the slider.
- FOV values above about 140 look heavily stretched at the edges of the screen.
- If your saved FOV is outside the new range, Minecraft resets it to the default.

## Compatibility

The mod changes the FOV option when `Options` is created, so it may conflict with other mods that also change the FOV slider range. If you run into a problem, please open an issue and include your `latest.log`.

## Reporting issues

Found a bug or have a suggestion? Open an issue on [GitHub](https://github.com/MeoSea).

## License

Released under the [MIT License](LICENSE).

---

Made by [MeoSea](https://github.com/MeoSea).
