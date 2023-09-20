package com.example.digitalfarminspectionapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.digitalfarminspectionapp.models.Grower
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class GrowerRepository(var navController: NavHostController, var context: Context) {

    var progress: ProgressDialog
    var growers:ArrayList<Grower>

    init {
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait..")
        growers = mutableListOf<Grower>() as ArrayList<Grower>
    }

    fun saveGrower(growerName:String,growerNumber:String,growerId:String,phoneNumber:String,numberofBushes:String,area:String) {
        var id = System.currentTimeMillis().toString()
        var growerData = Grower(growerName,growerNumber,growerId,phoneNumber,numberofBushes,area,id)
        var growerRef = FirebaseDatabase.getInstance().getReference()
            .child("Growers/$id")
        progress.show()
        growerRef.setValue(growerData).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Error: ${it.exception!!.message}", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun viewGrower(grower: MutableState<Grower>, growers: SnapshotStateList<Grower>):SnapshotStateList<Grower> {
        var ref = FirebaseDatabase.getInstance().getReference().child("Growers")
        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                growers.clear()
                for (snap in snapshot.children){
                    val value = snap.getValue(Grower::class.java)
                    grower.value = value!!
                    growers.add(value!!)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return growers

    }

    fun updateGrower(name:String,gnumber:String,idnumber:String,phone:String,bushes:String,garea:String,id:String) {
        var updateRef = FirebaseDatabase.getInstance().getReference().child("Growers/$id")
        progress.show()
        var updateData = Grower(name, gnumber,idnumber,phone,bushes,garea,id)
        updateRef.setValue(updateData).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "You have successfully updated grower", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }

        }


    }

    fun deleteGrower(id:String) {
        var delRef = FirebaseDatabase.getInstance().getReference().child("Growers/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener(){
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Grower deleted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }

    }


}

