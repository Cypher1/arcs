package arcs.core.storage.testutil

import arcs.core.storage.Driver
import arcs.core.storage.DriverProvider
import arcs.core.storage.StorageKey
import arcs.core.type.Type
import kotlin.reflect.KClass

/**
 * A fake [DriverProvider] for simple test cases.
 *
 * It will create a [DriverProvider] that will return the [Driver] associated with a [StorageKey]
 * in the provided list of map entries.
 */
class FakeDriverProvider(
  vararg entries: Pair<StorageKey, Driver<*>>
) : DriverProvider {

  val storageKeys = entries.map { it.first }
  val drivers = entries.toMap()

  override fun willSupport(storageKey: StorageKey): Boolean = storageKey in storageKeys

  override suspend fun <Data : Any> getDriver(
    storageKey: StorageKey,
    dataClass: KClass<Data>,
    type: Type
  ): Driver<Data> {
    require(storageKey in storageKeys)
    return drivers[storageKey] as Driver<Data>
  }

  override suspend fun removeAllEntities() = Unit
  override suspend fun removeEntitiesCreatedBetween(
    startTimeMillis: Long,
    endTimeMillis: Long
  ) = Unit
}
