package net.meshmc.examplemod

import dev.tigr.simpleevents.listener.EventHandler
import dev.tigr.simpleevents.listener.EventListener
import net.meshmc.mesh.Mesh
import net.meshmc.mesh.event.events.render.HudRenderEvent
import net.meshmc.mesh.util.render.Color
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mesh.Mod(modid = "examplemod", name = "Example Mod", version = "1.0-SNAPSHOT", description = "An example mod using the Mesh platform")
class ExampleMod: Mesh.Initializer {
    companion object {
        val LOGGER: Logger = LogManager.getLogger("Example Mod")
        val MESH: Mesh = Mesh.getMesh()
    }

    override fun init() {
        LOGGER.info("Example Mod loaded in {} {}!", MESH.loaderType.name.lowercase(), MESH.loaderVersion)

        MESH.eventManager.register(this)
    }

    @field:EventHandler
    val hudRenderEventListener = EventListener<HudRenderEvent> {
        // draw text to the hud using minecraft's font renderer
        MESH.minecraft.textRenderer.drawText("Hello ${MESH.minecraft.session.username}", 0F, 0F, Color.WHITE)
    }
}