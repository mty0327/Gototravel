package com.mty.myapplication.activities.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore
import com.mty.myapplication.R
import com.mty.myapplication.activities.model.UserAccount
import com.mty.myapplication.activities.network.A
import com.mty.myapplication.databinding.ActivityEmailSigninBinding

class EmailSigninActivity : AppCompatActivity() {

    lateinit var binding: ActivityEmailSigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailSigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_arrow_back)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.btnSignin.setOnClickListener { clickSignIn() }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun clickSignIn() {

        var email: String = binding.etEmail.text.toString()
        var password: String = binding.etPassword.text.toString()

        val db:FirebaseFirestore=FirebaseFirestore.getInstance()
        db.collection("emailUsers").whereEqualTo("email",email).whereEqualTo("password",password)
            .get().addOnSuccessListener {
                if(it.documents.size>0){
                    //로그인 성공
                    var id:String= it.documents[0].id //document 명
                    A.userAccount= UserAccount(id, email)

                    val intent: Intent = Intent(this, SearchActivity::class.java)

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }else{
                    AlertDialog.Builder(this).setMessage("이메일과 비밀번호를 다시 확인해주시기 바랍니다.").show()
                    binding.etEmail.requestFocus()
                    binding.etEmail.selectAll()
                }
            }

    }
}