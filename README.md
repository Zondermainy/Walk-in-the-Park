<div align="center">

# Infinite Parkour Fork (Purpur 26.2)

Плагин **Walk-in-the-Park** (Infinite Parkour) от [Efnilite](https://github.com/Efnilite/Walk-in-the-Park) — адаптированный форк под **Purpur 26.2**.

</div>

## Что это

Это форк оригинального плагина IP v5.3.1.1, обновлённый для совместимости с серверами на базе **Purpur/Paper 26.2**. Оригинальный плагин поддерживал Spigot 1.16–1.21.4 — этот форк добавляет поддержку новой платформы.

## Что изменено

| Было (оригинал) | Стало (форк) |
|---|---|
| `spigot-api 1.20.4-R0.1-SNAPSHOT` | `paper-api 26.2.build.112-stable` |
| Java 17 | Java 21 |
| `fastboard 2.1.5` | `fastboard 2.2.1` |
| `vilib d74a99d` (JitPack) | `vilib 2.0.1.1` (local build) |

### Подробнее

- **Paper API вместо Spigot API** — полная совместимость с Purpur 26.2
- **FastBoard 2.2.1** — нативная поддержка MC 26.2, новая схема scoreboard без мутации final-полей
- **VoidGenerator** — добавлены per-chunk overrides (shouldGenerateNoise/Surface/Caves/Decorations/Mobs/Structures с WorldInfo), совместимость с новым ChunkGenerator API
- **Version.getVersion()** — исправлен парсинг версии MC для формата `26.x` (вместо `1.xx.x`)
- **Option particle guard** — двойной fallback для несуществующих типов частиц
- **World.getWorldFolder()** — правильное определение папки мира через `Bukkit.getWorldContainer()`
- **HoloHook/FloodgateHook** — рефлексивные вызовы (плагин работает без holographicdisplays и floodgate)
- **Убраны тормозные SNAPSHOT-зависимости** из pom.xml (holographicdisplays, floodgate)

## Сборка

```bash
# Сначала собрать vilib
cd vilib
mvn clean package install -Dmaven.test.skip=true

# Затем собрать IP
cd ../Walk-in-the-Park
mvn clean package -Dmaven.test.skip=true
```

JAR будет в `Walk-in-the-Park/target/IP-5.3.1.1.jar`.

## Установка

1. Скачай готовый JAR из [Releases](https://github.com/Zondermainy/Walk-in-the-Park/releases) или собери сам.
2. Положи в папку `plugins/`.
3. Перезапусти сервер.
4. Настрой файл `plugins/IP/config.yml` под свой сервер.

## Оригинальный плагин

- [SpigotMC](https://www.spigotmc.org/resources/87226/)
- [GitHub (оригинал)](https://github.com/Efnilite/Walk-in-the-Park)
- [Wiki](https://efnilite.dev/projects/ip/wiki)

## License

[MIT](https://choosealicense.com/licenses/mit/)
