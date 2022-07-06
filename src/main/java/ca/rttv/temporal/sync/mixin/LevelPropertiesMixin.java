package ca.rttv.temporal.sync.mixin;

import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LevelProperties.class, priority = 990)
abstract class LevelPropertiesMixin {
	@Inject(method = "getTimeOfDay", at = @At("HEAD"), cancellable = true)
    private void getTimeOfDay(CallbackInfoReturnable<Long> cir) {
        cir.setReturnValue((long) (System.currentTimeMillis() / 1000 % 86400 / 3.6d));
    }
}
