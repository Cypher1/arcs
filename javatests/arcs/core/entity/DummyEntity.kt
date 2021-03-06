package arcs.core.entity

import arcs.core.data.Annotation
import arcs.core.data.FieldType
import arcs.core.data.RawEntity
import arcs.core.data.Schema
import arcs.core.data.SchemaFields
import arcs.core.data.SchemaName

/**
 * Subclasses [EntityBase] and makes its protected methods public, so that we can call them
 * in the test. Also adds convenient getters and setters for entity fields, similar to what a
 * code-generated subclass would do.
 */
class DummyEntity : EntityBase(ENTITY_CLASS_NAME, SCHEMA), Storable {
  var bool: Boolean? by SingletonProperty()
  var num: Double? by SingletonProperty()
  var text: String? by SingletonProperty()
  var ref: Reference<DummyEntity>? by SingletonProperty()
  var hardRef: Reference<DummyEntity>? by SingletonProperty()
  var primList: List<Double> by SingletonProperty()
  var refList: List<Reference<DummyEntity>> by SingletonProperty()
  var inlineEntity: InlineDummyEntity by SingletonProperty()
  var inlineList: List<InlineDummyEntity> by SingletonProperty()
  var bools: Set<Boolean> by CollectionProperty()
  var nums: Set<Double> by CollectionProperty()
  var texts: Set<String> by CollectionProperty()
  var refs: Set<Reference<DummyEntity>> by CollectionProperty()
  var inlines: Set<InlineDummyEntity> by CollectionProperty()

  private val nestedEntitySpecs = mapOf(
    SCHEMA_HASH to DummyEntity,
    InlineDummyEntity.SCHEMA_HASH to InlineDummyEntity
  )

  fun getSingletonValueForTest(field: String) = super.getSingletonValue(field)

  fun getCollectionValueForTest(field: String) = super.getCollectionValue(field)

  fun setSingletonValueForTest(field: String, value: Any?) =
    super.setSingletonValue(field, value)

  fun setCollectionValueForTest(field: String, values: Set<Any>) =
    super.setCollectionValue(field, values)

  fun deserializeForTest(rawEntity: RawEntity) = super.deserialize(rawEntity, nestedEntitySpecs)

  companion object : EntitySpec<DummyEntity> {
    override fun deserialize(data: RawEntity): DummyEntity {
      return DummyEntity().apply {
        deserialize(
          data, mapOf(
            SCHEMA_HASH to DummyEntity,
            InlineDummyEntity.SCHEMA_HASH to InlineDummyEntity
          )
        )
      }
    }

    const val ENTITY_CLASS_NAME = "DummyEntity"

    const val SCHEMA_HASH = "abcdef"

    override val SCHEMA = Schema(
      names = setOf(SchemaName(ENTITY_CLASS_NAME)),
      fields = SchemaFields(
        singletons = mapOf(
          "text" to FieldType.Text,
          "num" to FieldType.Number,
          "bool" to FieldType.Boolean,
          "ref" to FieldType.EntityRef(SCHEMA_HASH),
          "hardRef" to FieldType.EntityRef(SCHEMA_HASH, listOf(Annotation("hardRef"))),
          "primList" to FieldType.ListOf(FieldType.Number),
          "refList" to FieldType.ListOf(FieldType.EntityRef(SCHEMA_HASH)),
          "inlineEntity" to FieldType.InlineEntity(InlineDummyEntity.SCHEMA_HASH),
          "inlineList" to
            FieldType.ListOf(FieldType.InlineEntity(InlineDummyEntity.SCHEMA_HASH))
        ),
        collections = mapOf(
          "texts" to FieldType.Text,
          "nums" to FieldType.Number,
          "bools" to FieldType.Boolean,
          "refs" to FieldType.EntityRef(SCHEMA_HASH),
          "inlines" to FieldType.InlineEntity(InlineDummyEntity.SCHEMA_HASH)
        )
      ),
      hash = SCHEMA_HASH
    )
  }
}

class InlineDummyEntity : EntityBase(ENTITY_CLASS_NAME, SCHEMA, isInlineEntity = true), Storable {
  var text: String? by SingletonProperty()

  private val nestedEntitySpecs = mapOf(SCHEMA_HASH to InlineDummyEntity)

  companion object : EntitySpec<InlineDummyEntity> {
    override fun deserialize(data: RawEntity) =
      InlineDummyEntity().apply { deserialize(data, mapOf(SCHEMA_HASH to InlineDummyEntity)) }

    const val ENTITY_CLASS_NAME = "InlineDummyEntity"

    const val SCHEMA_HASH = "inline_abcdef"

    override val SCHEMA = Schema(
      names = setOf(SchemaName(ENTITY_CLASS_NAME)),
      fields = SchemaFields(
        singletons = mapOf(
          "text" to FieldType.Text
        ),
        collections = emptyMap()
      ),
      hash = SCHEMA_HASH
    )
  }
}
