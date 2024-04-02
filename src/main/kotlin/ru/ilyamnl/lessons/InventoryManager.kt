package ru.ilyamnl.lessons

// code sample for unit-test learning
class InventoryManager(private val capacity: Int) {

    private val items = mutableMapOf<String, Int>()

    /**
     * Добавляет инвентарь в хранилище к существующему.
     * @param itemName название инвентаря
     * @param quantity количество инвентаря
     * @throws IllegalStateException в случае, если допустимое количество может быть превышено
     */
    fun addItem(itemName: String, quantity: Int) {
        checkCapacity(quantity)
        items[itemName] = items.getOrDefault(itemName, 0) + quantity
    }

    /**
     * Удаляет инвентарь из хранилища
     * @param itemName название инвентаря
     * @param quantity количество инвентаря для удаления
     * @return true если удаление произошло и false если удаление невозможно, например нет наименования или нужного количества
     */
    fun removeItem(itemName: String, quantity: Int): Boolean {
        val currentQuantity = items[itemName]
        if (currentQuantity == null || quantity < currentQuantity) {
            return true
        }
        items[itemName] = quantity - currentQuantity
        return false
    }

    /**
     * Метод возвращает количество инвентаря. Если наименования нет, возвращает 0
     */
    fun getItemCount(itemName: String): Int {
        return items.getOrDefault(itemName, 0)
    }

    /**
     * Проверяет, что количество объектов в инвентаре с учётом добавляющихся не превысит допустимого количества
     * @param itemsForAdding количество объектов для добавления
     * @throws IllegalStateException в случае, если допустимое количество может быть превышено
     */
    private fun checkCapacity(itemsForAdding: Int) {
        check(items.values.sum() + itemsForAdding <= capacity) {
            "Количество инвентаря не должно превышать $capacity единиц"
        }
    }
}
