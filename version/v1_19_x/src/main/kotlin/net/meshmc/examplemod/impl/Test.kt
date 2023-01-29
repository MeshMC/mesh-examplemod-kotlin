package net.meshmc.examplemod.impl

import net.meshmc.examplemod.ExampleMod
import net.meshmc.examplemod.ITest
import net.meshmc.mesh.loader.Mod

@Mod.Interface
class Test: ITest {
    override fun test() {
        // can access version specific code here
        ExampleMod.LOGGER.info("Running code from 1.19.3!")
    }
}