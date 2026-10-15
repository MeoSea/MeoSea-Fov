<div align="center">

<!-- BANNER HEADER -->
<img src="https://raw.githubusercontent.com/MeoSea/MeoSea-Fov/images/banner.jpg" alt="MeoSea's FOV Banner" width="100%" />

# 👁️ MeoSea's FOV

**Break the limits of Minecraft's default FOV slider.**

[![Modrinth Downloads](https://img.shields.io/modrinth/dt/meosea-fov?color=green&label=Modrinth&logo=modrinth)](https://modrinth.com/project/meosea-fov)
[![Fabric Loader](https://img.shields.io/badge/Fabric_Loader-0.19.5+-blue?logo=fabric)](https://fabricmc.net/)
[![Minecraft](https://img.shields.io/badge/Minecraft-26.3-brightgreen?logo=minecraft)](https://minecraft.net/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

*A tiny, lightweight client-side Fabric mod that grants total control over your field of view range.*

---

<!-- GIF DEMO (Bỏ comment khi bạn có file demo.gif) -->
<!-- <img src="https://raw.githubusercontent.com/MeoSea/MeoSea-Fov/images/demo.gif" alt="FOV Slider Demo" width="85%" /> -->

</div>

## ✨ Key Features

- 📈 **Break the 110 Upper Limit:** Push your max FOV up to 130 (or higher!).
- 📉 **Lower Standard Bounds:** Reduce FOV below 30 for ultra-zoomed perspectives.
- 🏷️ **Dynamic Labels:** The iconic *"Quake Pro"* text automatically locks to your custom maximum FOV.
- ⚡ **Ultra Lightweight:** 
  - Pure client-side (no server installation needed)
  - Zero extra config screens or bloatware
  - Single compact configuration file

---

## 🛠️ Requirements & Compatibility

| Component | Minimum Version Required |
| :--- | :--- |
| **Minecraft** | `26.3` |
| **Fabric Loader** | `0.19.5` or newer |
| **Java** | `25` or newer |

> ℹ️ **Note:** Fabric API is **NOT** required!

---

## 📦 Installation

```text
1. Download & install Fabric Loader for Minecraft 26.3.
2. Grab the latest .jar from Modrinth or GitHub Releases.
3. Drop the .jar file into your `.minecraft/mods` directory.
4. Launch the game once to auto-generate the configuration file.
```

---

## ⚙️ Configuration

The config file will be generated at `config/meoseas-fov.yml`:

```yaml
# Minimum FOV threshold (Valid range: 1 - 70)
minFov: 30

# Maximum FOV threshold (Valid range: 70 - 179)
maxFov: 130
```

<details>
<summary><b>📌 Important Config Notes (Click to expand)</b></summary>

- **Game Restart Required:** The slider boundary is calculated once during game initialization. Restart Minecraft after tweaking values.
- **Auto-Clamping:** Values are clamped so `minFov <= 70 <= maxFov`. Minecraft's default FOV (70) will always remain safely inside the range.
- **Visual Warning:** Setting FOV above `140` causes noticeable fisheye/stretching around screen borders.
- **Safety Fallback:** If your currently saved FOV falls outside your new bounds, Minecraft will automatically reset it to default (70).
</details>

---

## 🤝 Support & Compatibility

- **Conflicts:** This mod hooks into `Options` at creation time. Mods that manipulate the FOV slider bounds simultaneously might cause conflicts.
- **Issues:** Found a bug or have a feature idea? Feel free to open an issue on [GitHub Issues](https://github.com/MeoSea/MeoSea-Fov/issues).

---

<div align="center">

Crafted with ❤️ by **[MeoSea](https://github.com/MeoSea)**  
Released under the [MIT License](LICENSE)

</div>