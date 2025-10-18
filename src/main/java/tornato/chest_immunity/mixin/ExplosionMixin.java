package tornato.chest_immunity.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({ExplosionBehavior.class, Entity.class})
public class ExplosionMixin {
    @ModifyReturnValue(method = {"canDestroyBlock", "canExplosionDestroyBlock"}, at = @At("RETURN"), require = 0)
    private boolean foo(boolean original, Explosion explosion, BlockView world, BlockPos pos, BlockState state, float power) {
        return original && world.getBlockEntity(pos) == null;
    }
}
