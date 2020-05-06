package software.bernie.geckolib.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.testentities.entity.StingrayTestEntity;

public class Entities
{
	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, GeckoLib.ModID);
	public static final RegistryObject<EntityType<StingrayTestEntity>> STING_RAY = BuildWaterEntity(StingrayTestEntity::new, StingrayTestEntity.class, 2.845F, 0.3125F);


	public static <T extends Entity> RegistryObject<EntityType<T>> BuildWaterEntity(EntityType.IFactory<T> entity, Class<T> entityClass, float width, float height)
	{
		String name = entityClass.getSimpleName().toLowerCase();
		return ENTITIES.register(name,
				() -> EntityType.Builder.create(entity, EntityClassification.WATER_CREATURE)
						.size(width, height).build(name));
	}
}