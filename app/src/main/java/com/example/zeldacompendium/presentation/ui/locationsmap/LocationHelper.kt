package com.example.zeldacompendium.presentation.ui.locationsmap

enum class LocationBreathHelper(val commonLocation: String, val coordinates: String) {
   WEST_NECLUDA("West Necluda", "z4,1296,1524"),
   EAST_NECLUDA("East Necluda", "z4,2680,2508"),
   HYRULE_FIELD("Hyrule Field", "z4,-460,580"),
   NECLUDA_SEA("Necluda Sea", "z4,4140,2844"),
   HYRULE_RIDGE("Hyrule Ridge", "z4,-2384,-408"),
   GERUDO_HIGHLANDS("Gerudo Highlands", "z4,-4088,844"),
   FARON_GRASSLANDS("Faron Grasslands", "z4,-424,3156"),
   LANAYRU_SEA("Lanayru Sea", "z4,4676,-196"),
   LANAYRU_GREAT_SPRING("Lanayru Great Spring", "z4,3696,260"),
   ELDIN_CANYON("Eldin Canyon", "z4,1852,-1400"),
   DEATH_MOUNTAIN("Death Mountain", "z4,2524,-2768"),
   GREAT_HYRULE_FOREST("Great Hyrule Forest", "z4,364,-2544"),
   ELDIN_MOUNTAINS("Eldin Mountains", "z4,1312,-3368"),
   GERUDO_DESERT("Gerudo Desert", "z4,-3664,3368"),
   TABANTHA_FRONTIER("Tabantha Frontier", "z4,-3476,-1180"),
   HEBRA_MOUNTAINS("Hebra Mountains", "z4,-3080,-3024"),
   GREATER_HYRULE("Greater Hyrule", "z2,-240,8"),
   THYPHLO_RUINS("Thyphlo Ruins", "z6,327,-3080"),
   AKKALA_HIGHLANDS("Akkala Highlands", "z4,3652,-2224"),
   RITO_STABLE("Rito Stable", "z4,-3256,-1756"),
   AKKALA_SEA("Akkala Sea", "z4,4812,-3364"),
   FLORIA_BRIDGE("Floria Bridge", "z5,1738,3468"),
   SATORI_MOUNTAIN("Satori Mountain", "z5,-2228,338"),
   LANAYRU_WETLANDS("Lanayru Wetlands", "z4,1748,-116"),
   DEEP_AKKALA("Deep Akkala", "z4,3604,-3188"),
   CRENEL_PEAK("Crenel Peak", "z5,1172,-320"),
   SERES_SCABLANDS("Seres Scablands", "z5,-2324,-450"),
   LAKE_HYLIA("Lake Hylia", "z4,-148,25200"),
   LAKE_FLORIA("Lake Floria", "z5,1738,3532"),
   DIVINE_BEAST_VAH_MEDOH("Divine Beast Vah Medoh", "z6,-3614,-1862"),
   HYRULE_CASTLE("Hyrule Castle", "z5,-254,-612"),
   DIVINE_BEAST_VAH_RUDANIA("Divine Beast Vah Rudania", "z6,2451.85,-2559.08"),
   YIGA_CLAN_HIDEOUT("Yiga Clan Hideout", "z4,-3592,1380"),
   DIVINE_BEAST_VAH_RUTA("Divine Beast Vah Ruta", "z5,3662,-176"),
   MOUNT_LANAYRU("Mount Lanayru", "z4,3896,1420"),
   DIVINE_BEAST_VAH_NABORIS("Divine Beast Vah Naboris", "z5,-2110,2616"),
   GERUDO_TOWN("Gerudo Town", "z4,-3836,2916"),
   FARON("Faron", "z4,944,3016"),
   KAKARIKO_VILLAGE("Kakariko Village", "z4,1808,984"),
   ZORA_RIVER("Zora River", "z5,2658,-364"),
   HYRULE_CAVES("Hyrule Caves", "z2,-240,8"),
   FARON_NECLUDA("Faron Necluda", "z2,1840,8"),
   ZORAS_DOMAIN("Zora's Domain", "z5,3272,-402"),
   ELDIN_GREAT_SPRING("Eldin Great Spring", "z5,2018,-744"),
   FARON_SEA("Faron Sea", "z4,-52,3368"),
   GERUDO_CANYON("Gerudo Canyon", "z5,-2308,2216"),
   LANAYRU("Lanayru", "z3,3200,352"),
   HATENO_VILLAGE("Hateno Village", "z5,3592,2122"),
   LURELIN_VILLAGE("Lurelin Village", "z5,3010,3478"),
   TABANTHA_TUNDRA("Tabantha Tundra", "z4,-1812,-2792"),
   LOMEI_LABYRINTH_ISLAND("Lomei Labyrinth Island", "z5,4654,-3650"),
   RITO_VILLAGE("Rito Village", "z5,-3618,-1808"),
   GORON_CITY("Goron City", "z5,1686,-2468"),
   GREAT_PLATEAU("Great Plateau", "z5,-930,1910"),
   UPLAND_ZORANA("Upland Zorana", "z5,3138,-876"),
   EVENTIDE_ISLAND("Eventide Island", "z5,4606,3646");

   companion object {
      fun fromCommonLocation(commonLocation: String): String? {
         return entries.find { it.commonLocation == commonLocation }?.coordinates
      }
   }
}

enum class LocationTearsHelper(val commonLocation: String, val coordinates: String) {
   WEST_NECLUDA("West Necluda", "z4,1296,1524,Surface"),
   EAST_NECLUDA("East Necluda", "z4,2680,2508,Surface"),
   HYRULE_FIELD("Hyrule Field", "z4,-460,580,Surface"),
   NECLUDA_SEA("Necluda Sea", "z4,4140,2844,Surface"),
   HYRULE_RIDGE("Hyrule Ridge", "z4,-2384,-408,Surface"),
   GERUDO_HIGHLANDS("Gerudo Highlands", "z4,-4088,844,Surface"),
   FARON_GRASSLANDS("Faron Grasslands", "z4,-424,3156,Surface"),
   LANAYRU_SEA("Lanayru Sea", "z4,4676,-196,Surface"),
   LANAYRU_GREAT_SPRING("Lanayru Great Spring", "z4,3696,260,Surface"),
   ELDIN_CANYON("Eldin Canyon", "z4,1852,-1400,Surface"),
   DEATH_MOUNTAIN("Death Mountain", "z4,2524,-2768,Surface"),
   GREAT_HYRULE_FOREST("Great Hyrule Forest", "z4,364,-2544,Surface"),
   ELDIN_MOUNTAINS("Eldin Mountains", "z4,1312,-3368,Surface"),
   GERUDO_DESERT("Gerudo Desert", "z4,-3664,3368,Surface"),
   TABANTHA_FRONTIER("Tabantha Frontier", "z4,-3476,-1180,Surface"),
   HEBRA_MOUNTAINS("Hebra Mountains", "z4,-3080,-3024,Surface"),
   GREATER_HYRULE("Greater Hyrule", "z2,-240,8,Surface"),
   AKKALA_HIGHLANDS("Akkala Highlands", "z4,3652,-2224,Surface"),
   RITO_STABLE("Rito Stable", "z4,-3256,-1756,Surface"),
   AKKALA_SEA("Akkala Sea", "z4,4812,-3364,Surface"),
   FLORIA_BRIDGE("Floria Bridge", "z5,1738,3468,Surface"),
   SATORI_MOUNTAIN("Satori Mountain", "z5,-2228,338,Surface"),
   LANAYRU_WETLANDS("Lanayru Wetlands", "z4,1748,-116,Surface"),
   DEEP_AKKALA("Deep Akkala", "z4,3604,-3188,Surface"),
   CRENEL_PEAK("Crenel Peak", "z5,1172,-320,Surface"),
   SERES_SCABLANDS("Seres Scablands", "z5,-2324,-450,Surface"),
   LAKE_HYLIA("Lake Hylia", "z4,-148,25200,Surface"),
   LAKE_FLORIA("Lake Floria", "z5,1738,3532,Surface"),
   DIVINE_BEAST_VAH_MEDOH("Divine Beast Vah Medoh", "z6,-3614,-1862,Surface"),
   HYRULE_CASTLE("Hyrule Castle", "z5,-254,-612,Surface"),
   DIVINE_BEAST_VAH_RUDANIA("Divine Beast Vah Rudania", "z6,2451.85,-2559.08,Surface"),
   YIGA_CLAN_HIDEOUT("Yiga Clan Hideout", "z4,-3592,1380,Surface"),
   DIVINE_BEAST_VAH_RUTA("Divine Beast Vah Ruta", "z5,3662,-176,Surface"),
   MOUNT_LANAYRU("Mount Lanayru", "z4,3896,1420,Surface"),
   DIVINE_BEAST_VAH_NABORIS("Divine Beast Vah Naboris", "z5,-2110,2616,Surface"),
   GERUDO_TOWN("Gerudo Town", "z4,-3836,2916,Surface"),
   FARON("Faron", "z4,944,3016,Surface"),
   KAKARIKO_VILLAGE("Kakariko Village", "z4,1808,984,Surface"),
   //
   GREAT_ABANDONED_CENTRAL_MINE("Great Abandoned Central Mine", "z4,-856,1716,Depths"),
   LANAYRU_WETLAND_DEPTHS("Lanayru Wetland Depths", " z4,1788,228,Depths"),
   THUNDERHEAD_ISLES("Thunderhead Isles", "z6,912,3065,Sky"),
   GREAT_SKY_ISLAND("Great Sky Island", "z6,394,1260,Sky"),
   NORTH_TABANTHA_SKY_ARCHIPELAGO("North Tabantha Sky Archipelago", "z6,-3601,-1334,Sky"),
   ZORA_RIVER("Zora River", "z6,2658,-364,Surface"),
   HYRULE_CAVES("Hyrule Caves", "z2,-240,8,Surface"),
   HYRULE_SKY_ISLANDS("Hyrule Sky Islands", "z3,-464,-56,Sky"),
   TABANTHA_SKY_ARCHIPELAGO("Tabantha Sky Archipelago", "z6,-2943,-558,Sky"),
   WEST_HEBRA_SKY_ARCHIPELAGO("West Hebra Sky Archipelago", "z6,-3846,-2300,Sky"),
   FARON_NECLUDA("Faron Necluda", "z2,1840,8,Surface"),
   ZORAS_DOMAIN("Zora's Domain", "z5,3330,-546,Surface"),
   ELDIN_GREAT_SPRING("Eldin Great Spring", "z5,2018,-744,Surface"),
   FARON_SEA("Faron Sea", "z6,-51,3986,Surface"),
   EAST_GERUDO_SKY_ARCHIPELAGO("East Gerudo Sky Archipelago", "z6,-1866,2316,Sky"),
   ELDIN_SKY_ARCHIPELAGO("Eldin Sky Archipelago", "z6,1777,-2705,Sky"),
   SOUTH_LANAYRU_SKY_ARCHIPELAGO("South Lanayru Sky Archipelago", "z6,4368.4,1254.57,Sky"),
   GERUDO_CANYON("Gerudo Canyon", "z6,-2308,2216,Surface"),
   LANAYRU("Lanayru", "z4,3176,616,Surface"),
   HATENO_VILLAGE("Hateno Village", "z5,3546,2090,Surface"),
   LURELIN_VILLAGE("Lurelin Village", "z5,3008,3474,Surface"),
   CENTRAL_HYRULE_SKY("Central Hyrule Sky", "z3,-248,-80,Sky"),
   TABANTHA_TUNDRA("Tabantha Tundra", "z6,-1812,-2793,Surface"),
   NORTH_NECLUDA_SKY_ARCHIPELAGO("North Necluda Sky Archipelago", "z6,1795,864,Sky"),
   HEBRA_MOUNTAINS_DEPTHS("Hebra Mountains Depths", "z6,-3079,-3025,Depths"),
   TABANTHA_FRONTIER_DEPTHS("Tabantha Frontier Depths", "z6,-3477,-1215,Depths"),
   ELDIN_MOUNTAINS_DEPTHS("Eldin Mountains Depths", "z6,1310,-3376,Depths"),
   FIRE_TEMPLE("Fire Temple", "z6,1272,-2817,Depths"),
   GERUDO_DESERT_SKY("Gerudo Desert Sky", "z4,-3624,2760,Sky"),
   NECLUDA_SEA_SKY("Necluda Sea Sky", "z5,4138,2828,Sky"),
   CENTRAL_HYRULE_DEPTHS("Central Hyrule Depths", "z4,-256,116,Depths"),
   GERUDO_DESERT_DEPTHS("Gerudo Desert Depths", "z6,-3682,3429,Depths"),
   EAST_NECLUDA_DEPTHS("East Necluda Depths", "z6,2679,2507,Depths"),
   NORTH_AKKALA_SKY_ARCHIPELAGO("North Akkala Sky Archipelago", "z6,3704,-2999,Sky"),
   RISING_ISLAND_CHAIN("Rising Island Chain", "z6,-3156,-3215,Sky"),
   SPIRIT_TEMPLE("Spirit Temple", ""),
   GERUDO_HIGHLANDS_DEPTHS("Gerudo Highlands Depths", "z6,-4089,843,Depths"),
   FARON_GRASSLANDS_DEPTHS("Faron Grasslands Depths", "z6,-423,3156,Depths"),
   DEATH_MOUNTAIN_DEPTHS("Death Mountain Depths", "z6,2530,-2479,Depths"),
   WIND_TEMPLE("Wind Temple", "z6,-2859,-3005,Sky"),
   WATER_TEMPLE("Water Temple", "z6,3357,-772,Sky"),
   THYPHLO_RUINS("Thyphlo Ruins", "z6,327,-3080,Surface"),
   ELDIN_CANYON_DEPTHS("Eldin Canyon Depths", "z6,1853,-1401,Depths"),
   WEST_NECLUDA_DEPTHS("West Necluda Depths", "z6,1297,1525,Depths"),
   THE_DEPTHS("The Depths", "z2,-560,8,Depths"),
   DEEP_AKKALA_DEPTHS("Deep Akkala Depths", "z6,3602,-3186,Depths"),
   LANAYRU_SKY_ARCHIPELAGO("Lanayru Sky Archipelago", "z6,3010,-83,Sky"),
   MOUNT_LANAYRU_DEPTHS("Mount Lanayru Depths", "z6,3882,1120,Depths"),
   LIGHTNING_TEMPLE("Lightning Temple", "z6,-4531,3641,Surface"),
   NORTH_GERUDO_SKY_ARCHIPELAGO("North Gerudo Sky Archipelago", "z6,-3573,608,Sky"),
   HYRULE_RIDGE_DEPTHS("Hyrule Ridge Depths", "z6,-2383,-407,Depths"),
   AKKALA_HIGHLANDS_DEPTHS("Akkala Highlands Depths", "z6,3476.85,-2205.88,Depths"),
   ABANDONED_KAKARIKO_MINE("Abandoned Kakariko Mine", "z6,1824,1198,Depths"),
   NECLUDA_SKY_ARCHIPELAGO("Necluda Sky Archipelago", "z6,2540.86,2270.68,Sky"),
   SOUTH_ELDIN_SKY_ARCHIPELAGO("South Eldin Sky Archipelago", "z6,1925,-799,Sky"),
   LANAYRU_GREAT_SPRING_SKY("Lanayru Great Spring Sky", "z4,3176,500,Sky"),
   LANAYRU_WETLANDS_DEPTHS("Lanayru Wetlands Depths", "z6,1826,59,Depths"),
   LOMEI_LABYRINTH_ISLAND("Lomei Labyrinth Island", "z6,4655,-3527,Surface"),
   RITO_VILLAGE("Rito Village", "z5,-3652,-1806,Surface"),
   GORON_CITY("Goron City", "z5,1658,-2440,Surface"),
   GREAT_PLATEAU("Great Plateau", "z6,-938,1906,Surface"),
   UPLAND_ZORANA("Upland Zorana", "z6,3137,-877,Surface"),
   EVENTIDE_ISLAND("Eventide Island", "z6,4586,3630,Surface");

   companion object {
      fun fromCommonLocation(commonLocation: String): String? {
         return entries.find { it.commonLocation == commonLocation }?.coordinates
      }
   }
}