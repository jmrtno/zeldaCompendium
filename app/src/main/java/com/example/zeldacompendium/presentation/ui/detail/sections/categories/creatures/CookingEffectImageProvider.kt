package com.example.zeldacompendium.presentation.ui.detail.sections.categories.creatures

import com.example.zeldacompendium.R

class CookingEffectImageProvider {
   companion object {
      fun getImageResource(cookingEffect: String): Int? {
         return when (cookingEffect) {
            "heat resistance" -> R.drawable.heat_resistance
            "frost resistance" -> R.drawable.frost_resistance
            "cold resistance" -> R.drawable.cold_resistance
            "shock resistance" -> R.drawable.shock_resistance
            "sock resistance" -> R.drawable.shock_resistance // API mistake
            "stamina recovery" -> R.drawable.stamina_recovery
            "flame guard" -> R.drawable.heat_guard
            "attack up" -> R.drawable.attack_up
            "stamina up" -> R.drawable.stamina_up
            "stealth up" -> R.drawable.stealth_up
            "defense up" -> R.drawable.defense_up
            "speed up" -> R.drawable.speed_up
            "extra hearts" -> R.drawable.bonus_heart
            "extra stamina" -> R.drawable.extra_stamina
            "swim speed up" -> R.drawable.speed_up
            "cold weather attack" -> R.drawable.cold_atk_up
            "hot weather attack" -> R.drawable.heat_atk_up
            "stormy weather attack" -> R.drawable.lighting_atk_up
            "glow" -> R.drawable.boost_glow
            "gloom recovery" -> R.drawable.resist_gloom
            "slip resistance" -> R.drawable.slip_resist
            else -> null
         }
      }
   }
}