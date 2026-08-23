package com.tacz.guns.client.sound.fmod;

import java.util.Map;

import net.minecraft.resources.ResourceLocation;

/**
 * Maps TACZ gun/action identifiers to FMOD event paths in weapons.bank.
 *
 * <p>Looked up by path (e.g. {@code "event:/Weapons/M4A1/1P M4A1 Fire"}), which requires
 * Master.strings.bank to be loaded (see FmodWeaponSoundManager). The GUID constants in
 * {@link com.tacz.guns.WeaponsEvents} were generated against a different/older weapons.bank
 * and don't match this project's current event tree at all (verified by dumping every event
 * path in the current bank and comparing) -- this map was built directly from that dump
 * instead.
 *
 * <p>Every weapon folder in the bank is bespoke: naming isn't consistent even for the fire
 * event itself (mostly {@code "1P <Name> Fire"}, but e.g. AK47 uses {@code "AK47 1P Shot"},
 * and Uzi/M249/RPD only have a {@code "3P ... Fire"} at all -- no 1P take exists for those).
 * Reload/draw/holster naming is far less consistent still (compare M4A1's
 * {@code "M4A1 ReloadNormalMagIn"} to MP5's {@code "MP5 Reload Start"} to G3A3's
 * {@code "G3A3TacReload"}), so per-weapon action sounds aren't attempted here -- those use
 * the bank's generic per-category ("Shared") events instead, picked by {@link WeaponCategory}.
 *
 * <p>The bank only names a subset of TACZ's default guns directly. Every other gun is mapped
 * to the closest real-world analogue available (e.g. the bolt-action Kar98k and M700 both use
 * the M24's fire event, since all three are bolt-action sniper rifles), falling back to
 * {@link #DEFAULT_SHOOT} for anything not explicitly listed here (addon/custom guns, mostly).
 */
final class WeaponFmodEvents {
    private WeaponFmodEvents() {
    }

    enum WeaponCategory {
        RIFLE, PISTOL, SMG, SHOTGUN
    }

    /** Fallback shoot event for guns not present in {@link #GUN_SHOOT_EVENTS}. */
    static final String DEFAULT_SHOOT = "event:/Weapons/M4A1/1P M4A1 Fire";

    /** Fallback category for guns not present in {@link #GUN_CATEGORIES}. */
    static final WeaponCategory DEFAULT_CATEGORY = WeaponCategory.RIFLE;

    // No per-category reload split (tactical/empty) or bolt sound exists in the bank under
    // Shared/ -- these are the closest generic equivalents available for all categories.
    static final String RELOAD_TACTICAL = "event:/Weapons/Shared/Rifles Shared/Mag In";
    static final String RELOAD_EMPTY = "event:/Weapons/Shared/Rifles Shared/Mag In";
    static final String BOLT = "event:/Weapons/Shared/Rifles Shared/Mag Hit";

    /**
     * Gun display id path (e.g. {@code "m4a1"} from {@code tacz:m4a1}) to shoot event path,
     * covering TACZ's bundled default gun pack. Verified against a dump of every path in the
     * current weapons.bank.
     */
    private static final Map<String, String> GUN_SHOOT_EVENTS = Map.ofEntries(
            Map.entry("aa12", "event:/Weapons/M1014/1P M1014 Fire"),
            Map.entry("ai_awp", "event:/Weapons/M24/1P M24 Fire"),
            Map.entry("ak47", "event:/Weapons/AK47/AK47 1P Shot"),
            Map.entry("aug", "event:/Weapons/SR16/1P SR16 Fire"),
            Map.entry("b93r", "event:/Weapons/G18/1P G18 Fire"),
            Map.entry("cz75", "event:/Weapons/G19 New/1P G19 Fire"),
            Map.entry("db_long", "event:/Weapons/Nova/1P Nova Fire"),
            Map.entry("db_short", "event:/Weapons/Nova/1P Nova Fire"),
            Map.entry("deagle", "event:/Weapons/Python/1P Python Fire"),
            Map.entry("deagle_golden", "event:/Weapons/Python/1P Python Fire"),
            Map.entry("fn_evolys", "event:/Weapons/M249/3P M249 Fire"),
            Map.entry("fn_fal", "event:/Weapons/FNFAL/1P FNFAL Fire"),
            Map.entry("g36k", "event:/Weapons/G36/1P G36 Fire"),
            Map.entry("glock_17", "event:/Weapons/G19 New/1P G19 Fire"),
            Map.entry("hk416d", "event:/Weapons/HK416/1P HK416 Fire"),
            Map.entry("hk_g3", "event:/Weapons/G3A4/1P G3A4 Fire"),
            Map.entry("hk_mk23", "event:/Weapons/SOCOM/1P SOCOM Fire"),
            Map.entry("hk_mp5a5", "event:/Weapons/MP5/1P MP5 Fire 1"),
            Map.entry("kar98", "event:/Weapons/M24/1P M24 Fire"),
            Map.entry("lonetrail", "event:/Weapons/SR16/1P SR16 Fire"),
            Map.entry("m1014", "event:/Weapons/M1014/1P M1014 Fire"),
            Map.entry("m107", "event:/Weapons/Grizzly/1P Grizzly Fire"),
            Map.entry("m16a1", "event:/Weapons/M4A1/1P M4A1 Fire"),
            Map.entry("m16a4", "event:/Weapons/M4A1/1P M4A1 Fire"),
            Map.entry("m1911", "event:/Weapons/USP/1P USP Fire"),
            Map.entry("m249", "event:/Weapons/M249/3P M249 Fire"),
            Map.entry("m320", "event:/Weapons/M320/1P M320 Fire"),
            Map.entry("m4a1", "event:/Weapons/M4A1/1P M4A1 Fire"),
            Map.entry("m700", "event:/Weapons/M24/1P M24 Fire"),
            Map.entry("m870", "event:/Weapons/870/1P 870 Fire"),
            Map.entry("m95", "event:/Weapons/Grizzly/1P Grizzly Fire"),
            Map.entry("m9a4", "event:/Weapons/M92FS/1P M92FS Fire"),
            Map.entry("minigun", "event:/Weapons/M249/3P M249 Fire"),
            Map.entry("mk14", "event:/Weapons/M14/1P M14 Fire"),
            Map.entry("p320", "event:/Weapons/P229/1P P229 Fire"),
            Map.entry("p90", "event:/Weapons/P90/1P P90 Fire"),
            Map.entry("qbz_191", "event:/Weapons/SR16/1P SR16 Fire"),
            Map.entry("qbz_95", "event:/Weapons/SR16/1P SR16 Fire"),
            Map.entry("rhino357", "event:/Weapons/Python/1P Python Fire"),
            Map.entry("rpg7", "event:/Weapons/M32A1/1P M32A1 Fire"),
            Map.entry("rpk", "event:/Weapons/AK47/AK47 1P Shot"),
            Map.entry("scar_h", "event:/Weapons/Scar17/1P Scar17 Fire"),
            Map.entry("scar_l", "event:/Weapons/ScarL/1P ScarL Fire"),
            Map.entry("sks_tactical", "event:/Weapons/SLR/1P SLR Fire"),
            Map.entry("spas_12", "event:/Weapons/Nova/1P Nova Fire"),
            Map.entry("spr15hb", "event:/Weapons/SR16/1P SR16 Fire"),
            Map.entry("springfield1873", "event:/Weapons/M24/1P M24 Fire"),
            Map.entry("taurus500", "event:/Weapons/Python/1P Python Fire"),
            Map.entry("taurus943", "event:/Weapons/Python/1P Python Fire"),
            Map.entry("timeless50", "event:/Weapons/USP/1P USP Fire"),
            Map.entry("type_81", "event:/Weapons/AK47/AK47 1P Shot"),
            Map.entry("ump45", "event:/Weapons/UMP45/1P UMP45 Fire"),
            Map.entry("uzi", "event:/Weapons/Uzi/3P Uzi Fire"),
            Map.entry("vector45", "event:/Weapons/MP9/1P MP9 Fire"));

    private static final Map<String, WeaponCategory> GUN_CATEGORIES = Map.ofEntries(
            Map.entry("aa12", WeaponCategory.SHOTGUN),
            Map.entry("ai_awp", WeaponCategory.RIFLE),
            Map.entry("ak47", WeaponCategory.RIFLE),
            Map.entry("aug", WeaponCategory.RIFLE),
            Map.entry("b93r", WeaponCategory.PISTOL),
            Map.entry("cz75", WeaponCategory.PISTOL),
            Map.entry("db_long", WeaponCategory.SHOTGUN),
            Map.entry("db_short", WeaponCategory.SHOTGUN),
            Map.entry("deagle", WeaponCategory.PISTOL),
            Map.entry("deagle_golden", WeaponCategory.PISTOL),
            Map.entry("fn_evolys", WeaponCategory.RIFLE),
            Map.entry("fn_fal", WeaponCategory.RIFLE),
            Map.entry("g36k", WeaponCategory.RIFLE),
            Map.entry("glock_17", WeaponCategory.PISTOL),
            Map.entry("hk416d", WeaponCategory.RIFLE),
            Map.entry("hk_g3", WeaponCategory.RIFLE),
            Map.entry("hk_mk23", WeaponCategory.PISTOL),
            Map.entry("hk_mp5a5", WeaponCategory.SMG),
            Map.entry("kar98", WeaponCategory.RIFLE),
            Map.entry("lonetrail", WeaponCategory.RIFLE),
            Map.entry("m1014", WeaponCategory.SHOTGUN),
            Map.entry("m107", WeaponCategory.RIFLE),
            Map.entry("m16a1", WeaponCategory.RIFLE),
            Map.entry("m16a4", WeaponCategory.RIFLE),
            Map.entry("m1911", WeaponCategory.PISTOL),
            Map.entry("m249", WeaponCategory.RIFLE),
            Map.entry("m320", WeaponCategory.RIFLE),
            Map.entry("m4a1", WeaponCategory.RIFLE),
            Map.entry("m700", WeaponCategory.RIFLE),
            Map.entry("m870", WeaponCategory.SHOTGUN),
            Map.entry("m95", WeaponCategory.RIFLE),
            Map.entry("m9a4", WeaponCategory.PISTOL),
            Map.entry("minigun", WeaponCategory.RIFLE),
            Map.entry("mk14", WeaponCategory.RIFLE),
            Map.entry("p320", WeaponCategory.PISTOL),
            Map.entry("p90", WeaponCategory.SMG),
            Map.entry("qbz_191", WeaponCategory.RIFLE),
            Map.entry("qbz_95", WeaponCategory.RIFLE),
            Map.entry("rhino357", WeaponCategory.PISTOL),
            Map.entry("rpg7", WeaponCategory.RIFLE),
            Map.entry("rpk", WeaponCategory.RIFLE),
            Map.entry("scar_h", WeaponCategory.RIFLE),
            Map.entry("scar_l", WeaponCategory.RIFLE),
            Map.entry("sks_tactical", WeaponCategory.RIFLE),
            Map.entry("spas_12", WeaponCategory.SHOTGUN),
            Map.entry("spr15hb", WeaponCategory.RIFLE),
            Map.entry("springfield1873", WeaponCategory.RIFLE),
            Map.entry("taurus500", WeaponCategory.PISTOL),
            Map.entry("taurus943", WeaponCategory.PISTOL),
            Map.entry("timeless50", WeaponCategory.PISTOL),
            Map.entry("type_81", WeaponCategory.RIFLE),
            Map.entry("ump45", WeaponCategory.SMG),
            Map.entry("uzi", WeaponCategory.SMG),
            Map.entry("vector45", WeaponCategory.SMG));

    private static final Map<WeaponCategory, String> DRAW_EVENTS = Map.of(
            WeaponCategory.RIFLE, "event:/Weapons/Shared/Draw/Draw Rifle",
            WeaponCategory.PISTOL, "event:/Weapons/Shared/Draw/Draw Pistol",
            WeaponCategory.SMG, "event:/Weapons/Shared/Draw/Draw Sub",
            WeaponCategory.SHOTGUN, "event:/Weapons/Shared/Draw/Draw Shotgun");

    // No per-category holster exists for SMG/shotgun; the rifle one is the closest generic
    // "weapon settles into its holster/sling" sound available.
    private static final Map<WeaponCategory, String> HOLSTER_EVENTS = Map.of(
            WeaponCategory.RIFLE, "event:/Weapons/Shared/Rifles Shared/Rifle Holster",
            WeaponCategory.PISTOL, "event:/Weapons/Shared/Pistols Shared/Pistol Holster",
            WeaponCategory.SMG, "event:/Weapons/Shared/Rifles Shared/Rifle Holster",
            WeaponCategory.SHOTGUN, "event:/Weapons/Shared/Rifles Shared/Rifle Holster");

    static String shootEventFor(ResourceLocation gunDisplayId) {
        return GUN_SHOOT_EVENTS.getOrDefault(gunDisplayId.getPath(), DEFAULT_SHOOT);
    }

    static String drawEventFor(ResourceLocation gunDisplayId) {
        return DRAW_EVENTS.get(GUN_CATEGORIES.getOrDefault(gunDisplayId.getPath(), DEFAULT_CATEGORY));
    }

    static String putAwayEventFor(ResourceLocation gunDisplayId) {
        return HOLSTER_EVENTS.get(GUN_CATEGORIES.getOrDefault(gunDisplayId.getPath(), DEFAULT_CATEGORY));
    }
}
