package ru.ilyamnl.homework

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class CerealStorageOldImplOldTest {
    private val defaultContainerManager: CerealStorageOld = CerealStorageOldImplOld(20f, 60f)

    @Test
    fun getContainerCapacity() {
        Assertions.assertEquals(
            20f, defaultContainerManager.containerCapacity,
            "Container capacity must be 20f"
        )
    }

    @Test
    fun `should throw IllegalArgumentException if container capacity negative`() {
        Assertions.assertThrows(IllegalArgumentException::class.java)
        { CerealStorageOldImplOld(-20f, 60f) }
    }

    @Test
    fun `should not throw IllegalArgumentException if container capacity negative`() {
        Assertions.assertDoesNotThrow { CerealStorageOldImplOld(0f, 60f) }
    }

    @Test
    fun getStorageCapacity() {
        Assertions.assertEquals(
            60f, defaultContainerManager.storageCapacity,
            "Container capacity must be 60f"
        )
    }

    @Test
    fun `should throw IllegalArgumentException if storage capacity lower than storage capacity`() {
        Assertions.assertThrows(IllegalArgumentException::class.java)
        { CerealStorageOldImplOld(60f, 20f) }
    }

    @Test
    fun `should not throw IllegalArgumentException if storage capacity lower than storage capacity`() {
        Assertions.assertDoesNotThrow { CerealStorageOldImplOld(20f, 20f) }
    }

    @Test
    fun addCereal() {
        defaultContainerManager.addCereal(Cereal.RICE, 12f)
        Assertions.assertEquals(12f, defaultContainerManager.getAmount(Cereal.RICE))
    }

    @Test
    fun `add extra cereal and get some back`() : Unit = with(defaultContainerManager) {
            addCereal(Cereal.RICE, 18f)
            addCereal(Cereal.PEAS, 12f)
            addCereal(Cereal.BULGUR, 9f)
        Assertions.assertEquals(5f, defaultContainerManager.addCereal(Cereal.RICE, 7f), 0.1f)
    }

    @Test
    fun `add four containers and get back exception`() {
        defaultContainerManager.addCereal(Cereal.RICE, 18f)
        defaultContainerManager.addCereal(Cereal.PEAS, 12f)
        defaultContainerManager.addCereal(Cereal.BULGUR, 9f)
        Assertions.assertThrows(IllegalStateException::class.java) {
            defaultContainerManager.addCereal(Cereal.MILLET, 1f)
        }
    }

    @Test
    fun `mound the cereal end to end and don't get an exception`() {
        Assertions.assertDoesNotThrow { defaultContainerManager.addCereal(Cereal.RICE, 20f) }
    }

    @Test
    fun `bring a negative amount of cereal`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            defaultContainerManager.addCereal(Cereal.RICE, -0.1f)
        }
    }

    @Test
    fun getCereal() {
        defaultContainerManager.addCereal(Cereal.RICE, 15f)
        Assertions.assertEquals(10.4f, defaultContainerManager.getCereal(Cereal.RICE, 10.4f))
        { "It should be 10.4f taken from container" }
    }

    @Test
    fun `get negative amount of cereal`() {
        defaultContainerManager.addCereal(Cereal.RICE, 15f)
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            defaultContainerManager.getCereal(Cereal.RICE, -1f)
        }
    }

    @Test
    fun `get cereal from non exist container`() {
        Assertions.assertEquals(0f, defaultContainerManager.getCereal(Cereal.RICE, 12f))
        { "Container doesnt exists. Should be 0f" }
    }

    @Test
    fun `Get more than you really have`() {
        defaultContainerManager.addCereal(Cereal.RICE, 15f)
        Assertions.assertEquals(15f, defaultContainerManager.getCereal(Cereal.RICE, 20f))
        { "15f - that's all you can get from here." }
    }

    @Test
    fun removeContainer() {
        defaultContainerManager.addCereal(Cereal.RICE, 0f)
        Assertions.assertTrue(defaultContainerManager.removeContainer(Cereal.RICE))
    }

    @Test
    fun `remove container after work`() {
        defaultContainerManager.addCereal(Cereal.PEAS, 19f)
        defaultContainerManager.addCereal(Cereal.PEAS, 0.5f)
        defaultContainerManager.getCereal(Cereal.PEAS, 10.25f)
        defaultContainerManager.addCereal(Cereal.PEAS, 0.75f)
        defaultContainerManager.getCereal(Cereal.PEAS, 10f)
        Assertions.assertTrue(defaultContainerManager.removeContainer(Cereal.PEAS))
    }

    @Test
    fun `bring a new container to someone's place`() {
        defaultContainerManager.addCereal(Cereal.RICE, 10f)
        defaultContainerManager.addCereal(Cereal.PEAS, 5f)
        defaultContainerManager.addCereal(Cereal.BULGUR, 19f)
        defaultContainerManager.getCereal(Cereal.RICE, 10f)
        defaultContainerManager.removeContainer(Cereal.RICE)
        defaultContainerManager.addCereal(Cereal.MILLET, 12f)
        Assertions.assertEquals(12f, defaultContainerManager.getAmount(Cereal.MILLET))
        { "should work" }
    }

    @Test
    fun `remove doesnt exists container`() {
        Assertions.assertTrue(defaultContainerManager.removeContainer(Cereal.RICE))
    }

    @Test
    fun `dont remove filled container`() {
        defaultContainerManager.addCereal(Cereal.RICE, 0.01f)
        Assertions.assertFalse(defaultContainerManager.removeContainer(Cereal.RICE))
    }

    @Test
    fun getAmount() {
        defaultContainerManager.addCereal(Cereal.RICE, 19.4f)
        Assertions.assertEquals(19.4f, defaultContainerManager.getAmount(Cereal.RICE))
        { "Rice should be 19.4f" }
    }

    @Test
    fun `get amount with overflow`() {
        defaultContainerManager.addCereal(Cereal.BULGUR, 45f)
        Assertions.assertEquals(20f, defaultContainerManager.getAmount(Cereal.BULGUR))
        { "Bulgur should be 20f" }
    }

    @Test
    fun `get amount if field doesnt exists`() {
        Assertions.assertEquals(0f, defaultContainerManager.getAmount(Cereal.RICE))
        { "Rice should be 0" }
    }

    @Test
    fun getSpace() {
        defaultContainerManager.addCereal(Cereal.BUCKWHEAT, 19.5f)
        Assertions.assertEquals(0.5f, defaultContainerManager.getSpace(Cereal.BUCKWHEAT))
        { "Buckwheat should be 0.5f" }
    }

    @Test
    fun `get space if field doesnt exists`() {
        Assertions.assertEquals(0f, defaultContainerManager.getSpace(Cereal.RICE))
        { "Rice should be 0" }
    }

    @Test
    fun `get space if field filled in`() {
        defaultContainerManager.addCereal(Cereal.RICE, 20f)
        Assertions.assertEquals(0f, defaultContainerManager.getSpace(Cereal.RICE))
        { "Rice should be 0" }
    }

    @Test
    fun testToString() {
        defaultContainerManager.addCereal(Cereal.RICE, 15f)
        defaultContainerManager.addCereal(Cereal.BUCKWHEAT, 1.3f)
        Assertions.assertEquals(
            "In our containers:\nГречка: 1,30 tons\nРис: 15,00 tons", defaultContainerManager.toString()
        )
    }
}