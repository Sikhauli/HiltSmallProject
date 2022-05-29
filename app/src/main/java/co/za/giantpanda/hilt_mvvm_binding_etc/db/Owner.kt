package co.za.giantpanda.hilt_mvvm_binding_etc.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

data class Owner(val avatar_url: String)

class TypeConverterOwner{

  private val gson : Gson = Gson()

  @TypeConverter
  fun stringToSomeObjectList(data: String): Owner? {

    val listType : Type = object : TypeToken<Owner?>(){}.type
    return gson.fromJson<Owner?>(data, listType)
  }


  @TypeConverter
  fun someObjectListToString(somObject : Owner?): String? {

    return gson.toJson(somObject)

  }
}