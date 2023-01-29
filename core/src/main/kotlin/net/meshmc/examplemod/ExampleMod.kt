package net.meshmc.examplemod

import net.meshmc.mesh.loader.MeshLoader;
import net.meshmc.mesh.loader.Mod
import org.apache.logging.log4j.LogManager

class ExampleMod: Mod.Initializer {
    companion object {
        val LOGGER = LogManager.getLogger("Example Mod")

        @Mod.Instance
        var INSTANCE: ExampleMod? = null
    }

    @Mod.Interface
    var test: ITest? = null

    override fun init(mod: Mod) {
        LOGGER.info("Example Mod loaded in {} {}!",
                MeshLoader.getInstance().getRuntime().name.toLowerCase(),
                MeshLoader.getInstance().getGameVersion())

        INSTANCE?.test?.test()
    }
}