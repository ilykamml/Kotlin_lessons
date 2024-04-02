package ru.ilyamnl.lessons

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InventoryManagerTest {

    @Test
    fun addItem() {
        val manager = InventoryManager(10)
        manager.addItem("Sword", 3)
        Assertions.assertEquals(3, manager.getItemCount("Sword"))
    }

    @Test
    fun addExtraItem() {
        val manager = InventoryManager(10)
        manager.addItem("Sword", 3)
        manager.addItem("Sword", 3)
        Assertions.assertEquals(6, manager.getItemCount("Sword"))
    }

    @Test
    fun `should throw exception in adding extra-extra item`() {
        val manager = InventoryManager(10)
        manager.addItem("Axe", 3)
        Assertions.assertThrows(IllegalStateException::class.java) { manager.addItem("Sword", 8) }
    }

    @Test
    fun removeItem() {
    }

    @Test
    fun getItemCount() {
        val manager = InventoryManager(10)
        manager.addItem("Knife", 2)
        Assertions.assertEquals(0, manager.getItemCount("Sword"))
    }

}