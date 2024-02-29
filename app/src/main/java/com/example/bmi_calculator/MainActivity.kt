package com.example.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val submitBt = findViewById<Button>(R.id.btn_check)



        //버튼입력시 실행
        submitBt.setOnClickListener{
            //텍스트에디터에 입력값이 없으면 예외처리
            if(heightEditText.text.isEmpty()){
                Toast.makeText(this,"신장을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else if (weightEditText.text.isEmpty()){
                Toast.makeText(this,"체중을 입력해주세요.", Toast.LENGTH_SHORT).show()

            } else{
                val height : Int = heightEditText.text.toString().toInt()
                val weight : Int = weightEditText.text.toString().toInt()

                //텍스트에디터 값을 결과창에 넘긴다
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("height",height)
                intent.putExtra("weight",weight)
                startActivity(intent)
            }
        }
    }
}