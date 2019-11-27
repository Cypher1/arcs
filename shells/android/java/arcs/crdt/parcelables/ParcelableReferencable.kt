package arcs.crdt.parcelables

import android.os.Parcel
import android.os.Parcelable
import arcs.common.Referencable
import arcs.data.RawEntity
import java.lang.IllegalArgumentException
import javax.annotation.OverridingMethodsMustInvokeSuper
import kotlin.reflect.KClass

/**
 * Parcelable variant of the [Referencable] interface.
 *
 * All subclasses of [Referencable] need to have their own [Parcelable] implementation. [Type] is
 * used to identify which subclass is being parceled.
 */
interface ParcelableReferencable : Parcelable {
    val actual: Referencable

    /** Indicates which subclass of [ParcelableReferencable] is being parceled. */
    enum class Type(
        val creator: Parcelable.Creator<out ParcelableReferencable>
    ) : Parcelable {
        // TODO: Add other ParcelableReferencable subclasses.
        RawEntity(ParcelableRawEntity.CREATOR);

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(ordinal)
        }

        override fun describeContents(): Int = 0

        companion object CREATOR : Parcelable.Creator<Type> {
            override fun createFromParcel(parcel: Parcel): Type = values()[parcel.readInt()]

            override fun newArray(size: Int): Array<Type?> = arrayOfNulls(size)
        }
    }

    @OverridingMethodsMustInvokeSuper
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedObject(
            when (this) {
                // TODO: Add other ParcelableReferencable subclasses.
                is ParcelableRawEntity -> Type.RawEntity
                else -> throw IllegalArgumentException("Unsupported")
            },
            flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        operator fun invoke(actual: Referencable): ParcelableReferencable = when (actual) {
            // TODO: Add other ParcelableReferencable subclasses.
            is RawEntity -> ParcelableRawEntity(actual)
            else -> throw IllegalArgumentException("Unsupported Referencable type: ${actual.javaClass}")
        }

        object CREATOR : Parcelable.Creator<ParcelableReferencable> {
            override fun createFromParcel(parcel: Parcel): ParcelableReferencable {
                val type = requireNotNull(parcel.readTypedObject(Type.CREATOR))
                return type.creator.createFromParcel(parcel)
            }

            override fun newArray(size: Int): Array<ParcelableReferencable?> = arrayOfNulls(size)
        }
    }
}

/** Converts a [Referencable] into a [ParcelableReferencable]. */
fun Referencable.toParcelable(): ParcelableReferencable = ParcelableReferencable(this)

/** Reads a [Referencable] from the [Parcel]. */
fun Parcel.readReferencable(): Referencable? =
    readTypedObject(ParcelableReferencable.Companion.CREATOR)?.actual
