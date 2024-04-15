package ru.ilyamnl.homework

class CerealStorageOldImplOld(containerCapacityArg: Float, storageCapacityArg: Float) : CerealStorageOld {

    /**
     * Map контейнеров
     */
    private val containers = mutableMapOf<Cereal, Float>()

    /**
     * Объём одного контейнера
     * @throws IllegalArgumentException если значение отрицательное при инициализации
     */
    override val containerCapacity: Float = containerCapacityArg.also {
        require(it >= 0) { "Container capacity must be not negative" }
    }

    /**
     * Совокупный объём хранилища
     * @throws IllegalArgumentException если значение меньше, чем [containerCapacity] при инициализации
     */
    override val storageCapacity: Float = storageCapacityArg.also {
        require(it >= containerCapacity) { "Storage capacity must be at least equal to the container's capacity" }
    }

    /**
     * @param cereal крупа для добавления в контейнер
     * @param amount количество добавляемой крупы
     * @return количество оставшейся крупы если контейнер заполнился
     * @throws IllegalArgumentException если передано отрицательное значение
     * @throws IllegalStateException если хранилище не позволяет разместить ещё один контейнер для новой крупы
     */
    override fun addCereal(cereal: Cereal, amount: Float): Float {
        require(amount >= 0) { "Cereal amount must be not negative" }

        // создание контейнера
        if (!containers.containsKey(cereal)) {
            check(!(storageCapacity - containers.size * containerCapacity < containerCapacity))
            { "There is no place to place the container" }
            containers[cereal] = 0f
        }

        // заполнение контейнера
        val freeSpace = getSpace(cereal)
        containers[cereal] = if (freeSpace > amount) containers.getValue(cereal) + amount
                            else containerCapacity
        return if (freeSpace > amount) 0f else amount - freeSpace

    }

    /**
     * @param cereal крупа, которую нужно взять из контейнера
     * @param amount количество крупы
     * @return количество полученной крупы или остаток, если было меньше
     * @throws IllegalArgumentException если передано отрицательное значение
     */
    override fun getCereal(cereal: Cereal, amount: Float): Float {
        require(amount >= 0) { "Cereal amount must be not negative" }

        val remainingCereal = getAmount(cereal)
        if (remainingCereal < amount) {
            containers[cereal] = 0f
            return remainingCereal
        } else {
            containers[cereal] = containers.getValue(cereal) - amount
            return amount
        }
    }

    /**
     * @param cereal уничтожает пустой контейнер
     * @return true если контейнер уничтожен и false если контейнер не пуст
     */
    override fun removeContainer(cereal: Cereal): Boolean {
        when {
            !containers.containsKey(cereal) -> {
                return true
            }
            containers[cereal] == 0f -> {
                containers.remove(cereal)
                return true
            }
            else -> {
                return false
            }
        }
    }

    /**
     * @param cereal крупа, количество которой нужно узнать
     * @return количество крупы, которое хранится в контейнере
     */
    override fun getAmount(cereal: Cereal): Float {
        return containers.getOrDefault(cereal, 0f)
    }

    /**
     * @param cereal крупа, для которой нужно проверить доступное место в контейнере
     * @return количество крупы, которое может вместить контейнер с учётом его текущей заполненности
     */
    override fun getSpace(cereal: Cereal): Float {
        return if (containers.containsKey(cereal)) {
            containerCapacity - getAmount(cereal)
        } else {
            0f
        }
    }

    /**
     * @return текстовое представление
     */
    override fun toString(): String {
        var result = "In our containers:"
        containers.toSortedMap().forEach {
            result += "\n${it.key.getLocal()}: ${"%.2f".format(it.value)} tons"
        }
        return result
    }

}