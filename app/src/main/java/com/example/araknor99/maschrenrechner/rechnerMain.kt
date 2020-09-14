package com.example.araknor99.maschrenrechner

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_rechner_main.*

class rechnerMain : AppCompatActivity() {

    lateinit var widths: MutableList<EditText>
    lateinit var heights: MutableList<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rechner_main)
        calculate.setOnClickListener{calculate()}
        widths = mutableListOf(yourWidthEdit,theirWidthEdit,wantedWidthEdit)
        heights = mutableListOf(yourHeightEdit,theirHeightEdit,wantedHeightEdit)
    }

    fun calculate(){
        if(checkInput(widths)){
            var result = calculateListRes(widths)
            resultWidthText.text = result.toString()
        }
        if(checkInput(heights)){
            var result = calculateListRes(heights)
            resultHeightText.text = result.toString()
        }
    }

    fun calculateListRes(list: MutableList<EditText>): Int{
        var result: Float = list[0].text.toString().toFloat()
        result /= list[1].text.toString().toFloat()
        result *= list[2].text.toString().toFloat()
        return Math.round(result)
    }

    fun checkInput(list: MutableList<EditText>): Boolean{
        for(view in list){
            if(view.text.toString().toIntOrNull() == null){
                return false
            }
        }
        return true
    }
}