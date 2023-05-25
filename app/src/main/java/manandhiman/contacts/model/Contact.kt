package manandhiman.contacts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "phone_number") val phoneNumber: Int,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "house_address") val house_address: String?,
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}
