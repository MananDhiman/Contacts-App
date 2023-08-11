package manandhiman.contacts.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contact WHERE id IN (:contactId)")
    fun loadAllByIds(contactId: IntArray): List<Contact>

    @Insert
    fun insertContact(vararg contact: Contact)
}