package com.mty.myapplication.activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore
import com.mty.myapplication.R
import com.mty.myapplication.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_arrow_back)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.btnSignup.setOnClickListener { clickSignUp() }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    private fun clickSignUp(){
        var email:String= binding.etEmail.text.toString()
        var password:String= binding.etPassword.text.toString()
        var passwordConfirm:String= binding.etPasswordConfirm.text.toString()

        if(password != passwordConfirm){
            AlertDialog.Builder(this).setMessage("패스워드가 일치하지 않습니다. 다시 확인해주세요.").create().show()
            binding.etPasswordConfirm.selectAll()
            return
        }

        val db= FirebaseFirestore.getInstance()

        val user:MutableMap<String, String> = mutableMapOf()
        user.put("email", email)
        user["password"] = password

        //이메일 중복시
        db.collection("emailUsers")
            .whereEqualTo("email", email)
            .get().addOnSuccessListener {

                if(it.documents.size>0){
                    AlertDialog.Builder(this).setMessage("중복된 이메일이 있습니다. 다시 확인하시기 바랍니다.").show()
                    binding.etEmail.requestFocus()
                    binding.etEmail.selectAll()
                }else{
                    db.collection("emailUsers").add(user).addOnSuccessListener {
                        AlertDialog.Builder(this)
                            .setMessage("축하합니다.\n회원가입을 성공하셨습니다.")
                            .setPositiveButton("확인", object : DialogInterface.OnClickListener {
                                override fun onClick(p0: DialogInterface?, p1: Int) {
                                    finish()
                                }
                            }).create().show()
                        startActivity(Intent(this, MainActivity::class.java))
                    }

                }
            }

    }
}